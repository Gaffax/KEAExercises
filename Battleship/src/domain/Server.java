package domain;

import gui.BattleGrid_V2;
import gui.EnemyGrid;
import gui.GameChat;
import gui.MainMenu;
import gui.StartMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
	private static StringBuffer toSend = new StringBuffer("");
	private static StringBuffer toAppend = new StringBuffer("");

	// TCP components
	private static ServerSocket hostServer = null;
	public static Socket socket = null;
	private static BufferedReader in = null;
	private static PrintWriter out = null;

	public final static int NULL = 0;
	public final static int DISCONNECTED = 1;
	public final static int DISCONNECTING = 2;
	public final static int BEGIN_CONNECT = 3;
	public final static int CONNECTED = 4;

	
	
	private static String hostIP;
	private static int port;
	public static int connectionStatus = BEGIN_CONNECT;
	public static boolean isHost;


	private static String playerName = StartMenu.getPlayerName();

	@Override
	public void run()
	{

		while (true)
		{
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				System.err.println("Not sure what this'll print" + e);
			}

			switch (connectionStatus)
			{
			case BEGIN_CONNECT:
				try
				{
					if (StartMenu.isHost() == true)
					{
						System.out.println("Establishing server");
						port = StartMenu.getPort();					
						hostServer = new ServerSocket(port);
						socket = hostServer.accept();
						System.out.println("host");
						changeStatus(CONNECTED);
					}
					else
					{

						hostIP = StartMenu.getHostIP();
						port = StartMenu.getPort();
						System.out.println(hostIP + " is the IP address we will connect to");
						System.out.println("connecting to server");
						socket = new Socket(hostIP, port);
						System.out.println("client");
						changeStatus(CONNECTED);
					}
					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					out = new PrintWriter(socket.getOutputStream(), true);
					/*
					 * Why not no reader and writer for hostserver?
					 *  Surely the poor guy also wants to send and receive messages?
					 */
				}
				catch (IOException e)
				{
					changeStatus(DISCONNECTED);
					System.out.println("Disconnected" + e);
				}

				break;
			/*
			 * When sending have message keys. First character is always the key
			 * 1: message 2: shot 3: verification 9: opponent name
			 */
			case CONNECTED:
				try
				{
					String message;
					if (toSend.length() != 0)
					{

						System.out.println(playerName + " message sent.");
						/*
						 * for some reason wasn't flushing output properly
						 * before sending. Why do I need to flush it both before
						 * and after sending it? Apparently the print method
						 * doesn't autoflush. Wait what does flush do anyway?
						 */
						
						out.print(toSend);
						out.flush();
						toSend.setLength(0); //makes sure the message isn't sent a million times. 
						

					}

					if (in.ready())
					{

						message = in.readLine();
						System.out.println(message + " has been received");
						int key = Integer.parseInt(message.substring(0, 1));
						// TODO look into Object Streams.

						int row;
						int column;
						int position;

						// chat message
						if (key == 1)
						{
							//doesn't send if nothing is in the message. 
							if (message.substring(2, message.length()-2) != "") //might be generating index out of bounds exceptions. 
							{
								String chatMessage = message.substring(1, message.length());
								GameChat.appendToChatBox(chatMessage + "\n");
							}
						}
						// shot
						else if (key == 2)
						{

							row = Integer.parseInt(message.substring(1, 2));
							column = Integer.parseInt(message.substring(2, 3));
							//position = BattleGrid_V2.convertCoordinateToPosition(row, column);

							if (BattleGrid_V2.shoot(row, column) == true)
							{
								BattleGrid_V2.markShotOnMyGrid(true, row,column);
								String verification = "3 " + "t " + row + " "
										+ column + "\n";
								sendString(verification);
							}
							else if (BattleGrid_V2.shoot(row, column) == false)
							{
								BattleGrid_V2.markShotOnMyGrid(false, row,
										column);
								String verification = "3 " + "f " + row + " "
										+ column + "\n";
								sendString(verification);
							}
						
							GameState.playerTurn = true;

						}
						// shot verification
						else if (key == 3)
						{
							/*
							 * Can't remember why using split instead of substring. Using split will be handier for later
							 * when increasing board size to beyond 9. Make sure to send messages with spaces in them. 
							 */
							String[] split = message.split("\\s+");
							String hit = split[1];
							row = Integer.parseInt(split[2]);
							column = Integer.parseInt(split[3]);

							if (hit.equals("f"))
							{
								EnemyGrid
										.markShotOnEnemyGrid(true, row, column);
							}
							else if (hit.equals("t"))
							{
								EnemyGrid.markShotOnEnemyGrid(false, row,
										column);
							}
						}
						else if (key == 9)
						{
							MainMenu.setEnemyLbl(message.substring(1,
									message.length()));
							System.out.println("ponies are great!");
						}
						else
						{
							System.out.println("not a valid message");
						}

					}
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

				break;

			case DISCONNECTING:

				changeStatus(DISCONNECTED);
				break;

			default:
				break;
			}
		}

	}

	private static void changeStatus(int newConnectStatus)
	{
		if (newConnectStatus != NULL)
		{
			connectionStatus = newConnectStatus;
		}
	}

	public static void sendString(String message)
	{
		synchronized (toSend)
		{
			toSend.append(message);
		}

	}

	public static void appendToChatBox(String message)
	{
		synchronized (message)
		{
			toAppend.append(message);
		}

	}

}
