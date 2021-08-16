# REPASO DE RECORRIDO DE LISTAS CON CICLO FOR

# Listas
numeros = [1,2,3.5,4,5]
nombres = ["Santiago","Geronimo","Fede","Thiago","Juliana"]
numeros_y_nombres = [1,"Santiago",2,"Geronimo",3,"Fede",4,"Thiago",5,"Juliana"]


# Recorridos
for numero in numeros:
    print(numero)
    
for nombre in nombres:
    print(nombre)
    
for dato in numeros_y_nombres:
    print(dato)

    
# Averiguamos si un dato está en la lista
for nombre in nombres:
    if nombre == "Thiago":
        print("Thiago está en la lista")