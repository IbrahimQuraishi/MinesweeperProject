import java.util.Scanner;
import java.util.Random;
public class Minesweeper {

	private int[][] rboard;//instance variables
	private char[][] hboard;
	
	public Minesweeper(int rows, int columns) {//constructor
		this.rboard = new int [rows][columns];
		this.hboard = new char [rows][columns];
	}
	
	//initial board filler
	public void fboard (int rows, int columns) {
		int count1, count2;
		Random rand = new Random();
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				this.rboard[count1][count2] = rand.nextInt(2);	
			}
		}
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				this.hboard[count1][count2] = '*';	
			}
		}
	}
	
	public void pboard (int rows, int columns) {
		int count1, count2;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				System.out.print(hboard[count1][count2]+ "  ");				
			}
			System.out.println();
		}
	}
	//user input method
	public int pinput () {
		Scanner cin = new Scanner(System.in);
		int grow, gcolumn;
		System.out.println("Enter the row you want to check");
		grow = cin.nextInt()-1;
		System.out.println("Enter the column you want to check");
		gcolumn = cin.nextInt()-1;
		if (rboard[grow][gcolumn]==1) {
			hboard[grow][gcolumn] = 'B';
			return 1;
		}
		else {
			hboard[grow][gcolumn] = 'C';
			return 0;
		}
	}
	
	//win checker
	public void wcheck(int rows, int columns) {
		int count1, count2, count=0, clear=1;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				if ((rboard[count1][count2]==0)&&hboard[count1][count2]=='C') {
					count++;
				}
				if (rboard[count1][count2]==0) {
					clear++;
				}
				
			}
		}
		if (count >= clear) {
			System.exit(0);
		}
	}
}



	
