function logaritmo(base, numero)

    local resultado = 1
    local contador = 0

    repeat 
        resultado = resultado * base
        contador = contador + 1
    until resultado == numero

    return contador
end

