package actividad2DivideConquer;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(mat);
		
		getTransposed(mat, 0, mat.length, 0, mat.length);
		
		printMatrix(mat);
		
	}

	
	public static int [][] getTransposed(int matrix[][], int initRow, int endRow, int initColumn, int endColumn) {
	    if (endRow - initRow > 2 && endColumn - initColumn > 2) {
	    	int mediumRow, mediumColumn;
	    	
	    	if((initRow  + endRow) % 2 != 0) 
	    		mediumRow = ((initRow + endRow) / 2) + 1;
	    	
	    	if((initColumn + endColumn) % 2 != 0)
	    		mediumColumn = ((initColumn + endColumn) / 2) + 1;
	    	
	    	mediumRow = (initRow + endRow) / 2;
		    mediumColumn = (initColumn + endColumn) / 2;
		    
	    	getTransposed(matrix, initRow, mediumRow, initColumn, mediumColumn);
		    getTransposed(matrix, initRow, mediumRow, mediumColumn, endColumn);
		    getTransposed(matrix, mediumRow, endRow, initColumn, mediumColumn);
		    getTransposed(matrix, mediumRow, endRow, mediumColumn, endColumn);
	    } else {
	    	invertPosition(matrix, initRow, endRow, initColumn, endColumn);
	 	    System.out.println("inverted");
	    }
	   
	    return matrix;
	}

	private static int [][] invertPosition(int matrix[][], int initRow, int endRow, int initColumn, int endColumn) {
		int[][] temp = new int[endRow - initRow][endColumn - initColumn];
		
		for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j] = matrix[j + initColumn][i + initRow];
            }
        }
		
		for(int i = 0; i < temp.length; i++) 
			for(int j = 0; j < temp.length; j++) 
				matrix[i + initRow][j + initColumn] = temp[i][j];
        
        return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
