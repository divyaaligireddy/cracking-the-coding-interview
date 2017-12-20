package arraysAndStrings;
/*
1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
Hints:#17, #74, #702
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		Integer[][] m1 = new Integer[][]{
			{1,2,3,4,5}, {6,7,0,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
		System.out.println("Given matrix:");
		printMatrix(m1);
		System.out.println("Zero matrix:");
		printMatrix(buildZeroMatrix(m1));
	}
	private static Integer[][] buildZeroMatrix(Integer[][] m1) {
		int m=m1.length, n=m1[0].length;
		Integer[][] m2 = new Integer[m][n];
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				m2[i][j] = m1[i][j];
			}
		}
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if(m1[i][j] == 0) {
					for (int k=0; k<m; k++)
						m2[k][j] = 0;
					for(int k=0; k<n; k++)
						m2[i][k] = 0;
				}
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
