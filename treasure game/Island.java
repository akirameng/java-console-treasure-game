/**
 * @(#)Island.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */


public abstract class Island {

     protected 	String name; //name of island

     public Island(String s) //only constructor
	{
		name=s;
	}
   public String GetName() //gets name
   {
   	return name;
   }
   public void SetName(String s) //sets name
   {
   	name=s;
   }
  public abstract void UseIsland(Player p);
/*abstract method will be implemented in children classes*/



}