import java.util.Scanner;

public class Accountant {
    public static void paySalary(Employee employee) {
        System.out.println("Salary to " + employee.getGivenName() + " " + employee.getSurName() + " was paid.");
    }

    public static void payPremium(Employee employee) {
        String s = "Such role of employee not found...";

        switch (employee.getRole()) {
            case STAFF:
                s = "Premium in the amount of 10% of the salary to " + employee.getGivenName() + " " + employee.getSurName() + " was paid.";
                break;
            case MANAGER:
                s = "Premium in the amount of 20% of the salary to " + employee.getGivenName() + " " + employee.getSurName() + " was paid.";
                break;
            case EXECUTIVE:
                s = "Premium in the amount of 30% of the salary to " + employee.getGivenName() + " " + employee.getSurName() + " was paid.";
                break;
        }

        System.out.println(s);
    }
}
