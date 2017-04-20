/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 6, 2017
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * Creates a Player for the user to play as
 *
 * <hr>
 * Date created: Apr 6, 2017
 * <hr>
 * @author Shane Barlow
 */
public class Player extends Participant
{
	private Weapon weapon;			//holds the player Weapon type

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 6, 2017 
	 *
	 * 
	 */
	public Player ( )
	{
		super(50,10);
		weapon = new Weapon();
	}//end Player()

	/**
	 * @return weapon.getAttack
	 */
	public int getAttack()
	{
		return attack + weapon.getAttack();
	}//end getAttack()
	
	/**
	 * @return weapon
	 */
	public Weapon getWeapon ( )
	{
		return weapon;
	}//end getWeapon()

	/**
	 * Sets the Player's Weapon         
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @param weapon - player Weapon
	 */
	public void setWeapon (Weapon weapon)
	{
		this.weapon = weapon;
	}//end setWeapon(Weapon)
	
}//end Player
