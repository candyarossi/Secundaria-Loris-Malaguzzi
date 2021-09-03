--      Trabajo Práctico Evaluativo N°2:  Lenguaje Lua
--      Resolución y códigos:

-- PUNTO 2
-- Escriban el código necesario para capturar un número por pantalla y que luego se muestre
-- la frase "Usted escribió el número: " seguido del número que se ingresó anteriormente.

print("Escriba un numero: ")
local numero = io.read("*n")
print("Usted escribio el número: ", numero)

-- PUNTO 3
-- Escriban el código necesario para obtener el módulo (resto de una división) de 564
-- dividido 5. El resultado es 4.

local rta = 564 % 5
print("564 % 5 = ", rta)

-- RESPUESTAS PUNTO 4
-- Indiquen cuál es el resultado booleano (true o false) de las siguientes operaciones:

-- a. Rta = 564 < = 5
local rta = 564 <= 5
print("Rta punto 4 inciso a: ", rta)

-- b. Rta = 123 > = 123 and 123 ~ = 0
local rta = 123 >= 123 and 123 ~= 0
print("Rta punto 4 inciso b: ", rta)

-- c. Rta = 123 < 123 or 123 = = 0
local rta = 123 < 123 or 123 == 0
print("Rta punto 4 inciso c: ", rta)

-- d. Rta = not 0 ~ = 0
local rta = not 0 ~= 0
print("Rta punto 4 inciso d: ", rta)

-- RESPUESTA PUNTO 5
-- ¿Cuál sería el resultado booleano de hacer: true and false or true?

local rta = true and false or true
print("Rta punto 5: ", rta)

-- PUNTO 7
-- Escribir el código necesario para determinar sin un número X es mayor a 10 e imprimir el
-- resultado por pantalla, utilizando la estructura IF…ELSE…END

print("Escriba un numero: ")
local numero = io.read("*n")
if numero > 10 then
    print("El numero es mayor a 10")
else
    print("El numero es menor o igual a 10")
end

-- CÓDIGO PUNTO 8

local numero = 1344
if numero % 5 == 0 then
    print("El numero es divisible por 5")
elseif numero % 4 == 0 then
    print("El numero es divisible por 4")
else
    print("El numero no es divisible ni por 5, ni por 4")
end

-- CÓDIGO PUNTO 9

print("Escriba un numero: ")
local numero = io.read("*n")
if numero == 0 or numero % 2 == 0 then
    print("El numero ingresado es par")
elseif numero ~= 0 and numero * 5 == 15 then
    print("El numero ingresado es 3")
else
    print("El numero ingresado es impar")
end

-- CÓDIGO PUNTO 10

local numero = 1
while numero ~= 0 do
    print("El numero es ", numero)
    print("Escriba otro numero: ")
    numero = io.read("*n")
end
