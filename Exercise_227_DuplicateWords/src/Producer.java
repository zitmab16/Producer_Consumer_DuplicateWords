
import Exception.FullException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class Producer extends Thread {

    private Queue myQueue;
    private ThreadState panel;

    public Producer(Queue myQueue, ThreadState panel) {
        this.myQueue = myQueue;
        this.panel = panel;
    }

    @Override
    public void run() {
        panel.setToRun();
        File[] files = new File("files/").listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String text = "";
                String line = "";
                while ((line = br.readLine()) != null) {
                    text += line;
                }
                Book b = new Book(file.getName(), text);
                synchronized (myQueue) {
                    try {
                        myQueue.push(b);
                        myQueue.notifyAll();
                    } catch (FullException ex) {
                        panel.setToWait();
                        myQueue.wait();
                        panel.setToRun();
                        System.out.println("Queue full!");
                    }
                }

            } catch (Exception ex) {
            }
        }
    }

}
