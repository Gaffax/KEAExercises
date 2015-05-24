package domain;

import gui.BattleGrid_V2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

/**
 * 
 * TODO pass the panel created into the methods instead of the grid. 
 * That will allow us to get the number of rows and columns for example. 
 * @author Nicholas
 *
 */
public abstract class Ship
{
	public List<Integer> shipPosition = new ArrayList<>(); //contains the place of the ship on the grid using position values. 
	public int crazyStuff = 100;
	private int segments; //when reaches 0, ship will be sunk
	boolean isAlive = true;
	int hitCounter = 0;
	
	/**
	 * Ship constructor. Needs to know what grid we are using, starting coordinates and which direction the ship needs to be placed in
	 * @param board
	 * @param row
	 * @param column
	 * @param isHorizontal
	 */
	public Ship(JButton[][] battleGrid ,int row, int column, int intactSegments, boolean isHorizontal)
	{
		segments = intactSegments;
		placeShipOnGrid(battleGrid, row, column, intactSegments, isHorizontal); //starts placement methods
		
	}
	/**
	 * 
	 * Does check for horizontal or vertical placement
	 * 
	 * @param battleGrid
	 * @param row
	 * @param column
	 * @param segments
	 * @param isHorizontal
	 */
	private void placeShipOnGrid(JButton[][] battleGrid, int row, int column, int segments, boolean isHorizontal)
	{
		if(isHorizontal) //for horizontal placement
		{
			placeHorizontalShipOnGrid(battleGrid, row, column, segments);
		}
		else if(!isHorizontal) //for vertical placement
		{
			placeVeticalShipOnGrid(battleGrid, row, column, segments);
		}	
		
		
	}
	
	/**
	 * Places the ships on the field if they are horizontal
	 * @param battleGrid
	 * @param row
	 * @param column
	 * @param segments
	 */
	private void placeHorizontalShipOnGrid(JButton[][] battleGrid, int row, int column,int segments)
	{
		//TODO check if it fits on the board
		//TODO check if it doesn't overlap other ships
		//TODO to set the ship to placed on the board
		
		for (int c = column; c < column + segments; c++)
		{
			BattleGrid_V2.shipUpdate(battleGrid, row, c);
			savePosition(row, c); //saves position of each ship segment
		}
		//board.setShipIsPlaced(true); //will want to set the ship to placed on the board
		
	}
	/**
	 * Place a ship on the field if it is vertical
	 * @param battleGrid
	 * @param row
	 * @param column
	 * @param segments
	 */
	private void placeVeticalShipOnGrid(JButton[][] battleGrid, int row, int column, int segments)
	{
		//TODO check if it fits on the board
		//TODO check if it doesn't overlap other ships
		//TODO to set the ship to placed on the board
		
		for (int r = row; r < row + segments; r++)
		{
			BattleGrid_V2.shipUpdate(battleGrid, r, column);
			savePosition(r,column); //saves position of each ship segment
		}
		
		//board.setShipIsPlaced(true); 
		
	}
	
	/**
	 * increments hit counter
	 */
	public void hit()
	{
		hitCounter++;

		if(hitCounter == segments )
		{
			isAlive = false;
		}
			
		//TODO maybe throw an illegal args exception if segments is less than 0
	}
	public boolean isAlive()
	{
		return isAlive;
	}
	/**
	 * adds the converted X:Y position to an arrayList. <br>
	 * This becomes the ships position on the grid. 
	 * @param row
	 * @param column
	 */
	public void savePosition(int row, int column)
	{
		shipPosition.add(BattleGrid_V2.convertCoordinateToPosition(row, column));		
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Sh = "+shipPosition;
	}

}
