-- Ejemplo de construcción de funciones:
-- En el archivo principal (main) se debe requerir el archivo
-- require "nombreDelArchivo"

-- Declaración
function NombreDeLaFuncion(Parametro1, Parametro2,...)
    -- Sentencias que forman parte de la función
end


-- Ejemplo
function string_capitalize(cadena)
    local nuevaCadena = string.gsub(string.gsub(cadena, "%a", string.lower), "^%l", string.upper)
    return nuevaCadena
end