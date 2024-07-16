package Models;
import exceptions.NonEligibleException;

public class Citizen {
    private String name;
    private int id;
    private String country;
    private String sex;
    private String maritalStatus;
    private double annualIncome;
    private String economyStatus;
    private int age;

    // Constructor
    public Citizen(String name, int id, String country, String sex, String maritalStatus, double annualIncome, String economyStatus, int age) throws NonEligibleException {
        this.name = name;
        this.id = id;
        this.country = country;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.annualIncome = annualIncome;
        this.economyStatus = economyStatus;
        this.age = age;

        // Validation
        if (age < 18 && !"India".equalsIgnoreCase(country)) {
            throw new NonEligibleException("Citizen is under 18 and not from India. Non-eligible.");
        }
    }

    // toString method to display the Citizen object
    @Override
    public String toString() {
        return "Citizen [name=" + name +
               ", id=" + id +
               ", country=" + country +
               ", sex=" + sex +
               ", maritalStatus=" + maritalStatus +
               ", annualIncome=" + annualIncome +
               ", economyStatus=" + economyStatus +
               ", age=" + age + "]";
    }
}
