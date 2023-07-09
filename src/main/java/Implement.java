public class Implement {
    private static int implementCount = 0; // Used to generate unique implement IDs
    private int implementID;
    private ImplementType implementType;
    public enum ImplementType {
        Mower,
        Sprayer,
        Driller,
        None
    };
    private Filling filling;
    public enum Filling {
        water,
        pesticides,
        none
    };

    // Constructor
    public Implement(ImplementType implementType, Filling... filling) {
        if (filling.length == 0){
            this.filling = Filling.none;
        } else {
            this.filling = filling[0];
        }
        this.implementID = ++implementCount;
        this.implementType = implementType;
    }

    // Getter for Implement ID
    public int getImplementID() {
        return implementID;
    }

    // Function to get the type of filling for a Sprayer implement
    public Filling getFillingType(ImplementType implementType) {
        if (implementType == ImplementType.Sprayer){
            return filling;
        }
        return Filling.none; // Default value for non-Sprayer implements
    }
}