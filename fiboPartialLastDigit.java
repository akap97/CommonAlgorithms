import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;
        ArrayList<Long> a =new ArrayList<>();
        a.add((long)0);
        a.add((long)1);

        for (int i = 2; i <60; ++i) {
            a.add(a.get(i-1)+a.get(i-2));
            //System.out.println(a.get(i));
        }
        int m=(int)(from%60);
        int n=(int)(to%60);
        
        if(n<=m)
            n+=60;
        for(int i=m;i<=n;i++)
            sum+=a.get(i%60);
        
        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

