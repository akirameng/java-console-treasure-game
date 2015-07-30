/**
 * @(#)HardPirate.java
 *
 *
 * @author
 * @version 1.00 2013/3/4
 */

import java.util.*;
public class HardPirate extends Creatures {

   private	boolean tradeResponse; //response given to trade requests

    public HardPirate() {
    	super("h",2,false);
 	SetHealth();
 	SetWealth();
 	Random generator= new Random();
 	voodoo=generator.nextBoolean();
 	tradeResponse=generator.nextBoolean();
    }
    public void SetHealth()
    {
    	Random generator= new Random();
    	health=generator.nextInt(50)+51;
    }
    /*abstract method from parent. sets health to random
*number between 51 and 100*/

public void SetHealth(int s)
{
	health=s;
}
    public void SetWealth()
    {
    	Random generator= new Random();
    	wealth=generator.nextInt(50)+51;
    }
 /*abstract method from parent. sets wealth to random
*number between 51 and 100*/

   public boolean  GetTradeResponse() //gets tradeResponse
   {
   	return tradeResponse;
   }

   public void Trade(Player p)
   {
   	int remain=this.wealth*4;
   	this.wealth*=5;
   	remain=p.GetWealth()-remain;
   	p.SetWealth(remain);

   }
   /*this method is called by a pirate when trading with Player p.
    *Reduces p's wealth.*/

public boolean DoBlackMagic()
{
	Random generator=new Random();
	int result=generator.nextInt(4);
	if(result==0)
	{
		return false;
	}
	else
	{
		return true;
	}

}
/*if this method returns false means blackmagic was not done or it backfired.
*Otherwise means opponents health will be halved.*/

   public void Fight(Player p)
   {
    System.out.println("XXxxXXxxXXxxXXxxXX FIGHT XXxxXXxxXXxxXXxxXX\n");
       int t=1;
       	int remain=0;

       Random generator= new Random();
       int[] player=new int[p.GetWeapon()];
       int[] hard=new  int[2];
      while(p.GetHealth()>0&&this.health>0)
      {
      	System.out.println("~~~~~Round: "+t+"~~~~~");
      	System.out.println("++"+p.GetName()+" Health: "+p.GetHealth()+" potions.");
      	System.out.println("++Enemy Health: "+this.health+" potions.");
      for (int i=0;i<player.length;i++)
    {
	   player[i]=generator.nextInt(6)+1;
    }
      for(int j=0;j<hard.length;j++)
     {
       	hard[j]=generator.nextInt(6)+1;
     }

      Arrays.sort(player);
      Arrays.sort(hard);
      System.out.println(p.GetName()+" has thrown: "+player[p.GetWeapon()-1]);
      System.out.println("Hard Enemy has thrown: "+hard[hard.length-1]);
      if(player[p.GetWeapon()-1]==hard[hard.length-1])
      {
      	System.out.println("Its a TIE.\n");
      }
      else if(player[p.GetWeapon()-1]>hard[hard.length-1])
      {
      	System.out.println(p.GetName()+" has won this round!");
      	this.health-=player[p.GetWeapon()-1]*5;
      	System.out.println("Hard Enemy decreases health by "+player[p.GetWeapon()-1]*5+" potions.\n");
      }
      else
      {
      	System.out.println("Hard Enemy has won this round!");
   	    remain=p.GetHealth()-hard[hard.length-1]*5;
     	p.SetHealth(remain);
      	System.out.println(p.GetName()+" decreases health by "+hard[hard.length-1]*5+" potions.\n");
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
      	System.out.println(p.GetName()+" has found a Ship.");
      	p.SetShip();
      }


   }
/*this method is called by a pirate when fighting
*with Player p (when p lands on a cell with a pirate
*on the game board).
*Could affect p's health, wealth, weapon, ship.*/



}