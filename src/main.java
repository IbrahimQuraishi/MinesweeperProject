import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		// This program is minesweeper
		int rows, columns, check=0;
		Scanner cin = new Scanner(System.in);
		System.out.println("How many rows would you like?");
		rows = cin.nextInt();
		System.out.println("How many columns would you like?");
		columns = cin.nextInt();
		Minesweeper game = new Minesweeper(rows,columns);
		game.fboard(rows, columns);
		game.pboard(rows, columns);
		
		while (check != 1) {
			game.wcheck(rows, columns);
			check = game.pinput();
			game.pboard(rows, columns);
		}
		System.out.println("YOu sUcK");
	}

}
