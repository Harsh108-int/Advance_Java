import java.util.LinkedList;

public class $LinkList {
    public static void main(String[] args) {

        //create LinkedList
        LinkedList<Integer> arr = new LinkedList<>();

        //add elements
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        //add at Specified Position
        arr.addFirst(0);
        arr.addLast(5);

        //access elements
        System.out.println("First Element :" + arr.getFirst());
        System.out.println("Last Element : " + arr.getLast());
        System.out.println("Access element on Index 2: " + arr.get(2));

        //remove element
        arr.removeFirst();
        arr.removeLast();
        arr.remove(2);

        //check element is exist or not
        System.out.println("Element 33 is Exist :" + arr.contains(33));

        // Iterate element
        for (int num : arr)
        {
            System.out.print(num +" ");
        }

    }
}
