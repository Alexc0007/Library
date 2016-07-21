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
		RBNode temp; // this is "y"
		while(newStudent.parent.color == RED)
		{
			if(newStudent.parent == newStudent.parent.parent.left) //if(p[z] = left[p[p[z]]] - parent is a left son
			{
				temp = newStudent.parent.parent.right; //y <- left[p[p[z]]]
				if(temp.color == RED)
				{
					newStudent.parent.color = BLACK;        //case1
					temp.color = BLACK;                     //case1
					newStudent.parent.parent.color = RED;   //case1
					newStudent = newStudent.parent.parent;  //case1
				}
				else
				{
					if(newStudent == newStudent.parent.right) //newStudent is right son
					{
						newStudent = newStudent.parent;    //case2
						leftRotate(root , newStudent);     //case2
					}
					newStudent.parent.color = BLACK;       //case3
					newStudent.parent.parent.color = RED;  //case3
					rightRotate(root , newStudent.parent.parent);  //case3
				}
			}
			else
			{
				temp = newStudent.parent.parent.left;
				if(temp.color == RED)
				{
					newStudent.parent = BLACK;              //case4
					temp.color = BLACK;                     //case4
					newStudent.parent.parent.color = RED;   //case4
					newStudent = newStudent.parent.parent;  //case4
				}
				else
				{
					if(newStudent == newStudent.parent.left) //newStudent is left son
					{
						newStudent = newStudent.parent;     //case5
						rightRotate(root , newStudent);     //case5
					}
					newStudent.parent.color = BLACK;
					newStudent.parent.parent.color = RED;
					leftRotate(root , newStudent.parent.parent);
				}
				
			}
		}
		root.color = BLACK;
	}
	
	
	//rb-delete method
	public RBNode delete(RBNode root, RBNode studentRecord)
	{
		RBNode tempY;
		RBNode tempX;
		if(studentRecord.left == nullNode || studentRecord.right == nullNode) //means there is 1 son to the node we want to delete
		{
			tempY = studentRecord;
		}
		else 
			tempY = treeSuccessor(node);
		
		if(tempY.left != nullNode)
		{
			tempX = tempY.left;
		}
		else
		{
			tempX = tempY.right;
		}
		tempX.parent = tempY.parent;
		if(tempY.parent == nullNode)
		{
			root = tempX;
		}
		else
		{
			if(tempY == tempY.parent.left)
			{
				tempY.parent.left = tempX;
			}
			else
			{
				tempY.parent.right = tempX;
			}
		}
		if(tempY.student.getId() != studentRecord.student.getId())
		{
			studentRecord.student.setID(tempY.student.getId());
		}
		if(tempY.color == BLACK)
		{
			deleteFixup(root , tempX);
		}
		return tempY;
	}
	//leftRotate method
	public void leftRotate(RBNode root , RBNode newStudent)
	{
		
	}
}
