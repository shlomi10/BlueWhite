import java.util.List;
import java.util.Random;

public class Tractor {

    private static int tractorCount = 0; // Used to generate unique tractor IDs
    private int tractorID;
    private TractorType tractorType;
    public enum TractorType {
        JohnDeere,
        NewHolland;

        private static final List<TractorType> values = List.of(values());
        private static final int size = values.size();
        private static final Random random = new Random();

        public static TractorType randomTractorType()  {
            return values.get(random.nextInt(size));
        }
    };
    private int fuelStatus;

    public Implement implement;
    private TractorStatus tractorStatus;
    public enum TractorStatus {
        Working,
        Stopped,
        On,
        Off
    };

    // Constructor
    public Tractor(TractorType tractorType, Implement implement) {
        this.tractorID = ++tractorCount;
        this.tractorType = tractorType;
        this.fuelStatus = 100;
        this.tractorStatus = TractorStatus.Off;
        this.implement = implement;
    }

    // Getters
    public int getTractorID() {
        return tractorID;
    }

    public TractorType getTractorType() {
        return tractorType;
    }

    public int getFuelStatus() {
        return fuelStatus;
    }

    public Implement getImplement() {
        return implement;
    }

    public TractorStatus getTractorStatus() {
        return tractorStatus;
    }

    // Function to start the tractor and spend fuel
    public void run() {
        tractorStatus = TractorStatus.On;
        while (fuelStatus > 10) {
            System.out.println("Tractor ID: " + tractorID + " | Fuel Status: " + fuelStatus + "%");
            try {
                Thread.sleep(1000); // Sleep for 1 second
                fuelStatus--;

                if (fuelStatus <= 10) {
                    System.out.println("WARNING: Low fuel! Tractor ID: " + tractorID + " will stop soon.");
                    stop();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Function to stop the tractor
    public void stop() {
        tractorStatus = TractorStatus.Off;
    }

    // Function to attach an implement to the tractor
    public void attachImplement(Implement implement) {
        this.implement = implement;
    }

    // Function to change the current implement with another one
    public void changeImplement(Implement newImplement) {
        this.implement = newImplement;
    }
}
