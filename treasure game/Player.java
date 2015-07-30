/**
 * @(#)Player.java
 *
 *
 * @author
 * @version 1.00 2013/3/3
 */

import java.util.*;
public class Player extends Creatures {
  private boolean ship; //whether player possesses a ship
  private int position; //Player's position on gameboard

 public  Player(String s) //only constructor
 {
 	super(s,1,false);
 	position=-1;
 	ship=false;
 	SetHealth();
 	SetWealth();
 }

public void SetHealth()
{
	health=500;
}
/*abstract method from parent. sets health to 500*/

public void SetHealth(int h)
{
	health=h;
}
public void SetWealth()
{
	wealth=500;
}
/*abstract method from parent. sets wealth to 500*/

public void SetWealth(int w)
{
	wealth=w;
}

public boolean GetShip() //gets ship
{
	return ship;
}
public void SetShip() //sets ship to true
{
	ship=true;
}

public void ResetShip() //sets ship to false
{
	ship=false;
}

public int GetPosition() //gets position
{
	return position;
}
public void SetPosition(int p) //sets position
{
	if(0<=p&&p<30)
		position=p;
}

private int Roll()      // roll the die
{
	Random generator=new Random();
	return generator.nextInt(6)+1;
}
public void Move()
{
	int roll= Roll();
	if(ship)
	{
		position+=2*roll;
	}
	else
	{
		position+=roll;
	}
	System.out.println(name+" has rolled "+roll);
	System.out.println(name+" has moved to cell#"+(position+1));
}
/*moves a player through the board, updates position as per requirements*/
public int TradeOrFight(String enemyName)
{
  	if(enemyName.equalsIgnoreCase("e"))
	{
		 System.out.println(name+" encounters a Easy Enemy pirate!" );
	}


	if(enemyName.equalsIgnoreCase("h"))
	  {
		System.out.println(name+" encounters a Hard Enemy pirate!" );

       }
	Scanner scan=new Scanner(System.in);
	int answer=0;

	  do
	{
	   if(answer!=0&&answer!=1)
	   	System.out.print("Error in Input! ");

	   	System.out.println("Would you like to offer to trade OR fight with this enemy (0=trade, 1=fight)?");
	        answer=scan.nextInt();
    }while(answer!=0&&answer!=1);



     return answer;

 }
/*takes user input regarding whether to trade/fight with enemy, and returns that
input*/

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

public void Reinforcements()
{
	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	System.out.println("$$$$$$$$$$$$$ REINFORCEMENTS $$$$$$$$$$$$$$$$$\n\n");
	  int answer=1;
 do
 {
	     System.out.println(name+", you have "+wealth+" gold coins.\n" );
	     System.out.println("$$$$$$$$ RATES $$$$$$$$");
	     System.out.println("1 health potions for 1 gold coin");
	     System.out.println("An improved weapon for 150 gold coins");
	     System.out.println("Non-refundable :)");
	     System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$\n");
		Scanner scan=new Scanner(System.in);


	  do
	{
	   if(answer!=0&&answer!=1&&answer!=2)
	   	System.out.print("Error in Input! ");
	   	System.out.println("What would you like to buy (0=nothing/done, 1=health potions, 2=better weapon)?");
	        answer=scan.nextInt();
    }while(answer!=0&&answer!=1&&answer!=2);


	if (answer==1)
	{
		int exchange=0;
			do
		{
			if(exchange<0||exchange>wealth)
				System.out.print("Error in Input! ");

			System.out.println("How many health potions would you like?(cannot be negative or more than your gold coins)");
	        exchange=scan.nextInt();
		}while(exchange<0||exchange>wealth);

			wealth-=exchange;
			health+=exchange;
			System.out.println(name+" increases health by "+exchange+" potions.");
			System.out.println(name+" decreases wealth by "+exchange+" gold coins.\n");

	}
	else if(answer==2)
	{
		if(weapon<8)
	  {

			   weapon++;


		if(wealth>=150)
		{
			wealth-=150;

			System.out.println(name+"\'s weapon has been improved to "+WeaponName(weapon)+".");
			System.out.println(name+" decreases wealth by 150 gold coins.\n" );
		}
		else
		{
			int temp=wealth;
			health+=temp-150;
			wealth=0;

		System.out.println(name+"\'s weapon has been improved to "+WeaponName(weapon));
		System.out.println(name+" decreases wealth by "+temp+" gold coins." );
		System.out.println(name+" decreases health by "+(150-temp)+" portions.\n");
		}
	  }
	  	else
	    {
	  		weapon=8;
	  		System.out.println("You have updated to the most powerful weapon!!!-----"+WeaponName(weapon)+".\n" );
	    }

	 }
	 else
	 	answer=0;

 } while(answer!=0);
}
/*Player uses this method to exchange their gold for ammo and/or
*health potions before the final battle for elixir of life.*/


public boolean Fight(Player p)
{
	int m=1;
	 int t=1;
    int temp=0;
    int player1=this.weapon-1;
    int player2=p.weapon-1;

	 int[] a=new int[this.weapon];
  int[] b=new int[p.weapon];
   System.out.println("XXxxXXxxXXxxXXxxXX FIGHT XXxxXXxxXXxxXXxxXX\n");
while(this.health>0&&p.health>0)
{
  System.out.println("~~~~~Round:  " +m+"~~~~~");
       m++;
  System.out.println("++"+this.name+" Health: "+this.health+" potions.");
  System.out.println("++"+p.name+" Health: "+p.health+" potions.");

 for (int i=0;i<a.length;i++)
 {
	a[i]=this.Roll();
 }
  for(int j=0;j<b.length;j++)
  {
	b[j]=p.Roll();
  }

      Arrays.sort(a);
      Arrays.sort(b);

    System.out.print(this.name+" has thrown: {");

    for(int i=a.length-1;i>0;i--)
    System.out.print(a[i]+", ");

    System.out.println(a[0]+"}");

   System.out.print(p.name+" has thrown: {");
    for(int j=b.length-1;j>0;j--)
    System.out.print(b[j]+", ");

     System.out.println(b[0]+"}");

        if(a.length>b.length)
        	temp=b.length;
        else
        	temp=a.length;

   player1=this.weapon-1;
   player2=p.weapon-1;
      t=1;
    while(this.health>0&&p.health>0&&temp>0)
    	{

        System.out.print("***Strike "+t+": ");
         if(a[player1]==b[player2])
         {
         	System.out.println("BOTH suffer blows!!!");
         	this.health-=a[player1]*10;
         	p.health-=b[player2]*10;
         	System.out.println(this.name+" decreases health by "+a[player1]*10+" potions.");
         	System.out.println(p.name+" decreases health by "+b[player2]*10+" potions.");
         }
         else if(a[player1]>b[player2])
         {
         		System.out.println(p.name+" does damage!");
         	p.health-=a[player1]*10;
         	System.out.println(p.name+" decreases health by "+a[player1]*10+" potions.");
         }
         else
         {
         	System.out.println(this.name+" does damage!");
         	this.health-=b[player2]*10;
         	System.out.println(this.name+" decreases health by "+b[player2]*10+" potions.");
         }

         player1--;
         player2--;

         temp--;
         t++;
    	}


}
if(this.health<=0)
  return false;
  else
  	return true;

}
/*Player uses this method to fight the other player (p) in
*the final battle for elixir of life.
*If this returns true means Player won, otherwise p won.*/




}
