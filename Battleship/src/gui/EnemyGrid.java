package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import domain.GameState;
import domain.Server;
import domain.Ship;

public class EnemyGrid extends JPanel 
{
	private static final int ROWS = 9;
	private static final int COLUMNS = 9;
	public static JButton[][] battleGrid = new JButton[ROWS+1][COLUMNS+1]; // saves buttons in 2D array
	JButton button;
	public List<Ship> listOfShips = new ArrayList<Ship>();
	
	private Ship aircraftCarrier;
	private Ship battleship;
	private Ship submarine;
	private Ship destroyer;
	private Ship patrolBoat;		
	
	//set to true once the ship has been placed on the grid
	private boolean aircraftCarrier_IsPlaced = false; 
	private boolean battleship_IsPlaced = false;
	private boolean submarine_IsPlaced = false;
	private boolean destoryer_IsPlaced = false;
	private boolean patrolBoat_IsPlaced = false;
	private ActionListener yourGridButtonListener = new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(GameState.playerShipsdeployed == true && GameState.playerTurn == true) //GameState.ismyturn == true
			{
				/*
				 * Can identify buttons by the tooltiptext. Code below illustrates that. 
				 */
				
//				JButton buttonTest = (JButton) e.getSource();
//				String ttt = buttonTest.getToolTipText();
//				int row2 = Integer.parseInt(ttt.substring(0, 1));
//				int column2 = Integer.parseInt(ttt.substring(1, 2));
//				System.out.println("Here are the coordinates for the button "+ row2 + " " +  column2);
				
//				battleGrid[row2][column2].getBackground();
				
				for (int row = 1; row <= ROWS; row++)
				{
					for (int column = 1; column <= COLUMNS; column++)
					{
						
						if (battleGrid[row][column] == e.getSource())
						{
							
							if(battleGrid[row][column].getBackground() == Color.RED || EnemyGrid.battleGrid[row][column].getBackground() == Color.WHITE)
							{
								System.out.println("invalid shot, please shoot again");
							}
							else
							{
								String shoot = "2" + row + column + "\n";
								Server.sendString(shoot);
								GameState.playerTurn = false;

							}
					
						}
						
				
					}
				}
			}
			
		
		}
	};
	public EnemyGrid()
	{
		this.setSize(400,400);
		this.setLayout(new GridLayout(ROWS, COLUMNS));

		for (int row = 1; row <= ROWS; row++)
		{

			for (int column = 1; column <= COLUMNS; column++)
			{

				JButton button = new JButton();
				button.setBackground(Color.CYAN);
				button.setToolTipText("" + row + column);
//				button.getToolTipText();
				battleGrid[row][column] = button;
				battleGrid[row][column].addActionListener(yourGridButtonListener);
				

				this.add(battleGrid[row][column]);

			}

		}
	}
	public static int getRows()
	{
		return ROWS;
	}

	public static int getColumns()
	{
		return COLUMNS;
	}
	public JButton[][] getEnemyGrid()
	{
		return battleGrid;
	}
	public static void shipUpdate(JButton[][] grid, int rows, int columns)
	{
		// TODO check if fits on board
		grid[rows][columns].setBackground(Color.GRAY);

	}
	/**
	 * Use this method to convert X-Y coordinates to position. 
	 * Used in savePosition to save the location of the ship and the position of a shot.
	 * @param row
	 * @param column
	 * @return int position
	 */
	public static int convertCoordinateToPosition(int row, int column)
	{
		int position = (((row-1) * COLUMNS) + column);
		
		return position;
	}
	/**
	 * unfinished!
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shoot(int row, int column)
	{
		boolean hit = false; // a miss until proven otherwise		
		int position = convertCoordinateToPosition(row, column);

		for(Ship ship: listOfShips)
		{
			if(ship.shipPosition.contains(position))
			{
				ship.hit();					
				
				if(ship.isAlive() == false)
				{
					//TODO set ship1 is sunk to true, or something. 
					//TODO perhaps a different color red for sunk ships. 
					
					System.out.println(ship + " is sunk");
										
					return true;
				}
				return true;
			}
			else if(!ship.shipPosition.contains(position))
			{
				hit = false;
			
			}
			else
			{
				System.out.println("something else happened.");
			}
		}
	
	return hit;

	}

	public static void markShotOnEnemyGrid(boolean hit, int row, int column)
	{
		if(hit == true)
		{
			battleGrid[row][column].setBackground(Color.RED);
		}
		else if(hit == false)
		{
			battleGrid[row][column].setBackground(Color.WHITE);
		}
				
	}


}

