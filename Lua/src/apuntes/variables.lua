-- Creación de variables
local palabra = "Candela"
local numero = 3.14
local booleano = true


-- Salida por pantalla
print("Hello World!") 
io.write("Hello World!")


-- Salida por pantalla de variables
local nombre = "Candela"
print("Hello ", nombre)


-- O también
local nombre = "Candela"
io.write("Hello ", nombre)


-- Ingreso por teclado de palabras
print("Ingrese su nombre: \n")
local nombre = io.read("*line")
print("Nombre: ", nombre)


-- Ingreso por teclado de números
print("Ingrese un numero: \n")
local numero = io.read("*n")
print("Numero: ", numero)