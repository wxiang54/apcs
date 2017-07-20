// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

public class Hunter extends Character{
    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Hunter(){
        _name= "Hunter";
    	_hitPts= 90;   
    	_strength= 140;  
    	_defense= 30;
    	_attack= 0.4;   
    }   
    
    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Hunter( String name ) {
        this();
        _name = name;
    }
    
    //prepare a Hunter for a special attack
    public void specialize(){
        /*Hunter: Has high def since they fight from long range in safety
        Special ability: When use specialize,
        decrease strength by 1/3 but has a chance of attacking up to 3 times
        */
        _strength -= _strength/3;
        int chance = (int)(Math.random()*4);
        System.out.println(_name +"'s trained wolf attacked him by mistake and "+_name+" loses 1/3 strength");
	    if (chance == 2) {
	        _strength *= 2;
	        System.out.println(_name + " shot two arrows for the price of one!");
	    } else if (chance == 3) {
	        _strength *= 3;
	        System.out.println(_name +" shot 3 Arrows! I didn't even know that was possible!");
	    }
	    else{
	     System.out.println(_name + " shot a flaming arrow");   
	    }
	    
    }   
    
    //revert to normal mode
    public void normalize(){
    	_strength= 140;  
    	_defense= 30;
    	System.out.println(_name + " attacked with their trained wolf");
    }
        public String about(){
      return "Hunter: A long range figher. A Hunter has extremely good accuracy and has high attack.\n Specialize: Decrease strength by 1/3 but has a chance of attacking up to 3 times.\n";
    }

}