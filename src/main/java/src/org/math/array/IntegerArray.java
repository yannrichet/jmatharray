package org.math.array;

/**
 * A collection of static methods for generating, modifying, and reading
 * arrays and matrices of integers.
 * BSD License
 * 
 * @author Yann RICHET
 */
public class IntegerArray {

	// creation of integer arrays

	/**
	 * Returns an m x m matrix. result has constants along the diagonal
	 * and zeros everywhere else.
	 * @param m an integer > 0.
	 * @param c Constant that lies along diagonal. Set c=1 for identity matrix.
	 * @return m x m two dimensional array of integers.
	 */
	public static int[][] diagonal(int m, int c) {
		int[][] I = new int[m][m];
		for (int i = 0; i < I.length; i++)
			I[i][i] = c;
		return I;
	}

	/**
	 * Returns an mxn matrix of constants
	 * @param m number of rows in matrix
	 * @param n number of columns in matrix
	 * @param c constant matrix is filled with.
	 * @return mxn two dimensional array of constants
	 */
	public static int[][] fill(int m, int n, int c) {
		int[][] o = new int[m][n];
		for (int i = 0; i < o.length; i++)
			for (int j = 0; j < o[i].length; j++)
				o[i][j] = c;
		return o;
	}

	/**
	 * Generates an m point array of constants
	 * @param m Size of array
	 * @param c constant array is to be filled with
	 * @return array of constants.
	 */
	public static int[] fill(int m, int c) {
		int[] o = new int[m];
		for (int i = 0; i < m; i++)
			o[i] = c;
		return o;
	}

	// conversion from/to double methods

	/**
	 * Truncates each double value in a matrix to an integer that is less than or equal to the double.
	 * @param v The input matrix of doubles
	 * @return The truncated version of the input matrix.
	 */
	public static int[][] floor(double[][] v) {
		int[][] ia = new int[v.length][];
		for (int i = 0; i < v.length; i++) {
			ia[i] = new int[v[i].length];
			for (int j = 0; j < ia[i].length; j++) {
				ia[i][j] = (int) Math.floor(v[i][j]);
			}
		}
		return ia;
	}

	/**
	 * Truncates each double value in an array to an integer that is less than or equal to the double.
	 * @param v The input array of doubles
	 * @return The truncated version of the input matrix.
	 */
	public static int[] floor(double[] v) {
		int[] ia = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			ia[i] = (int) Math.floor(v[i]);
		}
		return ia;
	}

	/**
	 * Converts each element in an integer matrix to a double
	 * @param v matrix of integers
	 * @return matrix of doubles
	 */
	public static double[][] int2double(int[][] v) {
		double[][] ia = new double[v.length][];
		for (int i = 0; i < v.length; i++) {
			ia[i] = new double[v[i].length];
			for (int j = 0; j < ia[i].length; j++) {
				ia[i][j] = v[i][j];
			}
		}
		return ia;
	}

	/**
	 * Converts each element in an integer array to a double
	 * @param v array of integers
	 * @return array of doubles
	 */
	public static double[] int2double(int[] v) {
		double[] ia = new double[v.length];
		for (int i = 0; i < v.length; i++) {
			ia[i] = v[i];
		}
		return ia;
	}

	// Modify rows & colmumns methods

	/**
	 * Generate a copy of an array
	 * @param M Input array.
	 * @return A copy of the input array.
	 */
	public static int[] copy(int[] M) {
		int[] array = new int[M.length];
		System.arraycopy(M, 0, array, 0, M.length);
		return array;
	}

	/**
	 * Generate a copy of a matrix
	 * @param M Input matrix.
	 * @return A copy of the input matrix
	 */
	public static int[][] copy(int[][] M) {
		int[][] array = new int[M.length][M[0].length];
		for (int i = 0; i < array.length; i++)
			System.arraycopy(M[i], 0, array[i], 0, M[i].length);
		return array;
	}

	/**
	 * Carve out a submatrix from the input matrix and return a copy. 
	 * Result is the intersection of rows i1 through i2
	 * and columns j1 through j2 inclusive.<br> 
	 * Example:<br>
	 * <code>
	 * int[][] a = <br>
	 * {{0,1,2,3,4},<br>
	 *  {1,7,8,9,10},<br>
	 *  {2,13,14,15,16},<br>
	 *  {3,19,20,21,22},<br>
	 *  {4,25,26,27,28}};<br>
	 * int[][] b = getSubMatrixRangeCopy(a, 2, 3, 1, 3);<br>
	 * Result is:<br>
	 * 13 14 15<br>
	 * 19 20 21<br>
	 * </code>
	 * @param M Input matrix
	 * @param i1 first row in cut
	 * @param i2 last row in cut
	 * @param j1 first column in cut
	 * @param j2 last column in cut
	 * @return submatrix. Input matrix is left unharmed.
	 */
	public static int[][] getSubMatrixRangeCopy(int[][] M, int i1, int i2, int j1, int j2) {
		int[][] array = new int[i2 - i1 + 1][j2 - j1 + 1];
		for (int i = 0; i < i2 - i1 + 1; i++)
			System.arraycopy(M[i + i1], j1, array[i], 0, j2 - j1 + 1);
		return array;
	}

	/**
	 * Extract a range of columns from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[][] z = getColumnsRangeCopy(a, 2, 4);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * result is:<br>
	 *  2   3   4<br>
	 *  8   9  10<br>
	 * 14  15  16<br>
	 * 20  21  22<br>
	 * 26  27  28<br>
	 * </code>
	 * @param M Input matrix
	 * @param j1 Index of first column to be extracted.
	 * @param j2 Index of last column to be extracted.
	 * @return An mxn matrix where m=number of rows in M and n=j2-j1+1
	 */
	public static int[][] getColumnsRangeCopy(int[][] M, int j1, int j2) {
		int[][] array = new int[M.length][j2 - j1 + 1];
		for (int i = 0; i < M.length; i++)
			System.arraycopy(M[i], j1, array[i], 0, j2 - j1 + 1);
		return array;
	}

	/**
	 * Extract specific columns from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[][] z = getColumnsCopy(a, 2, 4);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * result is:<br>
	 *  0   2   4<br>
	 *  1   8  10<br>
	 *  2  14  16<br>
	 *  3  20  22<br>
	 *  4  26  28<br>
	 * </code>
	 * @param M Input matrix
	 * @param J Each is the index of a column. There can be as many indices listed as there are columns in M.
	 * @return An mxn matrix where m=number of rows in M and n=number of indices listed
	 */
	public static int[][] getColumnsCopy(int[][] M, int... J) {
		int[][] array = new int[M.length][J.length];
		for (int i = 0; i < M.length; i++)
			for (int j = 0; j < J.length; j++)
				array[i][j] = M[i][J[j]];
		return array;
	}

	/**
	 * Extract one column from a matrix.
	 * <br>Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[][] z = getColumnCopy(a, 2);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * Result is:<br>
	 * 2   8  14  20  26<br>
	 * </code>
	 * @param M Input matrix
	 * @param j Index of desired column
	 * @return Array of values from extracted column.
	 */
	public static int[] getColumnCopy(int[][] M, int j) {
		int[] array = new int[M.length];
		for (int i = 0; i < M.length; i++)
			array[i] = M[i][j];
		return array;
	}

	/**
	 * Extract one <i>column</i> from a three dimensional array. The result is an array of the
	 * values in the first dimension.
	 * @param M Input 3D array
	 * @param j The index of the second dimension.
	 * @param k The index of the third dimension
	 * @return An array
	 */
	public static int[] getColumnCopy(int[][][] M, int j, int k) {
		int[] array = new int[M.length];
		for (int i = 0; i < M.length; i++)
			array[i] = M[i][j][k];
		return array;
	}

	/**
	 * Extract specific rows from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[][] z = getRowsCopy(a, 2, 4);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * result is:<br>
	 *  2  13  14  15  16<br>
	 *  4  25  26  27  28<br>
	 * </code>
	 * @param M Input matrix
	 * @param I Each is the index of a column. There can be as many indices listed as there are rows in M.
	 * @return An mxn matrix where m=number of indices listed and n=number of columns in m
	 */
	public static int[][] getRowsCopy(int[][] M, int... I) {
		int[][] array = new int[I.length][M[0].length];
		for (int i = 0; i < I.length; i++)
			System.arraycopy(M[I[i]], 0, array[i], 0, M[I[i]].length);
		return array;
	}

	/**
	 * Extract a row from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[] z = getRowCopy(a, 2);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * result is:<br>
	 *  2  13  14  15  16<br>
	 * </code>
	 * @param M Input matrix
	 * @param i index of row to copy
	 * @return An array of n values where n = number of columns in M
	 */
	public static int[] getRowCopy(int[][] M, int i) {
		int[] array = new int[M[0].length];
		System.arraycopy(M[i], 0, array, 0, M[i].length);
		return array;
	}

	/**
	 * Extract a range of rows from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[][] z = getRowsRangeCopy(a, 2, 4);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * result is:<br>
	 *  2  13  14  15  16<br>
	 *  3  19  20  21  22<br>
	 *  4  25  26  27  28<br>
	 * </code>
	 * @param M Input matrix
	 * @param i1 Index of first row to be extracted.
	 * @param i2 Index of last row to be extracted.
	 * @return An mxn matrix where m=j2-j1+1 and n=number of columns in M
	 */
	public static int[][] getRowsRangeCopy(int[][] M, int i1, int i2) {
		int[][] array = new int[i2 - i1 + 1][M[0].length];
		for (int i = 0; i < i2 - i1 + 1; i++)
			System.arraycopy(M[i + i1], 0, array[i], 0, M[i + i1].length);
		return array;
	}

	/**
	 * Extract a section of an array.
	 * Example:<br>
	 * <code>
	 * int[] a = {00,11,22,33,44,55,66,77,88,99};<br>
	 * int[] z = getRangeCopy(a, 2, 5);<br>
	 * result is:<br>
	 * 22  33  44  55<br>
	 * </code>
	 * @param M Input array
	 * @param j1 Index of first term to get
	 * @param j2 Index of last term to get
	 * @return An array with j2-j1+1 elements
	 */
	public static int[] getRangeCopy(int[] M, int j1, int j2) {
		int[] array = new int[j2 - j1 + 1];
		System.arraycopy(M, j1, array, 0, j2 - j1 + 1);
		return array;
	}

	/**
	 * Extract specific elements from an array.
	 * Example:
	 * <br>
	 * <code>
	 * int[] a = {00,11,22,33,44,55,66,77,88,99};<br>
	 * int[] z = getCopy(a, 2, 5);<br>
	 * result is:<br>
	 * 22  55<br>
	 * </code>
	 * @param M The input array.
	 * @param I the indices of the elements to extract
	 * @return The output array of n elements where n=number of indices listed.
	 */
	public static int[] getCopy(int[] M, int... I) {
		int[] array = new int[I.length];
		for (int i = 0; i < I.length; i++)
			array[i] = M[I[i]];
		return array;
	}

	/**
	 * Get the number of columns in a specified row of a matrix. Used for oddly sized matrices.
	 * @param M Input matrix
	 * @param i Index of row whose column length will be returned
	 * @return The number of columns in row <i>i</i>
	 */
	public static int getColumnDimension(int[][] M, int i) {
		return M[i].length;
	}

	/**
	 * Extract diagonal from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,25,26,27,28}};<br>
	 * int[] z = getDiagonal(a, 1);<br>
	 * input is:<br>
	 * 0   1   2   3   4<br>
	 * 1   7   8   9  10<br>
	 * 2  13  14  15  16<br>
	 * 3  19  20  21  22<br>
	 * 4  25  26  27  28<br>
	 * result is:<br>
	 *  1 8 15 22<br>
	 * </code>
	 * @param M Input matrix
	 * @param I index of diagonal to copy
	 * @return An array
	 */
	public static int[] getDiagonal(int[][] M, int I) {
		int nr = M.length, nc = M.length;
		int nd = 0;
		if (nc < nr) {
			if (I >= 0) {
				nd = nc - I;
			} else if (I < (nc - nr)) {
				nd = nr + I;
			} else {
				nd = nc;
			}
		} else {
			if (I <= 0) {
				nd = nr + I;
			} else if (I > (nc - nr)) {
				nd = nc - I;
			} else {
				nd = nr;
			}
		}

		int[] d = new int[nd];
		for (int i = 0; i < d.length; i++)
			d[i] = M[i + I][i + I];
		return d;
	}

	/**
	 * Combine a set of arrays into a matrix. Each array becomes a row.
	 * Example:<br>
	 * <code>
	 * int[] a = {0,11,22,33,44}, b = {55,66,77,88};
	 * int[][] z = mergeRows(a, b);
	 * result is:<br>
	 *   0  11  22  33  44
	 *  55  66  77  88
	 * </code>
	 * @param x Input arrays
	 * @return A matrix. May non-rectangular if arrays are not all the same length.
	 */
	public static int[][] mergeRows(int[]... x) {
		int[][] array = new int[x.length][];
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[x[i].length];
			System.arraycopy(x[i], 0, array[i], 0, array[i].length);
		}
		return array;
	}

	/**
	 * Combine a set of arrays into a matrix. Each array becomes a column. Arrays must all be of same length.
	 * Example:<br>
	 * <code>
	 * int[] a = {00,11,22,33,44}, b = {55,66,77,88,99};
	 * int[][] z = mergeColumns(a, b);
	 * result is:<br>
	 *  0  55
	 * 11  66
	 * 22  77
	 * 33  88
	 * 44  99
	 * </code>
	 * @param x Input arrays
	 * @return An mxn matrix where m=size of any input array and n is the number of arrays.
	 */
	public static int[][] mergeColumns(int[]... x) {
		int[][] array = new int[x[0].length][x.length];
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = x[j][i];
		return array;
	}

	/**
	 * Concatenates arrays.
	 * <br>Example:<br>
	 * <code>
	 * int[] a = {00,11,22,33,44}, b = {55,66,77,88,99};<br>
	 * int[] z = merge(a, b, a);<br>
	 * result is:<br>
	 *   0  11  22  33  44  55  66  77  88  99   0  11  22  33  44
	 * </code>
	 * @param x Input arrays
	 * @return Output array.
	 */
	public static int[] merge(int[]... x) {
		int[] xlength_array = new int[x.length];
		xlength_array[0] = x[0].length;
		for (int i = 1; i < x.length; i++)
			xlength_array[i] = x[i].length + xlength_array[i - 1];
		int[] array = new int[xlength_array[x.length - 1]];
		System.arraycopy(x[0], 0, array, 0, x[0].length);
		for (int i = 1; i < x.length; i++)
			System.arraycopy(x[i], 0, array, xlength_array[i - 1], x[i].length);
		return array;
	}

	// I didn't favor this insertColumns method because it was so different from insertRows() 
	// and it just seemed more likely that someone would want to insert arrays rather than 
	// whole matrices. See the new version below.
	/*    public static int[][] insertColumns(int[][] x, int J, int[]... y) {
	        int[][] array = new int[x.length][x[0].length + y[0].length];
	        for (int i = 0; i < array.length; i++) {
	            System.arraycopy(x[i], 0, array[i], 0, J);
	            System.arraycopy(y[i], 0, array[i], J, y[i].length);
	            System.arraycopy(x[i], J, array[i], J + y[i].length, x[i].length - J);
	        }
	        return array;
	    }
	*/
	/*public static int[][] insertColumn(int[][] x, int[] y, int J) {
	    int[][] array = new int[x.length][x[0].length + 1];
	    for (int i = 0; i < array.length; i++) {
	        System.arraycopy(x[i], 0, array[i], 0, J);
	        array[i][J] = y[i];
	        System.arraycopy(x[i], J, array[i], J + 1, x[i].length - J);
	    }
	    return array;
	}*/

	/**
	 * Insert any number of arrays between 2 columns of a matrix. Size of the arrays must
	 * equal number of rows in the matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,23,24,25,26}};<br>
	 * int[] b = {00,11,22,33,44}, c = {55,66,77,88,99};<br>
	 * int[][] z = insertColumns(a, 2, b, c);<br>
	 * input matrix is:<br>
	 *  0   1   2   3   4<br>
	 *  1   7   8   9  10<br>
	 *  2  13  14  15  16<br>
	 *  3  19  20  21  22<br>
	 *  4  23  24  25  26<br>
	 * result is:<br>
	 *  0   1   0  55   2   3   4<br>
	 *  1   7  11  66   8   9  10<br>
	 *  2  13  22  77  14  15  16<br>
	 *  3  19  33  88  20  21  22<br>
	 *  4  23  44  99  24  25  26<br>
	 * </code>
	 * @param x Input m x n matrix.
	 * @param J Index of column before which the new columns will be inserted.
	 * @param y The arrays to be inserted
	 * @return New matrix with added columns.
	 */
	public static int[][] insertColumns(int[][] x, int J, int[]... y) {
		return transpose(insertRows(transpose(x), J, y));
	}

	/**
	 * Insert any number of arrays between 2 rows of a matrix. Size of the arrays must
	 * equal number of columns in the matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22}};<br>
	 * int[] b = {0,11,22,33,44}, c = {55,66,77,88,99};<br>
	 * int[][] z = insertRows(a, 1, b, c);<br>
	 * result is:<br>
	 *   0   1   2   3   4<br>
	 *   0  11  22  33  44<br>
	 *  55  66  77  88  99<br>
	 *   1   7   8   9  10<br>
	 *   2  13  14  15  16<br>
	 *   3  19  20  21  22<br>
	 * </code>
	 * @param x Input m x n matrix.
	 * @param I Index of row before which the new rows will be inserted.
	 * @param y The arrays to be inserted
	 * @return New matrix with added rows.
	 */
	public static int[][] insertRows(int[][] x, int I, int[]... y) {
		int[][] array = new int[x.length + y.length][x[0].length];
		for (int i = 0; i < I; i++)
			System.arraycopy(x[i], 0, array[i], 0, x[i].length);
		for (int i = 0; i < y.length; i++)
			System.arraycopy(y[i], 0, array[i + I], 0, y[i].length);
		for (int i = 0; i < x.length - I; i++)
			System.arraycopy(x[i + I], 0, array[i + I + y.length], 0, x[i].length);
		return array;
	}

	/*public static int[][] insertRow(int[][] x, int[] y, int I) {
	    int[][] array = new int[x.length + 1][x[0].length];
	    for (int i = 0; i < I; i++)
	        System.arraycopy(x[i], 0, array[i], 0, x[i].length);
	    System.arraycopy(y, 0, array[I], 0, y.length);
	    for (int i = 0; i < x.length - I; i++)
	        System.arraycopy(x[i + I], 0, array[i + I + 1], 0, x[i].length);
	    return array;
	}*/

	/**
	 * Insert any number of values, or a single array, between 2 elements of an array.
	 * Example:<br>
	 * <code>
	 * int[] b = {00,11,22,33,44}, c = {55,66,77,88,99};<br>
	 * int[] z = insert(b, 2, 333, 444);<br>
	 * result is:<br>
	 * 0  11 333 444  22  33  44
	 * int[] z = insert(b, 2, c);<br>
	 * result is:<br>
	 * 0  11  55  66  77  88  99  22  33  44<br>
	 * </code>
	 * @param x Input array.
	 * @param I Index of element before which the values will be inserted.
	 * @param y Values to be inserted. Can also be a single array.
	 * @return Expanded array.
	 */
	public static int[] insert(int[] x, int I, int... y) {
		int[] array = new int[x.length + y.length];
		System.arraycopy(x, 0, array, 0, I);
		System.arraycopy(y, 0, array, I, y.length);
		System.arraycopy(x, I, array, I + y.length, x.length - I);
		return array;
	}

	/**
	 * Deletes a range of columns from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,23,24,25,26}};<br>
	 * int[][] z = deleteColumnsRange(a, 1, 3);<br>
	 * result is:<br>
	 *  0   4<br>
	 *  1  10<br>
	 *  2  16<br>
	 *  3  22<br>
	 *  4  26<br>
	 * </code>
	 * @param x The input matrix
	 * @param J1 The Index of the first column to delete.
	 * @param J2 The index of the last column to delete.
	 * @return The reduced matrix.
	 */
	public static int[][] deleteColumnsRange(int[][] x, int J1, int J2) {
		int[][] array = new int[x.length][x[0].length - (J2 - J1 + 1)];
		for (int i = 0; i < array.length; i++) {
			System.arraycopy(x[i], 0, array[i], 0, J1);
			//if (J2<x.length-1)
			System.arraycopy(x[i], J2 + 1, array[i], J1, x[i].length - (J2 + 1));
		}
		return array;
	}

	/**
	 * Deletes a list of columns from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,23,24,25,26}};<br>
	 * int[][] z = deleteColumns(a, 1, 3);<br>
	 * result is:<br>
	 *  0  2   4<br>
	 *  1  8  10<br>
	 *  2  14 16<br>
	 *  3  20 22<br>
	 *  4  24 26<br>
	 * </code>
	 * @param x The input matrix
	 * @param J The indices of the columns to be deleted. There must be no more indices listed 
	 * than there are columns in the input matrix.
	 * @return The reduced matrix.
	 */
	public static int[][] deleteColumns(int[][] x, int... J) {
		/*int[][] array = new int[x.length][x[0].length - J.length];
		for (int i = 0; i < array.length; i++) {
		    System.arraycopy(x[i], 0, array[i], 0, J[0]);
		    for (int j = 0; j < J.length - 1; j++)
		        System.arraycopy(x[i], J[j] + 1, array[i], J[j] - j, J[j + 1] - J[j] - 1);
		    System.arraycopy(x[i], J[J.length - 1] + 1, array[i], J[J.length - 1] - J.length + 1, x[i].length - J[J.length - 1] - 1);
		}
		return array;*/
		// TODO improve efficiency here
		return transpose(deleteRows(transpose(x), J));
	}

	/**
	 * Deletes a range of rows from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,23,24,25,26}};<br>
	 * int[][] z = deleteRowsRange(a, 1, 3);<br>
	 * result is:<br>
	 *   0   1   2   3   4<br>
	 *   4  23  24  25  26<br>
	 * </code>
	 * @param x The input matrix
	 * @param I1 The Index of the first row to delete.
	 * @param I2 The index of the last row to delete.
	 * @return The reduced matrix.
	 */
	public static int[][] deleteRowsRange(int[][] x, int I1, int I2) {
		int[][] array = new int[x.length - (I2 - I1 + 1)][x[0].length];
		for (int i = 0; i < I1; i++)
			System.arraycopy(x[i], 0, array[i], 0, x[i].length);
		for (int i = 0; i < x.length - I2 - 1; i++)
			System.arraycopy(x[i + I2 + 1], 0, array[i + I1], 0, x[i].length);
		return array;
	}

	/**
	 * Deletes a list of rows from a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,1,2,3,4},{1,7,8,9,10},{2,13,14,15,16},{3,19,20,21,22},{4,23,24,25,26}};<br>
	 * int[][] z = deleteRows(a, 1, 3);<br>
	 * result is:<br>
	 *   0   1   2   3   4<br>
	 *   2  13  14  15  16<br>
	 *   4  23  24  25  26<br>
	 * </code>
	 * @param x The input matrix
	 * @param I The indices of the rows to delete.
	 * @return The reduced matrix.
	 */
	public static int[][] deleteRows(int[][] x, int... I) {
		int[][] array = new int[x.length - I.length][x[0].length];
		int i2 = 0;
		for (int i = 0; i < x.length; i++) {
			if (!into(i, I)) {
				System.arraycopy(x[i], 0, array[i2], 0, x[i].length);
				i2++;
			}
		}
		/*for (int i = 0; i < I[0]; i++)
		    System.arraycopy(x[i], 0, array[i], 0, x[i].length);
		for (int j = 0; j < I.length - 1; j++)
		    for (int i = I[j] + 1; i < I[j + 1]; i++)
		        System.arraycopy(x[i], 0, array[i - j], 0, x[i].length);
		for (int i = I[I.length - 1] + 1; i < x.length; i++)
		    System.arraycopy(x[i], 0, array[i - I.length], 0, x[i].length);*/
		return array;
	}

	/**
	 * Delete a range of elements from an array.
	 * Example:<br>
	 * <code>
	 * int[] b = {00,11,22,33,44};<br>
	 * int[] z = deleteRange(b, 1, 3);<br>
	 * Result is:<br>
	 * 0  44<br>
	 * </code>
	 * @param x Input array
	 * @param J1 Index of first element to delete. Must be >= 0 and <= x.length
	 * @param J2 Index of last element to delete. Must be >= J1 and <= x.length
	 * @return Reduced array.
	 */
	public static int[] deleteRange(int[] x, int J1, int J2) {
		int[] array = new int[x.length - (J2 - J1 + 1)];
		System.arraycopy(x, 0, array, 0, J1);
		//if (J2<x.length-1)
		System.arraycopy(x, J2 + 1, array, J1, x.length - (J2 + 1));
		return array;
	}

	/**
	 * Delete a list of elements from an array.
	 * Example:<br>
	 * <code>
	 * int[] b = {00,11,22,33,44};<br>
	 * int[] z = deleteRange(b, 1, 3);<br>
	 * Result is:<br>
	 * 0  22  44<br>
	 * </code>
	 * @param x Input array
	 * @param J Index of elements to delete. Each must be >= 0 and <= x.length
	 * @return Reduced array.
	 */
	public static int[] delete(int[] x, int... J) {
		int[] array = new int[x.length - J.length];
		int j2 = 0;
		for (int j = 0; j < x.length; j++) {
			if (!into(j, J)) {
				array[j2] = x[j];
				j2++;
			}
		}
		/*System.arraycopy(x, 0, array, 0, J[0]);
		for (int j = 0; j < J.length - 1; j++)
		    System.arraycopy(x, J[j] + 1, array, J[j] - j, J[j + 1] - J[j] - 1);
		System.arraycopy(x, J[J.length - 1] + 1, array, J[J.length - 1] - J.length + 1, x.length - J[J.length - 1] - 1);*/
		return array;
	}

	/**
	 * Determines if a value is within an array
	 * @param i Value to be searched for.
	 * @param I array to be searched
	 * @return true if found. fales if not.
	 */
	private static boolean into(int i, int[] I) {
		boolean in = false;
		for (int j = 0; j < I.length; j++) {
			in = in || (i == I[j]);
		}
		return in;
	}

	// min/max methods

	/**
	 * Finds the minimum value in each column of a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a =    {{0, 13,  22,   3,  44},<br>
	 *                 {1,  7,  28,   9,  10},<br>
	 *                 {2,  1,  14,  15,   6},<br>
	 *                 {3, 19,  20,  21,   2},<br>
	 *                 {4, 23,  24,  25,   6}};<br>
	 * int[] z = min(a);<br>
	 * Result is:<br>
	 * 0  1  14  3  2<br>
	 * </code>
	 * @param M The input matrix
	 * @return Array of minimums from each column of M.
	 */
	public static int[] min(int[][] M) {
		int[] min = new int[M[0].length];
		for (int j = 0; j < min.length; j++) {
			min[j] = M[0][j];
			for (int i = 1; i < M.length; i++)
				min[j] = Math.min(min[j], M[i][j]);
		}
		return min;
	}

	/**
	 * Finds minimum value in either a list of numbers or a single array.
	 * @param M Can be a list of values e.g. min(1,22,333,.4) or an array.
	 * @return The minimum value.
	 */
	public static int min(int... M) {
		int min = M[0];
		for (int i = 1; i < M.length; i++)
			min = Math.min(min, M[i]);
		return min;
	}

	/**
	 * Finds the maximum value in each column of a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a =    {{0,  1,  2,   3,  4},<br>
	 *                 {1,  7, 88,   9, 10},<br>
	 *                 {2, 13, 14,  15, 16},<br>
	 *                 {3, 19, 20, 201, 22},<br>
	 *                 {4, 23, 24,  25, 26}};<br>
	 * int[] z = max(a);<br>
	 * Result is:<br>
	 * 4  23  88  201  26<br>
	 * </code>
	 * @param M The input matrix
	 * @return Array of maximums from each column of M.
	 */
	public static int[] max(int[][] M) {
		int[] max = new int[M[0].length];
		for (int j = 0; j < max.length; j++) {
			max[j] = M[0][j];
			for (int i = 1; i < M.length; i++)
				max[j] = Math.max(max[j], M[i][j]);
		}
		return max;
	}

	/**
	 * Finds maximum value in either a list of numbers or a single array.
	 * @param M Can be a list of values e.g. min(1,22,333,.4) or an array.
	 * @return The maximum value.
	 */
	public static int max(int... M) {
		int max = M[0];
		for (int i = 1; i < M.length; i++)
			max = Math.max(max, M[i]);
		return max;
	}

	/**
	 * Finds the indices of the minimum values in each column of a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a =    {{0, 13,  22,   3,  44},<br>
	 *                 {1,  7,  28,   9,  10},<br>
	 *                 {2,  1,  14,  15,   6},<br>
	 *                 {3, 19,  20,  21,   2},<br>
	 *                 {4, 23,  24,  25,   6}};<br>
	 * int[] z = minIndex(a);<br>
	 * Result is:<br>
	 * 0  2  2  0  3<br>
	 * </code>
	 * @param M Input matrix.
	 * @return Array of indices of the minimums from each column of M.
	 */
	public static int[] minIndex(int[][] M) {
		int[] minI = new int[M[0].length];
		for (int j = 0; j < minI.length; j++) {
			minI[j] = 0;
			for (int i = 1; i < M.length; i++)
				if (M[i][j] < M[minI[j]][j])
					minI[j] = i;

		}
		return minI;
	}

	/**
	 * Finds the index of the minumum value in a list of values or an array.
	 * @param M Can be a list of values e.g. minIndex(11,22,44,2) or an array
	 * @return index of minimum value in M
	 */
	public static int minIndex(int... M) {
		int minI = 0;
		for (int i = 1; i < M.length; i++)
			if (M[i] < M[minI])
				minI = i;
		return minI;
	}

	/**
	 * Finds the indices of the maximum values in each column of a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,  1,  2,   3,  4},<br>
	 *              {1,  7, 88,   9, 10},<br>
	 *              {2, 13, 14,  15, 16},<br>
	 *              {3, 19, 20, 201, 22},<br>
	 *              {4, 23, 24,  25, 26}};<br>
	 * int[] z = maxIndex(a);<br>
	 * Result is:<br>
	 * 4  4  1  3  4<br>
	 * </code>
	 * @param M Input matrix.
	 * @return Array of indices of the maximums from each column of M.
	 */
	public static int[] maxIndex(int[][] M) {
		int[] maxI = new int[M[0].length];
		for (int j = 0; j < maxI.length; j++) {
			maxI[j] = 0;
			for (int i = 1; i < M.length; i++)
				if (M[i][j] > M[maxI[j]][j])
					maxI[j] = i;
		}
		return maxI;
	}

	/**
	 * Finds the index of the maximum value in a list of values or an array.
	 * @param M Can be a list of values e.g. maxIndex(11,22,44,2) or an array
	 * @return index of maximum value in M
	 */
	public static int maxIndex(int... M) {
		int maxI = 0;
		for (int i = 1; i < M.length; i++)
			if (M[i] > M[maxI])
				maxI = i;
		return maxI;
	}

	// cumulative methods

	/**
	 * Calculate the sum of the values in an array
	 * @param v input array
	 * @return sum of values in v
	 */
	public static int sum(int[] v) {
		int m = v.length;
		int s = 0;
		for (int i = 0; i < m; i++)
			s += v[i];
		return s;
	}

	/**
	 * Calculates the sum of each column in a matrix.
	 * @param v
	 * @return Array. value of i'th element is sum of values in column(i)
	 */
	public static int[] sum(int[][] v) {
		int m = v.length;
		int n = v[0].length;
		int[] X = new int[n];
		int s;
		for (int j = 0; j < n; j++) {
			s = 0;
			for (int i = 0; i < m; i++)
				s += v[i][j];
			X[j] = s;
		}
		return X;
	}

	/**
	 * Calculates the cumulative sum of an array. Think of it as an integral.
	 * Example:<br>
	 * <code>
	 * int[] b = {0,1,2,3,4};<br>
	 * int[] z = cumSum(b);<br>
	 * result is:<br>
	 *  0    1    3    6   10<br>
	 * </code>
	 * @param v Input array.
	 * @return Output array of same length as v.
	 */
	public static int[] cumSum(int[] v) {
		int m = v.length;
		int[] X = new int[m];
		int s = 0;
		for (int i = 0; i < m; i++) {
			s += v[i];
			X[i] = s;
		}
		return X;
	}

	/**
	 * Calculates the cumulative sum of each column in a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a = {{0,  1,  2,  3,  4},<br>
	 *              {1,  7,  8,  9, 10},<br>
	 *              {2, 13, 14, 15, 16},<br>
	 *              {3, 19, 20, 21, 22},<br>
	 *              {4, 23, 24, 25, 26}};<br>
	 * int[][] z = cumSum(a);<br>
	 * result is:<br>
	 *  0    1    2    3    4<br>
	 *  1    8   10   12   14<br>
	 *  3   21   24   27   30<br>
	 *  6   40   44   48   52<br>
	 * 10   63   68   73   78<br>
	 * </code>
	 * @param v
	 * @return Output matrix. Each column is the cumulative sum of each column in v.
	 */
	public static int[][] cumSum(int[][] v) {
		int m = v.length;
		int n = v[0].length;
		int[][] X = new int[m][n];
		int s;
		for (int j = 0; j < n; j++) {
			s = 0;
			for (int i = 0; i < m; i++) {
				s += v[i][j];
				X[i][j] = s;
			}
		}
		return X;
	}

	/**
	 * Calculates the product of the values in an array.
	 * @param v Input array.
	 * @return The product of the values in v.
	 */
	public static int product(int[] v) {
		int m = v.length;
		int p = 1;
		for (int i = 0; i < m; i++)
			p *= v[i];
		return p;
	}

	/**
	 * Calculates the product of the values in each column of a matrix.
	 * @param v Input matrix.
	 * @return An array of n values where n=number of columns in v. The i'th element is product 
	 * of the values in the i'th column of v.
	 */
	public static int[] product(int[][] v) {
		int m = v.length;
		int n = v[0].length;
		int[] X = new int[n];
		for (int j = 0; j < n; j++) {
			int p = 1;
			for (int i = 0; i < m; i++)
				p *= v[i][j];
			X[j] = p;
		}
		return X;
	}

	/**
	 * Calculates cumulative product of the values in an array.
	 * Example:<br>
	 * <code>
	 * int[] b = {1,2,3,4};<br>
	 * int[] z = cumProduct(b);<br>
	 * Result is:<br>
	 * 1    2    6   24<br>
	 * </code>
	 * @param v Input array
	 * @return Out put array of same size as v.
	 */
	public static int[] cumProduct(int[] v) {
		int m = v.length;
		int[] X = new int[m];
		int s = 1;
		for (int i = 0; i < m; i++) {
			s *= v[i];
			X[i] = s;
		}
		return X;
	}

	/**
	 * Calculates the cumulative product of each column in a matrix.
	 * Example:<br>
	 * <code>
	 * int[][] a =    {{0,  1,  2,  3,  4},<br>
	 *                 {1,  7,  8,  9, 10},<br>
	 *                 {2, 13, 14, 15, 16},<br>
	 *                 {3, 19, 20, 21, 22},<br>
	 *                 {4, 23, 24, 25, 26}};<br>
	 * Result is:<br>
	 * 0        1        2        3        4<br>
	 * 0        7       16       27       40<br>
	 * 0       91      224      405      640<br>
	 * 0     1729     4480     8505    14080<br>
	 * 0    39767   107520   212625   366080<br>
	 * </code>
	 * @param v
	 * @return Output matrix. Each column is the cumulative product of each column in v.
	 */
	public static int[][] cumProduct(int[][] v) {
		int m = v.length;
		int n = v[0].length;
		int[][] X = new int[m][n];
		int s;
		for (int j = 0; j < n; j++) {
			s = 1;
			for (int i = 0; i < m; i++) {
				s *= v[i][j];
				X[i][j] = s;
			}
		}
		return X;
	}

	//  print methods

	/**
	 * Generates a string that holds a nicely organized version of a matrix or array. 
	 * Note the lower case S. It's tostring() not toString(). 
	 * Example:<br>
	 * <code>
	 * int[][] a = {{1,22,333},{4444,555,7}};<br>
	 * System.out.println(tostring(a));<br>
	 * result is:<br>
	 * 1 22 333<br>
	 * 4444 555 7<br>
	 * </code>
	 * @param v Matrix or array
	 * @return A string of a nicely organized version of the matrix or array.
	 */
	public static String toString(int[]... v) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length - 1; j++)
				str.append(v[i][j] + " ");
			str.append(v[i][v[i].length - 1]);
			if (i < v.length - 1)
				str.append("\n");
		}
		return str.toString();
	}

	/**
	 * Generates a string that holds a nicely organized version of a matrix or array. 
	 * Uses format specifier, e.g. "%5d"
	 * An extra space is automatically included.
	 * Note the lower case S. It's tostring() not toString(). 
	 * Example:<br>
	 * <code>
	 * int[][] a = fill(2, 3, 555);<br>
	 * System.out.println(tostring("%11d", a));<br>
	 * result is:<br>
	 *         555         555         555<br>
	 *         555         555         555<br>
	 * </code>
	 * @param format A standard format specifier for one value
	 * @param v Matrix or array
	 * @return A string of a nicely organized version of the matrix or array.
	 */
	public static String toString(String format, int[]... v) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length - 1; j++)
				str.append(String.format(format + " ", v[i][j]));
			str.append(String.format(format, v[i][v[i].length - 1]));
			if (i < v.length - 1)
				str.append("\n");
		}
		return str.toString();
	}

	// transpose

	/**
	 * Transposes an mxn matrix into an nxm matrix. Each row of the input matrix becomes a column in the
	 * output matrix.
	 * @param M Input matrix.
	 * @return Transposed version of M.
	 */
	public static int[][] transpose(int[][] M) {
		int[][] tM = new int[M[0].length][M.length];
		for (int i = 0; i < tM.length; i++)
			for (int j = 0; j < tM[0].length; j++)
				tM[i][j] = M[j][i];
		return tM;
	}

}