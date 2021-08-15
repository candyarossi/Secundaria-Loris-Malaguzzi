-- Averigar cuantas veces es necesario multiplicar el número 2 por 2 
-- Para llegar al resultado 4096, es decir, 2 elevado a qué número 
-- Nos va a dar como resultado 4096 (logaritmo), utilizando WHILE o REPEAT


--EJEMPLO REPEAT
local resultado = 1
local contador = 0
local numero = 4096

repeat 
   resultado = resultado * 2
   contador = contador + 1
   print("\n Resultado REPEAT: ", resultado)
   print("Veces que se repite el ciclo: ", contador)
until resultado == numero


-- EJEMPLO WHILE
local resultado2 = 1
local contador2 = 0

while resultado2 ~= numero do
    resultado2 = resultado2 * 2
    contador2 = contador2 + 1
	print("\n Resultado WHILE: ", resultado2)
	print("Veces que se repite el ciclo: ", contador2)
end