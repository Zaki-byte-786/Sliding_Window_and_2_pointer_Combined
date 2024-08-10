import java.util.HashMap;

public class MinimumWindowSubstring {
    static String BruteChatgpt(String s,String t){
        HashMap<Character, Integer> map = new HashMap<>();

        int count, minLength = Integer.MAX_VALUE, firstIndex = 0;

        // Iterate over each starting index of the string s
        for (int i = 0; i < s.length(); i++) {
            count = 0;

            // Initialize/reset the frequency map for each new starting point
            for (char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Iterate over the substring starting from index i
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);

                // If the current character is in t, decrement its count in the map
                if (map.containsKey(currentChar)) {
                    if (map.get(currentChar) > 0) {
                        count++;
                    }
                    map.put(currentChar, map.get(currentChar) - 1);
                }

                // If all characters are matched, update the minimum length and starting index
                if (count == t.length()) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        firstIndex = i;
                    }
                    break;
                }
            }

            // Clear the map for the next iteration
            map.clear();
        }

        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(firstIndex, firstIndex + minLength);
    }
    static String Brute(String s,String t){
        HashMap<Character,Integer> map = new HashMap<>();

        int count,minLength = Integer.MAX_VALUE,firstIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = 0; j < t.length(); j++) {
                map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0) + 1);
            }
            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))){
                    if (map.get(s.charAt(j)) > 0) count++;
                map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
                }
                if (count == t.length()){
                    if (j - i + 1 < minLength){
                        minLength = j - i + 1;
                        firstIndex = i;
                    }
                 break;
                }
            }
            map.clear();
        }
        if (minLength == Integer.MAX_VALUE)return "";
return s.substring(firstIndex,firstIndex + minLength);

    }
    static String Optimal(String s,String t){
        int count  = 0,firstIndex = 0,l = 0,minLength = Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)){
                if (map.get(ch) > 0)count++;
                map.put(ch,map.get(ch) - 1);
            }
            while (count == t.length()){
                if (r - l + 1 < minLength){
                    minLength = r - l + 1;
                    firstIndex = l;
                }
                if (map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l)) + 1);
                if (map.get(s.charAt(l)) > 0)count--;
                }
                l++;
            }
        }
     return (minLength == Integer.MAX_VALUE) ? "": s.substring(firstIndex,firstIndex + minLength);
    }
    static String OptimalChatgpt(String s, String t) {
        int count = 0, firstIndex = 0, l = 0, minLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) count++;
                map.put(ch, map.get(ch) - 1);
            }
            while (count == t.length()) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    firstIndex = l;
                }

                char leftChar = s.charAt(l);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count--;
                }
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(firstIndex, firstIndex + minLength);
    }
    public static void main(String[] args) {
        String s = "ddaaabbc";
        String t = "abc";
//        System.out.println(Brute(s,t));
//        System.out.println(BruteChatgpt(s,t));
//        HashMap<Character,Integer> map = new HashMap<>();
//        map.put('a',map.getOrDefault('a',0) - 1);
//        System.out.println(map);
        System.out.println(OptimalChatgpt(s,t));
        System.out.println(Optimal(s,t));
    }
}
