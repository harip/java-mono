import java.io.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.function.Predicate;

class PrimeComposite_Factorial {
    
    // Function to check if the given number is prime or composite
    public void primeOrComposite(int n) {
        // System.out.println(n);
        Predicate<Integer> isPrime = num -> {
            if (num < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        };
        
        Consumer<String> printResult = result -> {System.out.println(result);};
        
        boolean isP = isPrime.test(n);
        if (isP) {
            printResult.accept("Prime");
        } else if (n > 1) {
            printResult.accept("Composite");
        } else {
            printResult.accept("Neither Prime Nor Composite");
        }
    }
    
    // Function to find the factorial of the given number
    public void findFactorial(int n) {
        Consumer<Long> printFactorial = result -> System.out.println(result);
        
        Long factorial = 1L;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        printFactorial.accept(factorial);
    }
}
public class PrimeComposite_FactorialMain
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
                
         PrimeComposite_Factorial xyz=new PrimeComposite_Factorial();
          
         xyz.primeOrComposite(n);
         xyz.findFactorial(n);
        
    }
}
