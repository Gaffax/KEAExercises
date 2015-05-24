package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import domain.Server;
import net.miginfocom.swing.MigLayout;

public class StartMenu
{

	private JFrame frame;
	private static JTextField playerNameTextField;
	private static JTextField hostIPtextField;
	public static JTextField portTextField;
	private int port;
	private static String hostIP;
	private static JCheckBox chckbxYouHost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					StartMenu window = new StartMenu();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the application.
	 */
	public StartMenu()
	{
		initialize(); //why not initilize the gui in the constructor, why have it in a seperate method?
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 309, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[106.00px][142.00px,grow]", "[14px][20px][][][][][][][38.00][]"));
		
		JLabel lblPlayerName = new JLabel("Player name:");
		frame.getContentPane().add(lblPlayerName, "cell 0 0,growx,aligny top");
		
		playerNameTextField = new JTextField();

	
		frame.getContentPane().add(playerNameTextField, "cell 1 0,growx,aligny top");
		playerNameTextField.setColumns(10);
		
		JLabel lblHostIp = new JLabel("Host IP:");
		frame.getContentPane().add(lblHostIp, "cell 0 1,alignx left");
		
		hostIPtextField = new JTextField();
		
		hostIPtextField.setText("localhost");
		frame.getContentPane().add(hostIPtextField, "cell 1 1,growx");
		hostIPtextField.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		frame.getContentPane().add(lblPort, "cell 0 2,alignx left");
		
		portTextField = new JTextField();
		portTextField.setToolTipText("default port");
		portTextField.setText("4444");
		frame.getContentPane().add(portTextField, "cell 1 2,growx");
		portTextField.setColumns(10);
		JLabel lblBoardSize = new JLabel("Board Size:");
		frame.getContentPane().add(lblBoardSize, "cell 0 5");
		
		JSpinner boardSizeSpinner = new JSpinner();
		boardSizeSpinner.setToolTipText("Will always be a square");
		boardSizeSpinner.setModel(new SpinnerNumberModel(9, 5, 20, 1));
		frame.getContentPane().add(boardSizeSpinner, "cell 1 5,alignx left");
		boardSizeSpinner.setEnabled(false);
		
		
		JLabel lblGridColor = new JLabel("Grid Color");
		frame.getContentPane().add(lblGridColor, "cell 0 6,alignx left");
		
		JComboBox gridColorComboBox = new JComboBox();
		frame.getContentPane().add(gridColorComboBox, "cell 1 6,growx");
		gridColorComboBox.setEnabled(false);
		
		JLabel lblGameReady = new JLabel("Game Ready?");
		frame.getContentPane().add(lblGameReady, "cell 0 7");
		
		JButton btnReadyColorButton = new JButton("");
		btnReadyColorButton.setBackground(Color.RED);
		frame.getContentPane().add(btnReadyColorButton, "cell 1 7,grow");
		chckbxYouHost = new JCheckBox("You Host?");
		chckbxYouHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(chckbxYouHost.isSelected())
				{
					hostIPtextField.setText("localhost");
					hostIPtextField.setEnabled(false);
					boardSizeSpinner.setEnabled(true);
					gridColorComboBox.setEnabled(true);
					
				}
				else
				{
					hostIPtextField.setEnabled(true);
					boardSizeSpinner.setEnabled(false);
					gridColorComboBox.setEnabled(false);
					
				}
				
			}
		});
		chckbxYouHost.setToolTipText("Select if you are the host");
		frame.getContentPane().add(chckbxYouHost, "cell 1 3");
		
		
		
		JButton btnReady = new JButton("Ready");
		frame.getContentPane().add(btnReady, "cell 1 9,grow");
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!playerNameTextField.getText().equals("") && !hostIPtextField.getText().equals("") && !portTextField.getText().equals(""))
				{
						new MainMenu();
						new Thread(new Server()).start();
						frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill in your name, the hosts IP address and the port number", "Missing info", JOptionPane.PLAIN_MESSAGE); 
				}
		
			}
		});
		
		
	}
	public static String getPlayerName()
	{
		return playerNameTextField.getText();
	}
	public static String getHostIP()
	{
		return hostIPtextField.getText();
	}
	public static int getPort()
	{
		return Integer.parseInt(portTextField.getText());
	}
	public static boolean isHost()
	{
		return chckbxYouHost.isSelected();
	}
}
