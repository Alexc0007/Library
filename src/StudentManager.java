/**
 * 
 */

/**
 * @author Alexc007
 *
 */
public class StudentManager 
{
	public final static int RED = 1;
	public final static int BLACK = 0;
	
	//instance variables
	public RBNode root; //the root of the tree
	public RBNode nullNode = new RBNode(null, null, null, null, null, BLACK); //both Person and Book fields will be Null on this variable
	
	public StudentManager()
	{
		root = nullNode;
	}
	
	//check if tree is empty
	public boolean isEmpty()
	{
		if(root.student == null)
		{
			return true;
		}
		else return false;
	}
	
	//insert to tree method
	public void insert(RBNode newStudent)
	{
		RBNode temp1 = nullNode; // y <- null(T)
		RBNode temp2 = root; //x <- root(T)
		while(temp2 != temp1)
		{
			temp1 = temp2;
			if(newStudent.student.getId() < temp2.student.getId()) //if (key[z] < key[x])
				temp2 = temp2.left; // x<- left[x]
			else 
				temp2 = temp2.right; // x<- right[x]
		}
		newStudent.parent = temp1; // p[z] <- y
		if(temp1 == nullNode)
			root = newStudent; //root[T] <- z
		else
		{
			if(newStudent.student.getId() < temp1.student.getId()) //if(key[z] < key[y])
			{
				temp1.left = newStudent; //left[y] <- z
			}
			else
			{
				temp1.right = newStudent; // right[y] <- z
			}
		}
		newStudent.left = nullNode;
		newStudent.right = nullNode;
		newStudent.color = RED;
		rbInsertFixup(root , newStudent);
	}
	
	//fix-up after insert method
	public void rbInsertFixup(RBNode root , RBNode newStudent)
	{
		
	}
	
}
