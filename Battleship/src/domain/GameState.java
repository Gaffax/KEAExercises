package domain;

public class GameState
{
	private static boolean gameOver = false;
	private static boolean allPlayerShipSunk = false;
	private static boolean allEnemeyShipSunk = false;
	private static boolean isGameOver = false;
	//private boolean shipSunk;
	public static boolean airCraftCarrierSunk = false;
	public static boolean submarineSunk = false;
	public static boolean patrolBoatSunk = false;
	public static boolean battleshipSunk = false;
	public static boolean destroyerSunk = false;
	
	public static boolean playerTurn = false;
	public static boolean enemyTurn = false;
	public static boolean playerShipsdeployed = false;
	public static boolean enemyShipsDeployed = false;
	public static boolean isDeployedComplete;
	
	public GameState()
	{
		isDeployedComplete = false;
	}
	public void setSunk(String ship)
	{
		
	}
	public boolean isSunk(Ship ship)
	{
		return false;
		
	}
	
}
