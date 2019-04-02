
import Exception.EmptyException;
import Exception.FullException;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vizug
 */
public class Queue<T> {
    private LinkedList<T> queue = new LinkedList<>();
    private int maxsize=10;

    public Queue(int maxsize) {
        this.maxsize=maxsize;
    }
    
    
    
    public void push(T e) throws FullException{
        if(queue.size()<this.maxsize){
            queue.add(e);
        }else
            throw new FullException();
        
    }
    public T pull() throws EmptyException{
        if (queue.size() == 0) {
            throw new EmptyException();
        } else {
            return queue.poll();
        }
    }
}
