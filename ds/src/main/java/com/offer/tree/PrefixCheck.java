package com.offer.tree;

import java.util.HashMap;

import org.junit.Test;
/**
 * 给定一个字符串数组（不含重复的字符串），如果其中某个字符串是另一个字符串的前缀则true，否则false
 * @author zzy
 * 前缀树的辨别方法
 * 把每个字符key想象成节点到节点的边。
 */
public class PrefixCheck {
	public  class Tries {
		private HashMap<Character, Tries> children = new HashMap<Character, Tries>();;
		private boolean end = false;

		public boolean addAndCheck(char[] chs, int i) {
			if (end) {
				return true;
			}
			if (i == chs.length) {
				end = true;
				return !children.isEmpty();
			}
			if (!children.containsKey(chs[i])) {
				children.put(chs[i], new Tries());

			}
			return children.get(chs[i]).addAndCheck(chs, i + 1);
		}

	}

	public  boolean hasPrefix(String[] strs) {
		Tries tries = new Tries();
		for (String str : strs) {
			if (str == null || str.equals("")) {
				return true;
			}
			if (tries.addAndCheck(str.toCharArray(), 0)) {
				return true;
			}
		}
		return false;
	}
	
	@Test
	public  void test() {
		String[] strs = { "abcd", "abc" };
		String[] str = { "abcd", "bcd" };
		System.out.println(hasPrefix(strs));
		System.out.println(hasPrefix(str));
	}
}
