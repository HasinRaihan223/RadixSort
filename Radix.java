public class Radix {

  public static int nth(int n, int col){
    return (Math.abs(n) / (int)(Math.pow(10, col))) % 10;
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

  public static void merge(SortableLinkedList original,SortableLinkedList[]buckets){
    for(int i=0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0; i < buckets.length; ++i) {
      buckets[i] = new SortableLinkedList();
    }
    int numPasses = 1;
    for(int i = 0; i < numPasses; i++){
      for(int j = 0; j < data.size(); j++){
        int value = data.remove(0);
        int digit = nth(value, i);
        buckets[digit].add(value);
        if (length(value) > numPasses) {
          numPasses = length(value);
        }
      }
      merge(data, buckets);
    }
  }

  //Tester
  // public static void main(String[]args){
  //   Radix r = new Radix();
  //   int a =-2345;
  //   int b =0;
  //   int c= 21001245;
  //   System.out.println(r.length(a));
  //   System.out.println(r.length(b));
  //   System.out.println(r.length(c));
  // }

}
