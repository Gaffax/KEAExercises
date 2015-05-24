package gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;

import domain.Server;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//TODO seperate host, non host in seperate methods
//TODO separate connection and discussion
public class GameChat extends JPanel 
{

	private String message = "";

	private static String playerName = StartMenu.getPlayerName();

	private static JTextField chatTextLine;

	private static JTextArea textArea = new JTextArea();
	

	/**
	 * Create the panel.
	 * @param isHost2 
	 * @param port2 
	 * @param hostIP2 
	 * @param playerName 
	 * @param out2 
	 * @param in2 
	 * @param socket2 
	 * @param hostServer2 
	 */
	
	public GameChat()
	{
		
//		new Thread(new Server()).start();
				
		setLayout(null);
				
		textArea.setBounds(10, 11, 910, 87);
		
		
		Border border = BorderFactory.createLineBorder(Color.GRAY); //creates border for the text Area.
		textArea.setBorder(border);
		textArea.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10,11,831, 87);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
		add(scroll);
		
		chatTextLine = new JTextField();
		chatTextLine.setToolTipText("Press enter to send");
		chatTextLine.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String message = "1 " + chatTextLine.getText() + "\n"; 
					//the \n is necessary for message to be sent. 
					
					textArea.append(" " + playerName + ": " + chatTextLine.getText() + "\n");
					System.out.println("Message to be sent: " + message);
					Server.sendString(message); //Adds the message from chatline into a buffer to be used by server class.
					chatTextLine.setText(null);
				}
			
				
			}
			
		});
		chatTextLine.setBounds(10, 109, 831, 20);
		add(chatTextLine);
		chatTextLine.setColumns(10);
		
		this.setSize(930, 140);
		
		JButton btnNewButton = new JButton("Taunt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//TODO read from file. Enter into list. Shuffle list, then append to console. 
				 
				String message = ("1 I see your eyes glistening in fear " + "\n");
				textArea.append(" " + playerName + ": I see your eyes glistening in fear " + "\n");
				Server.sendString(message);
			}
		});
		btnNewButton.setBounds(852, 12, 78, 117);
		btnNewButton.setBackground(Color.RED);
		add(btnNewButton);


	}
	public static String getTextField()
	{
		return chatTextLine.getText();
	}

	public static void setTextField(String message)
	{
		chatTextLine.setText(message);
	}

	public static String getTextArea()
	{
		return textArea.getText();
	}

	public static void setTextArea(String message)
	{
		textArea.append(message);
	}

	public static String getPlayerName()
	{
		return playerName;
	}
	public static void appendToChatBox(String message)
	{
		synchronized (message)
		{
			textArea.append(message);
		}
		
	}


}
/*
 * Source
 * Enter key press
 * http://stackoverflow.com/questions/10745156/how-do-i-test-to-see-if-the-enter-key-is-pressed-in-a-textfield-in-java
 * TextArea Border
 * http://www.java-examples.com/set-jtextfield-border-example
 * 
 */
