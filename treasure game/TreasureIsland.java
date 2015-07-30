/**
 * @(#)TreasureIsland.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */

import java.util.*;
public class TreasureIsland extends Island {
	private int gain;

    public TreasureIsland()  //only constructor
    {
     	super("t");
    }

    public void UseIsland(Player p)
    {
       Random generator=new Random();
       gain=generator.nextInt(30)+1;
       int temp;
       temp=gain+p.GetWealth();
       p.SetWealth(temp);
    }
/*abstract method from parent. uses the island on
*Player p as indicated in assignment.
*This method is called by the TreasureIsland object
*when p lands on a cell with 't'.*/
public int Getgain()
{
	return gain;
}

}