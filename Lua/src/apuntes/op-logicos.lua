-- Ejemplos de operadores lógicos

-- Los operadores son AND, OR y NOT
-- Los resultados de combinar TRUE y FALSE con estos operadores son:


-- Tabla de resultados operador AND ("y")

-- true and true = true
local resultado = true and true
print(resultado)

-- true and false = false
local resultado = true and false
print(resultado)

-- false and true = false
local resultado = false and true
print(resultado)

-- false and false = false
local resultado = false and false
print(resultado)


-- Tabla de resultados operador OR ("o")

-- true or true = true
local resultado = true or true
print(resultado)

-- true or false = true
local resultado = true or false
print(resultado)

-- false or true = true
local resultado = false or true
print(resultado) 

-- false or false = false
local resultado = false or false
print(resultado)


-- Operador NOT

-- not true = false
local resultado = not true
print(resultado)

-- not false = true
local resultado = not false
print(resultado)