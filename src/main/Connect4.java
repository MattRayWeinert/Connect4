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
			if(isFull(--col) != 0)
			{
				drop(col);
			}
		}
		
		else
		{
			System.out.println("*** Try picking a valid column.");
		}
	}
	
	public void userInput2()
	{
		System.out.println("*** Please pick a column");
		int col2 = in.nextInt();

		if(col2 < 7 && col2 > 0)
		{
			if(isFull(--col2) == 1)
			{
				drop2(col2);
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
		if(options[col][0] != 0 )
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
	
	// Drops the token into the bottom of the column
	public void drop2(int col2)
	{
		int row = 0;
		
		// Finds the open bottom-most space in the column
		while(row < 6 && options[col2][row + 1] == 0)
		{
			row++;
		}
		
		// Places marker in the 2D array
		options[col2][row] = 2;
		System.out.println(options[col2][row]);
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
		int ctr1 = 0, ctr2 = 0;
		
		for(int a = 6; a >= 0; a--)
		{
				if(options[x][a] == 1)
				{
					ctr1++;
					
					if(ctr1 == 4)
					{
						return ctr1;
					}
				}
				
				else if(options[x][a] == 2)
				{
					ctr2++;
					
					if(ctr2 == 4)
					{
						return ctr2;
					}
				}

				else
				{
					ctr1 = 0;
					ctr2 = 0;
				}
		}

		return 0;
	}
	
	public int horizontal(int x, int y)
	{
		int ctr3 = 0, ctr4 = 0;
		
		for(int b = 5; b >= 0; b--)
		{
			if(options[b][y] == 1)
			{
				ctr3++;
				
				if(ctr3 == 4)
				{
					return ctr3;
				}
			}
			
			if(options[b][y] == 2)
			{
				ctr4++;
				
				if(ctr4 == 4)
				{
					return ctr4;
				}
			}

			else
			{
				ctr3 = 0;
				ctr4 = 0;
			}
		}
		
		return 0;
	}
}
