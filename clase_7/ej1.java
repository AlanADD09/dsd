import java.util.Random;
 
public class ej1 {
    private static char randomChar() {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'A');
    }

    private static String generateWord(){
        String word = "";
        for (int i = 0; i < 3; i++) {
            word = word + randomChar();
        }
        word = word + " ";
        return word;
    }

    private static int searchWords(String s, int idx){
        String sub = new String("IPN");
        int count = 0;
        while(idx >= 0){
            count++;
            idx = s.indexOf(sub, idx+1);
        }
        return count;
    }

    private static void countWordsString() {
        int n = 2000000;
        int count;
        StringBuilder cadenota = new StringBuilder();
        for (int i = 0; i < n; i++) {
            cadenota.append(generateWord());
        }
        count = searchWords(cadenota.toString(), 0);
        System.out.println(count);
    }

    private static char[] generateWordChar(){
        char[] word = new char[3];
        for (int i = 0; i < 3; i++) {
            word[i] = randomChar();
        }
        return word;
    }

    private static void countWordsChar() {
        int n = 1000000;
        int count=0;
        char[] cadenota = new char[n*4];
        for (int i = 0; i < n; i++) {
            cadenota[i] = randomChar();
            cadenota[i+1] = randomChar();
            cadenota[i+2] = randomChar();
            cadenota[i+3] = ' ';
        }
        for (int i = 0; i < n; i++) {
            if (cadenota[i+1] == 'I' && cadenota[i+2] == 'P' && cadenota[i+3] == 'N'){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        // countWordsString();
        countWordsChar();
    }
}