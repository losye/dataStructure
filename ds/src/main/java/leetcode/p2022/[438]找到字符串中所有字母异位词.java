import com.sun.xml.internal.xsom.impl.SchemaImpl;

import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            Integer val = need.getOrDefault(c, 0);
            need.put(c, val + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0; int right = 0; int valid = 0;
        while (right < chars.length) {
            char rv = chars[right++];
            if (need.containsKey(rv)) {
                int rc = window.getOrDefault(rv, 0);
                window.put(rv, ++rc);
                if (rc == need.get(rv)) {
                    valid++;
                }
            }
            while (right - left >= p.toCharArray().length) {
                if (need.size() == valid) {
                    res.add(left);
                }
                char lv = chars[left++];
                if (need.containsKey(lv)) {
                    int  lc = window.getOrDefault(lv, 0);
                    window.put(lv, lc - 1);
                    if (lc == need.get(lv)) {
                        valid--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
