
import Exception.EmptyException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import ui.ThreadState;

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
    private ThreadState panel;
    
    public Consumer(Queue myQueue, ThreadState panel) {
        this.myQueue = myQueue;
        this.panel = panel;
    }
    
    @Override
    public void run() {
        panel.setToRun();
        while (true) {
            Book b = null;
            HashMap<String, Integer> map = null;
            synchronized (myQueue) {
                try {
                    b = (Book) myQueue.pull();
                    myQueue.notifyAll();
                } catch (EmptyException ex) {
                    System.out.println("Queue emtpy!");
                    try {
                        panel.setToWait();
                        myQueue.wait();
                        panel.setToRun();
                    } catch (InterruptedException ex1) {
                        
                    }
                    continue;
                }
            }
            map = b.countWords();
            File f = new File("output/" + b.getInputfilename() + "_output");
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                for (String str : map.keySet()) {
                    if (str.matches("^[a-zA-Z0-9]+$")) {
                        bw.write(String.format("%s: %d\n", str, map.get(str)));
                    }
                }
            } catch (Exception ex) {
            }
        }
        
    }
    
}
