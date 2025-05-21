public class MonthlyEmployee extends Employee {

    // Attributes
    private double salary; // Usually a whole number but just in case it's not.

    // ______________________________________________

    public MonthlyEmployee(double salary){
        this.salary = salary;
    }

    // ______________________________________________

    @Override
    public Double calculateSalary() {
        return salary;
    }

} // Subclass end
