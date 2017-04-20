/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 14, 2017
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * To create different Weapon types that extend to the Magic Pencil, Study Guide, and Answer Key Classes
 *
 * <hr>
 * Date created: Apr 14, 2017
 * <hr>
 * @author Shane Barlow
 */
public class Weapon
{
	private String name;		//name of the weapon
	private String icon;		//weapon icon for the map
	private int attack;			//attack damage of weapon

	/**
	 * Parameter Constructor        
	 *
	 * <hr>
	 * Date created: Apr 16, 2017 
	 *
	 * 
	 * @param name - name of weapon
	 * @param icon - weapon icon
	 * @param attack - attack damage per weapon
	 */
	public Weapon(String name, String icon, int attack)
	{
			this.name = name;
			this.icon = icon;
			this.attack = attack;
	}//end Weapon(String, String, int)

	/**
	 * Constructor       
	 *
	 * <hr>
	 * Date created: Apr 16, 2017 
	 *
	 * 
	 */
	public Weapon ( )
	{
		// TODO Auto-generated constructor stub
	}//end Weapon()

	/**
	 * @return name
	 */
	public String getName ( )
	{
		return name;
	}//end getName()

	/**
	 * @return icon
	 */
	public String getIcon ( )
	{
		return icon;
	}//end getIcon()

	/**
	 * @return attack
	 */
	public int getAttack ( )
	{
		return attack;
	}//end getAttack()
	
}//end Weapon
