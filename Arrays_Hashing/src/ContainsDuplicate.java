import java.util.*;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Integer[] arr ={2,4,5,6,5,1,8,9,7};
        System.out.println(findDuplicate(arr)?"Contains duplicate value":"No Duplicate values");
        System.out.println(findDuplicate8(arr)?"Contains duplicate value":"No Duplicate values");
        System.out.println(findDuplicate1(arr)?"Contains duplicate value":"No Duplicate values");
    }

    private static boolean findDuplicate(Integer[] arr) {
        List<Integer> entries = new ArrayList<>();
        for (int i:arr) {
            boolean b = !entries.contains(i) ? entries.add(i) : false ;//another way
            //boolean b = !entries.contains(i) && entries.add(i);
            if (!b)
                return true;
        }
        return false;
    }
    private static boolean findDuplicate8(Integer[] arr) {
        Set<Integer> dupSet= Arrays.stream(arr).collect(Collectors.toSet());
        return arr.length != dupSet.size();
    }
    private static boolean findDuplicate1(Integer[] arr) {
        Set<Integer> entries = new HashSet<>();
        for (int i : arr) {
            if (!entries.add(i))
                return true;
        }
        return false;
    }
}
