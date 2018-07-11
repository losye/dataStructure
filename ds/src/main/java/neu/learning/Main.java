package neu.learning;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
	}

	public int subMaxMatrix(int[][] matrix) {

		int[][] total = matrix;
		for (int i = 1; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				total[i][j] += total[i - 1][j];
			}
		}

		int maximum = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				int[] result = new int[matrix[0].length];
				for (int f = 0; f < matrix[0].length; f++) {
					if (i == 0) {
						result[f] = total[j][f];
					} else {
						result[f] = total[j][f] - total[i - 1][f];
					}
				}
				int maximal = maxSubsequence(result);

				if (maximal > maximum) {
					maximum = maximal;
				}
			}
		}

		return maximum;
	}
	
	public int maxSubsequence(int[] array) {  
        if (array.length == 0) {  
            return 0;  
        }  
        int max = Integer.MIN_VALUE;  
        int[] maxSub = new int[array.length];  
        maxSub[0] = array[0];  
          
        for (int i = 1; i < array.length; i++) {  
            maxSub[i] = (maxSub[i-1] > 0) ? (maxSub[i-1] + array[i]) : array[i];   
            if (max < maxSub[i]) {  
                max = maxSub[i];  
            }  
        }  
        return max;  
    }  

}
