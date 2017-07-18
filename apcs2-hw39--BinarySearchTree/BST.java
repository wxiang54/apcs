/*****************************************************
 * William Xiang
 * APCS Pd10
 * 2016-05-17
 * HW39 -- Squad Goal(s)

 * class BST - skeleton
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST {

    //instance variables / attributes of a BST:
    TreeNode _root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) {
	_root = null;
    }

    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {
	if (_root == null)
	    _root = new TreeNode( newVal );
	else
	    insertHelper( _root, newVal );
    }

    public void insertHelper( TreeNode node, int newVal ) {
	if ( node.getValue() > newVal ) {
	    if ( node.getLeft() == null ) {
		TreeNode newNode = new TreeNode( newVal );
		node.setLeft(newNode);
	    }
	    else
		insertHelper( node.getLeft(), newVal );
	}
	else {
	    if ( node.getRight() == null ) {
		TreeNode newNode = new TreeNode( newVal );
		node.setRight(newNode);
	    }
	    else
		insertHelper( node.getRight(), newVal );
	}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() {
	preHelper( _root );
    }
    
    public void preHelper( TreeNode node ) {
	if ( node != null ) {
	    System.out.print( node.getValue() );
	    preHelper( node.getLeft() );
	    preHelper( node.getRight() );	
	}
    }

    
    public void inOrderTrav() 
    {
	inOrderHelper( _root );
    }

    public void inOrderHelper( TreeNode node ) {
	if ( node != null ) {
	    inOrderHelper( node.getLeft() );
	    System.out.print( node.getValue() );
	    inOrderHelper( node.getRight() );	
	}
    }

    
    public void postOrderTrav() 
    {
	postHelper( _root );
    }

    public void postHelper( TreeNode node ) {
	if ( node != null ) {
	    postHelper( node.getLeft() );
	    postHelper( node.getRight() );	    
	    System.out.print( node.getValue() );
	}
    }
    
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    /*****************************************************
     * int height( ) 
     * Returns maximum height of tree starting from _root.
     *****************************************************/
    public int height() {
	return heightHelper( _root, 0 );
    }

    public int heightHelper( TreeNode node, int level ) {
	if (node != null) {
	    //return max of 2 child recursions to find deepest leaf
	    return Math.max(
			    heightHelper(node.getLeft(), level+1 ),
			    heightHelper(node.getRight(), level+1 )
			    );		    
	}
	return level; //base case: reached leaf
    }

    
    /*****************************************************
     * int numLeaves( ) 
     * Returns total number of leaves in tree starting from _root.
     *****************************************************/
    public int numLeaves( ) {
	return numLeavesHelper( _root );
    }
    
    public int numLeavesHelper( TreeNode node ) {
	if (node != null) {
	    return 1 + numLeavesHelper( node.getLeft() ) +
		numLeavesHelper( node.getRight() );
	}
	return 0;
    }


    /*****************************************************
     * boolean search ( int ) 
     * Returns true if tree contains target, false otherwise
     *****************************************************/
    public boolean search( int target ) {
	return searchHelper( _root, target );
    }

    public boolean searchHelper( TreeNode node, int target ) {
	if (node != null) {
	    if ( node.getValue() == target )
		return true;
	    return searchHelper( node.getLeft(), target ) ||
		searchHelper( node.getRight(), target);
	}
	return false;
    }
    

    /*****************************************************
     * boolean remove ( int ) 
     * Removes an int from a BST
     *****************************************************/
    public void remove( int target ) {
	if ( ! search(target) )
	    throw new IllegalArgumentException("Target value does not exist in tree!");
	if (_root.getValue() == target) {
	    removeRoot();
	}
	else removeHelper( _root, target );
    }

    public void removeRoot() {
	boolean hasLeft, hasRight;
	hasLeft = hasRight = false;
	
	if ( _root.getLeft() != null ) {
	    hasLeft = true;
	}	
	if ( _root.getRight() != null ) {
	    hasRight = true;
	}

	if (hasLeft && hasRight) {
	    int maxLeft = max( _root.getLeft() );
	    remove( maxLeft );
	    _root.setValue( maxLeft );
	}
	else if (hasLeft) {
	    _root = _root.getLeft();
	}
	else if (hasRight) {
	    _root = _root.getRight();
	}
	else { //no children
	    _root = null;
	}
    }
    
    public void removeLeftChild( TreeNode node ) {
	boolean hasLeft, hasRight;
	hasLeft = hasRight = false;
	
	if ( node.getLeft().getLeft() != null) {
	    hasLeft = true;
	}	
	if ( node.getLeft().getRight() != null) {
	    hasRight = true;
	}
	
	if (hasLeft && hasRight) {
	    int maxLeft = max(node.getLeft());
	    remove( maxLeft );
	    node.setValue( maxLeft );
	}
	else if (hasLeft) {
	    node.setLeft( node.getLeft().getLeft() );
	}
	else if (hasRight) {
	    node.setLeft( node.getLeft().getRight() );
	}
	else { //no children
	    node.setLeft( null );
	}
    }

    public void removeRightChild( TreeNode node ) {
	boolean hasLeft, hasRight;
	hasLeft = hasRight = false;
	
	if ( node.getRight().getLeft() != null) {
	    hasLeft = true;
	}	
	if ( node.getRight().getRight() != null) {
	    hasRight = true;
	}
	
	if (hasLeft && hasRight) {
	    int maxLeft = max(node.getLeft());
	    remove( maxLeft );
	    node.setValue( maxLeft );
	}
	else if (hasLeft) {
	    node.setRight( node.getRight().getLeft() );
	}
	else if (hasRight) {
	    node.setRight( node.getRight().getRight() );
	}
	else { //no children
	    node.setRight( null );
	}
    }
    
    public void removeHelper( TreeNode node, int target ) {
	if ( node.getLeft() != null && node.getLeft().getValue() == target) {
	    removeLeftChild( node );
	    return;
	}
	if ( node.getRight() != null && node.getRight().getValue() == target) {
	    removeRightChild( node );
	    return;
	}
	
        if (target < node.getValue()) {
	    removeHelper( node.getLeft(), target );
	}
	else { //target >= node
	    removeHelper( node.getRight(), target );
	}
    }

    public int max( TreeNode start ) {
	TreeNode tmp = start;
	while (tmp.getRight() != null) { //look for rightmost element
	    tmp = tmp.getRight();
	}
	return tmp.getValue();
    }
    
    //main method for testing
    public static void main( String[] args ) {

	BST arbol = new BST();
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );
	
	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	

	System.out.println( "\nheight: " + arbol.height() );

	System.out.println( "numLeaves: " + arbol.numLeaves() );

	for ( int i = 0; i < 10; i++ ) {
	    System.out.format( "%nsearch(%s): %b", i, arbol.search(i) );
	}

	
	//Creds to anon on Piazza
	
	arbol.remove(1); //leaf test case
	System.out.print("\nAFTER REMOVING LEAF OF VAL 1\nPre: ");
	arbol.preOrderTrav();
	System.out.print("\tIn: ");
	arbol.inOrderTrav();

	arbol.remove(2); //one child test case
	System.out.print("\nAFTER REMOVING NODE OF VAL 2\nPre: ");
	arbol.preOrderTrav();
	System.out.print("\tIn: ");
	arbol.inOrderTrav();

	arbol.remove(4); //root test case
	System.out.print("\nAFTER REMOVING ROOT (OF VAL 4)\nPre: ");
	arbol.preOrderTrav();
	System.out.print("\tIn: ");
	arbol.inOrderTrav();
	
    }
}//end class
