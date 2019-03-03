package main;

public class Main {

	public static void main(String[] args)
	{
		Connect4 game = new Connect4();

		System.out.println("*** Player 1 will be given the number '1'");
		System.out.println("*** Player 2 will be given the number '2'");
		
		while(game.checkWin() != true)
		{
			game.userInput();
			game.printRack();
			
			if(game.checkWin() == true)
			{
				System.exit(0);
			}
			
			game.userInput2();
			game.printRack();
		}
	}
}
