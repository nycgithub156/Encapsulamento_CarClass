import java.util.Scanner;

class carClass {
    String licensePlate;
    String model;
    int year;
    double speed;
    double fuelAmount;
    double tankCapacity;

    public carClass(String licensePlate, String model, int year, double tankCapacity) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
        this.fuelAmount = tankCapacity;  
        this.tankCapacity = tankCapacity;
    }

    public void accelerate(double value) {
        if (fuelAmount <= 0) {
            System.out.println("Not enough fuel to accelerate.");
            return;
        }

        double speedIncrease = 0.1 * value;
        speed += speedIncrease;
        if (speed > 150) {
            speed = 150; 
        }

        fuelAmount -= 0.01 * value; 

        if (fuelAmount < 0) {
            fuelAmount = 0; 
        }

        System.out.println("The car accelerated. Current speed: " + speed + " km/h.");
    }

    public void brake(double value) {
        if (speed > 0) {
            double speedReduction = 0.1 * value;
            speed -= speedReduction;

            if (speed < 0) {
                speed = 0;
            }

            System.out.println("The car braked. Current speed: " + speed + " km/h.");
        } else {
            System.out.println("Speed is already 0. Cannot brake.");
        }
    }

    public void refuel(double value) {
        if (fuelAmount + value > tankCapacity) {
            fuelAmount = tankCapacity; 
        } else {
            fuelAmount += value;
        }

        System.out.println("The car was refueled. Fuel amount: " + fuelAmount + " liters.");
    }

    public void printCarInfo() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel in tank: " + fuelAmount + " liters");
        System.out.println("Maximum tank capacity: " + tankCapacity + " liters");
    }
}

public class carExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the car's license plate:");
        String licensePlate = scanner.nextLine();
        
        System.out.println("Enter the car's model:");
        String model = scanner.nextLine();
        
        System.out.println("Enter the car's year:");
        int year = scanner.nextInt();
        
        System.out.println("Enter the car's maximum tank capacity (in liters):");
        double tankCapacity = scanner.nextDouble();

        carClass car = new carClass(licensePlate, model, year, tankCapacity);

        int option;
        
        do {
            System.out.println("\nChoose an action for the car:");
            System.out.println("1 - Accelerate");
            System.out.println("2 - Brake");
            System.out.println("3 - Refuel");
            System.out.println("4 - Show car data");
            System.out.println("5 - Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("How much do you want to accelerate?");
                    double accelerateValue = scanner.nextDouble();
                    car.accelerate(accelerateValue);
                    break;
                case 2:
                    System.out.println("How much do you want to brake?");
                    double brakeValue = scanner.nextDouble();
                    car.brake(brakeValue);
                    break;
                case 3:
                    System.out.println("How much fuel do you want to add?");
                    double refuelValue = scanner.nextDouble();
                    car.refuel(refuelValue);
                    break;
                case 4:
                    car.printCarInfo();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);

        scanner.close();
    }
}
