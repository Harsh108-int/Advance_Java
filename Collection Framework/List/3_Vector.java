import java.util.Vector;

public class $_Vector {
    public static void main(String[] args) {

        //create Vector
        Vector<Integer> vec = new Vector<>();

        //adding elements
        vec.add(50);
        vec.add(23);
        vec.add(99);
        vec.add(32);

        //accessing element
        System.out.println("print all elements : " + vec);
        System.out.println("first element : " + vec.firstElement());
        System.out.println("last element : " + vec.lastElement());

        //modifying element
        vec.set(1,49);
        System.out.println("After modify : " + vec);

        //remove element
        vec.remove(3);
        System.out.println("after remove : " + vec);

        //check capacity
        System.out.println("capacity is  : " + vec.capacity());

        // Iterating over the vector
        for (int num : vec)
        {
            System.out.print(num + " ");
        }

    }
}
