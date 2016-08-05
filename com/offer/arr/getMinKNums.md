找到无序数组中最小的K个数
==============================

要求时间复杂度为O(N*lgk)或O(N)


O(N)
=======
其实有点类似找到数组中超过一半数的那题，如果利用快排思想。

如果找到第K小的数，那么在它之前的数就是最小的K个数。因为：
在时间复杂度O(N)内，从无序的数组中找到第k小的数。显而易见的是，如果我们找到了第k小的数，那么想求arr中最小的k个数，
就是再遍历一次数组的工作量而已。
public class getMinKNum {

//利用快排思想
public static void getKNum(int[] arr,int start,int end, int k){

		int index = partition(arr, start, end);
		while(index != k-1){
			if(index < k-1){
				index = partition(arr, index+1, end);
			}else if(index > k-1){
				index = partition(arr, start, index-1);
			}else{
				return;
			}
		}
	}
	//一次Partition的过程
	public static int partition(int[] arr,int start,int end){
	
		if(arr==null || arr.length==0){
			return -1; 
		}
		int l = start;
		int r = end;
		int temp = arr[l];
		if(l<r){
			while(l<r && temp >= arr[r]){
				r--;
			}
			if(l<r){
				arr[l++]=arr[r];
			}
			while(l<r && temp < arr[l]){
				l++;
			}
			if(l<r){
				arr[r--] = arr[l];
			}
		}
		arr[l] = temp;
		return l;
	}
}

有些书上说利用BFPRT算法实现O(N)，但是以上快排思想的方法也能做到O(N)，这里简单做下介绍

BFPRT算法
============
假设BFPRT算法的函数是 int select(int[] arr, k)，该函数的功能为在arr中找到第k小的数，然后返回该数。
1，将arr中的n个元素划分成n/5组，每组5个元素，如果最后的组不够5个元素，那么最后
剩下的元素为一组(n%5个元素)；
2，对每个组进行插入排序，只是每个组最多5个元素之间的组内排序，组与组之间并不排
序。排序后找到每个组的中位数，如果组的元素个数为偶数，这里规定找到下中位数；
3，步骤2中一共会找到n/5个中位数，让这些中位数组成一个新的数组，记为mArr。递归调
用select(mArr,mArr.length/2)，意义是找到mArr这个数组中的中位数，即mArr中的第
(mArr.length/2)小的数；
4，假设步骤3中递归调用select(mArr,mArr.length/2)后，返回的数为x。根据这个x划分整
个arr数组(partition过程)，划分完成的功能为在arr中，比x小的数都在x的左边，大于x的数
都在x的右边，x在中间。假设划分完成后，x在arr中的位置记为i；
5，如果i==k，说明x为整个数组中第k⼩小的数，直接返回。
如果i<k，说明x的处在第k小的数的左边，应该在x的右边寻找第k小的数，所以递归调
用select函数，在左半区寻找第k小的数。
如果i>k，说明x的处在第k小的数的右边，应该在x的左边寻找第k小的数，所以递归调
用select函数，在右半区寻找第(i-k)小的数。

为什么要如此费力的这么处理arr数组呢？又要5个数分1组，又要求中位数的中位数，又要
划分的，好麻烦啊。就是因为以中位数的中位数x划分的数组，可以在步骤5的递归时，确
保肯定淘汰掉一定的数据量，起码淘汰掉3N/10-6的数据量！
不得不说的是，关于选择划分元素的问题，很多实现都是随便找一个数进行数组的划分，
也就是类似随机快排的划分方式，这种划分方式无法达到时间复杂度O(N)的原因就是并不
能确定淘汰的数据量，而BFPRT算法在划分时，使用的是中位数的中位数进行划分，从而确
定了淘汰的数据量，最后成功的让时间复杂度收敛到O(N)的程度。
这里对BFPRT算法做了更好的改进，主要改进的地方是当中位数的中位数x，在arr中
大量出现的时候，那么在划分之后到底返回什么位置上的x呢？
在 本 书 的 实 现 中 ， 返 回 了 在 通 过 x 划 分 a r r 后 ， 等 于 x 的 整 个 位 置 区 间 ， 比 如
pivotRange=[a,b]表示arr[a..b]上都是x，并以此区间去命中第k⼩小的数如果k在[a,b]上就是
命中，如果没在[a,b]上表示没命中。这样即可以尽量少的进行递归过程，又可以增加淘汰
的数据量，使得步骤5递归过程变得数据量更少。

具体过程请参看如下代码中的getMinKNumsByBFPRT方法。


public class BFPRT {

	public int[] getMinKNumsByBFPRT(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int minKth = getMinKthByBFPRT(arr, k);
		int[] res = new int[k];
		int index = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] < minKth) {
				res[index++] = arr[i];
			}
		}
		for (; index != res.length; index++) {
			res[index] = minKth;
		}
		return res;
	}

	public int getMinKthByBFPRT(int[] arr, int K) {
		int[] copyArr = copyArray(arr);
		return select(copyArr, 0, copyArr.length - 1, K - 1);
	}

	public int[] copyArray(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i != res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	public int select(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);
		int[] pivotRange = partition(arr, begin, end, pivot);
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
		} else if (i < pivotRange[0]) {
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
	}

	public int medianOfMedians(int[] arr, int begin, int end) {
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		int[] mArr = new int[num / 5 + offset];
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;
			int endI = beginI + 4;
			mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
		}
		return select(mArr, 0, mArr.length - 1, mArr.length / 2);
	}

	public int[] partition(int[] arr, int begin, int end, int pivotValue) {
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivotValue) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivotValue) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;
	}

	public int getMedian(int[] arr, int begin, int end) {
		insertionSort(arr, begin, end);
		int sum = end + begin;
		int mid = (sum / 2) + (sum % 2);
		return arr[mid];
	}

	public void insertionSort(int[] arr, int begin, int end) {
		for (int i = begin + 1; i != end + 1; i++) {
			for (int j = i; j != begin; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
	}

	public void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}



	
