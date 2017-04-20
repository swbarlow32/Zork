/**
 * ---------------------------------------------------------------------------
 * File name: Room.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shane Barlow, barlows@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 8, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.Random;

/**
 * Creates each room for the dungeon randomly inserting Weapon and Monster types
 *
 * <hr>
 * Date created: Apr 8, 2017
 * <hr>
 * @author Shane Barlow
 */
public class Room
{
	Random rand = new Random();				//random variable frequently used
	private boolean hasPlayer = false;		//determines if a Room has the player
	private boolean hasMonster = false;		//determines if a Room has a monster
	private boolean hasWeapon = false;		//determines if a Room has a weapon
	private Weapon weapon;					//hold the weapon type
	private Monster monster;				//hold the monster type
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 8, 2017 
	 *
	 * 
	 */
	public Room ( )
	{
		setHasPlayer(false);
		setHasWeapon(false);
		createMonster();
	}//end Room()

	/**
	 * @return hasPlayer
	 */
	public boolean hasPlayer ( )
	{
		return hasPlayer;
	}//end hasPlayer()

	/**
	 * @param hasPlayer the hasPlayer to set
	 */
	public void setHasPlayer (boolean hasPlayer)
	{
		this.hasPlayer = hasPlayer;
	}//end setHasPlayer(boolean)

	/**
	 * @return hasMonster
	 */
	public boolean hasMonster ( )
	{
		return hasMonster;
	}//end hasMonster()
	
	/**
	 * @return monster
	 */
	public Monster getMonster ( )
	{
		return monster;
	}//end getMonster()
	
	/**
	 * @return hasWeapon
	 */
	public boolean hasWeapon ( )
	{
		return hasWeapon;
	}//end hasWeapon()
	
	/**
	 * @param hasWeapon the hasWeapon to set
	 */
	public void setHasWeapon (boolean hasWeapon)
	{
		this.hasWeapon = hasWeapon;
	}//end setHasWeapon(boolean)
	
	/**
	 * @param hasMonster the hasMonster to set
	 */
	public void setHasMonster (boolean hasMonster)
	{
		this.hasMonster = hasMonster;
	}//end setHasMonster(boolean)
	
	public Weapon getWeapon ( )
	{
		return weapon;
	}//end getWeapon()

	/**
	 * Set's the Weapon to the Participants       
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 * @param weapon - Participant Weapon
	 */
	public void setWeapon (Weapon weapon)
	{
		this.weapon = weapon;
	}//end setWeapon(Weapon)
	
	/**
	 * Randomly creates the different Monsters and their Weapons as well as randomly places them within a room         
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 */
	public void createMonster()
	{
		int spawn = rand.nextInt(2);
		int monsterWeaponChance;
		// 50% chance to create a monster
		if (spawn == 1)
		{
		spawn = rand.nextInt(4);
			switch (spawn)	
			{		
				case 0: monster = new DrBailey();
				monsterWeaponChance = rand.nextInt (3);
						switch(monsterWeaponChance)
						{
							case 0:
								monster.setWeapon (weapon = new Objects());
								break;
							case 1:
								monster.setWeapon (weapon = new Loops());
								break;
							case 2:
								monster.setWeapon (weapon = new DataTypes());
								break;
						}//end switch(monsterWeaponChance)
						break;
				case 1: monster = new DrWallace();
				monsterWeaponChance = rand.nextInt (3);
						switch(monsterWeaponChance)
						
						{
							case 0:
								monster.setWeapon (weapon = new TruthTables());
								break;
							case 1:
								monster.setWeapon (weapon = new Induction());
								break;
							case 2:
								monster.setWeapon (weapon = new RegularExpressions());
								break;
						}//end switch(monsterWeaponChance)
					break;
				case 2: monster = new MrTarnoff();
				monsterWeaponChance = rand.nextInt (3);
					switch(monsterWeaponChance)
						{
							case 0:
								monster.setWeapon (weapon = new ChipSets());
								break;
							case 1:
								monster.setWeapon (weapon = new PWM());
								break;
							case 2:
								monster.setWeapon (weapon = new KarnaughMaps());
								break;
						}//end //end switch(monsterWeaponChance)
					break;
				case 3: monster = new DrPrice();
				monsterWeaponChance = rand.nextInt (3);
						switch(monsterWeaponChance)
						{
							case 0:
								monster.setWeapon (weapon = new Inheritance());
								break;
							case 1:
								monster.setWeapon (weapon = new GUI());
								break;
							case 2:
								monster.setWeapon (weapon = new Arrays());
								break;
						}//end switch(monsterWeaponChance) 
					break;
			}//end switch(chance)
			setHasMonster(true);
		}
		else
		{
			setHasMonster(false);
		}//end if
	}//createMonster()
	
	/**
	 * Randomly creates a Weapon for the Player        
	 *
	 * <hr>
	 * Date created: Apr 19, 2017
	 *
	 * <hr>
	 */
	public void createWeapon()
	{
		Random rand = new Random();
		int chance = rand.nextInt(3);
		//equal chance of weapon 
		switch (chance)
		{
			case 0: weapon = new StudyGuide();
				break;
			case 1: weapon = new MagicPencil();
				break;
			case 2: weapon = new AnswerKey();
				break;
		}//end switch(chance)
		setHasWeapon(true);
	}//end createWeapon()	
	
	/**
	 * Creates a map String of what is contained in each Room        
	 *
	 * <hr>
	 * Date created: Apr 19, 2017 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String map = "";			//map per dungeon room
		String playerIcon;			//players icon
		String monsterIcon;			//monsters icon
		String weaponIcon;			//weapon icon
		
		//weapon icon
		if (hasWeapon)
		{
			weaponIcon = weapon.getIcon();
		}
		else
		{	
			weaponIcon = "__";
		}//end if
		//player icon
		if (hasPlayer)
		{
			playerIcon = "P";
		}
		else
		{
			playerIcon = "__";
		}//end if
		//monster icon
		if (hasMonster)
		{	
			monsterIcon = monster.getIcon();
		}
		else
		{
			monsterIcon = "__";
		}//end if
		
		//creates a room based on what the room contains
		map += "[_" + playerIcon + "_" + monsterIcon + "_" + weaponIcon + "_]";
		
		return map;
	}//end toString()
	
}//end Room

