import java.util.HashMap;

public class Main {
    static int subArraySumCount(int[] array,int k){
        int ps = 0,ans = 0,n = array.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            ps += array[i];
            if (map.containsKey(ps-k))ans += map.get(ps-k);
            map.put(ps,map.getOrDefault(ps,0) + 1);
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] array = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(subArraySumCount(array,3));
    }
}