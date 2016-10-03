
import java.awt.image.ImageObserver;
import java.util.Random;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p_unit
 */
public class Main {

    public static void main(String args[]) {

        System.out.println("Hello mentos");

        Random rand = new Random();

        int first = (rand.nextInt());

        System.out.print(first + "\n ");
        if (first < 0) {

            first = first + (2 * (-1 * first));

        } 
        Window start = new Window();
        start.setVisible(true);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.getTheGeneratedId(first);
        start.getConnected();
    }

}
