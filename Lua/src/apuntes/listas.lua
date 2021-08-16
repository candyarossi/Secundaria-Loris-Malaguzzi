-- Ejemplos de manejo de listas

-- Creación de una lista 
local climas = {'Ecuatorial', 'Tropical', 'Mediterráneo'}


-- Acceder a un elemento en específico, sabiendo su índice
print(climas[3])


-- Añadir un elemento al final de la lista
table.insert(climas, 'Alta Montaña')

for i=1, #climas, 1 do
    print(climas[i])
end


-- Inserta un valor en la posición que se especifica
table.insert(climas, 2, 'Alta Montaña')

for i=1, #climas, 1 do
    print(climas[i])
end


-- Ordena alfabéticamente una lista de palabras
table.sort(climas)

for i=1, #climas, 1 do
    print(climas[i])
end


-- Devuelve un valor en una posición específica y luego lo elimina de la lista
local eliminado = table.remove(climas, 3)
print(eliminado)


-- Devuelve una String con todos los elementos de la tabla concatenados
local str = table.concat(climas, ",")
print(str)