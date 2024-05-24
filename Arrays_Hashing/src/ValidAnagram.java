import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1= "listen";
        String str2= "enlist";
        System.out.println(isAnagram(str2,str1)?"is a valid Anagram":"its not a Anagram");
        System.out.println(isAnagram1(str2,str1)?"is a valid Anagram":"its not a Anagram");
        System.out.println(isAnagram2(str2,str1)?"is a valid Anagram":"its not a Anagram");
    }

    private static boolean isAnagram2(String str2, String str1) {
        if (str2.length()!=str1.length())
            return false;
        Map<Character,Integer> frquency = new HashMap<>();
        for (char ch:str1.toCharArray()){
            frquency.put(ch, frquency.getOrDefault(ch,0)+1);
        }
        for (char ch:str2.toCharArray()) {
            frquency.put(ch, frquency.getOrDefault(ch,0)-1);
            if (frquency.get(ch)<0)
                return false;
        }
        return true;
    }

    private static boolean isAnagram1(String str2, String str1) {
        char[] arr1=str2.toCharArray();
        char[] arr2=str1.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    private static boolean isAnagram(String str2, String str1) {
        if (str2.length()!=str1.length())
            return false;
        int a=0,b=0;
        System.out.println(str1.length());
        for (int i=0;i<str1.length();i++){
            a=a+Character.valueOf(str1.charAt(i)).hashCode();
            b=b+Character.valueOf(str2.charAt(i)).hashCode();
        }
        System.out.println(a+" = "+b);
        return a==b;
    }
}
