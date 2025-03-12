import java.util.StringTokenizer;

public class TwoDimArray {

	public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		printArray(myArray);
		printArrayEven(myArray);
	}
	private static void printArray (int[][] theArray) {
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}
	private static void display (int num){
		System.out.print(num+" ");
	}
	private static void printArrayEven(int[][] theArray){
		
	}
	public static int[][] fillArray(String myFile) {
		TextFileInput readFile = new TextFileInput(myFile);
		String line = readFile.readLine();
		StringTokenizer tokens = new StringTokenizer(line, ":");
		int rows = Integer.parseInt(tokens.nextToken());
		int cols = Integer.parseInt(tokens.nextToken());
		int [][] TwoDimArray = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			line = readFile.readLine();
			tokens = new StringTokenizer(line, ":");
			for (int j = 0; j < cols; j++) {
				TwoDimArray[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		return TwoDimArray;
	}
}
