public class Car {
    String color;
	String type;
    int serialNumber;
    /*
        "static" = this var is tied to the class itself, not the instances (objects)
        This "static" vars are instantiated when class is first loaded into the JVM by the class loader!
    */
    static int carCount;

    /* The code in this block will only be executed once: when class is loaded */
    static {
        resetCarCount();
    }

    /* static methods don't have access to static vars or methods
        static methods are used to:
        - for accessing class variable data
        - provide functionality without having to instatiate an object
        */
    static void resetCarCount() {
            carCount = 0;
    }

    public static void setCarCount (int count) {
        carCount = count;
    }

    protected void assignASerialNumber() {
        carCount++;
        serialNumber = carCount;
    }

    public Car() {
        assignASerialNumber();
    }

    public Car (String color, String type) {
        this();
        // assignASerialNumber();
        this.color = color;
        this.type = type;

    }

	void start() {
        System.out.println ("Get Started!");
	}

    void printDescription() {
        System.out.println ("This is a " + this.color + " " + this.type + ". S / N: " + this.serialNumber);
    }

    public String getDescription() {
        String description = "This is a " + color + " " + type;
        return description;
    }

    void customize(String color, String type) {
        this.color = color;
        this.type = type + " " + this.type;
    }


    public static void main (String[] args) {
        Car.resetCarCount();

        Car fordKaPlus = new Car ("Marine Blue", "Ford K+");
        Car renaultClio = new Car ("Red","Renault Clio" );
        Car fordFocus = new Car ("Metal grey", "Ford Focus");

        fordKaPlus.printDescription();
        fordKaPlus.start();

        renaultClio.printDescription();
        fordFocus.printDescription();
        fordFocus.customize ("blue", "convertible");
        fordFocus.printDescription();
    }
}
