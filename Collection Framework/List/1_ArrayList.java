import java.util.ArrayList;

public class 1_ArrayList {
    public static void main(String[] args) {
        //Create an Array List
        ArrayList<Integer> arr = new ArrayList<>();

        //add elements
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        //access elements using get() method who give index
        System.out.println(arr.get(2));

        //modify elements
        arr.set(1,22);
        arr.set(3,44);

        //remove element using remove() who give index
        arr.remove(0);

        //check if element is existed
        System.out.println("Element 22 present in List or not :" + arr.contains(22));


        //loop for print
        for(int num : arr)
        {
            System.out.print(num + " ");
        }

        //check size of ArrayList
        System.out.println("Size of ArrayList : " + arr.size());

        //clear List
        arr.clear();

    }

}