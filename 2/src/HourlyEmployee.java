public class HourlyEmployee extends Employee {

    // Attributes
    private double numberOfHours; // Can have half hours
    private double payPrHour; // Can have irregular payment per hour

    // ______________________________________________

    public HourlyEmployee(double numberOfHours, double payPrHour){
        this.numberOfHours = numberOfHours;
        this.payPrHour = payPrHour;
    }

    // ______________________________________________

    @Override
    public Double calculateSalary() {
        return numberOfHours * payPrHour;
    }

} // Subclass end
