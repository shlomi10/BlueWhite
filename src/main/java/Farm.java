import java.util.ArrayList;
import java.util.List;

public class Farm {

        private int numberOfTractors;
        public enum FarmType {
                Apples,
                Citrus,
                Grapes
        } ;
        private FarmType farmType;

        public static enum Season {
                winter("winter"),
                summer("summer"),
                fall("fall"),
                spring("spring");
                String name;

                private Season (String name) {
                        this.name = name;
                }

                public String getValue(){
                        return name;
                }
        } ;
        private Season season;

        private int x;
        private int y;
        private int width;
        private int height;
        private String farmName;

        // Constructor
        public Farm(int numberOfTractors, FarmType farmType, int x, int y, int width, int height, String farmName, Season season) {
                this.numberOfTractors = numberOfTractors;
                this.farmType = farmType;
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;
                this.farmName = farmName;
                this.season = season;
        }

        // Getters and Setters
        public int getNumberOfTractors() {
                return numberOfTractors;
        }

        public void setNumberOfTractors(int numberOfTractors) {
                this.numberOfTractors = numberOfTractors;
        }

        public FarmType getFarmType() {
                return farmType;
        }

        public void setFarmType(FarmType farmType) {
                this.farmType = farmType;
        }

        public int getX() {
                return x;
        }

        public void setX(int x) {
                this.x = x;
        }

        public int getY() {
                return y;
        }

        public void setY(int y) {
                this.y = y;
        }

        public int getWidth() {
                return width;
        }

        public void setWidth(int width) {
                this.width = width;
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public String getFarmName() {
                return farmName;
        }

        public void setFarmName(String farmName) {
                this.farmName = farmName;
        }

        // Function to get all working tractors at the farm
        public List<Tractor> getWorkingTractors() {
                // Implement this according to your requirements
                // You might have a list of Tractor objects associated with the farm
                // and you can filter out the working tractors based on their status
                List<Tractor> workingTractors = new ArrayList<>();
                // Add logic here to filter and populate the workingTractors list
                return workingTractors;
        }

        // Function to generate unique farm ID based on the name and location on map
        public String generateFarmID() {
                return farmName + "-" + x + "-" + y;
        }

        // Function to return the correct type of Implement depending on the time of the year
        public Implement getImplementBySeason(Season season) {
                switch (season.getValue()) {
                        case "summer":
                                return new Implement(Implement.ImplementType.Sprayer, Implement.Filling.water);
                        case "fall":
                                return new Implement(Implement.ImplementType.Mower);
                        case "winter":
                                return new Implement(Implement.ImplementType.Driller);
                        case "spring":
                                return new Implement(Implement.ImplementType.Sprayer, Implement.Filling.pesticides);
                        default:
                                return null;
                }
        }

        // Function to list all tractors with their statuses, implement, and percentage of done work
        public void listTractorsWithStatus() {
                // Implement this according to your requirements
                // You might have a list of Tractor objects associated with the farm
                // and you can iterate over them to print their details
                // Here's an example of how you can print the details
                List<Tractor> tractors = new ArrayList<>();
                // Add logic here to populate the tractors list
                for (Tractor tractor : tractors) {
                        System.out.println("Tractor Type: " + tractor.getTractorType());
                        System.out.println("Tractor Status: " + tractor.getTractorStatus());
                        System.out.println("Tractor Implement: " + tractor.getImplement());
                        //System.out.println("Percentage of Done Work: " + tractor.getPercentageDone() + "%");
                        System.out.println("----------------------");
                }
        }
}
