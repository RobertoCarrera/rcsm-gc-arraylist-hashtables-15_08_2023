//En el enunciado dice "el usuario podrá añadir artículos nuevos y cantidades. No lo entiendo, entiendo que quería decir precio

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class stockProductosApp {

	//De esta forma hago teclado accesible en todo el programa
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Así se crea un diccionario
		Hashtable<String, Double> productos = new Hashtable<>();
		
		int opcion = 0;
		
		crearBaseDatos(productos);

		//A partir de que está creada, trabajamos con ella
		while (opcion != 4) {
			System.out.println("1. Agregar un nuevo artículo");
			System.out.println("2. Consultar información de un artículo");
			System.out.println("3. Listar todos los artículos");
			System.out.println("4. Salir");

			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
				case 1:
					productos = agregarArticulo(productos);
					break;
				case 2:
					consultarArticulo(productos);
					break;
				case 3:
					listarArticulos(productos);
					break;
				case 4:
					
					System.out.println("Saliendo del programa");
					break;
				default:
					
					System.out.println("Opción inválida. Inténtalo de nuevo.");
			}
		}
	}
	
	  private static Hashtable crearBaseDatos(Hashtable productos) {
	    	
			//Primero de todo, crearemos la base de datos con los 10 productos
			for (int i = 0; i < 10; i++) {
				
				System.out.print("Introduce el nombre del artículo: ");
				String nombre = teclado.nextLine();
				
				System.out.print("Introduce el precio del artículo: ");
				double precio = teclado.nextDouble();
				//Así limpio la caché del Scanner
				teclado.nextLine();

				productos.put(nombre, precio);
			}
			
			return productos;
	    }
	
    private static Hashtable agregarArticulo(Hashtable productos_actualizado) {
    	
		System.out.print("Introduce el nombre del nuevo artículo: ");
		String nombre = teclado.nextLine();
		
		System.out.print("Introduce el precio del nuevo artículo: ");
		double precio = teclado.nextDouble();
		teclado.nextLine();

		productos_actualizado.put(nombre, precio);
		
		return productos_actualizado;
    }
	
    private static void consultarArticulo(Hashtable productos) {
    	
		System.out.print("Introduce el nombre del artículo a consultar: ");
		String nombre = teclado.nextLine();
		//De esta forma, comprobamos que el producto existe
		if (productos.containsKey(nombre)) {
			
			System.out.println("El precio del artículo " + nombre + " es " + productos.get(nombre));
		} else {
			
			System.out.println("El artículo " + nombre + " no existe en la base de datos");
		}
    }
	
    private static void listarArticulos(Hashtable productos) {
		//Enumeration sólo permite 1 salida de datos. Keys saca la primera entrada de Hash y elements la segunda
		Enumeration<String> nombres = productos.keys();
		Enumeration<Double> precios = productos.elements();
		
		while(nombres.hasMoreElements()) {
			System.out.print("Producto: "+nombres.nextElement()+" | ");
			System.out.println("Precio: "+precios.nextElement());
		}
    }
}