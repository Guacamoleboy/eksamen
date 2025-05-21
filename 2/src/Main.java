/*

    Eksamensopgave 2 - Lønberegner
    Lavet af Jonas Meinert Larsen // CPHJL325

    Comments:
    N/A

    Version 1.0

*/

import java.util.ArrayList;

public class Main {

    // Attributes

    // _____________________________________________

    public static void main(String[] args) {

        ArrayList<Employee> em = new ArrayList<>();

        // Monthly instantiate
        em.add(new MonthlyEmployee(20000));
        em.add(new MonthlyEmployee(30000));

        // Hourly instantiate
        em.add(new HourlyEmployee(160, 150));
        em.add(new HourlyEmployee(200, 200));

        // Commission instantiate
        em.add(new CommissionEmployee(20000, 10000, 20));
        em.add(new CommissionEmployee(30000, 30000, 50));

        displayPay(em);

    }

    // _____________________________________________

    public static void displayPay(ArrayList<Employee> em){
        for(Employee e : em){
            System.out.println("Salary: " + e.calculateSalary());
        }
    }

} // Main class end