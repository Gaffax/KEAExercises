package domain;

import javax.swing.JButton;

public class PatrolBoat extends Ship
{
	private static int intactSegments = 2;
	public PatrolBoat(JButton[][] battleGrid, int row, int column, boolean isHorizontal)
	{
		super(battleGrid, row, column, intactSegments, isHorizontal);		
	}

}
