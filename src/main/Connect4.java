package main;

import java.util.Scanner;

public class Connect4
{
	Scanner in = new Scanner(System.in);
	public int[][] options = new int[6][7];
	
	public Connect4()
	{
		options = new int[6][7];
	}
	
	public void printRack()
	{
		for(int a = 0; a < 7; a++)
		{
			System.out.print("|");
			System.out.print(" " + options[0][a] + "  ");
			System.out.print(" " + options[1][a] + "  ");
			System.out.print(" " + options[2][a] + "  ");
			System.out.print(" " + options[3][a] + "  ");
			System.out.print(" " + options[4][a] + "  ");
			System.out.println(" " + options[5][a]);
		}

		
		System.out.println(" =1= =2= =3= =4= =5= =6= ");
	}
	
	public void userInput()
	{
		System.out.println("*** Please pick a column");
		int col = in.nextInt();

		if(col < 7 && col > 0)
		{
			if(isFull(--col) == 1)
			{
				drop(col);
			}

		}
		
		else
		{
			System.out.println("*** Try picking a valid column.");
		}
	}
	
	// Checks if the column is full by checking top row of chosen column
	public int isFull(int col)
	{		
		if(options[col][0] == 1)
			return 0;
		else
			return 1;
	}
	
	// Drops the token into the bottom of the column
	public void drop(int col)
	{
		int row = 0;
		
		// Finds the open bottom-most space in the column
		while(row < 6 && options[col][row + 1] == 0)
		{
			row++;
		}
		
		// Places marker in the 2D array
		options[col][row] = 1;
				
	}
	
	public boolean checkWin()
	{
		for(int x = 0; x < 6; x++)
		{
			for(int y = 0; y < 7; y++)
			{
				if(options[x][y] != 0)
				{
					vertical(x, y);
					
					if(vertical(x, y) == 4)
					{
						System.out.println("Winner!");
						return true;
					}
					
					horizontal(x, y);
					
					if(horizontal(x, y) == 4)
					{
						System.out.println("Winner!");
						return true;
					}
				}
				
//				 Checks Diagonally
//				System.out.println(x + " " + y + " == " + options[x][y]);
			}
		}
		
		return false;
	}
	
	public int vertical(int x, int y)
	{
		int ctr = 0;
		
		for(int a = 6; a >= 0; a--)
		{
				if(options[x][a] != 0)
				{
					ctr++;
					
					if(ctr == 4)
					{
						return ctr;
					}
				}

				else
				{
					ctr = 0;
				}
		}

		return ctr;
	}
	
	public int horizontal(int x, int y)
	{
		int ctr = 0;
		
		for(int b = 5; b >= 0; b--)
		{
				if(options[b][y] != 0)
				{
					ctr++;
					
					if(ctr == 4)
					{
						return ctr;
					}
				}

				else
				{
					ctr = 0;
				}
		}
		
		return ctr;
	}
}
