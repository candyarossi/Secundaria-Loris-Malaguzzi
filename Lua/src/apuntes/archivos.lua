-- Manejo de archivos

-- Importamos la librería io de Lua
require "io"


-- Declaramos una variable
local variable = "Candela"


-- Creamos una variable que 
local filename = "archivo.json"


-- Abrimos el archivo en modo W. Los principales modos de apertura de Lua son:
-- W : Abre o crea un archivo en modo escritura (borra el contenido si existe)
-- R : Abre el archivo en modo lectura
-- A : Abre el archivo en modo adición (no borra el contenido si existe)
file = io.open(filename,"w")


-- Escribimos el contenido en el archivo
file:write(variable)


-- Lo cerramos
file:close()


-- Volvemos a abrir el archivo pero en modo R
file = io.open(filename,"r")


-- Leemos lo que contiene el archivo
for line in file:lines() do strArch = line end


-- Lo cerramos
file:close()


-- Imprimimos la variable
print("Variable: ", strArch)