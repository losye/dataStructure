题目描述
==============================
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:

在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。

但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？

例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
```java
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;;
        int temp = 0;
        for(int i=0;i<array.length;i++){
            temp += array[i];
            max = Math.max(max,temp);
            temp = temp<0?0:temp;
        }
        return max;
    }
}
```
如果arr[i]...arr[j]这段是最大子数组的话，那么arr[0]..arr[i-1]和arr[j+1]...arr[len-1]
这两段子数组的和分别都是负的！！！所以..
所以temp如果是负的就可以舍弃了，因为最后的结果是不可能包含这段值的。。
