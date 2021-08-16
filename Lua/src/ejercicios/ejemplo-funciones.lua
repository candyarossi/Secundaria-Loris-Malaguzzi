-- EJEMPLOS DE DECLARACIÓN DE FUNCIONES
-- En el archivo principal (main) se debe requerir el archivo
-- require "logaritmos"


-- Función "logaritmo" con números ya específicados (logaritmo en base 2 de 4096)
function logaritmo()
    local resultado = 1
    local contador = 0
    local numero = 4096
    repeat 
        resultado = resultado * 2
        contador = contador + 1
    until resultado == numero
    return contador
end


-- Función "logaritmo2" que nos da la posibilidad de ingresar el número (logaritmo en base 2)
function logaritmo2(numero)
    local resultado = 1
    local contador = 0
    repeat 
        resultado = resultado * 2
        contador = contador + 1
    until resultado == numero
    return contador
end


-- Función "logaritmo3" que nos da la posibilidad de ingresar el número y la base
function logaritmo3(numero, base)
    local resultado = 1
    local contador = 0
    repeat 
        resultado = resultado * base
        contador = contador + 1
    until resultado == numero
    return contador
end