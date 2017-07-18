/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
{
    /**
     * Get a default greeting
     * 
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
	if (statement.length() == 0)
	    {
		response = "Say something, please.";
	    }
	else if (findKeyword(statement, "no") >= 0)
	    {
		response = "Why so negative?";
	    }
	else if (findKeyword(statement, "mother") >= 0
		 || findKeyword(statement, "father") >= 0
		 || findKeyword(statement, "sister") >= 0
		 || findKeyword(statement, "brother") >= 0)
	    {
		response = "Tell me more about your family.";
	    }
	else if (findKeyword(statement, "cat") >= 0
		 || statement.indexOf("dog") >= 0)
	    {
		response = "Tell me more about your pets.";
	    }
	else if (findKeyword(statement, "Mr. Brown") >= 0
		 || findKeyword(statement, "mr. brown") >= 0
		 || findKeyword(statement, "brown") >= 0
		 || findKeyword(statement, "mykolyk") >= 0)
	    {
		response = "He sounds like an interesting, charming, intelligent, handsome, passionate person. Tell me more.";
	    }
	else if (statement.trim().equals(""))
	    {
		response = "Hello? Are you there? Say something.";
	    }
	else if (findKeyword(statement, "hate") >= 0
		 || findKeyword(statement, "stupid") >= 0
		 || findKeyword(statement, "useless") >= 0)
	    {
		response = "You're mean :(";
	    }
	else if (findKeyword(statement, "help") >= 0
		 || findKeyword(statement, "problem") >= 0
		 || findKeyword(statement, "question") >= 0)
	    {
		response = "I can't help you. Sorry.";
	    }
	else if (findKeyword(statement, "thank you") >= 0)
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
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
			    int startPos)
    {
	String phrase = statement.trim().toLowerCase();
	goal = goal.toLowerCase();

	// The only change to incorporate the startPos is in
	// the line below
	int psn = phrase.indexOf(goal, startPos);

	// Refinement--make sure the goal isn't part of a
	// word
	while (psn >= 0)
	    {
		// Find the string of length 1 before and after
		// the word
		String before = " ", after = " ";
		if (psn > 0)
		    {
			before = phrase.substring(psn - 1, psn);
		    }
		if (psn + goal.length() < phrase.length())
		    {
			after = phrase.substring(
						 psn + goal.length(),
						 psn + goal.length() + 1);
		    }

		// If before and after aren't letters, we've
		// found the word
		if (((before.compareTo("a") < 0) || (before
						     .compareTo("z") > 0)) // before is not a
		    // letter
		    && ((after.compareTo("a") < 0) || (after
						       .compareTo("z") > 0)))
		    {
			return psn;
		    }

		// The last position didn't work, so let's find
		// the next, if there is one.
		psn = phrase.indexOf(goal, psn + 1);

	    }

	return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
	return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * 
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
	final int NUMBER_OF_RESPONSES = 6;
	double r = Math.random();
	int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
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
