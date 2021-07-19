import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ameet
 * 
 *  Implement Stack using Queues
 */
class MyStack 
{
	Queue<Integer> q1;
	Queue<Integer> q2;
	
    /** Initialize your data structure here. */
    public MyStack() 
    {
    	q1 = new LinkedList<>();
    	q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x)
    {
    	while(!q1.isEmpty())
    	{
    		q2.add(q1.remove());//0
    	}
    	q1.add(x);//2
    	while(!q2.isEmpty())
    	{
    		q1.add(q2.remove());//q1-> 2,1,0
    	}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
    	if(q1.isEmpty())
    		return -1;
    	else
    		return q1.remove();
    }
    
    /** Get the top element. */
    public int top() 
    {
    	if(q1.isEmpty())
    		return -1;
    	else
    		return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
    	return q1.isEmpty();
    }
    
    public static void main(String[] args) 
	{
    	MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        
        int param_3 = obj.top();
        System.out.println(param_3);
        
        boolean param_4 = obj.empty();
        System.out.println(param_4);
        
        System.out.println(obj.q1);
	}
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
