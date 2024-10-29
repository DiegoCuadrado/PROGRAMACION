'''
CUESTIÓN 1: Mostrar figuras por pantalla (2,5 puntos): a través de un menú solicitaremos al
usuario que tipo de figura quiere mostrar (1-Cuadrado|2-Rectángulo), si la opción no es
correcta, se mostrará mensaje de error y se volverá a solicitar hasta que se correcta. 
'''
# Función para mostrar el menú de opciones
def mostrar_menu():
    print("Seleccione la figura que desea mostrar:")  # Mostramos las opciones disponibles
    print("1. Cuadrado")
    print("2. Rectángulo")
    opcion = input("Elija una opción (1-Cuadrado | 2-Rectángulo): ")  # Capturamos la opción ingresada por el usuario
    return opcion  # Devolvemos la opción seleccionada

# Función para pedir el lado de un cuadrado y calcular su área y perímetro
def mostrar_cuadrado():
    while True:  # Bucle para pedir un valor válido para el lado del cuadrado
        try:
            lado = float(input("Ingrese el valor del lado del cuadrado: "))  # Pedimos el valor del lado
            if lado > 0:  # Verificamos que el lado sea mayor que 0
                # Calculamos el área y el perímetro del cuadrado
                area = lado * lado
                perimetro = 4 * lado

                # Mostramos la figura del cuadrado en pantalla con el lado correspondiente
                print("Figura del cuadrado:")
                for i in range(int(lado)):
                    print("* " * int(lado))  # Dibujamos el cuadrado usando asteriscos
                
                # Mostramos el área y perímetro calculados
                print(f"Área del cuadrado: {area:.2f}")
                print(f"Perímetro del cuadrado: {perimetro:.2f}")
                break  # Salimos del bucle después de una entrada válida
            else:
                print("El lado debe ser un número mayor a 0. Intente de nuevo.")  # Mensaje para lados no válidos
        except ValueError:  # Manejo de error en caso de que no se ingrese un número
            print("Por favor, ingrese un valor numérico válido.")

# Función para pedir las dimensiones de un rectángulo y calcular su área y perímetro
def mostrar_rectangulo():
    while True:  # Bucle para pedir valores válidos para la base y altura del rectángulo
        try:
            base = float(input("Ingrese el valor de la base del rectángulo: "))  # Pedimos el valor de la base
            altura = float(input("Ingrese el valor de la altura del rectángulo: "))  # Pedimos el valor de la altura
            
            if base > 0 and altura > 0:  # Verificamos que tanto la base como la altura sean mayores que 0
                # Calculamos el área y el perímetro del rectángulo
                area = base * altura
                perimetro = 2 * (base + altura)

                # Mostramos la figura del rectángulo en pantalla usando asteriscos
                print("Figura del rectángulo:")
                for i in range(int(altura)):
                    print("* " * int(base))  # Dibujamos el rectángulo con base y altura correspondientes

                # Mostramos el área y perímetro calculados
                print(f"Área del rectángulo: {area:.2f}")
                print(f"Perímetro del rectángulo: {perimetro:.2f}")
                break  # Salimos del bucle después de una entrada válida
            else:
                print("La base y la altura deben ser mayores a 0. Intente de nuevo.")  # Mensaje para valores no válidos
        except ValueError:  # Manejo de error en caso de que no se ingrese un número
            print("Por favor, ingrese valores numéricos válidos.")

# Función principal del programa
def main():
    while True:  # Bucle que se repite hasta que el usuario ingrese una opción válida
        opcion = mostrar_menu()  # Mostramos el menú y capturamos la opción del usuario
        
        # Validamos la opción ingresada
        if opcion == '1':  # Si elige la opción 1, mostramos el cuadrado
            mostrar_cuadrado()
            break  # Terminamos el programa tras mostrar la figura
        elif opcion == '2':  # Si elige la opción 2, mostramos el rectángulo
            mostrar_rectangulo()
            break  # Terminamos el programa tras mostrar la figura
        else:
            print("Opción no válida, por favor elija una opción correcta.")  # Mensaje si ingresa una opción incorrecta

# Ejecutar el programa principal
main()
