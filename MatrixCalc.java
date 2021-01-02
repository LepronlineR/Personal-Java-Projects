import java.util.Scanner;
public class MatrixCalc{
  private static Scanner scan = new Scanner(System.in);
  public static int[][] createMatrix(int[][] matrix){
    for(int x=0;x<matrix.length;x++){
      for(int y=0; y<matrix[x].length;y++){
        System.out.println("Enter the number at column: "+x+" row: "+y);
        int input = scan.nextInt();
        matrix[x][y] = input;
      }
    }
    return matrix;
  }
  public static void printMatrix(int[][] matrix){
    for(int x=0;x<matrix.length;x++){
      for(int y=0; y<matrix[x].length;y++){
        System.out.print(matrix[x][y]+ " ");
      }
      System.out.println();
    }
  }
  public static int[][] getAddition(int[][] matOne, int[][] matTwo){
    int[][] matrix = new int[matOne.length][matOne[0].length];
    for(int x=0;x<matOne.length;x++){
      for(int y=0; y<matOne[x].length;y++){
        matrix[x][y]=matOne[x][y]+matTwo[x][y];
      }
    }
    return matrix;
  }
  public static int[][] getSubtraction(int[][] matOne, int[][] matTwo){
    int[][] matrix = new int[matOne.length][matOne[0].length];
    for(int x=0;x<matOne.length;x++){
      for(int y=0; y<matOne[x].length;y++){
        matrix[x][y]=matOne[x][y]-matTwo[x][y];
      }
    }
    return matrix;
  }
  public static int[][] getMultiplication(int[][] matOne, int[][] matTwo){
    int[][] matrix = new int[matOne.length][matTwo[0].length];
    
    for(int x=0;x<matOne.length;x++){
      for(int y=0; y<matOne[x].length;y++){
        int temp =0;
        for(int z=0; z<matTwo.length;z++){
          temp+=matOne[x][z]*matTwo[z][y];
        }
        matrix[x][y]=temp;
      }
    }
    return matrix;
  }
  public static void main(String[] args){
    System.out.println("Enter the matrix calculator (1 Addition, 2 Subtraction, 3 Multiplication)");
    int calcInput = scan.nextInt();
    System.out.println("Enter the number of rows for the 1st matrix (Matrix A)");
    int oneRow = scan.nextInt();
    System.out.println("Enter the number of columns for the 1st matrix (Matrix A");
    int oneCol = scan.nextInt();
    System.out.println("Enter the number of rows for the 2nd matrix (Matrix B)");
    int twoRow = scan.nextInt();
    System.out.println("Enter the number of columns for the 2st matrix (Matrix B");
    int twoCol = scan.nextInt();
    int[][] matrixA = new int[oneRow][oneCol];
    int[][] matrixB = new int[twoRow][twoCol];
    if(calcInput==1){
      if(oneRow==twoRow&&oneCol==twoCol){
        printMatrix(getAddition(createMatrix(matrixA), createMatrix(matrixB)));
      }
    }
    if(calcInput==2){
      if(oneRow==twoRow&&oneCol==twoCol){
        printMatrix(getSubtraction(createMatrix(matrixA), createMatrix(matrixB)));
      }
    }
    if(calcInput==3){
      if(oneCol==twoRow){
        printMatrix(getMultiplication(createMatrix(matrixA), createMatrix(matrixB)));
      }
    }
  }
}