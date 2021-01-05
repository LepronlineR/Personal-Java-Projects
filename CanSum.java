import java.util.Map;
import java.util.HashMap;

/*Write a function canSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array.
Yu may use an element of the array as many times as needed
You may assume that all input numbers are nonnegative*/

public class CanSum {

    private Map<Integer, Boolean> memo = new HashMap<>();

    public CanSum(){}
    //time complexity from O(array length ^ target sum) - O(n^m)
    //space complexity from O(m)

    /*
    private boolean canSum(int targetSum, int[] numbers){
        if(targetSum == 0)
            return true;
        if(targetSum <= 0)
            return false;
        for(int x=0; x<numbers.length; x++){
            int remainder = targetSum - numbers[x];
            if(canSum(remainder,numbers)==true)
                return true;
        }
        return false;
    }*/

    private boolean canSum(int targetSum, int[] numbers){
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);
        else if(targetSum == 0)
            return true;
        else if(targetSum < 0)
            return false;
        for(int x=0; x<numbers.length; x++){
            int remainder = targetSum - numbers[x];
            if(canSum(remainder,numbers)==true){
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
    public static void main(String[] args){
        CanSum cs = new CanSum();
        int[] numone = {2, 3};
        int[] numtwo = {5, 3, 4, 7};
        int[] numthree = {2, 4};
        int[] numfour = {2, 3, 5};
        int[] numfive = {7, 14};
        System.out.println(cs.canSum(7,numone));
        System.out.println(cs.canSum(7,numtwo));
        System.out.println(cs.canSum(7,numthree));
        System.out.println(cs.canSum(8,numfour));
        System.out.println(cs.canSum(300,numfive));

    }
}
