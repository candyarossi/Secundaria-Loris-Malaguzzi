-- Encodificado y Decodificado En JSON (JavaScript Object Notation)
-- Primero nos traemos la libería que se encargar de las traducciones desde:
-- https://github.com/rxi/json.lua

-- Importamos la librería
json = require "json"


-- Creamos variables
local val = "Hola Mundo!"


-- Para encodificar usamos
local str = json.encode({val = val})


-- Para decodificar usamos
local dat = json.decode(str)


-- Imprimimos
for key,value in pairs(dat) do
    print(key, value)
end