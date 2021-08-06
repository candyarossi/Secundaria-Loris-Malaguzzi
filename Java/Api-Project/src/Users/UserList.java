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
	
	public int contar() {
		return this.listado.size();
	}
	public User obtener(int pos) {
		return this.listado.get(pos);
	}
	
	
	public boolean agregarUser(User user) {
		
		boolean flag = false;
		
		return flag;
	}

	public boolean eliminarUser(User user) {
		
		boolean flag = false;
		
		return flag;
	}

	public boolean editarUser(User user) {
	
		boolean flag = false;
		
		return flag;
	}
	
	public void listarUsers() {
		
		for(int i=0; i<this.listado.size(); i++) {
			System.out.println(listado.get(i).toString());
		}
	}

}
