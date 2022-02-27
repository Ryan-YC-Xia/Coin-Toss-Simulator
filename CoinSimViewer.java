// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA1
// Fall 2021

/**
 * class CoinSimViewer takes input from the console the number of tosses to run for a coin toss simulation, 
 * and shows the CoinSimComponent with the input in a frame window.
 */

import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {
   public static void main(String[] args) {
      System.out.print("Enter number of trials: ");
      Scanner scan = new Scanner(System.in);
      int input = scan.nextInt();
      while (input <= 0) {
         System.out.println("ERROR: Number entered must be greater than 0.");
         System.out.print("Enter number of trials: ");
         input = scan.nextInt();
      }
      scan.close();

      JFrame frame = new JFrame();
      frame.setSize(800, 450);
      frame.setTitle("Coin Toss Simulation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CoinSimComponent component = new CoinSimComponent(input);
      frame.add(component);
      frame.setVisible(true);
   }
}