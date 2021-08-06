--[[

local resultado = 1
local contador = 0
local numero = 4096

repeat 
   resultado = resultado * 2
   contador = contador + 1
   print("\n Resultado REPEAT: ", resultado)
   print(" Veces que se repite el ciclo: ", contador)
until resultado == numero


local resultado2 = 1
local contador2 = 0

while resultado2 ~= numero do
    resultado2 = resultado2 * 2
    contador2 = contador2 + 1
	print("\n Resultado WHILE: ", resultado2)
	print(" Veces que se repite el ciclo: ", contador2)
end


local resultado3 = 1

for i=1, math.log(numero, 2) , 1 do
    resultado3 = resultado3 * 2
	print("\n Resultado FOR: ", resultado3)
	print(" Veces que se repite el ciclo: ", i)
end

print("2 ^ ", math.log(numero, 2), " = ", numero)

]]

--logs

local resultado = 1
local contador = 0
local numero = 4096

repeat 
   resultado = resultado * 2
   contador = contador + 1
until resultado == numero
print(" Veces que se repite el ciclo REPEAT: ", contador)


local resultado2 = 1
local contador2 = 0

while resultado2 ~= numero do
    resultado2 = resultado2 * 2
    contador2 = contador2 + 1
end
print(" Veces que se repite el ciclo WHILE: ", contador2)

--funcion 

function logaritmo()
    local resultado = 1
    local contador = 0
    local numero = 4096

    repeat 
        resultado = resultado * 2
        contador = contador + 1
        --print("\n Resultado REPEAT: ", resultado)
        --print(" Veces que se repite el ciclo: ", contador)
    until resultado == numero

    return contador
end


function logaritmo2(numero)
    local resultado = 1
    local contador = 0

    repeat 
        resultado = resultado * 2
        contador = contador + 1
    until resultado == numero

    return contador
end


function logaritmo3(numero, base)
    local resultado = 1
    local contador = 0

    repeat 
        resultado = resultado * base
        contador = contador + 1
    until resultado == numero

    return contador
end