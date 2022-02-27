// Name: Yuchen Xia
// USC NetID: xiayuche
// CS 455 PA1
// Fall 2021

/**
 * class CoinTossSimulatorTester is a non-interactive program to test the
 * correctness of class CoinTossSimulator. It prints relevant information and
 * the expcted values to the console. It tests whether the CoinTossSimulator can
 * handle multiple calls for run, and the reset method. It also tests whether
 * it's possible to construct different Simulators at the same time.
 */

public class CoinTossSimulatorTester {
   public static void main(String[] args) {
      CoinTossSimulator sim = new CoinTossSimulator();
      System.out.println("After constructor:");
      printInfo(sim, 0);

      sim.run(1);
      System.out.println("After run(1):");
      printInfo(sim, 1);

      sim.run(10);
      System.out.println("After run(10):");
      printInfo(sim, 11);

      sim.run(100);
      System.out.println("After run(100):");
      printInfo(sim, 111);

      sim.reset();
      System.out.println("After reset:");
      printInfo(sim, 0);

      sim.run(1000);
      System.out.println("After run(1000):");
      printInfo(sim, 1000);

      CoinTossSimulator sim2 = new CoinTossSimulator();
      System.out.println("Constructing another instance:");
      printInfo(sim2, 0);

      sim2.run(10000);
      System.out.println("After run(10000):");
      printInfo(sim2, 10000);

      sim.run(2000);
      System.out.println("Check the first Simulator after another run(2000):");
      printInfo(sim, 3000);
   }

   /**
    * A function to print relevant information of a CoinTossSimulator. Also takes
    * the expected number of trials as an input.
    */
   private static void printInfo(CoinTossSimulator sim, int exp_trial) {
      System.out.println("Number of trials [exp:" + exp_trial + "]: " + sim.getNumTrials());
      System.out.println("Two-head tosses: " + sim.getTwoHeads());
      System.out.println("Two-tail tosses: " + sim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + sim.getHeadTails());
      boolean add_up = sim.getTwoHeads() + sim.getTwoTails() + sim.getHeadTails() == sim.getNumTrials();
      System.out.println("Tosses add up correctly? " + add_up);
      System.out.println("");
   }
}