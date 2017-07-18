// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

public class CSTeacher extends Character{
    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public CSTeacher(){
        _name= "CSTeacher";
    	_hitPts= 100;
    	_strength= 300;
    	_defense= 60;
    	_attack= 0.7;
    }
    
    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public CSTeacher( String name ) {
        this();
        if (name.toLowerCase().equals("brown")){
            _hitPts += 1337;
            System.out.println("You just gained 1337 HP for being an awesome CS teacher!");
        }
        _name = name;
    }
    /*
    public int attack(Character opponent){
        super.attack(Character opponent);
        System.out.println( _name + "summoned a python")
    } */
    //prepare a csteacher for a special attack
    public void specialize(){
        int randNum= (int)((Math.random()*45)+ 15);
        _hitPts += randNum;
	    _strength -= 15;
	    System.out.println(_name + " had a hot cup of java. Strength decrease by 15. HP increased by "+randNum);
    }
    
    //revert to normal mode
    public void normalize(){
        _strength= 300;
	      _defense = 60;
	      System.out.println(_name + " summoned a python");
    }
        public String about(){
      return "CSTeacher: A godly figure. A CSTeacher has near endless HP with deadly attacks.\n Specialize: Heals with a hot cup of Java, but loses a little strength doing so.\n";

    }
}//end Warrior