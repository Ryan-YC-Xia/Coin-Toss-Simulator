// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA1
// Fall 2021

/**
 * CoinSimComponent class takes input of the number of tosses for a coin toss simulation,
 * uses the results from a CoinTossSimulator, and paint out the results using three bars.
 * To be used in the CoinSimViewer program.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CoinSimComponent extends JComponent {

   public final static int BAR_WIDTH = 50;
   public final static int VERTICAL_BUFFER = 50;
   public final static Color COLOR_HEADTAIL = Color.GREEN;
   public final static Color COLOR_TWOTAIL = Color.YELLOW;
   public final static Color COLOR_TWOHEAD = Color.BLUE;

   private int numTwoHead;
   private int numTwoTail;
   private int numHeadTail;
   private int numTrials;

   /**
    * Construct a coin toss simulator component. The CoinTossSimulator is run for a
    * desired number of times to fill the instance variables.
    * 
    * @param input the user input of desired number of tosses.
    */
   public CoinSimComponent(int input) {
      CoinTossSimulator toss = new CoinTossSimulator();
      toss.run(input);
      numTwoHead = toss.getTwoHeads();
      numTwoTail = toss.getTwoTails();
      numHeadTail = toss.getHeadTails();
      numTrials = toss.getNumTrials();
   }

   /**
    * Paint the CoinSimComponent.
    *
    * @param g the graphics context
    */
   public void paintComponent(Graphics g) {
      int heightOfFrame = getHeight();
      int widthOfFrame = getWidth();

      int bottom = heightOfFrame - VERTICAL_BUFFER;
      int distance = widthOfFrame / 4;
      double scale = (double) (heightOfFrame - VERTICAL_BUFFER * 2) / numTrials;
      int leftHeadTail = (widthOfFrame - BAR_WIDTH) / 2; // The abscissa of the Head-Tail bar
      int leftTwoHead = leftHeadTail - distance;
      int leftTwoTail = leftHeadTail + distance;
      int percentageHeadTail = (int) Math.round(100 * (double) numHeadTail / numTrials);
      int percentageTwoHead = (int) Math.round(100 * (double) numTwoHead / numTrials);
      int percentageTwoTail = (int) Math.round(100 * (double) numTwoTail / numTrials);
      String labelHeadTail = "A Head and a Tail: " + numHeadTail + " (" + percentageHeadTail + "%)";
      String labelTwoHead = "Two Heads: " + numTwoHead + " (" + percentageTwoHead + "%)";
      String labelTwoTail = "Two Tails: " + numTwoTail + " (" + percentageTwoTail + "%)";

      Graphics2D g2 = (Graphics2D) g;
      Bar barHeadTail = new Bar(bottom, leftHeadTail, BAR_WIDTH, numHeadTail, scale, COLOR_HEADTAIL, labelHeadTail);
      Bar barTwoHead = new Bar(bottom, leftTwoHead, BAR_WIDTH, numTwoHead, scale, COLOR_TWOHEAD, labelTwoHead);
      Bar barTwoTail = new Bar(bottom, leftTwoTail, BAR_WIDTH, numTwoTail, scale, COLOR_TWOTAIL, labelTwoTail);
      barHeadTail.draw(g2);
      barTwoHead.draw(g2);
      barTwoTail.draw(g2);
   }
}