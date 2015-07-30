/**
 * @(#)MysteryIsland.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */


public class MysteryIsland extends Island {

    public MysteryIsland() //only constructor
    {
    	super("m");
    }

    public void UseIsland(Player p)
    {
    	p.SetVoodoo();
    }
/*abstract method from parent. uses the island on
*Player p as indicated in assignment.
*This method is called by the MysteryIsland object
*when p lands on a cell with 'm'.*/


}