
import java.util.*;

public class Hmap {
    public static void main(String[] args) {
        HashMap<Integer, String > MCA= new HashMap<>();

        MCA.put(1, "Ayush");
        MCA.put(2,"Ayushi");
        MCA.put(3, "Udit");
        MCA.put(4, "Nishant");

        System.out.println(MCA);
        //update(Key is exsist)
        MCA.put(2, "Manav");
        //key does'nt exsist
        MCA.put(5,"Rahul");
        MCA.put(5,"Amit");

        // Can we add the value in hashmap?
        //answer is Yes, we add the value in hashmap
        MCA.put(null,"Amit");
        System.out.println(MCA);


        // Containskey function is return True(Key is exsist) or False(Key does'nt exsist)
//        System.out.println(MCA.containsKey(5));

        if(MCA.containsKey(5)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }

        //Get function is return values
        System.out.println(MCA.get(6));

    }
}
