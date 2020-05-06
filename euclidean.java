import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
   if(b==0)
        return a;
    a=a%b;
    return gcd(b,a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
