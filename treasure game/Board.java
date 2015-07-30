/**
 * @(#)Board.java
 *
 *
 * @author
 * @version 1.00 2013/3/5
 */

import java.util.*;
public class Board {

	private final int SIZE=30;       //size of gameboard
    private final int NUM_PLAYERS=2;     //max players
    private int diffLevel;      //holds difficulty level of the game
    private Player[] players;

    /*array of Player objects. size of this array
     *is NUM_PLAYERS*/

    private char[] hurdles;

    /*this array represents the different hurdles
   *on the game board using a single character.
   *Hence this is the gameboard.
   *The size of this array is SIZE.
   *For example, if hurdles[2] is equal to 't'
   *then there is a treasure island on cell#3
   *on the game board.*/

    public Board()
    {
    	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
    	System.out.println("||||||||||||||||||||START||||||||||||||||||||");
    	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||\n\n");

    	 players= new Player[NUM_PLAYERS];

    	 SetDifficulty();
    	 players[0]=new Player(GetPlayerName(0));
    	 players[1]=new Player(GetPlayerName(1));
    	 DisplayPlayerDetails();
    System.out.println("<<<--GAME BOARD LEGEND-->>>");
	System.out.println("e = This cell contains an easy enemy pirate.");
	System.out.println("h = This cell contains a hard enemy pirate.");
	System.out.println("t = This cell contains a treasure island.");
	System.out.println("a = This cell contains an abandoned ship.");
	System.out.println("m = This cell contains a mystery island.");
	System.out.println("j = This cell contains a magic chamber.");
	System.out.println(",P = This cell has a player in it.");
	System.out.println("<<<------- ----- ------->>>\n\n");
    DisplayBoard();



    }

/*only construcor.
*Displays introductory messages as shown in Sample Input and Output.
*Creates array of players (with user inputs for names).
*Displays player details.
*Sets game difficulty.
*Sets up the board, i.e. hurdles array.
*Displays game board legend as shown in Sample Input and Output.
*Displays game board.
**/

public int GetSIZE()    //using this method to pass to the UseIsland(Player p, Board b) from MagicIsland class
{
	return SIZE;
}

public void SetDifficulty()
{
		Scanner scan= new Scanner(System.in);
    	diffLevel=0;
      do
    	{
    	if(diffLevel!=0&&diffLevel!=1&&diffLevel!=2)
    		System.out.println("Error in Input!");

    	System.out.println("Enter Diffculty Level for the Game (0=easy, 1=50/50 i.e. not too easy, not too hard, 2=HARD)");
    	diffLevel=scan.nextInt();

    	}
    	while(diffLevel!=0&&diffLevel!=1&&diffLevel!=2);



}
/*inputs difficulty level from user with some error checking.
*Assumes user will input an integer*/

public String GetPlayerName(int index)
{
	String playername;
	Scanner scan= new Scanner(System.in);
	System.out.print("\n Enter Player"+(index+1)+" \'s Name: ");
	playername=scan.nextLine();
	System.out.println(playername+" has no Voodoo doll.");
	System.out.println(playername+" does not have a ship.");
	return playername;

}
/*Asks user to input the name of a player*/

public void SetHurdles()
{
  hurdles=new char[SIZE];

  for(int i=0;i<6;i++)
  	hurdles[i]='t';

  for(int i=6;i<12;i++)
  	hurdles[i]='a';

  for(int i=12;i<15;i++)
  	hurdles[i]='m';

  	for(int i=15;i<18;i++)
  	hurdles[i]='j';

  	if(diffLevel==0)
  	{
  		for(int i=18;i<SIZE;i++)
  			hurdles[i]='e';
  	}
   else if(diffLevel==1)
   {
   	for(int i=18;i<24;i++)
   		hurdles[i]='e';

   	for(int i=24;i<SIZE;i++)
   		hurdles[i]='h';
   }
   else
   {
   	for(int i=18;i<SIZE;i++)
  			hurdles[i]='h';
   }
   Random generator=new Random();
   char temp;
   int index;
   for(int i=SIZE-1;i>0;i--)
   {
   	 index=generator.nextInt(i);
   	 temp=hurdles[i];
   	 hurdles[i]=hurdles[index];
   	 hurdles[index]=temp;
   }

}

/*Creates a random gameboard based on requirements
*set in the assignment*/

public void DisplayPlayerDetails()
{
 System.out.println("------------- PLAYER DETAILS -------------\n");
 System.out.println("        -->Player 1<--");
 System.out.println("Name: "+players[0].GetName());
 System.out.println("Health: "+players[0].GetHealth()+" potions");
 System.out.println("Treasure: "+players[0].GetWealth()+" gold coins");
 System.out.println("Weapon: "+players[0].WeaponName(players[0].GetWeapon()));
 System.out.println("Voodoo Doll: "+players[0].GetVoodoo() );
 System.out.println("Ship: "+players[0].GetShip());
 System.out.println("Position: "+(players[0].GetPosition()+1));
 System.out.println("        ------><------\n\n");
 System.out.println("        -->Player 2<--");
  System.out.println("Name: "+players[1].GetName());
 System.out.println("Health: "+players[1].GetHealth()+" potions");
 System.out.println("Treasure: "+players[1].GetWealth()+" gold coins");
 System.out.println("Weapon: "+players[1].WeaponName(players[1].GetWeapon()));
 System.out.println("Voodoo Doll: "+players[1].GetVoodoo() );
 System.out.println("Ship: "+players[1].GetShip());
 System.out.println("Position: "+(players[1].GetPosition()+1));
 System.out.println("        ------><------\n\n");

}

/*Displays details of all players as shown
*in Sample Input and Output*/
public void DisplayBoard()
{
     SetHurdles();
	System.out.println("---------------------------------------------");
	System.out.println("********PIRATES OF 125 GAME BOARD********");
	int number=0;
	for(int i=0;i<6;i++)
	{
		for(int j=0;j<5;j++)
		{
		 System.out.print(number+1+": "+hurdles[number]+" ");
		 number++;
		}
		System.out.println();
	}
		System.out.println("---------------------------------------------");

}
/*Displays the gameboard as shown
*in Sample Input and Output*/

public void DisplayBoard(Player p)             //Displays the gameboad with players "p" on it
{
	System.out.println("---------------------------------------------");
	System.out.println("********PIRATES OF 125 GAME BOARD********");
	int number=0;
	for(int i=0;i<6;i++)
	{
		for(int j=0;j<5;j++)
		{
		 System.out.print(number+1+": "+hurdles[number]);
		 if(p.GetPosition()==number)
		 	System.out.print(",p\t");

		 	System.out.print(" ");
		 number++;
		}
		System.out.println();
	}
		System.out.println("---------------------------------------------");
}

public void Play()                       //start to play the board
{
	Scanner scan=new Scanner(System.in);
	int temp;
	int get=0;
	for(int i=0;i<NUM_PLAYERS;i++)
	{
		DisplayPlayerDetails();
			while(players[i]. GetHealth()>0&&players[i]. GetPosition()>=-1&&players[i]. GetPosition()<30)     // roll the die and displayed on the board
     	{
	      System.out.println("---------------------------------------------");
            players[i].Move();
          System.out.println("---------------------------------------------");

          if(players[i].GetPosition()<30)
         {
         	DisplayBoard(players[i]);

          if(hurdles[players[i]. GetPosition()]=='e')                  // when palyer encounter easy pirate
          {
          	System.out.println("Easy Enemy has no Voodoo doll.");
          	int result=players[i].TradeOrFight("e");                   //ask user whether fight or trade
          	EasyPirate easy=new EasyPirate();
          	if(result==0)                                              // when user select trade
          	{
          		if(players[i].GetWealth()>=easy.GetWealth())
          		{

          		System.out.println(players[i].GetName()+"\'s trade offer has been accepted. The enemy has been paid "+easy.GetWealth()+" gold coins to let "+players[i].GetName()+" pass through their shores unscathed.");
          		System.out.println(players[i].GetName()+" decreases wealth by "+easy.GetWealth()+" gold coins. ");
          		System.out.println("Easy Enemy increases wealth by "+easy.GetWealth()+" gold coins.");
                easy.Trade(players[i]);
          		}
          		else
          		{
          			System.out.println(players[i].GetName()+" does not have enough money to pass the Easy Enemy. The only thing you can do is Fight!");

          		if(players[i].GetVoodoo())
          		{
          			do
          		  {
          			if(get!=0&&get!=1)
          			{
          				System.out.print("Error in Input! ");
          			}
          			System.out.println(players[i].GetName()+", You have a voodoo doll which you can use to curse your opponent through black magic. However, BEWARE as it may backfire! Would you like to curse the enemy with black magic (0=no, 1=yes)? ");
          			get=scan.nextInt();

          		  }while(get!=0&&get!=1);

                 if(get==1)
                 {
                 	boolean v=players[i].DoBlackMagic();
                 	if(v)
                 	{
                       int eh=easy.GetHealth()/2;
                       easy.SetHealth(eh);
                       System.out.println("Easy Enemy have been cursed! Easy Enemy health potions have been halved!");
                        System.out.println("Easy Enemy decreases health by "+eh+" potions.");
                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");

                 	}

                 players[i].ResetVoodoo();
                 }

          		}

          	    easy.Fight(players[i]);


          		}

          	}

          	  if(result==1)                                //when user select the fight
          	{

          		  System.out.println(players[i].GetName()+" has chosen to FIGHT!");

          		if(players[i].GetVoodoo())
          		{
          			do
          		  {
          			if(get!=0&&get!=1)
          			{
          				System.out.print("Error in Input! ");
          			}
          			System.out.println(players[i].GetName()+", You have a voodoo doll which you can use to curse your opponent through black magic. However, BEWARE as it may backfire! Would you like to curse the enemy with black magic (0=no, 1=yes)? ");
          			get=scan.nextInt();

          		  }while(get!=0&&get!=1);

                 if(get==1)
                 {
                 	boolean v=players[i].DoBlackMagic();
                 	if(v)
                 	{
                       int eh=easy.GetHealth()/2;
                       easy.SetHealth(eh);
                       System.out.println("Easy Enemy have been cursed! Easy Enemy health potions have been halved!");
                        System.out.println("Easy Enemy decreases health by "+eh+" potions.");
                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");

                 	}

                 players[i].ResetVoodoo();
                 }

          		}

          	    easy.Fight(players[i]);

          	}


          }
          if(hurdles[players[i]. GetPosition()]=='h')             //when player encounter hard enemy pirate
          {
          		System.out.println("Hard Enemy has no Voodoo doll.");
          			HardPirate hard=new HardPirate();
          			if(hard.GetVoodoo())
          			{
          				System.out.println("Hard Enemy has found a Voodoo doll.");
          			}
          	int result=players[i].TradeOrFight("h");                      //user input fight or trade
          		if(result==0&&hard.GetTradeResponse() )                  //user select trade and hard pirate accept the response
          	{
          		if(players[i].GetWealth()>=hard.GetWealth()*4)
          		{

          		System.out.println(players[i].GetName()+"\'s trade offer has been accepted. The enemy has been paid "+hard.GetWealth()*4+" gold coins to let "+players[i].GetName()+" pass through their shores unscathed.");
          		System.out.println(players[i].GetName()+" decreases wealth by "+hard.GetWealth()*4+" gold coins. ");
          		System.out.println("Hard Enemy increases wealth by "+hard.GetWealth()*4+" gold coins.");
                hard.Trade(players[i]);
          		}
          		else
          		{
          			System.out.println(players[i].GetName()+" does not have enough money to pass the Hard Enemy. The only thing you can do is Fight!");
          				if(players[i].GetVoodoo())
          		{
          			do
          		  {
          			if(get!=0&&get!=1)
          			{
          				System.out.print("Error in Input! ");
          			}
          			System.out.println(players[i].GetName()+", You have a voodoo doll which you can use to curse your opponent through black magic. However, BEWARE as it may backfire! Would you like to curse the enemy with black magic (0=no, 1=yes)? ");
          			get=scan.nextInt();

          		  }while(get!=0&&get!=1);

                 if(get==1)
                 {
                 	boolean v=players[i].DoBlackMagic();
                 	if(v)
                 	{
                       int hh=hard.GetHealth()/2;
                       hard.SetHealth(hh);
                       System.out.println("Hard Enemy have been cursed! Hard Enemy health potions have been halved!");
                       System.out.println("Hard Enemy decreases health by "+hh+" potions.");
                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");
                 	}
                 	players[i].ResetVoodoo();
                 }


               }
               if(hard.GetVoodoo())
               {
               	System.out.println("Hard Enemy happens to have a voodoo doll and they WILL USE IT on you!");
               		boolean v=hard.DoBlackMagic();
               		if(v==false)
                 	{
                       int hh=hard.GetHealth()/2;
                       hard.SetHealth(hh);
                       System.out.println("Hard Enemy have been cursed! Hard Enemy health potions have been halved!");
                       System.out.println("Hard Enemy decreases health by "+hh+" potions.");
                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");
                 	}


               }

          	   hard.Fight(players[i]);


          		}

          	}

          	if((result==0&&hard.GetTradeResponse()==false)||result==1)                   //when pirate refused the trade or user select the fight
          	{
          	  if(result==0&&hard.GetTradeResponse()==false)
          		System.out.println(players[i].GetName()+"\'s trade attempts have been REFUSED! There is only one thing on their mind!!!");


          	 		System.out.println(players[i].GetName()+" has chosen to FIGHT!");

          			if(players[i].GetVoodoo())
          		{
          			do
          		  {
          			if(get!=0&&get!=1)
          			{
          				System.out.print("Error in Input! ");
          			}
          			System.out.println(players[i].GetName()+", You have a voodoo doll which you can use to curse your opponent through black magic. However, BEWARE as it may backfire! Would you like to curse the enemy with black magic (0=no, 1=yes)? ");
          			get=scan.nextInt();

          		  }while(get!=0&&get!=1);

                 if(get==1)
                 {
                 	boolean v=players[i].DoBlackMagic();
                 	if(v)
                 	{
                       int hh=hard.GetHealth()/2;
                       hard.SetHealth(hh);
                       System.out.println("Hard Enemy have been cursed! Hard Enemy health potions have been halved!");
                       System.out.println("Hard Enemy decreases health by "+hh+" potions.");
                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");
                 	}
                 	players[i].ResetVoodoo();
                 }


               }
               if(hard.GetVoodoo())
               {
               	System.out.println("Hard Enemy happens to have a voodoo doll and they WILL USE IT on you!");
               		boolean v=hard.DoBlackMagic();
               		if(v==false)
                 	{
                       int hh=hard.GetHealth()/2;
                       hard.SetHealth(hh);
                       System.out.println("Hard Enemy have been cursed! Hard Enemy health potions have been halved!");
                       System.out.println("Hard Enemy decreases health by "+hh+" potions.");
                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");
                 	}


               }

          	   hard.Fight(players[i]);
          }




	    }
	    if(hurdles[players[i]. GetPosition()]=='t')                 //when player landed the treasureisland
	    {
	    	System.out.println(players[i].GetName()+" has landed on a Treasure Island.");
	      TreasureIsland t=new TreasureIsland();
	    	t.UseIsland(players[i]);
	    	System.out.println(players[i].GetName()+" increases wealth by "+t.Getgain()+" gold coins.");
	    }
	    if(hurdles[players[i]. GetPosition()]=='a')                //when palyer landed the abandoned island
	    {
	    	System.out.println(players[i].GetName()+" has landed on a  Abandoned Island.");
	    AbandonedIsland a=new AbandonedIsland();
	    	a.UseIsland(players[i]);
	    System.out.println(players[i].GetName()+"\'s weapon has been improved to "+players[i].WeaponName(players[i].GetWeapon())+".");
	    }
	    if(hurdles[players[i]. GetPosition()]=='m')              //when player landed the mystery island
	    {
	    	System.out.println(players[i].GetName()+" has landed on a  Mystery Island.");
	    		System.out.println(players[i].GetName()+" has found a Voodoo doll.");
	    	MysteryIsland m=new MysteryIsland();
	       m.UseIsland(players[i]);

	    }
	    if(hurdles[players[i]. GetPosition()]=='j')           //when palyer landed the magic island
	    {
	    	System.out.println(players[i].GetName()+" has landed on a  Magic Island.");
	       MagicIsland j=new MagicIsland();
	    	j.UseIsland(players[i], this);
	    	System.out.println(players[i].GetName()+" has moved to cell#"+(j.Getchamber()+1)+".");
	    }
	  }
	}

   }

   if(players[0].GetHealth()>0&&players[1].GetHealth()<=0)       //decide the final Elixir of life....winner
   {
   	Elixir(players[0]);
   }
   else if(players[0].GetHealth()<=0&&players[1].GetHealth()>0)
   {
   	Elixir(players[1]);
   }
   else if(players[0].GetHealth()<=0&&players[1].GetHealth()<=0)
   {
   	 if(players[0].GetPosition()>players[1].GetPosition())
   	 {
   		Elixir(players[0]);
   	 }
   	else if(players[0].GetPosition()<players[1].GetPosition())
   	 {
   		Elixir(players[1]);
   	 }
   	 else
   	 {
   	 	if(players[0].GetWealth()>players[1].GetWealth())
   	 		Elixir(players[0]);

   	 	if(players[0].GetWealth()<players[1].GetWealth())
   	 		Elixir(players[1]);

   	 }
   }
   else if(players[0].GetHealth()>0&&players[1].GetHealth()>0)
   {
     DisplayPlayerDetails();
   	players[0].Reinforcements();
   	players[1].Reinforcements();
   	DisplayPlayerDetails();
   	for(int i=0;i<2;i++)
   	{

          			if(players[i].GetVoodoo())
          		{
          			do
          		  {
          			if(get!=0&&get!=1)
          			{
          				System.out.print("Error in Input! ");
          			}
          			System.out.println(players[i].GetName()+", You have a voodoo doll which you can use to curse your opponent through black magic. However, BEWARE as it may backfire! Would you like to curse the enemy with black magic (0=no, 1=yes)? ");
          			get=scan.nextInt();

          		  }while(get!=0&&get!=1);

                 if(get==1)
                 {
                 	boolean v=players[i].DoBlackMagic();
                 	System.out.println(players[i].GetName()+" has no Voodoo doll.");
                 	if(v)
                 	{
                 		if(players[i].GetHealth()==players[0].GetHealth())
                 		{
                 			int hh=players[1].GetHealth()/2;
                           players[1].SetHealth(hh);
                            System.out.println("Opponent have been cursed! Opponent health potions have been halved!\nNice :)!");
                       System.out.println(players[1].GetName()+" decreases health by "+hh+" potions.");
                 		}

                 		if(players[i].GetHealth()==players[1].GetHealth())
                 		{
                 			int hh=players[0].GetHealth()/2;
                           players[0].SetHealth(hh);
                            System.out.println("Opponent have been cursed! Opponent health potions have been halved!\nNice :)!");
                       System.out.println(players[0].GetName() +" decreases health by "+hh+" potions.");
                 		}
                       players[i].ResetVoodoo();


                    }
                 	else
                 	{
                      int ph=players[i].GetHealth()/2;
                      players[i].SetHealth(ph);
                      System.out.println("OH NO! YOU have been cursed! YOUR health potions have been halved! :(");
                      System.out.println(players[i].GetName()+" decreases health by "+ph+" potions.");
                 	}
                 	players[i].ResetVoodoo();
                 }


               }
   	}
   	DisplayPlayerDetails();
   	boolean f=	players[0].Fight(players[1]);
   	if(f)
   	{
   		Elixir(players[0]);
   	}
   	else
   	{
   		Elixir(players[1]);
   	}
   }

}
/*Plays the game from start to finish.
*Displays a players details, then moves the player
*through the board.
*When player lands on a cell this method takes appropriate
*actions depending on what is in that cell.
*Once both players have gone through the boardthis
*method decides who should get the Elixir of Life
*perhaps through a final battle*/

public void Elixir(Player p)     //final output for Elixir life
{
	System.out.println("\n\n\nElixir of Life goes to:");
	System.out.println("||||||||~!@#$%^&*(  "+p.GetName()+"  )*&^%$#@!~||||||||\n\n\n");
	System.out.println("_____________________________________________");
	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
	System.out.println("|||||||||||||||||||||END|||||||||||||||||||||");
	System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
}
}
