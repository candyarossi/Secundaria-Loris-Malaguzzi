--local numero = 2
--local resultado = 0
--while numero <= 2048 do
 --   numero = numero * 2
 --   resultado = resultado + 1
 --   print("while", resultado)
--end

json = require "src.json"

local nombre = "cande"
local apellido = "yarossi"

local strJson = json.encode({{nombre, apellido, 2},{nombre}})

print(strJson)

local datosJson = json.decode(strJson)

for key,value in pairs(datosJson) do
    local lista = datosJson[value]
    for key,value in pairs(lista) do
        print(key, value)
    end
end
