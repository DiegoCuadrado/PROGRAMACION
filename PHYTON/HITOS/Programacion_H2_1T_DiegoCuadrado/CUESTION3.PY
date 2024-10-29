'''
CUESTION 3: Simular el funcionamiento de una cuenta bancaria (2.5 puntos): al iniciar el
programa,pediremos el saldo inicial de la cuenta (puede ser un número decimal), si el saldo es
menor que 0 se volverá a pedir hasta que sea correcto.
Posteriormente mostraremos un menú con las opciones, 1-ingresar dinero, 2-retirar dinero y
3- mostrar saldo y 4-salir, si la opción no es correcta se volver a pedir de nuevo hasta que sea
correcta. No se pueden ingresar cantidades negativas y no podemos retirar dinero si nos
quedamos en números rojos.
'''
# Función para pedir el saldo inicial de la cuenta
def pedir_saldo_inicial():
    while True:  # Bucle que se repite hasta que el usuario ingrese un saldo válido
        try:
            saldo = float(input("Ingrese el saldo inicial de la cuenta: "))  # Pedimos al usuario el saldo inicial
            if saldo >= 0:  # Comprobamos si el saldo es mayor o igual a 0
                return saldo  # Si es válido, devolvemos el saldo
            else:
                print("El saldo no puede ser negativo. Intente de nuevo.")  # Si el saldo es negativo, mostramos un mensaje
        except ValueError:  # Si el usuario ingresa algo que no es un número, capturamos el error
            print("Por favor, ingrese un número válido.")  # Mensaje de error para entrada no válida

# Función para mostrar el menú de opciones
def mostrar_menu():
    print("\nSeleccione una opción:")  # Mostramos las opciones del menú
    print("1. Ingresar dinero")
    print("2. Retirar dinero")
    print("3. Mostrar saldo")
    print("4. Salir")
    opcion = input("Elija una opción: ")  # El usuario ingresa su opción
    return opcion  # Devolvemos la opción seleccionada

# Función para ingresar dinero en la cuenta
def ingresar_dinero(saldo):
    while True:  # Bucle para pedir una cantidad válida
        try:
            cantidad = float(input("Ingrese la cantidad de dinero a ingresar: "))  # Pedimos la cantidad a ingresar
            if cantidad > 0:  # Comprobamos que la cantidad sea mayor que 0
                saldo += cantidad  # Sumamos la cantidad ingresada al saldo actual
                print(f"Has ingresado {cantidad:.2f}.")  # Mostramos el monto ingresado
                return saldo  # Devolvemos el saldo actualizado
            else:
                print("La cantidad debe ser mayor a 0. Intente de nuevo.")  # Si la cantidad es negativa, mostramos un mensaje
        except ValueError:  # Si el usuario ingresa algo que no es un número
            print("Por favor, ingrese un número válido.")  # Mensaje de error para entrada no válida

# Función para retirar dinero de la cuenta
def retirar_dinero(saldo):
    while True:  # Bucle para pedir una cantidad válida
        try:
            cantidad = float(input("Ingrese la cantidad de dinero a retirar: "))  # Pedimos la cantidad a retirar
            if cantidad > 0:  # Verificamos que la cantidad sea mayor que 0
                if cantidad <= saldo:  # Verificamos que la cantidad no exceda el saldo disponible
                    saldo -= cantidad  # Restamos la cantidad del saldo actual
                    print(f"Has retirado {cantidad:.2f}.")  # Mostramos la cantidad retirada
                    return saldo  # Devolvemos el saldo actualizado
                else:
                    print("Fondos insuficientes. No puedes retirar más de lo que tienes.")  # Mensaje si no hay suficiente saldo
            else:
                print("La cantidad debe ser mayor a 0. Intente de nuevo.")  # Si la cantidad es negativa, mostramos un mensaje
        except ValueError:  # Si el usuario ingresa algo que no es un número
            print("Por favor, ingrese un número válido.")  # Mensaje de error para entrada no válida

# Función principal del programa
def main():
    saldo = pedir_saldo_inicial()  # Solicitamos el saldo inicial al usuario

    while True:  # Bucle principal que mostrará el menú continuamente
        opcion = mostrar_menu()  # Mostramos el menú y capturamos la opción elegida por el usuario

        if opcion == '1':  # Si la opción es ingresar dinero
            saldo = ingresar_dinero(saldo)  # Llamamos a la función para ingresar dinero y actualizamos el saldo
        elif opcion == '2':  # Si la opción es retirar dinero
            saldo = retirar_dinero(saldo)  # Llamamos a la función para retirar dinero y actualizamos el saldo
        elif opcion == '3':  # Si la opción es mostrar el saldo
            print(f"El saldo actual de tu cuenta es: {saldo:.2f}")  # Mostramos el saldo actual con dos decimales
        elif opcion == '4':  # Si la opción es salir del programa
            print("Gracias por usar el sistema bancario. ¡Adiós!")  # Mensaje de despedida
            break  # Salimos del bucle y finalizamos el programa
        else:
            print("Opción no válida, por favor elija una opción correcta.")  # Si el usuario ingresa una opción no válida

# Ejecutar el programa principal
main()
