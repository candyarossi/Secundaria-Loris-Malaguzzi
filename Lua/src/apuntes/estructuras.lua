-- Ejemplos de estructuras condicionales y cíclicas

-- Estructura condicional IF...ELSE
-- Vamos a crear 2 variables para comparar:
local primerNumero = 5
local segundoNumero = 4

if primerNumero < segundoNumero then
    -- Sentencias que se ejecutan si la Condición1 es true.
    print(primerNumero, " es menor a ", segundoNumero)
else
    -- Sentencias que se ejecutan cuando la Condición1 es false.
    print(primerNumero, " es mayor a ", segundoNumero)
end 


-- Estructura condicional IF...ELSEIF...ELSE
if primerNumero < segundoNumero then
    -- Sentencias que se ejecutan si la Condición1 es true.
    print(primerNumero, " es menor a ", segundoNumero)
elseif primerNumero > segundoNumero then
    -- Sentencias que se ejecutan si la Condición1 es false y la Condición2 es true.
    print(primerNumero, " es mayor a ", segundoNumero)
else
    -- Sentencias que se ejecutan cuando todas las Condiciones son false.
    print(primerNumero, " es igual a ", segundoNumero)
end


-- Vamos a imprimir números del 1 al 10:
-- Estructura cíclica WHILE
local numero = 1

while numero < 10 do
    -- Sentencias que se ejecutan si la Condición1 es true.
    print(numero)
    numero = numero + 1
end 


-- Estructura cíclica REPEAT
local numero = 1

repeat
    -- Sentencias que se ejecutan al menos 1 vez, y luego hasta que la Condición1 es true.
    print(numero)
    numero = numero + 1
until numero == 10


-- Estructura cíclica FOR
-- Como se usa para Listas, vamos a crear una:
local climas = {'Ecuatorial', 'Tropical', 'Mediterráneo', 'Continental', 'Alta Montaña'}

for i=1, #climas, 1 do
    -- Sentencias que se ejecutan hasta llegar al Tope.
    print(climas[i])
end

-- Otro tipo de FOR con KEY-VALUE
local tabla = {['nombre'] = 'Candela', ['apellido'] = 'Yarossi'}

for key,value in pairs(tabla) do
    -- Sentencias que se ejecutan hasta acabar la tabla.
    print(key, value)
end