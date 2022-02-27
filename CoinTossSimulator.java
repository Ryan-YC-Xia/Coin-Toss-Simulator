// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA1
// Fall 2021

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to
 * access the cumulative results.
 * 
 * NOTE: we have provided the public interface for this class. Do not change the
 * public interface. You can add private instance variables, constants, and
 * private methods to the class. You will also be completing the implementation
 * of the methods given.
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;

public class CoinTossSimulator {

   private int numTwoHead;
   private int numTwoTail;
   private int numHeadTail;
   private Random generator = new Random();

   /**
    * Creates a coin toss simulator with no trials done yet.
    */
   public CoinTossSimulator() {
      numTwoHead = 0;
      numTwoTail = 0;
      numHeadTail = 0;
   }

   /**
    * Runs the simulation for numTrials more trials. Multiple calls to this method
    * without a reset() between them *add* these trials to the current simulation.
    * 
    * @param numTrials number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      for (int i = 0; i < numTrials; i++) {
         int first = generator.nextInt(2); // Simulate first toss: 0 indicates tail, 1 indicates head.
         int second = generator.nextInt(2); // Simulate second toss: 0 indicates tail, 1 indicates head.
         int result = first + second; // The sum of first and second represents the result.
         if (result == 0) {
            numTwoTail++;
         } else if (result == 2) {
            numTwoHead++;
         } else {
            numHeadTail++;
         }
      }
   }

   /**
    * Get number of trials performed since last reset.
    */
   public int getNumTrials() {
      return numTwoHead + numTwoTail + numHeadTail;
   }

   /**
    * Get number of trials that came up two heads since last reset.
    */
   public int getTwoHeads() {
      return numTwoHead;
   }

   /**
    * Get number of trials that came up two tails since last reset.
    */
   public int getTwoTails() {
      return numTwoTail;
   }

   /**
    * Get number of trials that came up one head and one tail since last reset.
    */
   public int getHeadTails() {
      return numHeadTail;
   }

   /**
    * Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      numTwoHead = 0;
      numTwoTail = 0;
      numHeadTail = 0;
   }
}