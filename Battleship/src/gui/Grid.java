
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import domain.Ship;

/**
 * isn't quite working as desired. YET!!!
 * @author Nicholas
 *
 */
public class Grid extends JPanel
{
	public static final int ROWS = 15;
	public static final int COLUMNS = 15;
	public JButton[][] battleGrid = new JButton[ROWS+1][COLUMNS+1]; // saves buttons in 2D array
	JButton button;
	public List<Ship> listOfShips = new ArrayList<Ship>();
	
	public Grid()
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
				//battleGrid[row][column].addActionListener(new AL_enemyGrid_GUI());

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
	 * Checks if a ship occupies the shot at position.
	 * 
	 * 
	 * @param row
	 * @param column
	 * @return boolean
	 */
	public boolean shoot(int row, int column)
	{
		boolean hit = false; // a miss until proven otherwise		
		int position = convertCoordinateToPosition(row, column);
		System.out.println("******** pos "+position);
		System.out.println("*********** sh info "+ listOfShips);
		
		for(Ship ship: listOfShips) 
		{
			
			if(ship.shipPosition.contains(position))
			{
				
				ship.hit();					
				
				if(ship.isAlive() == false)
				{
					//TODO set ship1 is sunk to true, or something. 
					//TODO perhaps a different color red for sunk ships. 
					//battleGrid[row][column].setBackground(new Color(102,0,0));
					System.out.println(ship + " is sunk");
										
					return true;
				}
				return true;
			}
			else if(!ship.shipPosition.contains(position))
			{
				System.out.println("Nope, doesn't contain that position");
				hit = false;
							
			}
			else
			{
				System.out.println("something else");
				
			}
		}
	
	return hit;

	}



}
