给定一个无序数组，找到其中最小的K个数
====================
O(N*lgK)

```java
public class getMinKNum {
	
	//利用最大堆
	public static int[] getMinKNumByHeap(int[]arr ,int k){
		if(arr==null ||arr.length<k|| k<0){
			return null;
		}
		int[] kHeap = new int[k];
		for(int i =0 ; i<k; i++){
			heapInsert(kHeap,arr[i],i);
		}
		for(int i=k; i<arr.length; i++){
			if(kHeap[0]>arr[i]){
				kHeap[0] = arr[i];
				heapify(kHeap, 0, k);
			}
		}
		return kHeap;
	} 
	//建堆的过程
	public static void heapInsert(int[] heap, int value, int index){
		heap[index] = value;
		int parent = (index-1)/2;
		while(index!=0){
			if(heap[index]>heap[parent]){
				swap(heap,index,parent);
				index = parent;
			}else{
				break;
			}
		}
	}
	//调整的过程
	public static void heapify(int[] heap, int index, int heapSize){
		int left = 2*index +1;
		int right = 2*index +2;
		int largest = index;
		while(left < heapSize){
			if(heap[index]<heap[left]){
				//swap(heap,index,left);
				largest = left;
			}
			if(right < heapSize && heap[largest]<heap[right]){
				largest = right;
			}
			if(index!=largest){
				swap(heap,index,largest);
			}else{
				break;
			}
			index = largest;
			left = 2*index +1;
			right = 2*index +2;
		}

	}
	public static void swap(int[] arr, int low, int high){
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
```


为什么求最小的K个数，要用最大堆呢。

因为利用最大堆的特性，我们只要维持着K个数就可以了。每次新遍历的数只要和头节点比较。

比头大，跳过。 比头小，做一次向下调的过程。也就是一直维持K个数就可以解决。
