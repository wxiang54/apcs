/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting 	
     * @return a greeting
     */
    public String getGreeting()
    {
	return "Hello, let's talk.";
    }
	
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
	String response = "";
	if (statement.indexOf("no") >= 0)
	    {
		response = "Why so negative?";
	    }
	else if (statement.indexOf("mother") >= 0
		 || statement.indexOf("father") >= 0
		 || statement.indexOf("sister") >= 0
		 || statement.indexOf("brother") >= 0)
	    {
		response = "Tell me more about your family.";
	    }
	else if (statement.indexOf("cat") >= 0
		 || statement.indexOf("dog") >= 0)
	    {
		response = "Tell me more about your pets.";
	    }
	else if (statement.indexOf("Mr. Brown") >= 0
		 || statement.indexOf("mr. brown") >= 0
		 || statement.indexOf("brown") >= 0
		 || statement.indexOf("mykolyk") >= 0)
	    {
		response = "He sounds like an interesting, charming, intelligent, handsome, and passionate person. Tell me more.";
	    }
	else if (statement.trim().equals(""))
	    {
		response = "Hello? Are you there? Say something.";
	    }
	else if (statement.indexOf("hate") >= 0
		 || statement.indexOf("stupid") >= 0
		 || statement.indexOf("useless") >= 0)
	    {
		response = "You're mean :(";
	    }
	else if (statement.indexOf("help") >= 0
		 || statement.indexOf("problem") >= 0
		 || statement.indexOf("question") >= 0)
	    {
		response = "I can't help you. Sorry.";
	    }
	else if (statement.indexOf("thank you") >= 0)
	    {
		response = "You're welcome!";
	    }
	else
	    {
		response = getRandomResponse();
	    }
	return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
	final int NUMBER_OF_RESPONSES = 6;
	double r = Math.random();
	int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
	String response = "";
		
	if (whichResponse == 0)
	    {
		response = "Interesting, tell me more.";
	    }
	else if (whichResponse == 1)
	    {
		response = "Hmmm.";
	    }
	else if (whichResponse == 2)
	    {
		response = "Do you really think so?";
	    }
	else if (whichResponse == 3)
	    {
		response = "You don't say.";
	    }
	else if (whichResponse == 4)
	    {
		response = "What happened next?";
	    }
	else if (whichResponse == 5)
	    {
		response = "Elaborate.";
	    }

	return response;
    }
}
