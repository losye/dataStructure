<p>给定两个字符串 <code>s</code> 和&nbsp;<code>t</code> 。返回 <code>s</code> 中包含&nbsp;<code>t</code>&nbsp;的所有字符的最短子字符串。如果 <code>s</code> 中不存在符合条件的子字符串，则返回空字符串 <code>""</code> 。</p>

<p>如果 <code>s</code> 中存在多个符合条件的子字符串，返回任意一个。</p>

<p>&nbsp;</p>

<p><strong>注意： </strong>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC" 
<strong>解释：</strong>最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "aa"
<strong>输出：</strong>""
<strong>解释：</strong>t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, t.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> 和 <code>t</code> 由英文字母组成</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？</p>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 76&nbsp;题相似（本题答案不唯一）：<a href="https://leetcode-cn.com/problems/minimum-window-substring/">https://leetcode-cn.com/problems/minimum-window-substring/</a></p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 72, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1。过年前最后一期打卡挑战 [开始报名](https://aep.xet.tech/s/1a9ByX)。**



<p><strong><a href="https://labuladong.github.io/article?qno=剑指OfferII017" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [76. 最小覆盖子串](/problems/minimum-window-substring) 相同。

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 85 页。

这题就是典型的滑动窗口类题目，一般来说难度略高，解法框架如下：

```cpp
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置***/
        printf("window: [%d, %d)n", left, right);
        /********************/

        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

具体的算法原理看详细题解吧，这里写不下。

**详细题解：[我写了首诗，把滑动窗口算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=滑动窗口技巧进阶)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[滑动窗口](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```cpp
class Solution {
    public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = INT_MAX;/**<extend down -200>

![](https://labuladong.github.io/algo/images/slidingwindow/1.png)
*/
        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {/**<extend down -200>

![](https://labuladong.github.io/algo/images/slidingwindow/2.png)
*/
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }/**<extend up -50>

![](https://labuladong.github.io/algo/images/slidingwindow/4.png)
*/
        }
        // 返回最小覆盖子串
        return len == INT_MAX ?
                "" : s.substr(start, len);
    }
};
```

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>



