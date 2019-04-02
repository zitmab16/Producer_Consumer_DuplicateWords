
import java.awt.GridLayout;
import javax.swing.JFrame;
import ui.ThreadState;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(3);

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 2));

        ThreadState panProd1 = new ThreadState("Producer 1");
        frame.add(panProd1);
        ThreadState panProd2 = new ThreadState("Producer 2");
        frame.add(panProd2);
        ThreadState panCons1 = new ThreadState("Consumer 1");
        frame.add(panCons1);
        ThreadState panCons2 = new ThreadState("Consumer 2");
        frame.add(panCons2);

        frame.setSize(400, 400);
        frame.setVisible(true);

        Producer p1 = new Producer(queue, panProd1);
        Producer p2 = new Producer(queue, panProd2);
        Consumer c1 = new Consumer(queue, panCons1);
        Consumer c2 = new Consumer(queue, panCons2);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
