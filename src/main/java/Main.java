import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Farm.Season season = null;

        // Step 4: Ask for the name of the farm
        System.out.print("Enter the name of the farm: ");
        String farmName = scanner.next();

        // Step 4: Ask for the season
        System.out.print("Enter the season (winter, fall, summer, spring): ");
        switch (scanner.next().toLowerCase()) {
            case "winter":
                season = season.winter;
                break;
            case "fall":
                season = season.fall;
                break;
            case "spring":
                season = season.spring;
                break;
            case "summer":
                season = season.summer;
                break;
            default:
                System.out.println("Not a valid season");
                ;
        }

        // Step 4a: Ask for the number of dedicated tractors (should be more than 3)
        System.out.print("Enter the number of dedicated tractors (should be more than 3): ");
        int numTractors = 0;
        try {
            numTractors = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid number of tractors: " + e.getMessage());
        }

        if (numTractors <= 3) {
            System.out.println("Number of dedicated tractors should be more than 3.");
            return;
        }

        // Step 4 create a new farm
        Farm farm = new Farm(numTractors, Farm.FarmType.Apples, 1, 2, 10, 10, farmName, season);

        // Step 4b: Assign new tractors to the farm
        List<Tractor> tractors = new ArrayList<>();

        for (int i = 0; i < numTractors; i++) {
            Tractor tractor = new Tractor(Tractor.TractorType.randomTractorType(), farm.getImplementBySeason(season));
            tractors.add(tractor);
        }

        // Step 4d: Make the assigned tractors run
        for (int i = 0; i < 3; i++) {
            Tractor tractor = tractors.get(i);
            tractor.run();
        }

        // Step 4e and 4f: Handle tractors with shortage of fuel and continue running until all tractors are off
        while (!allTractorsOff(tractors)) {
            for (Tractor tractor : tractors) {
                if (tractor.getFuelStatus() <= 10 && tractor.getTractorStatus() == Tractor.TractorStatus.On) {
                    tractor.stop();
                    // Find the next unused tractor and assign the implement from the tractor with fuel shortage
                    Tractor unusedTractor = findUnusedTractor(tractors);
                    if (unusedTractor != null) {
                        unusedTractor.attachImplement(tractor.getImplement());
                        unusedTractor.run();
                    }
                }
            }
        }

        // Step 4g and 4h: Turn off all tractors
        for (Tractor tractor : tractors) {
            if (tractor.getTractorStatus() == Tractor.TractorStatus.On) {
                tractor.stop();
            }
        }

        scanner.close();
    }

    // Function to check if all tractors are off
    private static boolean allTractorsOff(List<Tractor> tractors) {
        for (Tractor tractor : tractors) {
            if (tractor.getTractorStatus() == Tractor.TractorStatus.On) {
                return false;
            }
        }
        return true;
    }

    // Function to find the next unused tractor
    private static Tractor findUnusedTractor(List<Tractor> tractors) {
        for (Tractor tractor : tractors) {
            if (tractor.getTractorStatus() == Tractor.TractorStatus.Off) {
                return tractor;
            }
        }
        return null;
    }
}