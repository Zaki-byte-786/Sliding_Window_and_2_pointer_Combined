public class NumberofSubstringsContainingAllThreeCharacters {
    static int NumberofSubstringsContainingAllThreeCharactersBruteMethod(String s){
        int[] array;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            array = new int[3];
            for (int j = i; j < s.length(); j++) {
                array[s.charAt(j) - 'a'] = 1;
                if (array[0] + array[1] + array[2] == 3){
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }
    static int NumberofSubstringsContainingAllThreeCharactersOptimal(String s){
        int count = 0;
        int[] lastSeenArray = new int[3];
        for (int i = 0; i < 3; i++) lastSeenArray[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            lastSeenArray[s.charAt(i) - 'a'] = i;
            if (lastSeenArray[0] != -1 && lastSeenArray[1] != -1 && lastSeenArray[2] != -1){
                int min = Math.min(lastSeenArray[0],Math.min(lastSeenArray[1],lastSeenArray[2]));
                count += min + 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "bbacba";
        System.out.println(NumberofSubstringsContainingAllThreeCharactersBruteMethod(s));
        System.out.println(NumberofSubstringsContainingAllThreeCharactersOptimal(s));
    }
}
