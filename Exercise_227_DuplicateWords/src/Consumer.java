
import Exception.EmptyException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vizug
 */
public class Consumer extends Thread {

    private Queue myQueue;

    public Consumer(Queue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        Book b = null;
        synchronized (myQueue) {
            try {
                b = (Book) myQueue.pull();
            } catch (EmptyException ex) {
                System.out.println("Queue emtpy!");
                try {
                    myQueue.wait();
                } catch (InterruptedException ex1) {

                }
            }
        }
        HashMap map = b.countWords();
        
        System.out.println(map.toString());
    }

}
