import java.util.Random;

public class KnightsTourAccessibility {
	public static void main(String[] args) {
		int chessBoardArray[][] = new int[8][8];
		
		int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		int[][] accMatrix = {{2,3,4,4,4,4,3,2}, {3,4,6,6,6,6,4,3}, {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4}, {3,4,6,6,6,6,4,3}, {2,3,4,4,4,4,3,2}}; 
		
		int currentRow = 1;
		int currentCol = 0;
		
		Random rand = new Random();
		
		int i = 1;
		int q = 1;
		chessBoardArray[currentRow][currentCol] = q;
		
		int nextMove;
		while (q<=chessBoardArray.length*chessBoardArray[0].length && i<=10000) {
			i++;
			
			int bestMove=8;
			int curBestAcc = 9;
			for(int r=0; r<8; r++) {
				if(isValidMove(r, currentRow, currentCol, horizontal, vertical)) {
					if(accMatrix[currentRow+vertical[r]][currentCol+horizontal[r]] < curBestAcc && chessBoardArray[currentRow+vertical[r]][currentCol+horizontal[r]]==0) {
						curBestAcc = accMatrix[currentRow+vertical[r]][currentCol+horizontal[r]];
						bestMove = r;
					}
				}
				
			}
			
			nextMove = bestMove;
			
			if(nextMove < 8) {
				//make the next Move
				q++;
				currentRow += vertical[nextMove];
				currentCol += horizontal[nextMove];
				chessBoardArray[currentRow][currentCol] = q;
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
