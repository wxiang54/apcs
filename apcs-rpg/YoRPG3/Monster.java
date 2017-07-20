// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

public class Monster extends Character{
    
    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Monster() {
		_hitPts = 80;
		_strength = 40 + (int)( Math.random() * 25 ); // [40,65)
		_defense = 20;
		_attack = 1;
    }
    
    public Monster(String newName){
    	_name= newName;
    	_hitPts= 80;
    	_strength=(int)(Math.random()*25)+40;
    	_defense= 20;
    	_attack = 1;
    }
    //=================================================================
    public String toString(){
    	String s= "Name: "+_name;
    	s+= "\nStrength: "+_strength;
    	s+= "\nDefense: "+_defense;
    	s+= "\nAttack Rating: "+_attack ;
    	return s;
    }
    public void specialize(){}
    public void normalize(){}
    public String about(){ return "is evil";}
    
}//end Monster
