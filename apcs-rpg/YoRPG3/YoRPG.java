// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name, eh?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;
    private int charClass;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty and instance var for charClass
      and instantiates a Character according to charClass
      =============================================*/
    public void newGame() {

	String s;
	String name = "";
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	
	//lets the player choose his class

	String info= "Information about the classes: \n\n";
		info+= "Warrior: A sword user. A Warrior is an overall brute with high stats and a tough build.\n";
        info+= "Specialize: Dual weilding adds a ton to their attack stats\n\n";
        info+= "Hunter: A long range figher. A Hunter has extremely good accuracy and has high attack.\n";
        info+= "Specialize: Decrease strength by 1/3 but has a chance of attacking up to 3 times.\n\n";
        info+= "Mage: A magic user. A Mage has high HP and high defense, but has low strength.\n";
        info+= "Specialize: Heals HP by 30, but defense decrease by 10 and strength decreased by 1/4.\n\n";
        info+= "Rogue: A sneaky theif. A Rogue has low stats overall, but can gain at will.\n";
        info+= "Specialize: Steals stats from opponents.\n\n";
        info+= "CSTeacher: A godly figure. A CSTeacher has near endless HP with deadly attacks.\n";
        info+= "Specialize: Heals with a hot cup of Java, but loses a little strength doing so.\n";
        System.out.print(info);
        
	s = "What class dost thou chooseth? (State your class): \n";
	s += "\nClass Info:\n";
	s += "\t1: Warrior\n";
	s += "\t2: Hunter\n";
	s += "\t3: Mage\n";
	s += "\t4: Rogue\n";
	s += "\t5: CSTeacher\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    charClass = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	
	
	//lets the player choose his name
	s = "Intrepid hero, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }


	//instantiate the player's character
	Character[] classList = {
		new Warrior(name), 
		new Hunter(name),
		new Mage(name),
		new Rogue(name),
		new CSTeacher(name)
	};
	
	if (charClass - 1 < classList.length) {
		pat = classList[charClass - 1];
	} else {
		pat = classList[0];
	}
    
    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "Nothing to see here. Move along!" );

	else {
	    System.out.println( "Lo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "Do you feel lucky?(Type 3 for help)" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 ){
		    pat.specialize();
		}else if (i==1){
		    pat.normalize();
		}else if (i== 3){
			System.out.println(pat.about());
		}
		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );
		
		
		System.out.println("\n"+pat.getName()+" attacks");
		System.out.println( pat.getName() + " dealt " + d1 +
				    " points of damage.");
		System.out.println("\nMonster attacks");
		
		System.out.println( "Ye Olde Monster hit back for " + d2 +
				    " points of damage\n");
				    
		//prints out the HP if the monster and Hero
		System.out.println( pat.getName() + " has " + pat.getHP() + " HP left.");
		System.out.println( "The monster has " + smaug.getHP() + " HP left.\n");		    
				    
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
    }//end main

}//end class YoRPG