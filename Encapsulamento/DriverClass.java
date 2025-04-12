package Encapsulamento;

public class DriverClass {
    private String name;
    private String licenseNum;

    public DriverClass(String name, String licenseNum) {
        this.name = name;
        this.licenseNum = licenseNum;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setlicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }
}
