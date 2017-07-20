// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

public class Rogue extends Character{
      public Rogue(){
        _name= "Rogue";
    	_hitPts= 100;
    	_strength= 100;
    	_defense= 30;
    	_attack= 0.3;
    }
    
    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Rogue( String name ) {
        this();
        _name = name;
    }
    /*
    public int attack(Character opponent){
        super.attack(Character opponent);
        System.out.println( _name + "summoned a python")
    } */
    //prepare a csteacher for a special attack
    public void specialize(){
        int stealer = (int)(Math.random()*5);
        
        if (stealer == 0){
            _defense += 10;
             System.out.println(_name + " pickpocketed and gained some armor. Defense increased by 10");
        }else if (stealer== 1){
            _attack += 0.2;
             System.out.println(_name + " pickpocketed and gained some weapons.");
        }else if (stealer ==2){
            _hitPts += 10;
             System.out.println(_name + " pickpocketed and gained some potions. HP increased by 10.");
        }else if (stealer ==3){
            _strength+= 50;
             System.out.println(_name + " pickpocketed and gained some steroids. Strength increased by 50.");
        }else if (stealer ==4){
            _hitPts -= 30;
             System.out.println(_name + " got caught trying to steal and lost 30 health");
        }
    }
    
    //revert to normal mode
    public void normalize(){
        _strength = 100;
	      _defense = 30;
	      System.out.println(_name + " threw a cool ninja star");
    }
        public String about(){
      return "Rogue: A sneaky theif. A Rogue has low stats overall, but can gain at will.\nSpecialize: Steals stats from opponents.\n";
}

}