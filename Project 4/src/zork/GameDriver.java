/**
 * ---------------------------------------------------------------------------
 * File name: GameDriver.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 6, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver method. Runs the program.
 *
 * <hr>
 * Date created: Apr 6, 2017
 * <hr>
 * @author Shane Barlow
 */
public class GameDriver
{
	/**
	 * Driver method. Runs the program.         
	 *
	 * <hr>
	 * Date created: Apr 6, 2017
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		welcome();
		startGame();
	}//end main(String[] args)
	
	/**
	 * Uses the GameManager Class to control the movement, combat, and items within the dungeon         
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 */
	public static void startGame()
	{
		Scanner kb = new Scanner(System.in);
		
		try
		{
			GameManager game = new GameManager();
			game.help();
			while (game.getPlayerHealth ( )>0)
			{
				System.out.println (game.showStats ( ));
				System.out.println (game.map ( ).toString ( ));
				game.option ( );
				if(game.currentRoom ( ).hasMonster ( ))
				{
					//if the room has a monster
					System.out.println (">" + game.currentRoom ( ).getMonster ( ).getName ( ) + " here! Prepare for Class!" );
					System.out.println (">Press ENTER to take the Class!");
					kb.nextLine ( );
					game.combat ( );
				}
				if(game.currentRoom ( ).hasWeapon ( ))
				{
					//if the room as a weapon, equip weapon found
					System.out.println ("\t>You found a " + game.currentRoom ( ).getWeapon ( ).getName ( ) + "! Adding " + game.currentRoom ( ).getWeapon ( ).getAttack ( ) + " attack damage!");
					game.getPlayer ( ).setWeapon (game.currentRoom ( ).getWeapon ( ));
					game.currentRoom ( ).setHasWeapon (false);
				}
				if (game.getPlayerPosition ( ) == game.getDungeonLength ( ) -1)
				{
					//if the player reaches the end of the dungeon/end game
					System.out.println (game.winGame());
					System.exit (-1);
					break;
				}
				else
				{
					//if the room is empty
					System.out.println ("\n>There is nothing else to do here.");	
				}//end if
			}//end while
			
		}//end try
		catch(Exception e)
		{
			System.out.println("Something bad happened: " + e.getMessage()); 
		}//end catch	
	}//end startGame()
	
	/**
	 * Shows the Zork splash text        
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 */
	public static void welcome()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println ("\n"
			+ "        ====================================================        \n"
			+ "         oooooooooooo   .oooooo.   ooooooooo.   oooo    oooo        \n"
			+ "        d'''''''d888'  d8P'  `Y8b  `888   `Y88. `888   .8P'         \n" 
			+ "              .888P   888      888  888   .d88'  888  d8'           \n"  
			+ "             d888'    888      888  888ooo88P'   88888[             \n"
			+ "           .888P      888      888  888`88b.     888`88b.           \n"
			+ "          d888'    .P `88b    d88'  888  `88b.   888  `88b.         \n"
			+ "        .8888888888P   `Y8bood8P'  o888o  o888o o888o  o888o        \n"
			+ "        ====================================================        \n"
			+ "                         A GAME OF DEGREES                          \n"
			+ "        ====================================================        \n"
			+ "               Created by:   Shane Barlow                           \n"
			+ "               ======================================               \n"
			+ "                        ****** STORY ******                         \n"
			+ "           You play as Shane, an under grad student at ETSU.        \n"	
			+ "        Shane is a Computer Science IT major tring to navigate      \n"
			+ "       Nicks Hall in persuit of a degree. Along is journey, he      \n"
			+ "    is met by powerful foes. These foes are the professors of the   \n"	
			+ "     Computer Science department. Shane must defeat these enemies   \n"
			+ "    reach the end of Nick's hall. If Shanes Mental drops below 0    \n"
			+ "     Shane fails. If Shane makes it to the end of Nick's Hall with  \n"
			+ "           any amount of Mental Health left, Shane Passes!          \n"
			+ "       Professors have a 25% chance to drop potions, in this        \n"
			+ "     case Coffee, to allow Shane to recover Mental Health points!   \n"
			+"\n"
			+">Press ENTER to Continue                                               ");
			kb.nextLine ( );
	}//end welcome()

}//end GameDriver
