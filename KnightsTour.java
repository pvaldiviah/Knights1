import java.util.Random;

public class KnightsTour {
	public static void main(String[] args) {
		int chessBoardArray[][] = new int[8][8];
		
		int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		int currentRow = 3;
		int currentCol = 4;
		
		Random rand = new Random();
		
		int i = 1;
		int q = 1;
		chessBoardArray[currentRow][currentCol] = q;
		
		int nextMove;
		while (q<=chessBoardArray.length*chessBoardArray[0].length && i<=10000) {
			i++;
			nextMove = rand.nextInt(8);
			if(isValidMove(nextMove, currentRow, currentCol, horizontal, vertical)) {
				//check to make sure that this site hasn't already been visited
				if(chessBoardArray[currentRow+vertical[nextMove]][currentCol+horizontal[nextMove]]==0) {
					//make the next Move
					q++;
					currentRow += vertical[nextMove];
					currentCol += horizontal[nextMove];
					chessBoardArray[currentRow][currentCol] = q;
				}
			}
			
		}
		
		for(int j=0; j<8; j++) {
			for (int k=0; k<8; k++) {
				System.out.printf("%2d ", chessBoardArray[j][k]);
			}
			System.out.println();
		}
	}
	
	public static boolean isValidMove(int nextMove, int curRow, int curCol, int[] horizontal, int[] vertical) {
		boolean flag = true;
		if(curRow+vertical[nextMove]<0) {
			flag = false;
		}
		else if (curRow+vertical[nextMove]>7) {
			flag = false;
		}
		else if (curCol+horizontal[nextMove]<0) {
			flag = false;
		}
		else if (curCol+horizontal[nextMove]>7) {
			flag = false;
		}
		
		return flag;
	}
}
