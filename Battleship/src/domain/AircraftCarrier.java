package domain;

import javax.swing.JButton;
import domain.Submarine;

public class AircraftCarrier extends Ship
{

	private static int intactSegments = 5;
	public AircraftCarrier(JButton[][] battleGrid, int row, int column, boolean isHorizontal)
	{
		super(battleGrid, row, column, intactSegments, isHorizontal);
		
	}
	
	
	
}
