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
    for(int i = 0; i < buckets.length; i++) {
      buckets[i] = new SortableLinkedList();
    }
    // Biggest digit length
    int k = 0;
    for(int i = 0; i < data.size(); ++i) {
      k = Math.max(k, length(data.get(i)));
    }
    for(int i = 0; i < k; i++){
      while(data.size()>0){
        int value = data.remove(0);
        int digit = nth(value, i);
        buckets[digit].add(value);
      }
      merge(data, buckets);
    }
  }

  // public static void radixSort(SortableLinkedList data){
  //
  // }

  //Tester
  // public static void main(String[]args){
  //   SortableLinkedList r = new SortableLinkedList();
  //   r.add(23);
  //   r.add(11);
  //   r.add(67);
  //   r.add(99);
  //   r.add(5);
  //   r.add(104);
  //   r.add(134);
  //   r.add(1034);
  //   r.add(404);
  //   radixSortSimple(r);
  //   System.out.println(r);
  // }

}
