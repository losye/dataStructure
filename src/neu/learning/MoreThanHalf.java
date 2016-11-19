package neu.learning;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * 原题（数组中超过一半（N/2）的数）进阶 （找到出现次数超过N/K的数） 
 * @author Administrator
 * 原题一个候选数 一次删2个  进阶题 一次k-1个候选数 一次删k个
 */
public class MoreThanHalf {
	public static void main(String[] args) {
		
	}
	
	public static void pirntKMajor(int[] arr, int k){
		if(k<2){
			System.out.println("the value of k is invalid");
			return;
		}
		HashMap<Integer,Integer> cands = new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length; i++){
			if(cands.containsKey(arr[i])){
				cands.put(arr[i], cands.get(arr[i])+1);
			}else{
				if(cands.size()==k-1){
					allCandsMinsusOne(cands);
				}else{
					cands.put(arr[i], 1);
				}
			}
		}
		HashMap<Integer,Integer> reals = getReals(arr,cands);
		
		boolean print = false;
		for(Entry<Integer,Integer> set :reals.entrySet()){
			int value = set.getValue();
			int key = set.getKey();
			if(value > arr.length/k){
				print = true;
				System.out.print(key + " ");
			}
		}
		System.out.println(print ? "" : "no such number");
	}

	private static HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> reals  = new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length; i++){
			if(cands.containsKey(arr[i])){
				if(reals.containsKey(arr[i])){
					reals.put(arr[i], reals.get(arr[i])+1);
				}else{
					reals.put(arr[i], 1);
				}
			}
		}
		return reals;
	}

	private static void allCandsMinsusOne(HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		List<Integer> removeList = new LinkedList<Integer>();
		for(Entry<Integer,Integer> set : map.entrySet()){
			int key = set.getKey();
			int value = set.getValue();
			if(value==1){
				removeList.add(key);
			}else{
				map.put(key, value-1);
			}
		}
		for(Integer removeKey : removeList){
			map.remove(removeKey);
		}
	}
}
