--Aime
local contador = 2
local resultado = 0
repeat
    print("repeat", contador)
    contador = contador * 2
    resultado = resultado + 1
until contador == 4096
resultado = resultado + 1
io.write("2 con exponente ", resultado, " es igual a 4096 \n")

--Luciano
numero=2
exponente=2
contador=1
while numero<4096 do
    numero=2^exponente
    exponente=exponente+1
end
print(exponente-1)

--Geremias 1
local numero = 2
while numero ~= 4096 do
	print ("Escribe un numero:")
		local numero1 = io.read ("*n")
		local resultado = numero ^ numero1
	print ("El resultado de 2 elevado a la", numero1, "es: ", resultado)
end
--repeat
--	print ("Escribe un numero:")
--		local numero1 = io.read ("*n")
--		local resultado = 2 ^ numero1
--	print ("El resultado de 2 elevado a la", numero1, "es: ", resultado)
--until numero1 <= 4096


--Geremias 2
local numero = 2
repeat
	numero = numero * 2
	print ("El resultado es", numero)
until numero == 4096

--Lucas
local contador=2
repeat
    print("repeat", contador)
    contador= contador*2
until contador== 4096

--Dante
numero = 2
while numero ~= 4096 do
    resultado = numero * 2
    print(numero, "* 2 = ", resultado)
    numero = resultado
end

--Manuela
local numero= 2 
local contador= 0 
while numero ~= 4096 do 
    numero= numero *2 
    contador= contador + 1 
end 
io.write(contador) 

----Lucia
--double num = 2; 
--int i = 1; 
--while (num < 4096) { 
--    num = num*2; 
--    i++; 
--} 
local num = 2
local i = 1
while (num < 4096) do
    num = num*2
    i=i+1
end
print(i)