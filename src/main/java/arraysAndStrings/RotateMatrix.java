package arraysAndStrings;
/*
1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
Hints: #51, # 100
 */
public class RotateMatrix {
	
	public static void main(String[] args) {
		// NxN matrix
		int n=4;
		Integer[][] m1 = new Integer[n][n];
		int num = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				m1[i][j] = ++num;
			}
		}
		System.out.println("Given Matrix:");
		printMatrix(m1);
		System.out.println("Rotated Matrix:");
		printMatrix(rotateMatrix(m1));
		
	}

	private static Integer[][] rotateMatrix(Integer[][] m1) {
		int row = m1.length, column = m1[0].length;
		Integer[][] m2 = new Integer[column][row]; 
		for (int i=0; i< row; i++){
			for (int j=0; j< column; j++) {
				m2[j][row -1 - i] = m1[i][j];
			}
		}
		return m2;
	}

	private static void printMatrix(Integer[][] m) {
		for (int i=0; i<m.length; i++) {
			for (int j=0; j<m[0].length; j++) {
				System.out.printf("%3d", m[i][j]);
			}
			System.out.println();
		}
	}

}
