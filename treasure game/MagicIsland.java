/**
 * @(#)MagicIsland.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */

import java.util.*;
public class MagicIsland extends Island {

	private int chamber;  //teleported positon in the board

    public MagicIsland() //only constructor
    {
	  super("j");
    }

    public void UseIsland(Player p)
    {
    Random generator=new Random();
      chamber=generator.nextInt(30);
     p.SetPosition(chamber);
     }
    /*abstract method from parent. NEVER USED by my
*program. However, need to include it as otherwise
*the abstract method from parent will not have
*been overridden.*/

   public void UseIsland(Player p, Board b)
   {
     Random generator=new Random();
    chamber=generator.nextInt(b.GetSIZE());
     p.SetPosition(chamber);


   }
/*Overloaded version of abstract method from parent.
*Uses the island on Player p as indicated in assignment.
*This method is called by the MagicIsland object
*when p lands on a cell with 'j'. The method needs
*Board object so that p is teleported to a valid
*destination cell.*/


public int Getchamber()   //get teleported positon in the board
{
	return chamber;
}
}