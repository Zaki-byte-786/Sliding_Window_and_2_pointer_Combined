import java.util.HashMap;
import java.util.HashSet;

public class fruit_into_basket {
    static int fruit_into_basket_Brute(int[] array){
        HashSet<Integer> hs;
        int max = 0 , n = array.length;
        if (array.length == 1)return 1;
        for (int i = 0; i < n; i++) {
            hs = new HashSet<>();
            for (int j = i; j < n; j++) {
                hs.add(array[j]);
                if (hs.size() > 2)break;
                max = Math.max(max,j - i + 1);
            }
        }
        return max;
    }
    static int fruit_into_basket_Optimal(int[] array){
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0,r = 0,max = 0;
        int n = array.length;
        while (r < n){
            if (map.containsKey(array[r])){
                map.put(array[r], map.get(array[r]) + 1);
            }
            else {
                map.put(array[r],1);
            }
            if (map.size() > 2){
                while (map.size() != 2){
                    map.put(array[l],map.get(array[l])-1);
                    if (map.get(array[l]) == 0)map.remove(array[l]);
                    l++;
                }
            }
            max = Math.max(max,r - l + 1);
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] fruits  = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(fruit_into_basket_Brute(fruits));
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(1,2);
//        map.put(2,3);
//        map.put(1,map.get(1) - 1);
//        System.out.println(map);
//        map.put(2,map.get(2) + 1);
//        System.out.println(map);
//        map.remove(1);
//        System.out.println(map);
        System.out.println(fruit_into_basket_Optimal(fruits));
    }
}
