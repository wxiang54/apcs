    // Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
    // APCS Pd10
    // HW #30: Ye Olde Role Playing Game, Expanded
    // 2015-11-15
    
    public class Mage extends Character{
    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
        public Mage(){
            _name= "Mage";
        	_hitPts= 120;   
        	_strength= 80;  
        	_defense= 50;
        	_attack= 0.4;   
        }   
        
        /*=============================================
          overloaded constructor
          pre:  instance vars are declared
          post: initializes instance vars. _name is set to input String.
          =============================================*/
        public Mage( String name ) {
            this();
            _name = name;
        }
        
    //prepare a Mage for a special attack
    //Heals HP by 50, but defense decrease by 10 and strength decreased by 1/4
    public void specialize(){
        _strength-= (_strength/4);
	    _defense -= 10;
	    _hitPts += 30;
	    System.out.println(_name + " turned their armor into cupcakes by mistake. Defense decrease by 10");
	    System.out.println(_name + " used healing magic! Hp increased by 30!");
	    System.out.println(_name + " didn't have enough magic powers. Strength decreased by 1/4");
	    
    }
    
    //revert to normal mode
    public void normalize(){
    	_strength= 80;  
    	_defense= 50;
    	System.out.println(_name + " casts Magic Missle");
    }
        public String about(){
      return "Mage: A magic user. A Mage has high HP and high defense, but has low strength.\n Specialize: Heals HP by 30, but defense decrease by 10 and strength decreased by 1/4.\n";

    }
    
}    