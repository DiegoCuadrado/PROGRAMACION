# Sistema de gestión de pedidos
# Estructuras de datos
clientes = {}  
pedidos = {}  
productos_disponibles = {
    "P001": "Producto A",
    "P002": "Producto B",
    "P003": "Producto C",
}  
# Funciones
def registrar_cliente():
    print("Registro de Cliente")
    id_cliente = input("Introduce un ID único para el cliente: ")
    if id_cliente in clientes:
        print("Error: El cliente ya está registrado.")
        return
    nombre = input("Introduce el nombre del cliente: ")
    correo = input("Introduce el correo del cliente: ")
    direccion = input("Introduce la dirección del cliente: ")
    clientes[id_cliente] = {"nombre": nombre, "correo": correo, "direccion": direccion}
    print(f"Cliente {nombre} registrado con éxito.")

def visualizar_clientes():
    print("Lista de Clientes Registrados:")
    if not clientes:
        print("No hay clientes registrados.")
        return
    for id_cliente, datos in clientes.items():
        print(f"ID: {id_cliente}, Nombre: {datos['nombre']}, Correo: {datos['correo']}")

def realizar_compra():
    print("Realizar Compra")
    id_cliente = input("Introduce el ID del cliente: ")
    if id_cliente not in clientes:
        print("Error: Cliente no encontrado.")
        return
    print("Productos Disponibles:")
    for codigo, nombre in productos_disponibles.items():
        print(f"{codigo}: {nombre}")
    productos_seleccionados = input(
        "Introduce los códigos de los productos separados por comas: "
    ).split(",")
    productos_validados = [
        codigo for codigo in productos_seleccionados if codigo in productos_disponibles
    ]
    if not productos_validados:
        print("Error: No se seleccionaron productos válidos.")
        return
    n_pedido = len(pedidos) + 1  
    pedidos[n_pedido] = {"cliente": id_cliente, "productos": productos_validados}
    print(f"Compra realizada con éxito. Número de pedido: {n_pedido}")

def seguimiento_compra():
    print("Seguimiento de Compra")
    n_pedido = int(input("Introduce el número de pedido: "))
    if n_pedido not in pedidos:
        print("Error: Pedido no encontrado.")
        return
    pedido = pedidos[n_pedido]
    cliente = clientes[pedido["cliente"]]
    print(f"Datos del Cliente: {cliente}")
    print("Productos del Pedido:")
    for codigo in pedido["productos"]:
        print(f"{codigo}: {productos_disponibles[codigo]}")

# Menú principal
def menu():
    while True:
        print("\nSistema de Gestión de Pedidos")
        print("1. Registrar Cliente")
        print("2. Visualizar Clientes")
        print("3. Realizar Compra")
        print("4. Seguimiento de Compra")
        print("5. Salir")
        opcion = input("Selecciona una opción: ")
        if opcion == "1":
            registrar_cliente()
        elif opcion == "2":
            visualizar_clientes()
        elif opcion == "3":
            realizar_compra()
        elif opcion == "4":
            seguimiento_compra()
        elif opcion == "5":
            print("Saliendo del sistema...")
            break
        else:
            print("Opción no válida.")

# Ejecutar la aplicación
menu()


