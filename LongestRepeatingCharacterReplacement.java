import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    static int LongestRepeatingCharacterReplacementBrute(String s,int k){
        int n = s.length(),maxCount,length,maxLength = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            maxCount = 0;
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'A']++;
                maxCount = Math.max(maxCount,count[s.charAt(j) - 'A']);
                length = j - i + 1;
                if (length - maxCount <= k)maxLength = Math.max(length,maxLength);
            }
        }
        return maxLength;
    }
    static int LongestRepeatingCharacterReplacementOptimal1(String s,int k){
        int n = s.length();
        int l = 0,r = 0,maxLength = 0,maxFreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (r < n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) + 1);
            maxFreq = Math.max(maxFreq,map.get(s.charAt(r)));
            while (r - l + 1 - maxFreq > k){
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                    int maxValue = Integer.MIN_VALUE;
                for (int x : map.values()){
                    maxValue = Math.max(maxValue,x);
                }
                maxFreq = maxValue;
                l++;
            }
            maxLength = Math.max(maxLength,r - l + 1);
            r++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "AABAABBAA";
        System.out.println(LongestRepeatingCharacterReplacementBrute(s,2));
    HashMap<Character,Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('B', 5);
        map.put('C', 3);
        map.put('D', 7);
        map.put('E', 2);
        for (int x : map.values()){
            System.out.print(x+" ");
        }
    }
}
