// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.util.*;

class Queue {

    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();
    int i=0;



    public Queue() {
        

    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
        while (!s1.isEmpty())
        {
            s2.push(s1.pop());
            
        }
        s1.push(x);
 
        
        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
            
        }

    }

    // Removes the element from in front of queue.
    public int dequeue() {
        if(s2.isEmpty()){
            while(!s1.isEmpty())
            s2.push(s1.pop());
        }
        i++;
        return s2.pop();


    }
    
    // Get the front element.
    public int peek() {

    }
    
    // Return whether the queue is empty.
    public boolean empty() {

    }

    // Return the number of elements in queue.
    public boolean size() {

    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                queue.dequeue();
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());
            } 
        }
    }
}
