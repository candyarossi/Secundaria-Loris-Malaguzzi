package Users;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Json.JsonUtiles;


public class UserList {
	
	private ArrayList<User> listado = new ArrayList<User>();

	public UserList() {
		super();
		this.listado = UserList.LeerArchivo();
	}
	 
	public static ArrayList<User> LeerArchivo(){
		
		ArrayList<User> listado = new ArrayList<User>();
		String strJson = JsonUtiles.leer();
		
		try {
			
			JSONArray jarray = new JSONArray(strJson);
			
			for(int i=0; i<jarray.length(); i++) {
				
				JSONObject jobj = (JSONObject) jarray.get(i);
				User newUser = User.fromJSON(jobj);
				listado.add(newUser);
			}
			
		} catch (JSONException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return listado;
	}
	
	public static void GuardarArchivo(UserList listado) {
		
		JSONArray jarray = new JSONArray();
		
		for(int i=0; i<listado.contar(); i++) {
			
			JSONObject jobj = User.toJSON(new User(listado.obtener(i)));
			jarray.put(jobj);
		}
		
		JsonUtiles.grabar(jarray);
	}
	
	public int contar() {
		return this.listado.size();
	}
	
	public User obtener(int pos) {
		return this.listado.get(pos);
	}
	
	
	public boolean agregarUser(User user) {
		
		boolean flag = listado.add(user);
		return flag;
	}
	
	public void listarUsers() {
		
		for(int i=0; i<this.listado.size(); i++) {
			System.out.println(listado.get(i).toString());
		}
	}

}
