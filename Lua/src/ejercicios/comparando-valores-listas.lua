-- ENCONTRAR UN VALOR EN UNA LISTA COMPARANDO STRINGS
-- Buscar la forma de que el programa encuentre el elemento en la lista, 
-- Sin importar si está escrito en mayúscula o minúscula.

-- Código visto en clase:
local lista = {"Catalina", "Geremias", "Tobias", "Aime"}

-- Recorrer y mostrar una lista
-- Método 1
for i=1, #lista, 1 do
    print(lista[i])
end

-- Método 2
for k,v in pairs(lista) do
    print(k,v)
end

-- Encontrar un valor
for i=1, #lista, 1 do
    if lista[i] == "Tobias" then
        print("Tobias está en la lista.")
    end
end


-- RESOLUCIÓN
-- Método 1:
-- Convertimos todo a minúsculas, cada uno de los elementos de la lista y lo que pedimos por teclado
print("Escriba un nombre: ")
local otro = io.read()
-- local otro = io.read("*line")  <-- Se puede indicar entre los () 
--                                    del io.read que se va a leer una línea de texto con "*line"

for i=1, #lista, 1 do
    if string.lower(lista[i]) == string.lower(otro) then  -- Se puede usar string.upper() también
        print(otro, "está en la lista.")
    end
end


-- Método 2: 
-- Usando booleanos
print("Escriba un nombre: ")
local otro = io.read("*line")
local estaEnLaLista = false  -- Vamos a crear un booleano en false que cambie a true solo si se encuentra el valor

for i=1, #lista, 1 do
    if string.lower(lista[i]) == string.lower(otro) then  -- Se puede usar string.upper() también
        estaEnLaLista = true  -- Si se encuentra pasa a ser true
    end
end

if estaEnLaLista then
    print(otro, "está en la lista.")
else
    print(otro, "no está en la lista.")
end


-- Bonus sobre Strings: 
-- Poner solo la primera letra de una palabra en mayúsculas
local cadena = "AGUSTIN"
print(cadena)
local nuevaCadena = string.gsub(string.gsub(cadena, "%a", string.lower), "^%l", string.upper)
print(nuevaCadena)