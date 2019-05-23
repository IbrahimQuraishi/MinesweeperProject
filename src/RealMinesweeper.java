import java.util.Scanner;
import java.util.Random;
public class RealMinesweeper {
	//instance variables
	private int [][] hboard;
	private char [][] uboard;
	private int rows, columns, urow, ucolumn;
	Random rand = new Random();
	Scanner cin = new Scanner(System.in);
	
	public RealMinesweeper(int r, int c) {//constructor
		this.hboard = new int [r][c];//sets size of board to what the input is
		this.uboard = new char [r][c];
		this.rows = r;
		this.columns = c;
		this.urow = 0;
		this.ucolumn = 0;
	}
	
	//methods
	//fill the hidden board
	public void hfiller() {
		
		int count1, count2;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				this.hboard[count1][count2] = rand.nextInt(2);//fills the hidden board with ones and zeros
			}
		}
	}
	//fill the user's board
	public void ufiller() {
		int count1, count2;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				this.uboard[count1][count2] = '*';//fills the user board with stars to represent hidden spaces
			}
		}
	}
	//print the board
	public void pboard() {
		int count1, count2;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				System.out.print(uboard[count1][count2]+ " ");//prints the board after changed
			}
			System.out.println();
		}
	}
	//allow user input
	public void uinput () {
		System.out.println("Enter in the row then column of the location you want to check");
		this.urow = cin.nextInt()-1;
		this.ucolumn = cin.nextInt()-1;//sets the variabes for user row and column based on the input
	}
	//change the board based on the input
	public void cboard() {
		if (hboard[urow][ucolumn]==1) {
			uboard[urow][ucolumn] = 'C';//changes the user board based on their input
		}
		else if (hboard[urow][ucolumn]==0) {
			uboard[urow][ucolumn] = 'B';
		}
	}
	//check if they won
	public void cwin() {
		int count1, count2, count3=0, count4=0;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				if (uboard[count1][count2] == 'C') {//counts how many spaces on the user board are cleared
					count3++;
				}
			}
		}
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {//counts how many spaces on the hidden board are cleared
				if (hboard[count1][count2] == 1) {
					count4++;
				}
			}
		}
		if (count3>=count4) {//if they have cleared all the available spots they win
			System.out.println("You Win!");
			System.exit(0);
		}
	}
	//check if they hit a bomb
	public void cbomb() {
		int count1, count2;
		for (count1 = 0; count1 < rows; count1 ++) {
			for (count2 = 0; count2 < columns; count2 ++) {
				if (uboard[count1][count2] == 'B') {//checks if their input was a bomb
					int count3, count4;
					for (count3 = 0; count3 < rows; count3 ++) {
						for (count4 = 0; count4 < columns; count4 ++) {//prints the final board again 
							System.out.print(uboard[count3][count4]+ " ");
						}
						System.out.println();
					}
					System.out.println("You Lost!");
					System.exit(0);
				}
			}
		}
	}
}
