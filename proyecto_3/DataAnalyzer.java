//Proyecto 3 -- Dominguez Duran Alan Axel -- 4CM11
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione la información que desea ver:");
            System.out.println("1. Cantidad de registros por sexo");
            System.out.println("2. Cantidad de registros por entidad federativa");
            System.out.println("3. Cantidad de personas con escolaridad \"preparatoria\" y su sexo");
            System.out.println("4. Edad promedio de las personas con escolaridad \"preparatoria\"");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    showRegistrosPorSexo();
                    break;

                case 2:
                    showRegistrosPorEntidad();
                    break;

                case 3:
                    showPreparatoriaPorSexo();
                    break;

                case 4:
                    showEdadPromedioPreparatoria();
                    break;

                case 5:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void showRegistrosPorSexo() {
        List<String> curps = DataReader.getCURPs("Logs.txt");
        Map<Character, Integer> registrosPorSexo = new HashMap<>();

        for (String curp : curps) {
            char sexo = curp.charAt(10);
            registrosPorSexo.put(sexo, registrosPorSexo.getOrDefault(sexo, 0) + 1);
        }

        System.out.println("1. Cantidad de registros por sexo:");
        for (Map.Entry<Character, Integer> entry : registrosPorSexo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void showRegistrosPorEntidad() {
        List<String> curps = DataReader.getCURPs("Logs.txt");
        Map<String, Integer> registrosPorEntidad = new HashMap<>();

        for (String curp : curps) {
            String entidad = curp.substring(11, 13);
            registrosPorEntidad.put(entidad, registrosPorEntidad.getOrDefault(entidad, 0) + 1);
        }

        System.out.println("2. Cantidad de registros por entidad federativa:");
        for (Map.Entry<String, Integer> entry : registrosPorEntidad.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void showPreparatoriaPorSexo() {
        Map<Character, Integer> preparatoriaPorSexo = new HashMap<>();
        Map<String, String> curpsAndEscolaridad = DataReader.getCURPsAndScholarship("Logs.txt");

        for (Map.Entry<String, String> entry : curpsAndEscolaridad.entrySet()) {
            String curp = entry.getKey();
            String escolaridad = entry.getValue();

            if (escolaridad.equals("PREPARATORIA")) {
                char sexo = curp.charAt(10);
                preparatoriaPorSexo.put(sexo, preparatoriaPorSexo.getOrDefault(sexo, 0) + 1);
            }
        }

        System.out.println("\n3. Cantidad de personas con escolaridad \"preparatoria\" y su sexo:");
        for (Map.Entry<Character, Integer> entry : preparatoriaPorSexo.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void showEdadPromedioPreparatoria() {
        Map<String, Integer> escolaridadAndAge = DataReader.getScholarshipAndAge("Logs.txt");
        int totalEdad = 0;
        int totalPersonas = 0;

        for (Map.Entry<String, Integer> entry : escolaridadAndAge.entrySet()) {
            String escolaridad = entry.getKey();
            int edad = entry.getValue();

            if (escolaridad.equals("PREPARATORIA")) {
                totalEdad += edad;
                totalPersonas++;
            }
        }

        if (totalPersonas > 0) {
            double promedioEdad = (double) totalEdad / totalPersonas;
            System.out.println("\n4. Edad promedio de las personas con escolaridad \"preparatoria\": " + promedioEdad);
        } else {
            System.out.println("\n4. No hay personas con escolaridad \"preparatoria\" en los datos.");
        }
    }
}
