json = require "json"

local nombre = "cande"
local apellido = "yarossi"

local strJson = json.encode({{nombre = nombre}, {apellido = apellido}})

print(strJson)

local datosJson = json.decode(strJson)

for i=1, #datosJson, 1 do
    local lista = datosJson[i]
    for key,value in pairs(lista) do
        print(key,value)
    end
end

