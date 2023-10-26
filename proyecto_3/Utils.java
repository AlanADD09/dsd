//Proyecto 3 -- Dominguez Duran Alan Axel -- 4CM11
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils{
    public static final List<String> educationLevels = Arrays.asList("PREESCOLAR", "PRIMARIA", "SECUNDARIA", "PREPARATORIA", "UNIVERSIDAD", "MAESTRIA", "DOCTORADO");

    static String getCURP() {
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numero = "0123456789";
        String Sexo = "HM";
        String Entidad[] = {"AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS"};
        int indice;
        StringBuilder sb = new StringBuilder(18);

        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }

        for (int i = 5; i < 11; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }

        indice = (int) (Sexo.length()* Math.random());
        sb.append(Sexo.charAt(indice));        
        sb.append(Entidad[(int)(Math.random()*32)]);

        for (int i = 14; i < 17; i++) {
            indice = (int) (Letra.length()* Math.random());
            sb.append(Letra.charAt(indice));        
        }

        for (int i = 17; i < 19; i++) {
            indice = (int) (Numero.length()* Math.random());
            sb.append(Numero.charAt(indice));        
        }

        return sb.toString();
    }

    public static String generatePhoneNumber() {
        Random rand = new Random();
        String countryCode = "+52";
        String areaCode = String.format("%03d", rand.nextInt(1000));
        String firstPart = String.format("%03d", rand.nextInt(1000));
        String secondPart = String.format("%04d", rand.nextInt(10000));
        return countryCode + areaCode + firstPart + secondPart;
    }

    public static String getRandomEducationLevel() {
        long seed = System.currentTimeMillis();
        Collections.shuffle(educationLevels, new Random(seed));
        Random random = new Random(seed);
        int index = random.nextInt(educationLevels.size());
        return educationLevels.get(index);
    }

    public static String generateAge() {
        Random rand = new Random();
        int randomNum = rand.nextInt((100 - 18) + 1) + 18;
        return Integer.toString(randomNum);
    }

}
