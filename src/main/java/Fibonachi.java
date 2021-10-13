public class Fibonachi {
    public int getNumberFibonachi(int n){
        if( n == 0 ) return 0;
        if( n == 1 ) return 1;
        if( n >= 2 ) {
            int fib = 0;
            int a1  = 0;
            int a2  = 1;
            for(int i = 1; i < n; i++) {
                fib = a1 + a2;
                a1 = a2;
                a2 = fib;
            }
            return fib;
        }
        return 0;
    }
}
