-- REPASO DE LUA
--
-- Variables
--

-- global (accesible desde todo el programa Lua)
hello = 'Hello'

-- local (accesible sólo dentro del archivo/función)
local world = ' World!'

--
-- Funciones
--

-- Declaración de una función
function say(text)
    print(text)
end

-- Llamado a una función
say("Hello world!")

--
-- Sentencia IF
--
if world == 'World' then
    print('World!')
else
    print('Hello!')
end

--
-- Bucles
--

-- Bucle WHILE con un contador
local i = 10
while i > 0 do
    i = i - 1
    print(i)
end

-- Un bucle FOR que decrementa desde el 10 hasta el 1
for j = 10, 1, -1 do
    print(j)
end

-- Bucle REPEAT
i = 10
repeat
    i = i - 1
    print(i)
until i == 0

--
-- Tablas
--

-- Creación de una lista de clave-valor
local person = {}
person.name = 'Candela'
person.age = 24
person.height = 1.55

-- Formas de acceder a cada valor
print(person['name'])
print(person.name)

-- Iteración de a pares(clave-valor) con la muestra de ambos valores
for key, value in pairs(person) do
    print(key, value)
end
