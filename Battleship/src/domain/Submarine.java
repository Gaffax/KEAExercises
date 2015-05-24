package domain;

import javax.swing.JButton;

public class Submarine extends Ship
{
	private static int intactSegments = 3;
	
	public Submarine(JButton[][] battleGrid, int row, int column, boolean isHorizontal)
	{
		super(battleGrid, row, column, intactSegments, isHorizontal);
		
	}

}
