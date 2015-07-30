/**
 * @(#)Creatures.java
 *
 *
 * @author
 * @version 1.00 2013/3/3
 */

public abstract class Creatures {
    protected	String name; //Creature's name
    protected   int health; //Creature's health
    protected   int wealth; //Creature's wealth
    protected   int weapon; //the weapon Creature has
    protected   boolean voodoo; //does Creature have voodoo capabilities


    /**
     * Creates a new instance of <code>Creatures</code>.
     */
    public Creatures(String nam, int weap, boolean voo)  {
    	SetName(nam);
    	SetWeapon(weap);
    	voodoo=voo;


    }
    public String GetName() //gets name
    {
    	return name;
    }

    public void SetName(String s) //sets name
    {
    	name=s;
    }
    public int GetHealth() //gets health
    {
    	return health;
    }
    public abstract void SetHealth(); //abstract method will be implemented in children classes

    public int GetWealth() //gets wealth
    {
    	return wealth;
    }
    public abstract void SetWealth(); //abstract method will be implemented in children classes

    public int GetWeapon() //gets weapon
    {
    	return weapon;
    }
    public void SetWeapon(int w) //sets weapon to a number
    {
    	if(0<w&&w<=8)
    		weapon=w;
    		else
    			weapon=8;
    }
    public  String WeaponName(int w)
    {
    	String s;
    	if(w==1)
    	{
    		s="Sword";
    	}
    	else if(w==2)
    	{
    		s="Pistol";
    	}
    	else if(w==3)
    	{
    		s="Rifle";
    	}
    	else if(w==4)
    	{
    		s="Cannon";
    	}
    	else if(w==5)
    	{
    		s="AK47";
    	}
    	else if (w==6)
    	{
    		s="Machine Gun";
    	}
    	else if(w==7)
    	{
    		s="Rocket Launcher";
    	}
    	else
    	{
    		s="OK!Thats pertty ugly";
    	}
    	return s;
    }

          /*converts numeric weapon index to its
                 *name as required by assignment*/


     public boolean GetVoodoo() //gets voodoo
     {
     	return voodoo;
     }
    public void SetVoodoo() //sets voodoo to true
    {
    	voodoo=true;
    }
     void ResetVoodoo() //sets voodoo to false
     {
     	voodoo=false;
     }



}
