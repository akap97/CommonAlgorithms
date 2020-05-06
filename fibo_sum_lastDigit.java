import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSum(long n) {
    int pissano=60;
    int res=1;
    if(n<2)
        return n;
    int num=(int)((n+2)%pissano);
    int fib[]=new int[num+1];
    fib[0]=0;
    fib[1]=1;
    for(int i=2;i<=num;i++)
    {
        fib[i]=(fib[i-1] +fib[i-2])%10;
    }
    if(fib[num] == 0){
        return 9;
    }
    return (fib[num]-1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

