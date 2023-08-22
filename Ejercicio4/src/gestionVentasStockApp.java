import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class gestionVentasStockApp {
	
    private static Hashtable<String, Double> productos = new Hashtable<>();

    private static List<String> compras = new ArrayList<>();

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
    	
        for (int i = 0; i < 10; i++) {
            agregarArticulo();
        }

        while (true) {
            System.out.println("1. Gestionar ventas");
            System.out.println("2. Controlar stock");
            System.out.println("3. Salir");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    gestionarVentas();
                    break;
                case 2:
                    controlarStock();
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private static void gestionarVentas() {
    	
        while (true) {
            System.out.println("1. Añadir compra");
            System.out.println("2. Caja del día");
            System.out.println("3. Volver al menú principal");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    anadirCompra();
                    break;
                case 2:
                    resumenCaja();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private static void anadirCompra() {
        int op = 0;

        String producto = "";
        int cantidad = 0;
        float precio_u = 0;
        float iva = 0;
        float total_bruto = 0;
        float total_iva = 0;
        float dinero = 0;
        float cambio = 0;

        do {

            System.out.println("Dame el nombre del producto que se ha comprado: ");
            producto = teclado.next();
            compras.add(producto);

            System.out.println("La cantidad comprada: ");
            cantidad = teclado.nextInt();
            compras.add(Integer.toString(cantidad));

            System.out.println("El precio que tiene la unidad: ");
            precio_u = teclado.nextFloat();
            compras.add(Float.toString(precio_u));

            do {

                System.out.println("Qué iva tiene aplicado: (4% o 21%)");
                iva = teclado.nextInt();
            } while ((iva != 4) && (iva != 21));
            compras.add(Float.toString(iva));

            total_bruto = (precio_u * cantidad);
            compras.add(Float.toString(total_bruto));
            total_iva = total_bruto * (1 + iva);
            compras.add(Float.toString(total_iva));

            System.out.println("Con cuánto dinero paga el cliente: ");
            dinero = teclado.nextFloat();
            compras.add(Float.toString(dinero));

            if ((dinero - total_iva) < 0) {
                cambio = dinero - total_iva;
            } else {
                System.out.println("El cliente no tenía suficiente dinero para pagar");
                cambio = 0;
            }

            System.out.println("Si no quieres añadir más productos, pulsa 0 + enter");
            op = teclado.nextInt();
        } while (op != 0);
    }

    private static void resumenCaja() {

        System.out.println(
                "Nombre producto | Unidades | Precio/U | IVA | Precio total bruto | Precio total + IVA | Cantidad pagada | Cambio");
        for (int i = 0; i < compras.size(); i++) {

            System.out.print(compras.get(i) + " \t| ");
            if ((i % 6 == 0) && (i != 0)) {
                System.out.println("");
            }
        }
        System.out.println("");
    }

    private static void controlarStock() {
    	
        while (true) {
            System.out.println("1. Agregar un nuevo artículo");
            System.out.println("2. Consultar información de un artículo");
            System.out.println("3. Listar todos los artículos");
            System.out.println("4. Volver al menú principal");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    consultarArticulo();
                    break;
                case 3:
                    listarArticulos();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private static void agregarArticulo() {
    	
        System.out.print("Introduce el nombre del nuevo artículo: ");
        String nombre = teclado.nextLine();
        System.out.print("Introduce el precio del nuevo artículo: ");
        double precio = teclado.nextDouble();
        teclado.nextLine();

        productos.put(nombre, precio);
    }

    private static void consultarArticulo() {
    	
        System.out.print("Introduce el nombre del artículo a consultar: ");
        String nombre = teclado.nextLine();

        if (productos.containsKey(nombre)) {
        	
            System.out.println("El precio del artículo " + nombre + " es " + productos.get(nombre));
        } else {
            System.out.println("El artículo " + nombre + " no existe en la base de datos");
        }
    }

    private static void listarArticulos() {
    	
        Enumeration<String> nombres = productos.keys();
        Enumeration<Double> precios = productos.elements();

        while (nombres.hasMoreElements()) {
            System.out.print("Producto: " + nombres.nextElement() + " | ");
            System.out.println("Precio: " + precios.nextElement());
        }
    }
}
