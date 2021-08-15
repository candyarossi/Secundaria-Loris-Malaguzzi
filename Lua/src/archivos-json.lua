json = require "json"

local nombre = "Cande"
local apellido = "Yarossi"

print("Variables: Nombre-> ", nombre, " - Apellido-> ", apellido)

local stringJson = json.encode({{nombre = nombre}, {apellido = apellido}})

print("String JSON: ", stringJson)

require "io"

local filename = "archivo.json"

file = io.open(filename,"w")

file:write(stringJson)

file:close()

print("Se escribió el archivo.")

file = io.open(filename,"r")

for line in file:lines() do datosArchivo = line end 

file:close()

print("Se leyó el archivo.")

local datosJson = json.decode(datosArchivo)

for i=1, #datosJson, 1 do
    local list = datosJson[i]
    for key,value in pairs(list) do
        print(key,value)
    end
end

print("FIN.")