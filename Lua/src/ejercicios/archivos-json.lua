-- GUARDADO DE INFORMACIÓN EN ARCHIVOS .JSON
-- Primero nos traemos la libería que se encargar de las traducciones desde:
-- https://github.com/rxi/json.lua

-- Importamos la librería json.lua y tambien io de Lua
json = require "json"
require "io"


-- Declaramos la tabla (modo clave-valor) a traducir
local tabla = {['nombre'] = 'Candela', ['apellido'] = 'Yarossi'}


-- Creamos una variable que 
local filename = "archivo.json"


-- Pasamos a json.encode() la tabla para encodificarla
-- Hay que tener en cuenta, que en este caso se va a devolver un JsonObject
-- {"nombre":"Candela","apellido":"Yarossi"}
local strJson = json.encode(tabla)


-- Abrimos el archivo en modo W. Los principales modos de apertura de Lua son:
-- W : Abre o crea un archivo en modo escritura (borra el contenido si existe)
-- R : Abre el archivo en modo lectura
-- A : Abre el archivo en modo adición (no borra el contenido si existe)
file = io.open(filename,"w")


-- Escribimos el contenido en el archivo
file:write(strJson)


-- Lo cerramos
file:close()


-- Volvemos a abrir el archivo pero en modo R
file = io.open(filename,"r")


-- Leemos lo que contiene el archivo
for line in file:lines() do strJsonArch = line end


-- Lo cerramos
file:close()


-- Pasamos a json.decode() la String obtenida para decodificarla
local datosJsonDecode = json.decode(strJsonArch)


-- Recorremos el JsonObject y nos guardamos los valores en las nuevas variables
for key,value in pairs(datosJsonDecode) do
    if key == 'nombre' then
        nuevoNombre = value
    elseif key == 'apellido' then
        nuevoApellido = value
    end
end


-- Imprimimos las variables para comprobar la correcta conversión
print("Nombre: ", nuevoNombre, " - Apellido: ", nuevoApellido)