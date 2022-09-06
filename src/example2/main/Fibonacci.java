package example2.main;

public class Fibonacci {

    public int NFibonacci(int n){
      if(n <= 0 ){
          return 0;
      }
      if(n == 1 || n ==2){
          return 1;
      }
      return NFibonacci(n - 2) + NFibonacci(n-1);
    }
    //0 1 1 2 3 5 8 13 21
}
