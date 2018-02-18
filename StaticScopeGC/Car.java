public class Car {
    String color;
	String type;
    int serialNumber;
    /*
        "static" = this var is tied to the class itself, not the instances (objects)
        This "static" vars are instantiated when class is first loaded into the JVM by the class loader!
    */
    static int carCount;

    {
        color = "Red";
        type = "Renault";
    }

    /* static methods don't have access to static vars or methods */
    static void resetCarCount() {
            carCount = 0;
    }

    protected void assignASerialNumber() {
        carCount++;
        serialNumber = carCount;
    }

    public Car() {
        assignASerialNumber();
    }

    public Car (String color, String type) {
        this.color = color;
        this.type = type;
        assignASerialNumber();
    }

	void start() {
        System.out.println ("Get Started!");
	}

    void printDescription() {
        System.out.println ("This is a " + color + " " + type + ". S / N: " + serialNumber);
    }

    public String getDescription() {
        String description = "This is a " + color + " " + type;
        return description;
    }
    public static void main (String[] args) {
        Car.resetCarCount();

        Car fordKaPlus = new Car ("Marine Blue", "Ford K+");
        Car renaultClio = new Car ("Renault Clio", "Red");
        Car fordFocus = new Car ("Ford Focus", "Metal grey");

        fordKaPlus.printDescription();
        fordKaPlus.start();

        renaultClio.printDescription();
        fordFocus.printDescription();
    }
}
