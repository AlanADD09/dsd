public class ej4 {
    public static void main(String args[]){
        System.out.println(Fibonacci(20));
    }

    static int Fibonacci(int num){
        int fib = 0;
        int a = 0;
        int b = 1;
        for(int i=0; i<num; i++) {
            int temp = fib;
            fib = fib + a + b;
            a = temp;
        }
        return fib;
    }
}