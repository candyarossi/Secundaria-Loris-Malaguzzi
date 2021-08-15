# ACTIVIDAD: TRABAJAMOS CON LISTAS

# Creamos una lista con 3 o más elementos (palabras).
youtubers = ['rubius','vegetta','alexby','willy']


# La mostramos por pantalla para ver sus elementos.
print("LISTA ORIGINAL")
for yt in youtubers:
    print(yt)


# Pedimos que se ingrese un nuevo elemento a la lista y lo guardamos en ella.
nuevoyoutuber = input("Ingrese un youtuber a la lista: ")
youtubers.append(nuevoyoutuber)


# Volvemos a mostrar la lista para ver si se guardó el elemento.
print("LISTA NUEVA")
for yt in youtubers:
    print(yt)


# Hacemos que la lista se ordene alfabéticamente.
youtubers.sort()


# Mostramos la lista ya ordenada.
print("LISTA ORDENADA ALFABETICAMENTE")
for yt in youtubers:
    print(yt)


# Pedimos que se escriba un valor para buscarlo en la lista e indicar si está en ella.
# Si el valor está en la lista, lo borramos.
buscaryoutuber = input("Ingrese un youtuber para buscar y borrar de la lista: ")
print("BUSCANDO UN YT")
for yt in youtubers:
    if yt == buscaryoutuber:
        print(buscaryoutuber, "está en la lista y será borrado.")
        youtubers.remove(buscaryoutuber)


# Por último, mostramos cómo quedó la lista.
print("LISTA FINAL")
for yt in youtubers:
    print(yt)
        
print("FIN DEL PROGRAMA")