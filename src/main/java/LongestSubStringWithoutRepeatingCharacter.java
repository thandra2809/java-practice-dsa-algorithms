import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacter {


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, r);
            max = Math.max(max, r - left + 1);
        }
        return max;
    }

    static void main() {
        LongestSubStringWithoutRepeatingCharacter obj = new LongestSubStringWithoutRepeatingCharacter();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }

}
