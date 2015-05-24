package domain;

import javax.swing.JButton;

public class Battleship extends Ship
{
	private static int intactSegments = 4;
	
	public Battleship(JButton[][] battleGrid, int row, int column, boolean isHorizontal)
	{
		super(battleGrid, row, column, intactSegments, isHorizontal);
	}

}
