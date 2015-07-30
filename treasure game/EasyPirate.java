/**
 * @(#)EasyPirate.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */

import java.util.*;
public class EasyPirate extends Creatures {

       private boolean tradeResponse;//response given to trade requests

    public EasyPirate() //only constructor
    {
    		super("e",1,false);
    		SetHealth();
 	     SetWealth();
 		tradeResponse=true;
    }
    public void SetHealth()
    {
    		Random generator= new Random();
    	health=generator.nextInt(50)+1;
    }

/*abstract method from parent. sets health to random
*number between 1 and 50*/

public void SetHealth(int s)
{
	health=s;
}

    public void SetWealth()
    {
    	Random generator= new Random();
    	wealth=generator.nextInt(50)+1;
    }
/*abstract method from parent. sets wealth to random
*number between 1 and 50*/

    public boolean GetTradeResponse() //gets tradeResponse
   {
   	 return tradeResponse;

    }

    public void Trade(Player p)
    {
     int remain=this.wealth;
   	  this.wealth*=2;
   	remain=p.GetWealth()-remain;
   	  p.SetWealth(remain);
    }
/*this method is called by a pirate when trading with Player p.**Reduces p's wealth.*/

     public void Fight(Player p)
     {
     	 System.out.println("XXxxXXxxXXxxXXxxXX FIGHT XXxxXXxxXXxxXXxxXX\n");
       int t=1;
       	int remain=0;

       Random generator= new Random();
       int[] player=new int[p.GetWeapon()];
       int[] easy=new  int[1];
      while(p.GetHealth()>0&&this.health>0)
      {
      	System.out.println("~~~~~Round: "+t+"~~~~~");
      	System.out.println("++"+p.GetName()+" Health: "+p.GetHealth()+" potions.");
      	System.out.println("++Enemy Health: "+this.health+" potions.");
      for (int i=0;i<player.length;i++)
    {
	   player[i]=generator.nextInt(6)+1;
    }
      for(int j=0;j<easy.length;j++)
     {
       	easy[j]=generator.nextInt(6)+1;
     }

      Arrays.sort(player);
      Arrays.sort(easy);
      System.out.println(p.GetName()+" has thrown: "+player[p.GetWeapon()-1]);
      System.out.println("Easy Enemy has thrown: "+easy[easy.length-1]);
      if(player[p.GetWeapon()-1]==easy[easy.length-1])
      {
      	System.out.println("Its a TIE.\n");
      }
      else if(player[p.GetWeapon()-1]>easy[easy.length-1])
      {
      	System.out.println(p.GetName()+" has won this round!");
      	this.health-=player[p.GetWeapon()-1]*5;
      	System.out.println("Easy Enemy decreases health by "+player[p.GetWeapon()-1]*5+" potions.\n");
      }
      else
      {
      	System.out.println("Easy Enemy has won this round!");
   	    remain=p.GetHealth()-easy[easy.length-1]*5;
     	p.SetHealth(remain);
      	System.out.println(p.GetName()+" decreases health by "+easy[easy.length-1]*5+" potions.\n");
      }
        t++;
      }
      if(this.health<=0)
      {
      	System.out.println(p.GetName()+" has won the BATTLE!" );
      	int total=p.GetWealth()+this.wealth;
      	p.SetWealth(total);
      	System.out.println(p.GetName()+" increases wealth by "+this.wealth+" gold coins.");
      	int wtotal=p.GetWeapon()+1;
      	p.SetWeapon(wtotal);
      	System.out.println(p.GetName()+"\'s weapon has been improved to "+WeaponName(wtotal) );

      }


    }
    /*this method is called by a pirate when fighting
*with Player p (when p lands on a cell with a pirate
*on the game board).
*Could affect p's health, wealth and weapon*/

}