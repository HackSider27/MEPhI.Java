import java.time.LocalDate;
import static java.lang.System.*;

public class Person {
    public String name;
    public String surName;
    public LocalDate birthDate;
    public LocalDate deathDate;

    Person(String name, String surName, int year, int month, int dayOfMonth) {
        this.name = name;
        this.surName = surName;
        this.birthDate = LocalDate.of(year, month, dayOfMonth);
    }

    Person(String name,
           String surName,
           int bYear,
           int bMonth,
           int bDayOfMonth,
           int dYear,
           int dMonth,
           int dDayOfMonth) {
        this.name = name;
        this.surName = surName;
        this.birthDate = LocalDate.of(bYear, bMonth, bDayOfMonth);
        this.deathDate = LocalDate.of(dYear, dMonth, dDayOfMonth);
    }
}
