'''
CUESTIÓN 2: Juego de piedra papel o tijera (2,5 puntos). El usuario introduce un valor (1-
Piedra|2- Papel|3-Tijera), si no es correcto se volver a pedir de nuevo hasta que se correcta.
La “maquina” generará un valor aleatorio (de 1 a 3) para elegir piedra, papel o tijera. Al
finalizar, mostrará la opción del usuario y de la máquina e indicará si hemos ganado, perdido o empatado.
'''
import random  # Importamos la biblioteca random para generar la elección aleatoria de la máquina

# Función que muestra el menú y pide la opción del usuario
def mostrar_menu():
    print("Seleccione una opción:")  # Mostramos las opciones del menú
    print("1. Piedra")
    print("2. Papel")
    print("3. Tijera")
    opcion = input("Elija una opción (1-Piedra | 2-Papel | 3-Tijera): ")  # Capturamos la opción seleccionada
    return opcion  # Devolvemos la opción que ha elegido el usuario

# Función que convierte la opción numérica a texto para facilitar la lectura
def convertir_opcion_a_texto(opcion):
    if opcion == '1':
        return "Piedra"  # Si elige '1', es Piedra
    elif opcion == '2':
        return "Papel"  # Si elige '2', es Papel
    elif opcion == '3':
        return "Tijera"  # Si elige '3', es Tijera

# Función que determina quién es el ganador según las reglas del juego
def determinar_ganador(usuario, maquina):
    if usuario == maquina:
        return "Empate"  # Si ambas elecciones son iguales, es un empate
    elif (usuario == '1' and maquina == '3') or (usuario == '2' and maquina == '1') or (usuario == '3' and maquina == '2'):
        return "Ganaste"  # El usuario gana según las reglas del juego
    else:
        return "Perdiste"  # Si no es empate ni gana el usuario, entonces pierde

# Función principal del juego
def main():
    while True:  # Bucle que se repetirá hasta que el usuario ingrese una opción válida
        usuario = mostrar_menu()  # Mostramos el menú y capturamos la opción del usuario
        
        # Verificamos si el usuario ingresó una opción válida (1, 2 o 3)
        if usuario in ['1', '2', '3']:
            maquina = str(random.randint(1, 3))  # Generamos una opción aleatoria para la máquina (1 a 3)
            opcion_usuario = convertir_opcion_a_texto(usuario)  # Convertimos la opción del usuario a texto
            opcion_maquina = convertir_opcion_a_texto(maquina)  # Convertimos la opción de la máquina a texto
            
            # Mostramos las opciones que eligieron tanto el usuario como la máquina
            print(f"Tú elegiste: {opcion_usuario}")
            print(f"La máquina eligió: {opcion_maquina}")
            
            # Determinamos quién es el ganador
            resultado = determinar_ganador(usuario, maquina)
            print(f"Resultado: {resultado}")  # Mostramos el resultado (Ganaste, Perdiste o Empate)
            break  # Salimos del bucle y terminamos el juego
        else:
            print("Opción no válida, por favor elija una opción correcta.")  # Si el usuario ingresó una opción inválida

# Ejecutar el programa principal
main()
