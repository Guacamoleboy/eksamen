public class CommissionEmployee extends Employee {

    // Attributes
    private int baseSalary; // Usually a whole number
    private int salesAmount; // Can't sell half a car
    private double commissionPercentage;

    // ______________________________________________

    public CommissionEmployee(int baseSalary, int salesAmount, double commissionPercentage){
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionPercentage = commissionPercentage;
    }

    // ______________________________________________

    @Override
    public Double calculateSalary() {
        double commissionAsDecimal = commissionPercentage / 100;
        return baseSalary + (salesAmount * commissionAsDecimal);
    }

} // Subclass end
