# EJEMPLOS ESTRUCTURAS IF Y WHILE

# Comparación de dos valores
if 6>5:
    print("6 es mayor a 5")
else:
    print("6 es menor a 5")


# Pedimos 2 valores y los comparamos
numero1 = int(input("Ingrese un número: "))
numero2 = int(input("Ingrese otro número: "))
if numero1 < numero2:
    print(numero1, " Es menor a ", numero2)
else:
    print(numero1, " es mayor a ", numero2)
    
    
# Estructura WHILE implementada en un juego: Hasta que no se llegue a los 50 puntos, no se termina el nivel.
puntos = 0
while puntos < 50:
    print("Se repite el nivel.")
    puntos = puntos + 5
    print("Puntos: ", puntos)
print("Fin del nivel.")


# Estructura FOR en listas. Estructura IF anidada.
numeros = [1,2,3,4,5,6,7,8,9,10,11,12,13,14]
for numero in numeros:
    if numero % 2 == 1:
        print("El numero ", numero, " es impar.")