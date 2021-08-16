# Ejemplos de manejo de listas

# Creación de una lista 
climas = ['Ecuatorial', 'Tropical', 'Mediterráneo']


# Acceder a un elemento en específico, sabiendo su índice
print(climas[3])


# Añadir un elemento al final de la lista
climas.append('Alta Montaña')
print(climas)


# Devuelve la posición del elemento que se especifica
print(climas.index('Tropical'))


# Inserta un valor en una posición específica
climas.insert(2, 'Continental')
print(climas)


# Ordena alfabéticamente una lista de palabras
climas.sort()
print(climas)


# Borra de la lista el elemento especificado
climas.remove('Alta Montaña')
print(climas)