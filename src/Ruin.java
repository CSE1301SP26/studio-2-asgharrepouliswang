import java.util.Scanner;

public class Ruin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Start Amount: ");
        Double startAmount = in.nextDouble();
        Double winChance = in.nextDouble();
        Double winLimit = in.nextDouble();
        Integer totalSimulations = in.nextInt();
        System.out.println("The win chance is " + winChance*100 + "%, the winLimit is $" + Math.round(winLimit) + ", and the starting amount is $" + Math.round(startAmount));

        double Ruin = 0.0;

        // Counts
        Double simulationNum = 0.0;
        double losses = 0.0;
        double currentAmount = startAmount;
    
        // Simulate
        while (currentAmount < winLimit && currentAmount != 0.0 && simulationNum < totalSimulations) {
            simulationNum = simulationNum + 1;
            if (Math.random() < winChance){
                currentAmount = currentAmount + 1;
                System.out.println("Simulation #" + simulationNum + ": You won! Your money remaining is $" + Math.round(currentAmount));
            }else {
                currentAmount = currentAmount - 1;
                System.out.println("Simulation #" + simulationNum + ": You lost! Your money remaining is $" + Math.round(currentAmount));
                losses = losses + 1;
            }

           
                
        }

        // Ruin
        if (winChance==0.5){
            Ruin = 1.0 - (startAmount/winLimit);
        }else {
            double Alpha = (1.0 - winChance)/winChance;
            Ruin = (Math.pow(Alpha, startAmount) - Math.pow(Alpha, winLimit))/(1.0-Math.pow(Alpha, winLimit));
            
        }

        //Simulated Ruin
        double simulatedRuin = losses/simulationNum;

        System.out.println("Expected ruin is " + Ruin + " and simulated ruin is " + simulatedRuin);


    }
}
