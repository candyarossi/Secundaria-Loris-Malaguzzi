# Ejemplos de manejo de Strings

# Primero crearemos una String:
nombre = "candela"


# Convierte la primera letra de una String en mayúscula
print(nombre.capitalize())


# Convierte una String a mayúsculas
print(nombre.upper())


# Convierte una String a minúsculas
print(nombre.lower())


# Convierte la primera letra de cada palabra en mayúscula
print(nombre.title())


# Devuelve el número de veces que una determinada letra aparece en una String
print(nombre.count("a"))


# Devuelve TRUE si la String termina en un valor específico
print(nombre.endswith("a"))


# Busca una String dada dentro de otra. Si la encuentra, devuelve la posición de la misma, si no la encuentra, devuelve -1
print(nombre.find("de"))


# Busca un caracter (letra) dada dentro de una String. Si la encuentra, devuelve la posición de la misma, si no la encuentra, devuelve un error.
print(nombre.index("e"))


# Devuelve una String con el valor dado reemplazado por un valor específico (una letra o una palabra)
print(nombre.replace("candela", "luz"))