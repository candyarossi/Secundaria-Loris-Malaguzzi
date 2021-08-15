# Ejemplos de estructuras condicionales y cíclicas

# Estructura condicional IF...ELSE
# Vamos a crear 2 variables para comparar:
primerNumero = 5
segundoNumero = 4

if primerNumero < segundoNumero:
    #Sentencias que se ejecutan si la Condición1 es true.
    print(primerNumero, " es menor a ", segundoNumero)
else:
    #Sentencias que se ejecutan cuando la Condición1 es false.
    print(primerNumero, " es mayor a ", segundoNumero)


# Estructura condicional IF...ELIF...ELSE
if primerNumero < segundoNumero:
    #Sentencias que se ejecutan si la Condición1 es true.
    print(primerNumero, " es menor a ", segundoNumero)
elif primerNumero > segundoNumero:
    #Sentencias que se ejecutan si la Condición1 es false y la Condición2 es true.
    print(primerNumero, " es mayor a ", segundoNumero)
else:
    #Sentencias que se ejecutan cuando todas las Condiciones son false.
    print(primerNumero, " es igual a ", segundoNumero)


# Estructura cíclica WHILE
# Vamos a imprimir números del 1 al 10:
numero = 1

while numero < 10:
    #Sentencias que se ejecutan si la Condición1 es true.
    print(numero)
    numero = numero + 1


# Estructura cíclica FOR
# Como se usa para Listas, vamos a crear una:
climas = ['Ecuatorial', 'Tropical', 'Mediterráneo', 'Continental', 'Alta Montaña']

for clima in climas:
    #Sentencias que se ejecutan en cada vuelta del ciclo.
    print(clima)

