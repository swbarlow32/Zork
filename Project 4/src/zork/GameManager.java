/**
 * ---------------------------------------------------------------------------
 * File name: GameManager.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 6, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Controls all game functions
 *
 * <hr>
 * Date created: Apr 6, 2017
 * <hr>
 * @author Shane Barlow
 */
public class GameManager
{
	private int damageTaken;				//damage taken by monster
	private int damageDelt;					//damage dealt to monster
	private Room[] dungeon;					//creates a dungeon rooms
	private int playerPosition;				//player's position in the dungeon
	private int monsterPosition;			//monster's position in the dungeon
	private Random rand = new Random();		//random variable that is used frequently
	private Player player = new Player();	//creates a new Player object
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 6, 2017 
	 *
	 * 
	 */
	public GameManager ( )
	{
		createDungeon();
		setPlayerPosition(0);
		placeWeapon();
	}//end GameManager()
	
	/**
	 * @return player
	 */
	public Player getPlayer()
	{
		return player;
	}//end getPlayer()
	
	/**
	 * Sets the Player's position         
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @param playerPosition
	 */
	public void setPlayerPosition (int playerPosition)
	{
		this.playerPosition = playerPosition;
	}//end setPlayerPsotion(int)
	
	/**
	 * @return playerPosition
	 */
	public int getPlayerPosition ( )
	{
		return playerPosition;
	}//end getPlayerPsoition()
	
	/**
	 * Sets the Monster's position         
	 *
	 * <hr>
	 * Date created: Apr 10, 2017
	 *
	 * <hr>
	 * @param monsterPosition
	 */
	public void setMonsterPosition (int monsterPosition)
	{
		this.monsterPosition = monsterPosition;
	}//end setMonsterPosition(int)
	
	/**
	 * @return monsterPosition
	 */
	public int getMonsterPosition ( )
	{
		return monsterPosition;
	}//end getMonsterPosition()

	/**
	 * Creates a dungeon using an array of Rooms        
	 *
	 * <hr>
	 * Date created: Apr 10, 2017
	 *
	 * <hr>
	 */
	public void createDungeon()
	{
			//creates a random number of rooms, then adds 5 to it. 5 being the minimum
			int rooms = rand.nextInt(5)+1;
			rooms += 5;	
			dungeon = new Room[rooms];
			dungeon[0] = new StartRoom();
			
			for (int index = 1; index < dungeon.length; index++)
			{
				dungeon[index] = new Room();
			}//end for	
	}//end createDungeon()
	
	/**
	 * Returns the dungeon length        
	 *
	 * <hr>
	 * Date created: Apr 10, 2017
	 *
	 * <hr>
	 * @return dungeon length
	 */
	public int getDungeonLength()
	{
		return dungeon.length;
	}//end getDungeonLength()
	
	/**
	 * Creates a map for each room of the dungeon, used with .toString()        
	 *
	 * <hr>
	 * Date created: Apr 10, 2017
	 *
	 * <hr>
	 * @return map - map of the dungeon
	 */
	public String map()
	{
		String map = "";
	
		for (int index = 0; index < dungeon.length; index++)
		{
			map += dungeon[index];
		}//end for
		
		return map;
	}//end map()
	
	/**
	 * Places a random Weapon in a random room        
	 *
	 * <hr>
	 * Date created: Apr 10, 2017
	 *
	 * <hr>
	 */
	public void placeWeapon()
	{
		int room;			//selected room of the dungeon
		//places weapon in any other room other than first or last
		room = rand.nextInt(dungeon.length-2);
		room += 1;		
		dungeon[room].createWeapon();
	}//end placeWeapon()
	
	public void usePotion()
	{
		if(player.getPotion ( )>0)
		{
			//does not allow layer health to go over 50
			player.setHealth (player.getHealth ( ) + 20);
			if(player.getHealth ( )>49)
			{
				player.setHealth (50);
			}
			player.setPotion (player.getPotion ( ) -1);
			System.out.println ("Mental Health increased by 20!");
		}
		else
		{
			System.out.println ("You do not have any Coffee");
		}//end if
	}//end usePotion()
	
	/**
	 * Initiates combat when the Player is in the same room as a Monster         
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @throws InterruptedException 
	 */
	public void combat() throws InterruptedException
	{
		//gets the player's and monster's health
		
		int monsterHealth = currentRoom ( ).getMonster ( ).getHealth ( );	//monster's health
		int playerHealth = player.getHealth ( );							//player's health
		int potChance = 0;													//potion drop chance
		
		while(monsterHealth > 0)
		{
		
			//set the hit chances
			player.setHit (rand.nextInt (10));
			currentRoom ( ).getMonster ( ).setHit (rand.nextInt (5));
			//sets the damage
			damageTaken = rand.nextInt (currentRoom ( ).getMonster ( ).getAttack()) +1;
			damageDelt = rand.nextInt (player.getAttack())+1;
				
			if(player.getHit ( )!=1)
			{
				//if Player hits Monster
				TimeUnit.SECONDS.sleep(1);
				System.out.println ("\t>You strike " + currentRoom ( ).getMonster ( ).getName() + " for " + damageDelt + " damage!");
				monsterHealth -= damageDelt;
			}
			else
			{
				//in the Player Misses
				TimeUnit.SECONDS.sleep(1);
				System.out.println ("\t>You miss!");
			}//end if
			if(currentRoom ( ).getMonster ( ).getHit ( )!=1)
			{
				//if the Monster hits the Player
				TimeUnit.SECONDS.sleep(1);
				System.out.println ("\t>"+currentRoom ( ).getMonster ( ).getName() +" strikes you with " +currentRoom().getMonster ( ).getWeapon ( ).getName ( )+ " for "+damageTaken + " damage!");
				playerHealth -= damageTaken;
			}
			else
			{
				//if the Monster misses
				TimeUnit.SECONDS.sleep(1);
				System.out.println ("\t>"+currentRoom ( ).getMonster ( ).getName()+" misses!");
			}//end if
			
			if(playerHealth < 1)
			{
				//if the player has no health
				System.out.println (loseGame());
				System.exit (-1);
			}
			else if(monsterHealth < 1)
			{
				//defeated the enemy
				TimeUnit.SECONDS.sleep(1);
				System.out.println ("\n\t>You defeated the " + currentRoom().getMonster ( ).getName ( ) + "!");
				TimeUnit.SECONDS.sleep(1);
				System.out.println ("\n\t>" + currentRoom().getMonster ( ).getName ( ) + " scurries back to the office!");
				player.setHealth (playerHealth);
				dungeon[playerPosition].setHasMonster(false);
				
				//25% chance to drop a potion/coffee
				potChance = rand.nextInt (4);
				switch(potChance)
				{
					case 0:
						TimeUnit.SECONDS.sleep(1);
						System.out.println ("\n\t>" + currentRoom().getMonster ( ).getName ( ) + " dropped a cup of Coffee!\n");
						player.setPotion (player.getPotion ( ) + 1);
					default:
						break;
				}//end switch
				TimeUnit.SECONDS.sleep(1);
			}//end if
		}//end while	
	}//end combat()
	
	/**
	 * To display the stats of the player       
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @return
	 */
	public String showStats()
	{
		String stats =   "\nCurrent Status:";
		stats +=         "\n----------------------------";
		stats +=         "\n>Mental Health: " + player.getHealth ( );
		if(player.getWeapon ( ).getName ( ) ==null)
		{
			stats +=     "\n>Weapon:        No Weapon";
		}
		else
		{
			stats +=     "\n>Weapon:        " + player.getWeapon ( ).getName ( );
		}
		stats +=         "\n>Attack:        " + player.getAttack ( );
		stats +=         "\n>Coffee:        " + player.getPotion ( );
		stats +=         "\n----------------------------";
		
		return stats;
	}
	/**
	 * Gets the current room of the player      
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @return - player position
	 */
	public Room currentRoom()
	{
		return dungeon[playerPosition];
	}//end currentRoom();
	
	/**
	 * Gets the player's health         
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @return - player's health
	 */
	public int getPlayerHealth()
	{
		return player.getHealth ( );
	}//end getPlayerHeath()

	/**
	 * Uses the goEast() goWest() usePotion() help() methods to control movement and input         
	 *
	 * <hr>
	 * Date created: Apr 8, 2017
	 *
	 * <hr>
	 */
	public void option()
	{
		Scanner kb = new Scanner (System.in);
		int option = 0;
		boolean flag = false;
		do{
			try
			{
				System.out.println ("\n>What would you like to do? \n[1]East \n[2]West \n[3]Drink Coffee\n[4]Help");
				option = kb.nextInt();
			switch (option)
			{
				case 1:
					goEast();
					clearScreen();
					break;
				case 2:
					goWest();
					clearScreen();
					break;
				case 3:
					clearScreen();
					usePotion();
					break;
				case 4:
					clearScreen();
					help();
					break;
				default:
					clearScreen();
					System.out.println ("Invalid Movement.");
			
			}//end switch()
			}
			catch(InputMismatchException e)
			{
				//if the input is invalid
				clearScreen();
				System.out.println ("Must choose 1-4.");
				kb.nextLine ( );
			}
		}while(flag);
	}//end movement()
	
	/**
	 * To control the users east movements and removes Weapons/Monsters from the room after collected/defeated          
	 *
	 * <hr>
	 * Date created: Apr 8, 2017
	 *
	 * <hr>
	 */
	public void goEast()
	{
		if(playerPosition<dungeon.length-1)
		{
			dungeon[playerPosition].setHasMonster(false);
			dungeon[playerPosition].setHasPlayer(false);
			dungeon[playerPosition].setHasWeapon(false);
			setPlayerPosition(playerPosition += 1);
			dungeon[playerPosition].setHasPlayer(true);
		}//end if
	}//end goEast()
	
	/**
	 * To control the users west movements and removes Weapons/Monsters from the room after collected/defeated        
	 *
	 * <hr>
	 * Date created: Apr 8, 2017
	 *
	 * <hr>
	 */
	public void goWest()
	{
		if(playerPosition>0)
		{
			dungeon[playerPosition].setHasMonster(false);
			dungeon[playerPosition].setHasPlayer(false);
			dungeon[playerPosition].setHasWeapon(false);;
			setPlayerPosition(playerPosition -= 1);
			dungeon[playerPosition].setHasPlayer(true);
		}
		else
		{
			//if the player cannot go west anymore
			System.out.println ("Cannot got back!");
		}//end if
	}//end goWest()
	
	/**
	 * Clears the screen         
	 *
	 * <hr>
	 * Date created: Apr 17, 2017
	 *
	 * <hr>
	 */
	public void clearScreen()
	{
		for(int index = 0;index<50;index++)
			System.out.println();
	}//end clearScreen()

	/**
	 * Shows the help menu along with the Player's/Monster's health, attack, weapons        
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 */
	public void help()
	{
		Scanner kb = new Scanner(System.in);
		clearScreen();
		System.out.println( "\n\n\n\n"
			+ "                          ****** HELP ******                        \n"
			+ "          Use the following numbers to perform an action:           \n"	
			+ "          [1] Move one space right                                  \n"
			+ "          [2] Move one space left                                   \n"
			+ "          [3] Use a potion to restore Mental Health                 \n"
			+ "          [4] Show this help menu again.                            \n "
			+ "\n"
			+ "                        ****** PLAYER ******                        \n"
			+ "        Shane:              Attack Power: 10               Health: 50\n"
			+ "\n"
			+ "                      ****** PROFESSORS ******                      \n"
			+ "        Dr. Price:          Attack Power: 6                Health: 25\n"
			+ "        Dr. Bailey:         Attack Power: 5                Health: 30\n"
			+ "        Dr. Wallace:        Attack Power: 8                Health: 27\n"
			+ "        Mr. Tarnoff:        Attack Power: 10               Health: 20\n"
			+ "\n"
			+ "                   ****** PROFESSOR WEAPONS ******                  \n"
			+ "        Dr. Price:                                                  \n"
			+ "                            Arrays                  Attack Power: +9\n"
			+ "                            Inheritance             Attack Power: +8\n"
			+ "                            GUIs                    Attack Power: +7\n"
			+ "        Dr. Bailey:                                                 \n"
			+ "                            Objects                 Attack Power: +9\n"
			+ "                            Loops                   Attack Power: +5\n"
			+ "                            Data Types              Attack Power: +8\n"
			+ "        Dr. Wallace:                                                \n"
			+ "                            Induction               Attack Power:+10\n"
			+ "                            Truth Tables            Attack Power: +5\n"
			+ "                            Regular Expression      Attack Power: +8\n"
			+ "        Mr. Tarnoff:                                                \n"
			+ "                            Chip Sets               Attack Power: +9\n"
			+ "                            Pulse Width Modulation  Attack Power: +7\n"
			+ "                            Karnaugh Maps           Attack Power: +5\n"
			+ "\n"
			+ "                    ****** PLAYER WEAPONS ******\n"
			+ "        Magic Pencil:                               Attack Power: +8\n"
			+ "        Answer Key:                                 Attack Power:+12\n"
			+ "        Study Guide:                                Attack Power:+10\n"
			+ "                       ****** POTIONS ******\n"
			+ "        Coffee:                                    Mental Health:+20\n"
			+"\n"
			+">Press ENTER to Continue                                               ");
			kb.nextLine ( );
		clearScreen();
	}//end 

	/**
	 * Displays a message and closes the program if the player dies       
	 *
	 * <hr>
	 * Date created: Apr 17, 2017
	 *
	 * <hr>
	 * @return Game Over
	 */
	public String loseGame()
	{
		return "\n\n\n"
			+ " #     # ####### #     #    ####### ####### ### #       \n"
			+ "  #   #  #     # #     #    #       #     #  #  #       \n"
			+ "   # #   #     # #     #    #####   #     #  #  #       \n"
			+ "    #    #     # #     #    #       #######  #  #       \n"
			+ "    #    #     # #     #    #       #     #  #  #       \n"
			+ "    #    #     # #     #    #       #     #  #  #       \n"
			+ "    #    #######  #####     #       #     # ### ####### \n";
	}//end endGame()
	/**
	 * Displays a message and closes the game if the player wins         
	 *
	 * <hr>
	 * Date created: Apr 17, 2017
	 *
	 * <hr>
	 * @return You win
	 */
	public String winGame()
	{
		return "\n\n\n"
			+ " #     # ####### #     #    ####### ####### ####### #######\n"
			+ "  #   #  #     # #     #    #     # #     # #       #      \n"
			+ "   # #   #     # #     #    #     # #     # #       #      \n"
			+ "    #    #     # #     #    ####### ####### ####### #######\n"
			+ "    #    #     # #     #    #       #     #       #       #\n"
			+ "    #    #     # #     #    #       #     #       #       #\n"
			+ "    #    #######  #####     #       #     # ####### #######\n";

	}//end winGame()
	
}//end GameManager
