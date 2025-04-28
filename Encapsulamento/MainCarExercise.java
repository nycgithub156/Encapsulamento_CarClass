package Encapsulamento;

public class MainCarExercise {
    public static void main(String[] args) {
        EngineClass v6Engine = new EngineClass("Gasoline", 300);
        DriverClass johnDoe = new DriverClass("John Doe", "DL12345678");
        
        CarClass myCar = new CarClass("Ford", "Mustang", "ABC1234", v6Engine, johnDoe);
        
        EngineClass carEngine = myCar.getEngine();  
        DriverClass carDriver = myCar.getDriver(); 
        
        System.out.println("Car Engine Type: " + carEngine.getType());
        System.out.println("Driver Name: " + carDriver.getName());
        
        myCar.displayInfo();
    } 
}