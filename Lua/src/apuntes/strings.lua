-- Ejemplos de manejo de Strings

-- Primero crearemos una String:
local nombre = "candela"


-- Convierte una String a mayúsculas
print(string.upper(nombre))


-- Convierte una String a minúsculas
print(string.lower(nombre))


-- Reemplaza una porción de la String por un valor dado.
print(string.gsub(nombre, "la", "", 1))


-- Invierte el orden de los caracteres de una String
print(string.reverse(nombre))


-- Repite una String una cantidad determinada de veces
print(string.rep(nombre, 2))


-- Cuenta la cantidad de caracteres de una String
print(string.len(nombre))
-- O también
print(#nombre)


-- Devuelve el caracter al cual le pertenece el código ASCII dado
print(string.char(65))


-- Devuelve el código ASCII que le pertenece al caracter dado
print(string.byte("A"))


-- EXTRA
-- Convierte la primera letra de una String en mayúscula
print(string.gsub(string.gsub(nombre, "%a", string.lower), "^%l", string.upper))