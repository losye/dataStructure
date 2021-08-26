### 解题思路
搜索DNA字符串，长度已经固定了，所以从0开始往前搜索固定长度的字符串，
遇到一个就判断是否和hashset里面的有重复，有则说明是目标子串，
没有，则加入hashset
注意：这里如果结果用list存放，会在出现次数大于2次的时候，需要判断
这个子串之前是否已经放入过了，为了避免这个复杂度，可以把结果也用hashset存放，最后
用ArrayList的构造方法转一下。

### 代码

```java
class Solution {
    //子串长度固定为10，那么就从DNA字符串中以窗口长度10来递进
    //每遇到一个，就检查和hashset里面是否有重复的
    //有这说明这个是目标子串，没有就加入到hashset
    //直到搜索完毕
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10;
        int len = s.length();
        HashSet<String>  set= new HashSet();
        //result也用hashset，这样即使出现次数超过两次，也不会重复记录了
        HashSet<String> result = new HashSet();
    
        for (int start = 0; start < len - L + 1; start++) {
            String tmp = s.substring(start, start + L);
            if (set.contains(tmp)){
                result.add(tmp);
            }
            set.add(tmp);
        }
        return new ArrayList<String>(result);
    }
}
```