package domain;

import javax.swing.JButton;

public class Destroyer extends Ship
{
	private static int intactSegments = 3;
	
	public Destroyer(JButton[][] battleGrid, int row, int column, boolean isHorizontal)
	{
		super(battleGrid, row, column, intactSegments, isHorizontal);
	}

}
