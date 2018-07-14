题目描述
=====================
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。

请问用n个 2*1 的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

```java
public class Solution {

    public int RectCover(int target) {
        if(target<1){
            return 1;
        }
        if(target==1||target==2){
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}

```