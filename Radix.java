public class Radix {

  public static int nth(int n, int col){
    for (int i=0; i<col; i++){
      n /= 10;
    }
    return n % 10;
  }

  public static int length(int n){
    int len = 1;
    while (n/10 != 0){
      n /= 10;
      len++;
    }
    return len;
  }

  // public static void merge(MyLinkedList original,MyLinkedList[]buckets){
  //
  // }

  //Tester 
  // public static void main(String[]args){
  //   Radix r = new Radix();
  //   int a =123;
  //   int b =482;
  //   int c= 21001245;
  //   System.out.println(r.nth(a, 0));
  //   System.out.println(r.nth(b, 2));
  //   System.out.println(r.nth(c, 0));
  //   System.out.println(r.length(a));
  //   System.out.println(r.length(b));
  //   System.out.println(r.length(c));
  // }

}
