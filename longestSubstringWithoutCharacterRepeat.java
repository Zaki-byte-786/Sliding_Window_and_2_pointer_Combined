import java.util.HashMap;
import java.util.HashSet;

public class longestSubstringWithoutCharacterRepeat{
    static int longestSubstringWithoutCharacterRepeatMethod(String s){
        HashSet<Character> hs;
        int length,mom = 0,n = s.length();
        for (int i = 0; i < n; i++) {
            hs = new HashSet<>();
            length = 0;
            for (int j = i; j < n; j++) {
                if (hs.contains(s.charAt(j)))break;
                else {
                    length++;
                    hs.add(s.charAt(j));
                    mom = Math.max(mom, length);
                }
            }
        }
        return mom;
    }
    static int longestSubstringWithoutCharacterRepeatOptimal(String s){
        HashMap<Character,Integer> hs = new HashMap<>();
        int i = 0,j = 0, n = s.length(),max = 0,length ;
        if (s.isEmpty())return 0;
        if (s.length() == 1)return 1;
        while (j < n){
            char ch = s.charAt(j);
            if (hs.containsKey(ch)){
                while (s.charAt(i) != ch){
                    hs.remove(s.charAt(i),i);
                    i++;
                }
                hs.remove(s.charAt(i),i);
                i++;
            }
                hs.put(ch,j);
                length = (j - i + 1);
                max = Math.max(length,max);
                j++;
        }
            return max;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0,j = 0;
        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                maxLength = Math.max(maxLength,i- j + 1);
            }
            else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(s.charAt(i));
            }
            i++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
String s = "abccbcbb";
        System.out.println(longestSubstringWithoutCharacterRepeatMethod(s));

    }
}
