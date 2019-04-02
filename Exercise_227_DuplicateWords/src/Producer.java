
import Exception.FullException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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

    public Producer(Queue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        File[] files = new File("files/").listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String text = "";
                String line;
                while ((line = br.readLine()) != null) {
                    text += line;
                }
                Book b = new Book(file.getName(), text);
                synchronized (myQueue) {
                    try{
                        myQueue.push(b);
                    }catch(FullException ex){
                        myQueue.wait();
                        System.out.println("Queue full!");
                    }
                    
                }

            } catch (Exception ex) {

            }
        }
    }

}
