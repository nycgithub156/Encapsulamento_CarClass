package Encapsulamento;

public class CarClass {
    private String brand;
    private String model;
    private String licensePlate;
    private EngineClass engine;
    private DriverClass driver;

    public CarClass(String brand, String model, String licensePlate, EngineClass engine, DriverClass driver) {
        this.brand = brand;
        this.model = model; 
        this.licensePlate = licensePlate;
        this.engine = engine;
        this.driver = driver; 
    }

    public CarClass(String brand, String model, String licensePlate, EngineClass engine) {
        this.brand = brand;
        this.model = model; 
        this.licensePlate = licensePlate;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public EngineClass getEngine() {
        return engine;
    }

    public void setEngine(EngineClass engine) {
        this.engine = engine;
    }

    public DriverClass getDriver() {
        return driver;
    }

    public void setDriver(DriverClass driver) {
        this.driver = driver;
    }

    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model);
        System.out.println("License: " + licensePlate);
        System.out.println("Engine: " + engine.getType() + " (" + engine.getPower() + " HP)");
        
        if (driver != null) {
            System.out.println("Driver: " + driver.getName() + " (License: " + driver.getLicenseNum() + ")");
        } else {
            System.out.println("No driver assigned");
        }
    }
}
