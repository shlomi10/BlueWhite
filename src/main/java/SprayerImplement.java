public class SprayerImplement {
    private String fillingType;

    // Constructor
    public SprayerImplement(String fillingType) {
        super();
        this.fillingType = fillingType;
    }

    // Overridden function to get the type of filling for a Sprayer implement
    public String getFillingType() {
        return fillingType;
    }
}