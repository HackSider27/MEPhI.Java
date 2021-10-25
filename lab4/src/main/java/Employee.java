import java.lang.Enum;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private int dept;
    private String eMail;
    private int phone;
    private String adress;
    private String city;
    private String state; //область
    private int code; //код области

    public enum Gender {
        MALE,
        FEMALE;

        public static Gender getRandomGender() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public enum Role {
        STAFF,
        MANAGER,
        EXECUTIVE;


        public static Role getRandomRole() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    /*Constructors*/
    private Employee(Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        role = builder.role;
        dept = builder.dept;
        eMail = builder.eMail;
        phone = builder.phone;
        adress = builder.adress;
        city = builder.city;
        state = builder.state;
        code = builder.code;
    }

    public Employee() {
        givenName = "John";
        surName = "Smith";
        age = 27;
        gender = Gender.MALE;
        role = Role.EXECUTIVE;
        dept = 3;
        eMail = "JohnSm@matrix.com";
        phone = 0;
        adress = "NS";
        city = "Neocity";
        state = "Secret";
        code = 1337;
    }

    public Employee(String givenName1, String surName1,
             int age1, Gender gender1, Role role1,
             int dept1, String eMail1, int phone1,
             String adress1, String city1,
             String state1, int code1) {
        givenName = givenName1;
        surName = surName1;
        age = age1;
        gender = gender1;
        role = role1;
        dept = dept1;
        eMail = eMail1;
        phone = phone1;
        adress = adress1;
        city = city1;
        state = state1;
        code = code1;
    }

    /* Getters*/

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public Gender getGender(){
        return gender;
    }

    public int getDept(){
        return dept;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    /*builder*/
    public static class Builder {

        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private Role role;
        private int dept;
        private String eMail;
        private int phone;
        private String adress;
        private String city;
        private String state;
        private int code;

        public Builder GivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder SurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder Age(int age) {
            this.age = age;
            return this;
        }

        public Builder Gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder Role(Role role) {
            this.role = role;
            return this;
        }

        public Builder eMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder Phone(int phone) {
            this.phone = phone;
            return this;
        }

        public Builder Dept(int dept) {
            this.dept = dept;
            return this;
        }

        public Builder Adress(String adress) {
            this.adress = adress;
            return this;
        }

        public Builder City(String city) {
            this.city = city;
            return this;
        }

        public Builder State(String state) {
            this.state = state;
            return this;
        }

        public Builder Code(int code) {
            this.code = code;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }


    /*Methods*/
    @Override
    public String toString() {
        // Good good_str = new Good.Builder(givenName, surName).build()
        return givenName + " " + surName +
                "\n\tAge: " + age +
                "\n\tGender: " + gender +
                "\n\tRole: " + role +
                "\n\tDepartament: " + dept +
                "\n\tEmail: " + eMail +
                "\n\tPhone: " + phone +
                "\n\tAdress: " + adress +
                "\n\tCity, state, code: " + city + ", " + state + ", " + code + "\n\n";
    }

    public static String RandomWord(int length) {
        String rez = new String();
        Random r = new Random();
        char c;
        for (int i = 0; i < length; i++) {
            c = (char) (r.nextInt(26) + 'a');
            rez += c;
        }
        return rez;
    }

    public static List<Employee> createShortList() {
        LinkedList<Employee> employeeList = new LinkedList<>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            Supplier another_one =
                    () -> new Builder().GivenName(RandomWord(5))
                    .SurName(RandomWord(6)).Age(r.nextInt(65))
                    .Gender(Gender.getRandomGender()).Role(Role.getRandomRole())
                    .Dept(r.nextInt(5)).eMail(RandomWord(10))
                    .Phone(r.nextInt(1000000000) + 800000000)
                    .Adress(RandomWord(10)).City(RandomWord(7))
                    .State(RandomWord(6)).Code(r.nextInt(10)).build();

            employeeList.add((Employee) another_one.get());
        }

        return employeeList;
    }

}

