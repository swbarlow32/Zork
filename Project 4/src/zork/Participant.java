/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 6, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * To create Participant type for Monster and Player classes to extend from
 *
 * <hr>
 * Date created: Apr 6, 2017
 * <hr>
 * @author Shane Barlow
 */
public class Participant
{

	protected String name;		//name of the player/monster
	protected int health;		//health of the player/monster
	protected int attack;		//attack damage of the player/monster
	protected int hit;			//hit chance of the player/monster
	protected String icon;		//icon for the map
	protected int potion;		//player potions that restore health


	public Participant ( )
	{
		setHealth(0);
		setAttack(0);
		setPotion(0);

	}//end Participant()

	public Participant(int health, int attack)
	{
		this.health = health;
		this.attack = attack;
	}//end Participant(int, int)
	
	/**
	 * Set the hit chance of the Participant and its subclasses          
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @param hit - hit chance
	 */
	public void setHit (int hit)
	{
		this.hit = hit;
	}//end setAttack(int)
	
	/**
	 * @return hit
	 */
	public int getHit ( )
	{
		return hit;
	}//end getHit()

	/**
	 * Sets the attack damage of the Participant and its subclasses          
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @param attack - attack damage
	 */
	public void setAttack (int attack)
	{
		this.attack = attack;
	}//end setAttack(int)

	/**
	 * @return attack
	 */
	public int getAttack ( )
	{
		return attack;
	}//end getAttack()

	/**
	 * Sets the name of the Participant and its subclasses         
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @param name - name of the Participants
	 */
	public void setName (String name)
	{
		this.name = name;
	}//end setName(String)
	
	/**
	 * @return name
	 */
	public String getName ( )
	{
		return name;
	}//end getName()
	
	/**
	 * Sets the health of the Participant and its subclasses          
	 *
	 * <hr>
	 * Date created: Apr 16, 2017
	 *
	 * <hr>
	 * @param health - Participant's health
	 */
	public void setHealth (int health)
	{
		this.health = health;
	}//end setHealth(int)

	/**
	 * @return health
	 */
	public int getHealth ( )
	{
		return health;
	}//end getHealth()

	/**
	 * @param icon
	 */
	public String getIcon()
	{
		return icon;
	}// getIcon()
	
	
	/**
	 * Adds a potion that heals the player to the Participant - Player         
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 * @param potion - heals the player
	 */
	public void setPotion (int potion)
	{
		this.potion = potion;
	}//end setPotion(int)
	
	/**
	 * @return potion
	 */
	public int getPotion ( )
	{
		return potion;
	}//end getPotion()

}//end Participant
