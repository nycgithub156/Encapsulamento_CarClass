package Encapsulamento;

public class EngineClass {
    private String type;  
    private double power; 

    public EngineClass(String type, double power) {
        this.type = type;
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public double getPower() {
        return power;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
