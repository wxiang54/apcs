// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

/*=============================================
  class Warrior -- protagonist of Ye Olde RPG
  =============================================*/

public class Warrior extends Character{

    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Warrior(){
      _name= "Warrior";
    	_hitPts= 200;
    	_strength= 100;
    	_defense= 40;
    	_attack= 0.4;
    }
    
    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Warrior( String name ) {
        this();
        _name = name;
    }
    

    //prepare a Warrior for a special attack
    public void specialize(){
        int addition= (int)((Math.random()*45)+ 15);
        _strength += addition;
	      _defense -= 15;
	      System.out.println(_name + " threw down his shield to dual wield swords!");
	      System.out.println(_name + " lost 15 defense and gained "+addition+" strength!");   
    }
    //revert to normal mode
    public void normalize(){
      System.out.println(_name + " attacked with a sword!");
        _strength = 100;
	      _defense = 40;
    }
    
    public String about() {
        String info= "Warrior: A sword user. A Warrior is an overall brute with high stats and a tough build.\n";
        info+= "Specialize: Dual weilding adds a ton to their attack stats\n";
        return info;
    }
}//end Warrior
