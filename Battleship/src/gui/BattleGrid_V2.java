package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.AircraftCarrier;
import domain.Battleship;
import domain.Destroyer;
import domain.GameState;
import domain.PatrolBoat;
import domain.Server;
import domain.Ship;
import domain.Submarine;

/**
 * 
 *TODO perhaps add the methods in here to a grid class.
 *
 * This panel is meant to be used twice. One of the
 * panels will show you the shots you took and where you hit enemy ships, The
 * other panel will show you where your ships are and where the enemy has been
 * shooting.
 * 
 * @author Nicholas
 *
 */
public class BattleGrid_V2 extends JPanel
{
	/*
	 * Switched to 2d array as it should make ship placement easier later. Also
	 * easier to check if ships are being placed on top of each other
	 */
	private static final int ROWS = 9;
	private static final int COLUMNS = 9;
	private static JButton[][] battleGrid = new JButton[ROWS+1][COLUMNS+1]; // saves buttons in 2D array
	JButton button;
	public static List<Ship> listOfShips = new ArrayList<Ship>();
	
	//The ships we want to have on the board
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
	
	/**
	 * Action listener for placing ships on your grid 
	 */
	private ActionListener yourGridButtonListener = new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//TODO give this action listener it's own class. Let's be nice to it.
			
			
			if(GameState.playerShipsdeployed == false)
			{
								
				for (int row = 1; row <= ROWS; row++)
				{
					for (int column = 1; column <= COLUMNS; column++)
					{
						
						if (battleGrid[row][column] == e.getSource())
						{
													
							boolean isHorizontal = MainMenu.getHorizontalBox();
							
							//TODO create other ship classes that extend ship
							
							//Perhaps switch would be more legible here?
						

								if(MainMenu.getBtnAircraftCarrier() == true && !aircraftCarrier_IsPlaced)
								{
									AircraftCarrier aircraftCarrier = new AircraftCarrier(battleGrid, row, column,isHorizontal);
									aircraftCarrier_IsPlaced = true;
									listOfShips.add(aircraftCarrier);
									
								
								}
								else if(MainMenu.getBtnBattleship() == true && !battleship_IsPlaced)
								{
									Battleship battleship = new Battleship(battleGrid ,row, column, isHorizontal);
									battleship_IsPlaced = true;
									listOfShips.add(battleship);
																
								}
								else if(MainMenu.getBtnSubmarine() == true && !submarine_IsPlaced)
								{
									Submarine submarine = new Submarine(battleGrid,row, column, isHorizontal);
									submarine_IsPlaced = true;
									listOfShips.add(submarine);
								}
								else if(MainMenu.getBtnDestroyer() == true && !destoryer_IsPlaced)
								{
									Destroyer destroyer = new Destroyer(battleGrid,row, column, isHorizontal);
									destoryer_IsPlaced = true;
									listOfShips.add(destroyer);
														
								}
								else if(MainMenu.getBtnPatrolBoat() == true && !patrolBoat_IsPlaced)
								{
									PatrolBoat patrolboat = new PatrolBoat(battleGrid,row, column, isHorizontal);
									patrolBoat_IsPlaced = true;
									listOfShips.add(patrolboat);
																	
								}
								if(aircraftCarrier_IsPlaced && battleship_IsPlaced && destoryer_IsPlaced && patrolBoat_IsPlaced && patrolBoat_IsPlaced && submarine_IsPlaced)
								{
									domain.GameState.playerShipsdeployed = true;
																					
									//TODO need to move the deployed complete. Need message from opponent for it.
									GameState.isDeployedComplete = true;
								}	
							}								
		
					}
				}			
				
			}
		
		}
		
	};

	public BattleGrid_V2()
	{
		this.setSize(400,400);
		this.setLayout(new GridLayout(ROWS, COLUMNS));

		for (int row = 1; row <= ROWS; row++)
		{

			for (int column = 1; column <= COLUMNS; column++)
			{

				JButton button = new JButton();
				button.setBackground(Color.CYAN);
				battleGrid[row][column] = button;
				battleGrid[row][column].addActionListener(yourGridButtonListener);

				this.add(battleGrid[row][column]);

			}

		}
	}
	/**
	 * Is used by the placeShipOnGrid methods. 
	 * Sets button on grid to gray.
	 * 
	 * @param grid
	 * @param rows
	 * @param columns
	 */
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
//	public static int convertPositionToCoordinate(int position)
//	{
//		
//	}
	/**
	 * Checks if a ship occupies the shot at position. <br>
	 * If it does, return's true (a hit) <br>
	 * If it does not, returns false (a miss)
	 * @param row
	 * @param column
	 * @return
	 */
	public static boolean shoot(int row, int column)
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
					//Server.sendString("1" + ship + " is sunk"); //attempt to send sunk message via chat. (failed)
					
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
				System.out.println("something else");
				
			}
		}
	
	return hit;

	}
	public static void markShotOnMyGrid(boolean hit, int row, int column)
	{
		if(hit == true)
		{
			battleGrid[row][column].setBackground(Color.WHITE);
		}
		else if(hit == false)
		{
			battleGrid[row][column].setBackground(Color.RED);
		}
		
	}

	/**
	 * Used by the ship class once a ship has been placed.
	 *  
	 * Will I need to have one of these methods per ship?
	 * @param IsPlaced
	 */
//	public void setShipIsPlaced()
//	{
//		this.shipIsPlaced = true;
//	}

}

