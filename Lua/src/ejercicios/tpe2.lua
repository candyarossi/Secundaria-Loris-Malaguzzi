--      Trabajo Práctico Evaluativo N°2:  Lenguaje Lua
--      Resolución:

local lista = {}

function MostrarLista(lista)
    print("VALORES DE LA LISTA:")
    for i=1, #lista, 1 do
        print(lista[i])
    end
end

--1.	Hacer una función que permita ingresar varios elementos a una lista, 
--      tantos como quiera el usuario.

function IngresarElementosALista()
    local rta = "si"
    repeat
        print("Desea ingresar un nuevo elemento a la lista? si/no")
        rta = io.read("*line")
        if rta == "si" then
            print("Ingrese un numero: ")
            local nro = io.read("*n")
            table.insert(lista, nro)
        end
    until rta == "no"
end

IngresarElementosALista()
MostrarLista(lista)

--2.	Hacer una función que pase todos los elementos de una lista a otra.

local lista2 = {}

function PasarDeUnaListaAOtra(lista, lista2)
    for i=1, #lista, 1 do
        table.insert(lista2, lista[i])
    end
end

PasarDeUnaListaAOtra(lista, lista2)
print("Lista 1:")
MostrarLista(lista)
print("Lista 2:")
MostrarLista(lista2)

--3.	Hacer una función que encuentre el menor elemento de una lista 
--      y lo retorne.

-- Versión 1
function DevolverMenorDeUnaLista(lista)
    local menor = lista[1]
    for i=1, #lista, 1 do
        if menor > lista[i] then
            menor = lista[i]
        end
    end
    return menor
end

-- Versión 2
function DevolverMenorDeUnaLista(lista)
    table.sort(lista)
    local menor = lista[1]
    return menor
end

-- Versión 2.1
function DevolverMenorDeUnaLista(lista)
    table.sort(lista)
    return lista[1]
end

print("Menor elemento de la lista: ", DevolverMenorDeUnaLista(lista))

--4.	Hacer una función que inserte en una lista ordenada un nuevo elemento, 
--      conservando el orden de esta.

table.sort(lista)
print("Lista anterior ordenada:")
MostrarLista(lista)
print("Ingrese un nuevo numero: ")
local nuevo = io.read("*n")

-- Versión 1 - No sabemos si la lista está ordenada 
function InsertarElementoYOrdenar(lista, nuevo)
    table.insert(lista, nuevo)
    table.sort(lista)
end

-- Versión 2 - Asumimos que la lista está ordenada
function InsertarElementoYOrdenar(lista, nuevo)
    for i=1, #lista, 1 do
        if nuevo < lista[i] then 
            table.insert(lista, i, nuevo)
            break
        end
    end
end

InsertarElementoYOrdenar(lista, nuevo)
print("Elemento insertado: ", nuevo)
print("Lista nueva ordenada:")
MostrarLista(lista)

--5.	Hacer una función que sume todos los elementos de una lista, 
--      sin alterar su contenido, y retorne su resultado.

function SumarElementosDeUnaLista(lista)
    local resultado = 0
    for i=1, #lista, 1 do
        resultado = resultado + lista[i]
    end
    return resultado
end
 
print("Suma de todos los elementos de la lista: ", SumarElementosDeUnaLista(lista))

--6.	Hacer una función que calcule el promedio de los elementos de una lista, 
--      para ello se puede usar la función del punto 5 y agregar la división por 
--      la cantidad de elementos de la lista.

-- Versión 1
function PromedioDeLosElementosDeUnaLista(lista)
    local suma = SumarElementosDeUnaLista(lista)
    local promedio = suma / #lista
    return promedio
end

-- Versión 1.1
function PromedioDeLosElementosDeUnaLista(lista)
    local promedio = SumarElementosDeUnaLista(lista) / #lista
    return promedio
end

-- Versión 1.2
function PromedioDeLosElementosDeUnaLista(lista)
    return SumarElementosDeUnaLista(lista) / #lista
end

print("Promedio de todos los elementos de la lista: ", PromedioDeLosElementosDeUnaLista(lista))

--7.	Hacer una función que reciba una lista con números de un solo dígito 
--      y que transforme esos dígitos en un número decimal. Por ejemplo, la lista:
--
--      local lista = {1,5,9,3,6,8}
--      Resultado de la función: 159368

local listaDada = {1,5,9,3,6,8}

-- Versión 1
function TransformarListaANumeroDecimal(lista)
    local nro = table.concat(lista, "")
    return nro
end

-- Versión 1.1
function TransformarListaANumeroDecimal(lista)
    return table.concat(lista, "")
end

print("Numero decimal: ", TransformarListaANumeroDecimal(listaDada))
MostrarLista(listaDada)