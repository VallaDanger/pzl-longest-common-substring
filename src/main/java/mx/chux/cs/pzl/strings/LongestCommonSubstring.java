package mx.chux.cs.pzl.strings;

import java.util.function.Function;

public class LongestCommonSubstring implements Function<String, String> {

    final String first;
    
    public LongestCommonSubstring(final String first) {
        this.first = first;
    }
    
    @Override
    public String apply(final String second) {
        
        if( (second == null) || second.isEmpty() ) {
            return "";
        }
        
        final int[][] matrix = buildMatrix(second);
        
        return lcss(matrix, second);
    }
    
    private String lcss(final int[][] matrix, final String second) {
        
        final int sizeOfFirst = matrix.length;
        final int sizeOfSecond = matrix[0].length;
        
        int max = 0;
        int maxRow = 0;
        int maxCol = 0;
        
        for( int i = 1 ; i < sizeOfFirst ; i++ ) {
            for( int j = 1 ; j < sizeOfSecond ; j++ ) {
                if( this.first.charAt(i-1) == second.charAt(j-1) ) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }
                if( matrix[i][j] > max ) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        
        return backtrace(matrix, maxRow, maxCol);
    }
    
    private String backtrace(final int[][] matrix, int i, int j) {
        if( matrix[i][j] == 0 ) {
            return "";
        }
        return backtrace(matrix, i-1, j-1) + this.first.charAt(i-1);
    }
    
    private final int[][] buildMatrix(final String second) {
        
        final int sizeOfRows = this.first.length() + 1;
        final int sizeOfCols = second.length() + 1;
        
        final int[][] matrix = new int[sizeOfRows][sizeOfCols];
        
        return initializeMatrix(matrix, sizeOfRows, sizeOfCols);
    }
    
    private int[][] initializeMatrix(final int[][] matrix, int r, int c) {
        for( int row = 0 ; row < r ; row++ ) {
            for( int col = 0 ; col < c ; col++ ) {
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }
    
}
