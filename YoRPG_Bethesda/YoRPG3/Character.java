// Team Bethesda - Ling Cheng, Max Bertfield, William Xiang
// APCS Pd10
// HW #30: Ye Olde Role Playing Game, Expanded
// 2015-11-15

public abstract class Character{
    protected String _name;
    protected int _hitPts;
    protected int _strength;
    protected int _defense;
    protected double _attack;
    
    public abstract String about();
    public abstract void normalize();
    public abstract void specialize();

    public Boolean isAlive(){
	    return _hitPts > 0;
    }
    
    public String getName(){
	    return _name;
    }
    
    public int getDefense(){
	    return _defense;
    }

    public int getHP(){
        if (_hitPts < 0){
            _hitPts=0;
        }
	    return _hitPts;
    }

    public void lowerHP(int damage){
	    _hitPts -= damage;
    }
    
    public int attack(Character opponent){
	    int damage = (int)(_strength * _attack) - opponent.getDefense();
	    if (damage < 0){
	        damage=1;
	    }
	    opponent.lowerHP(damage);
	    return damage;
    }
    


}//end class
