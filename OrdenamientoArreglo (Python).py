# Partiendo de un arreglo de los cuatro primeros números naturales en cualquier orden (orden aleatorio), se debe
# de llegar al siguiente estado objetivo [1,2,3,4]
# Sólo se pueden intercambiar dos posiciones continuas en el arreglo por cada estado
#
# Imprimir los espacios de estados del problema


vector = [4,3,2,1]
objetivo = [1,2,3,4]
def ordenar(movimiento):
    if movimiento == 1:
        a = vector[0]
        vector[0] = vector[1]
        vector[1] = a
    if movimiento == 2:
        a = vector[1]
        vector[1] = vector[2]
        vector[2] = a
    if movimiento == 3:
        a = vector[2]
        vector[2] = vector[3]
        vector[3] = a
    return vector

while vector[0] != 1:
    if 1 == vector[1]:
        ordenar(1)
        print(vector)
    elif 1 == vector[2]:
        ordenar(2)
        print(vector)
    elif 1 == vector[3]:
        ordenar(3)
        print(vector)
print(vector)
while vector[1] != 2:
    if 2 == vector[2]:
        ordenar(2)
    if 2 == vector[3]:
        ordenar(3)
print(vector)
while vector[2] !=3:
    if 3 == vector[3]:
        ordenar(3)
print("Final: ", vector)