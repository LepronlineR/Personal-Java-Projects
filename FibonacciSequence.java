import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/*Write a function that takes in a number as an argument, the function should return the n-th number of the fibonacci sequence*/

public class FibonacciSequence{

    private Map<Integer, Integer> memo = new HashMap<>();

    public FibonacciSequence(){}
    //time complexity from O(2^n) to O(n)
    //space complexity O(n)

    /* private int fib(int x){
        if(x<=2)
            return 1;
        return fib(x-1)+fib(x-2);;
    }*/

    private int fib(int x){
        if(memo.containsKey(x)){
            //System.out.println("Getting memo "+x);
            return memo.get(x);
        }
        if(x<=2)
            return 1;
            //System.out.println("Computing "+x);
        int r = fib(x-1)+fib(x-2);
        memo.put(x,r);
        return r;
    }

    public static void main(String[] args){
        FibonacciSequence fs = new FibonacciSequence();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an input for the fibonnaci number");
        int n = scan.nextInt();
        System.out.println(fs.fib(n));
    }
}