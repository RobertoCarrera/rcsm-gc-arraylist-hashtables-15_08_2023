import java.util.HashMap;
import java.util.Map;

public class notasEstudiantesApp {
	
    public static void main(String[] args) {
    	
        Map<String, Double> notasProgramacion = new HashMap<>();
        notasProgramacion.put("Juan", 8.5);
        notasProgramacion.put("Maria", 9.0);
        notasProgramacion.put("Pedro", 7.5);
        notasProgramacion.put("Roberto", 4.5);
        notasProgramacion.put("Sandra", 5.3);
        notasProgramacion.put("Laura", 3.9);

        double total = 0;
        
        for (double nota : notasProgramacion.values()) {
        	
        	total += nota;
        }
        double media = total / notasProgramacion.size();

        System.out.println("Notas de los estudiantes:");
        for (Map.Entry<String, Double> entry : notasProgramacion.entrySet()) {
        	
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("La nota media del curso es: " + media);
    }
}