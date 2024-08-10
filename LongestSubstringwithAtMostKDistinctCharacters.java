import java.util.HashMap;
public class LongestSubstringwithAtMostKDistinctCharacters {
    static int Brute(String s,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
           map.clear();
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
                if (map.size() > k)break;
                maxLength = Math.max(maxLength,j -i + 1);
            }
        }
        return maxLength;
    }

    static int Optimal(String s,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int max = -1,j = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            while (map.size() > k){
                map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0)map.remove(s.charAt(j));
                j++;
            }
                max = Math.max(i - j + 1,max);
        }
        return max;
    }

    static int moreOptimal(String s,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int max = -1,j = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            if (map.size() > k){
                map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0)map.remove(s.charAt(j));
                j++;
            }
            if (map.size() <= k){
            max = Math.max(i - j + 1,max);
            }
        }
        return max;
    }



//    soution for exact k
//    static int Optimal(String s,int k){
//        HashMap<Character,Integer> map = new HashMap<>();
//        int max = -1,j = 0;
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
//            while (map.size() > k){
//                map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
//                if (map.get(s.charAt(j)) == 0)map.remove(s.charAt(j));
//                j++;
//            }
//            if (map.size() == k) {
//            max = Math.max(i - j + 1,max);
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        System.out.println(Optimal(s,2));
        System.out.println(Brute(s,2));
    }
}
