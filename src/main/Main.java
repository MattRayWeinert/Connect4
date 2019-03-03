package main;

public class Main {

	public static void main(String[] args)
	{
		Connect4 game = new Connect4();


		
		while(game.checkWin() != true)
		{
			game.userInput();
			game.printRack();
		}
	}
}
