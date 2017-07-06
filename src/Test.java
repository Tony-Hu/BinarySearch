import java.util.*;

/**
 * Created by warha on 6/22/2017.
 */
public class Test {
    public static void main(String[] args){
        ArrayList a = new ArrayList();
        System.out.println(a instanceof Collection);
        System.out.println(a instanceof Set);
        System.out.println(a instanceof List);
        System.out.println(a instanceof AbstractList);
    }
}
