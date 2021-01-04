import java.util.Scanner;
public class Sort{
  
  public Sort(){}
  
  //a[] from index to c, and c+1 to d
  public void merge(int[] a, int b, int c, int d){
    int sub1 = c - b + 1;
    int sub2 = d - c;
    
    int[] newArr1 = new int[sub1];
    int[] newArr2 = new int[sub2];
    for(int x=0; x<sub1; x++){
      newArr1[x] = a[b + x];
    }
    for(int y=0; y<sub2; y++){
      newArr2[y] = a[c + y + 1];
    }
    int x=0,y=0,n=b;
    while(x<sub1 && y<sub2){
      if(newArr1[x] <= newArr2[y]){
        a[n] = newArr1[x];
        x++;
      } else {
        a[n] = newArr2[y];
        y++;
      }
      n++;
    }
    while(x<sub1){
      a[n] = newArr1[x];
      x++;
      n++;
    }
    while(y<sub2){
      a[n] = newArr2[y];
        y++;
      n++;
    }
  }
  
  public void mergesort(int[] a, int left, int right){
    if(left<right){
      int mid = (left+right)/2;
      mergesort(a, left, mid);
      mergesort(a, mid + 1, right);
      merge(a, 1, mid, right);
    }
  }
  public void insertionsort(int[] a, int n, int x){
    if(n<a.length){
      int c = n;
      while(c>=0){
        if(a[c] > x){
          a[c+1] = a[c];
          a[c] = x;
        }
        c--;
      }
      
      print(a);
      System.out.println();
      if(n<a.length-1)
        insertionsort(a,n+1,a[n+1]);
    }
    
  }
  
  public int partition(int a[], int l, int r){
    int p = a[r];
    int i = l-1;
    for(int x=l; x<r; x++){
      if(a[x] < p){
        i++;
        int temp = a[i];
        a[i] = a[x];
        a[x] = temp;
      }
    }
    int temp2 = a[i+1];
    a[i+1] = a[r];
    a[r] = temp2;
    
    return i+1;
  }
  
  public void quicksort(int a[], int l, int r){
    if(l<r){
      int index = partition(a,l,r);
      quicksort(a, l, index-1);
      quicksort(a, index+1, r);
      System.out.println();
      print(a);
    }
  }
  
  public void print(int[] arr){
    System.out.print("{");
    for(int x=0; x<arr.length; x++){
      if(x!=arr.length-1)
        System.out.print(arr[x]+", ");
      else
        System.out.print(arr[x]);
    }
    System.out.print("}");
  }
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Sort s = new Sort();
    System.out.println("enter the amount of numbers in the array");
    int len = scan.nextInt();
    int[] num = new int[len];
    for(int x=0; x<num.length; x++){
      num[x] = (int) ((Math.random() * 20)+(Math.random() * 50));
    }
    boolean happens = false;
    while(happens == false){
      System.out.println("which sort would you like to use? (Insertion, Merge, Quick");
      String input = scan.next();
      if(input.equals("Merge")){
        s.mergesort(num,0,num.length-1);
        happens = true;
      } else if(input.equals("Insertion")){
        s.insertionsort(num,0,num[0]);
        happens = true;
      } else if(input.equals("Quick")){
        s.quicksort(num,0,num.length-1);
        happens = true;
      }
    } 
  }
}