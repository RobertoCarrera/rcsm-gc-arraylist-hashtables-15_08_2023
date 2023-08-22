import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class supermercadoApp {

	
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int opcion = 0;
		
		List<Double> carrito = new ArrayList<>();
		
		do {

			opcion = mostrarMenu();
			
			switch(opcion)
			{
			case 1:
				carrito = anadirCompras();
				break;
			case 2:
				resumenCaja(carrito);
				break;
			case 0:
				System.out.println("Saliendo del sistema");
				break;
			default:
				System.out.println("Error en el sistema");
				break;
			}
		}while(opcion != 0);
	}
	
	public static int mostrarMenu() {

		Scanner teclado = new Scanner(System.in);
		
		int op = 0;
		
		do {
			
			System.out.println("==== MENU =====");
			System.out.println("1. Añadir compra");
			System.out.println("2. Caja del día");
			System.out.println("0. Salir");
			op = teclado.nextInt();
			if((op<0) || (op>2))
			{
				System.out.println("Dame un número entre 0 y 2");
			}
		}while((op<0) || (op>2));
		
		return op;
	}
	
	public static List anadirCompras() {

		Scanner teclado = new Scanner(System.in);
		
		List<String> compras = new ArrayList<>();
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
			}while ((iva!=4)&&(iva!=21));
			compras.add(Float.toString(iva));
			
			total_bruto = (precio_u * cantidad);
			compras.add(Float.toString(total_bruto));
			total_iva = total_bruto*(1+iva);
			compras.add(Float.toString(total_iva));
			
			System.out.println("Con cuánto dinero paga el cliente: ");
			dinero = teclado.nextFloat();
			compras.add(Float.toString(dinero));
			
			if((dinero - total_iva) < 0)
			{
				cambio = dinero - total_iva;
			}else {
				System.out.println("El cliente no tenía suficiente dinero para pagar");
				cambio = 0;
			}
			
			System.out.println("Si no quieres añadir más productos, pulsa 0 + enter");
			op = teclado.nextInt();
		}while(op != 0);
		
		return compras;
	}
	
	public static void resumenCaja(List caja) {
						
		System.out.println("Nombre producto | Unidades | Precio/U | IVA | Precio total bruto | Precio total + IVA | Cantidad pagada | Cambio");
		for(int i = 0; i < caja.size(); i++)
		{

			System.out.print(caja.get(i)+" \t| ");
			if((i%6 == 0) && (i != 0))
			{
				System.out.println("");
			}
		}
		System.out.println("");
	}

}