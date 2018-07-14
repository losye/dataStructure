题目描述
=============
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

```java
public class Solution {

    public int NumberOf1(int n) {
        int count = 0;
        if(n==0){
            return count;
        }
        while(n!=0){
          if((n&1)==1){
              count++;
          }
            n>>>=1;
        }
        return count;
    }
}
```
解题思路：
================
显而易见，每次与1与运算。再向后移一位。
