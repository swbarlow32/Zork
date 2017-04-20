/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 6, 2017
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * To create Monster types
 *
 * <hr>
 * Date created: Apr 6, 2017
 * <hr>
 * @author Shane Barlow
 */
public class Monster extends Participant
{
	private Weapon weapon;		//holds the player Weapon type
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 6, 2017 
	 *
	 * 
	 */
	public Monster ( )
	{
		super(50,10);
		name = "Monster";
		icon = "M";
		weapon = new Weapon();

	}//end Monster()

	/**
	 * Parameter Constructor        
	 *
	 * <hr>
	 * Date created: Apr 6, 2017 
	 *
	 * 
	 * @param name - monster name
	 * @param health - monster health
	 * @param attack - monster attack
	 * @param icon - monster icon
	 */

	public Monster(String name, int health, int attack, String icon)
	{
		super(health, attack);
		this.name = name;
		this.icon = icon;
	}//end Monster(String, int, int, String)
	
	/**
	 * @return weapon
	 */
	public Weapon getWeapon ( )
	{
		return weapon;
	}//end getWeapon()

	/**
	 * Sets the Monster's Weapon         
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
	
}//end Monster
