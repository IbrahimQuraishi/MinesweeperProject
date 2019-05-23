import java.util.Scanner;
public class realmain {

	public static void main(String[] args) {
		// This program is Minesweeper
		int r, c, x=0;
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter the number of Rows and Columns");
		r = cin.nextInt();
		c = cin.nextInt();
		RealMinesweeper game = new RealMinesweeper(r,c);
		game.hfiller();
		game.ufiller();
		while (x==0) {
			game.pboard();
			game.uinput();
			game.cboard();
			game.cbomb();
			game.cwin();
			}
	}

}
