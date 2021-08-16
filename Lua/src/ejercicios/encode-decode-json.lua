-- ENCODIFICADO Y DECODIFICADO EN JSON
-- Primero nos traemos la libería que se encargar de las traducciones desde:
-- https://github.com/rxi/json.lua

-- Importamos la librería
json = require "json"


-- Método 1
-- Declaramos las variables a traducir
local nombre = "Candela"
local apellido = "Yarossi"


-- Se las pasamos a json.encode() para encodificarlas
local strJsonVariables = json.encode({{nombre = nombre}, {apellido = apellido}})


-- Hay que tener en cuenta, que en este caso se va a devolver un JsonArray
-- [{"nombre":"cande"},{"apellido":"yarossi"}]
print(strJsonVariables)


-- Se lo pasamos a json.decode() para decodificarlo
local datosJsonDecode = json.decode(strJsonVariables)


-- Recorremos el JsonArray y nos guardamos los valores en las nuevas variables
for i=1, #datosJsonDecode, 1 do
    local listaInterna = datosJsonDecode[i]
    for key,value in pairs(listaInterna) do
        if key == 'nombre' then
            nuevoNombre = value
        elseif key == 'apellido' then
            nuevoApellido = value
        end
    end
end


-- Imprimimos las variables para comprobar la correcta conversión
print("Nombre: ", nuevoNombre, " - Apellido: ", nuevoApellido)


-- Método 2
-- Declaramos la tabla (modo clave-valor) a traducir
local tabla = {['nombre'] = 'Candela', ['apellido'] = 'Yarossi'}


-- Se la pasamos a json.encode() para encodificarla
local strJsonTabla = json.encode(tabla)


-- Hay que tener en cuenta, que en este caso se va a devolver un JsonObject
-- {"nombre":"Candela","apellido":"Yarossi"}
print(strJsonTabla)


-- Se lo pasamos a json.decode() para decodificarlo
local datosJsonDecode = json.decode(strJsonTabla)


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