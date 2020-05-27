import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
    int pissano=60;
    int res=1;
    if(n<2)
        return n;
    int num1=(int)((n)%pissano);
    int num2=(int)((n+1)%pissano);
    
    int fib[]=new int[num2+1];
    if(num2==0)
        return 0;
    fib[0]=0;
    fib[1]=1;
    for(int i=2;i<=num2;i++)
    {
        fib[i]=(fib[i-1] +fib[i-2])%10;
    }
    return ((fib[num1]*fib[num2])%10);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

