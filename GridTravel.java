import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class GridTravel {

    private Map<String,Integer> memo = new HashMap<>();
    /* Say that you are a traveler on a 2D grid, you begin in the top left corner and your goal is to travel to
    the bottom right corner. You may only move down or right.
    In how many ways can you travel to the goal on a grid with dimensions m* n?

    write a function gridTraveler(m,n) that calculates this */

    public GridTravel(){}
    //time complexity from O(2^(n+m)) to O(m*n)
    //space complexity O(n+m)

    /*private int gridTraveler(int m, int n){
        if(n==1&&m==1)
            return 1;
        else if(n==0||m==0)
            return 0;
        return gridTraveler(m-1, n) + gridTraveler(m, n-1);
    }*/

    private int gridTraveler(int m, int n){
        String key = m + "," + n;
        if(memo.containsKey(key))
            return memo.get(key);
        else if(n==1&&m==1)
            return 1;
        else if(n==0||m==0)
            return 0;
        int result = gridTraveler(m-1, n) + gridTraveler(m, n-1);
        memo.put(key,result);
        return result;
    }
    public static void main(String[] args){
        GridTravel gt = new GridTravel();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number m");
        int m = scan.nextInt();
        System.out.println("Enter a number n");
        int n = scan.nextInt();
        System.out.println(gt.gridTraveler(m,n));
    }
}
