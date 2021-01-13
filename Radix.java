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

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList positives = new SortableLinkedList();
    SortableLinkedList negatives = new SortableLinkedList();
    while (data.size() > 0){
      int value = data.remove(0);
      if (value < 0){
        negatives.add(value);
      }
      else {
        positives.add(value);
      }
    }
    radixSortSimple(positives);
    radixSortSimple(negatives);
    // System.out.println(negatives);
    while(negatives.size() > 0) {
      data.add(negatives.remove(negatives.size() - 1));
    }
    data.extend(positives);
  }

  //Tester
  // public static void main(String[]args){
  //   SortableLinkedList r = new SortableLinkedList();
  //   r.add(-3);
  //   r.add(-5);
  //   r.add(-1);
  //   r.add(15);
  //   r.add(9);
  //   r.add(-100);
  //   r.add(-45);
  //   r.add(10324);
  //   r.add(509);
  //   radixSort(r);
  //   System.out.println(r);
  // }

}
