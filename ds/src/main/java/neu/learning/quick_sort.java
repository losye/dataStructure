package neu.learning;

public class quick_sort {
	public static void quick(int[] arr,int start,int end){
		int i=start,j=end;
		int middle = (start+end)/2;
		int temp = arr[i];
		while(i<j){
			while(i<j && arr[i]<=arr[j]){
				j--;
			}arr[i]=arr[j];
			while(i<j && arr[i]>arr[j]){
				i++;
			}arr[j]=arr[i];
			arr[i]=temp;
		}
		quick(arr,start,middle-1);
		quick(arr,middle+1,end);
	}
	public static void main(String[] args) {
		int[] arr = { 11, 66, 22, 10, 55, 28, 0, 32 };
		quick(arr,0,arr.length-1);
	}
}
