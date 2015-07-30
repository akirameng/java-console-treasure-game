/**
 * @(#)AbandonedIsland.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */


public class AbandonedIsland extends Island {


    public AbandonedIsland()   //only constructor
    {
    	super("a");
    }

    public void UseIsland(Player p)
    {
       int w=p.GetWeapon();
       w++;
       p.SetWeapon(w);
    }
/*abstract method from parent. uses the island on
*Player p as indicated in assignment.
*This method is called by the AbandonedIsland object
*when p lands on a cell with 'a'.*/


}