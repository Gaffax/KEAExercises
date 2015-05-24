package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import domain.GameState;
import gui.StartMenu;


public class MainMenu
{

	private JFrame frame;
	
	private static String playerName;
	private static String hostIP;
	private static int port;
	private static boolean isHost;
	private static JCheckBox boxHorizontal = new JCheckBox("Horizontal");
	private static JRadioButton btnAircraftCarrier = new JRadioButton("Aircraft carrier");
	private static JRadioButton btnSubmarine = new JRadioButton("Submarine");
	private static JRadioButton btnPatrolBoat = new JRadioButton("Patrol boat");
	private static JRadioButton btnBattleship = new JRadioButton("Battleship");
	private static JRadioButton btnDestroyer = new JRadioButton("Destroyer");
	private static JLabel enemyPlayer;
	private static ServerSocket hostServer;
	private static Socket socket;
	private static PrintWriter out;
	private static BufferedReader in;
	


	public MainMenu()
	{
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		if(StartMenu.isHost())
		{
			GameState.playerTurn = true;
		}
		EnemyGrid enemyGrid = new EnemyGrid();
		enemyGrid.setBounds(0, 0, 400, 400);
		
		BattleGrid_V2 yourGrid = new BattleGrid_V2();
		
		yourGrid.setBounds(0, 0, 400, 400);
	
		GameChat gameChat = new GameChat();
		gameChat.setBounds(0, 0, 930, 140);
		
		
		frame = new JFrame();
		
		frame.setBounds(0, 0, 1024, 700);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel yourGridPanel = new JPanel();
		yourGridPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		yourGridPanel.setBounds(39, 53, 400, 400);
		yourGridPanel.setLayout(null);
		yourGridPanel.add(yourGrid);
		frame.getContentPane().add(yourGridPanel);
		
		JPanel enemyGridPanel = new JPanel();
		enemyGridPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		enemyGridPanel.setBounds(568, 53, 400, 400);
		enemyGridPanel.setLayout(null);
		enemyGridPanel.add(enemyGrid);
		frame.getContentPane().add(enemyGridPanel);
		
		JPanel chatPanel = new JPanel();
		chatPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		chatPanel.setBounds(37, 499, 930, 140);
		frame.getContentPane().add(chatPanel);
		chatPanel.setLayout(null);
		
		chatPanel.add(gameChat);
		
		JLabel lblPlayer = new JLabel(StartMenu.getPlayerName());
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPlayer.setBounds(49, 453, 390, 35);
		frame.getContentPane().add(lblPlayer);
		
		enemyPlayer = new JLabel("Player 2");
		enemyPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
		enemyPlayer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		enemyPlayer.setBounds(568, 453, 400, 35);
		frame.getContentPane().add(enemyPlayer);
		
		JLabel lblPhaseTurn = new JLabel("PHASE / TURN");
		lblPhaseTurn.setBounds(431, 11, 171, 31);
		frame.getContentPane().add(lblPhaseTurn);

		JPanel shipHolderPanel = new JPanel();
		shipHolderPanel.setBounds(441, 53, 117, 400);
		frame.getContentPane().add(shipHolderPanel);
		shipHolderPanel.setLayout(new GridLayout(10, 1, 0, 5));
		
		
		ButtonGroup shipGroup = new ButtonGroup();
		
		shipGroup.add(btnAircraftCarrier);
		shipHolderPanel.add(btnAircraftCarrier);
		
		
		shipGroup.add(btnSubmarine);
		shipHolderPanel.add(btnSubmarine);
		
		
		shipGroup.add(btnPatrolBoat);
		shipHolderPanel.add(btnPatrolBoat);
		
		
		shipGroup.add(btnBattleship);
		shipHolderPanel.add(btnBattleship);
		
		
		shipGroup.add(btnDestroyer);
		shipHolderPanel.add(btnDestroyer);
		
		
		shipHolderPanel.add(boxHorizontal);
		
		JButton btnReady = new JButton("Ready");
		shipHolderPanel.add(btnReady);
		frame.setVisible(true);
		
		
	}
	public static boolean getHorizontalBox()
	{
		return boxHorizontal.isSelected();
	}
	public static boolean getBtnAircraftCarrier()
	{
		return btnAircraftCarrier.isSelected();
	}
	public static boolean getBtnSubmarine()
	{
		return btnSubmarine.isSelected();
	}
	public static boolean getBtnPatrolBoat()
	{
		return btnPatrolBoat.isSelected();
	}
	public static boolean getBtnBattleship()
	{
		return btnBattleship.isSelected();
	}
	public static boolean getBtnDestroyer()
	{
		return btnDestroyer.isSelected();
	}
	public static void setEnemyLbl(String enemyName)
	{
		enemyPlayer.setText(enemyName);
	}
	public static String getEnemyLbl()
	{
		return enemyPlayer.getText();
	}
}
