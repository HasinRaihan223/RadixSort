public class Radix {

  public static int nth(int n, int col){
    for (int i=0; i<col; i++){
      n /= 10;
    }
    return n % 10;
  }

  public static int length(int n){
    int length = 0;
    if (n==0){
      return 1;
    }
    else if (n < 0){
      n = Math.abs(n);
    }
    length = (int) (Math.log10(n) + 1);
    return length;
  }

  // public static void merge(MyLinkedList original,MyLinkedList[]buckets){
  //
  // }

  //Tester
  public static void main(String[]args){
    Radix r = new Radix();
    int a =-2345;
    int b =0;
    int c= 21001245;
    System.out.println(r.length(a));
    System.out.println(r.length(b));
    System.out.println(r.length(c));
  }

}
