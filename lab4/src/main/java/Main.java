import java.util.*;
import java.util.function.*;

public class main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Employee> employeeList = Employee.createShortList();
        Employee employee = new Employee();

        SomeGoodMethods4.lab4();

        System.out.println("Which one do you want?");
        System.out.println("[1] Payment of premiums to women employees.");
        System.out.println("[2] Payment of salaries to employees of a specific department.");
        System.out.println("[3] Payment of premiums to employees over 30 working in a specific department.");
        System.out.println("[4] Payment of salaries to managers.");
        System.out.println("[5] Payment of premiums to staff.");

        switch (in.nextInt()) {
            case (1):
                System.out.println("Pay premium to female employees");
                //for (int i = 0; i < employeeList.size(); i++) {
                //employee = (Employee) employeeList.get(i);
                BiPredicate<Employee, Gender> female = (t, s) -> t.getGender().equals(s);
                for (Employee e : employeeList) {
                   // Employee i = new Employee();
                    if (female.test(e,Gender.FEMALE)) {
                        Accountant.payPremium(e);
                    }
                }
                System.out.println(System.lineSeparator());

            case (2):
                System.out.println("Pay salary to employees of current dep");
                System.out.println("What department?");
                int curDept1 = in.nextInt();

                for (Employee e : employeeList) {
                    if (e.getDept() == curDept1)
                        Accountant.paySalary(e);
                }
                System.out.println(System.lineSeparator());

            case (3):
                System.out.println("Pay premium employees up to 30, working in current department");
                System.out.println("What department?");
                int curDept2 = in.nextInt();

                Consumer<Employee> premium_to_dept = t ->
                {
                    if (t.getDept() == curDept2 && t.getAge() > 30) {
                        Accountant.payPremium(t);
                    }
                };
                for (Employee e : employeeList) {
                    premium_to_dept.accept(e);
                }


                /*for (int i = 0; i < employeeList.size(); i++) {
                    employee = (Employee) employeeList.get(i);
                    if (employee.getAge() > 30 && employee.getDept() == curDept2)
                        Accountant.payPremium(employee);
                }*/
                System.out.println(System.lineSeparator());

            case (4):
                System.out.println("Pay salaries to manager");
                for (int i = 0; i < employeeList.size(); i++) {
                    employee = employeeList.get(i);
                    if (employee.getRole().equals(Role.MANAGER))
                        Accountant.paySalary(employee);
                }
                System.out.println(System.lineSeparator());

            case (5):
                System.out.println("Pay premium to staff");
                for (int i = 0; i < employeeList.size(); i++) {
                    employee = employeeList.get(i);
                    if (employee.getRole().equals(Role.STAFF))
                        Accountant.payPremium(employee);
                }
        }

    }
}
