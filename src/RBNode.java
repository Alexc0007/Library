/**
 * 
 */

/**
 * @author Alexc007
 *
 */
public class RBNode
{
	public final static int RED = 1;
	public final static int BLACK = 0;
	
	//instance variables
	RBNode left , right , parent;
	public Person student;
	public Book book;
	public int color;
	
	//constructor
	//we can construct a node to hold book object or person object - depends on who we want to sort by
	public RBNode(Person person ,Book book, RBNode left , RBNode right , RBNode parent , int color)
	{
		student = person;
		this.book = book;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.color = color;
	}
}
