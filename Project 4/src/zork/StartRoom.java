/**
 * ---------------------------------------------------------------------------
 * File name: StartRoom.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 16, 2017
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * Creates a start room for the Player, inherited from the Room class
 *
 * <hr>
 * Date created: Apr 16, 2017
 * <hr>
 * @author Shane Barlow
 */
public class StartRoom extends Room
{

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 16, 2017 
	 *
	 * 
	 */
	public StartRoom ( )
	{
		setHasPlayer(true);
		setHasMonster(false);
		setHasWeapon(false);
	}//end StartRoom()
	
}//end StartRoom
