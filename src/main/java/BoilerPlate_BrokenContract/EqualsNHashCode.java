package BoilerPlate_BrokenContract;

import java.util.HashSet;

public class EqualsNHashCode {

    public static void main(String args[]) {
        HashSet<Employee> empHashSet = new HashSet<>();
        empHashSet.add(new Employee("David", 32));
        empHashSet.add(new Employee("John", 45));
        empHashSet.add(new Employee("David", 32));
        empHashSet.forEach(System.out::println);
        Employee david = new Employee("David", 32);
        System.out.println("I'm adding next Employee called David, age 32");
        empHashSet.add(david);
        System.out.println("Does Set contain only unique values ?? Contract was broken");
        empHashSet.forEach(System.out::println);

        System.out.println("\n\n\nIn EmployeeCorrect class Equals and Hashcode was added\n");

        HashSet<EmployeeCorrect> empHashSet2 = new HashSet<>();
        empHashSet2.add(new EmployeeCorrect("David", 32));
        empHashSet2.add(new EmployeeCorrect("John", 45));
        empHashSet2.add(new EmployeeCorrect("David", 32));
        empHashSet2.forEach(System.out::println);
        EmployeeCorrect david2 = new EmployeeCorrect("David", 32);
        System.out.println("\n\nI'm adding next Employee called David, age 32");
        empHashSet2.add(david2);
        System.out.println("\nNow, Set contains only unique values.");
        empHashSet2.forEach(System.out::println);

        System.out.println("\n\n\nWhat if we try to remove one object from Set....\nDifferent approach... \n");
        System.out.println("Broken Contract version:");
        Employee david3 = new Employee("David", 32);
        Employee john1 = new Employee("John", 45);
        empHashSet.add(david3);
        empHashSet.add(john1);
        empHashSet.forEach(System.out::println);
        Employee davidForRemoval = new Employee("David", 32);
        System.out.println("----David's Objects are equal? " + david3.equals(davidForRemoval));
        boolean isRemoved1 = empHashSet.remove(davidForRemoval);
        System.out.println("David is removed: " + isRemoved1);
        empHashSet.forEach(System.out::println);

        System.out.println("\n\n After repair >>>\n");
        EmployeeCorrect david4 = new EmployeeCorrect("David", 32);
        EmployeeCorrect john3 = new EmployeeCorrect("John", 45);
        empHashSet2.add(david4);
        empHashSet2.add(john3);
        empHashSet2.forEach(System.out::println);
        EmployeeCorrect davidForRemoval2 = new EmployeeCorrect("David", 32);
        System.out.println("----David's Objects are equal? " + david4.equals(davidForRemoval2));
        boolean isRemoved2 = empHashSet2.remove(davidForRemoval2);
        System.out.println("David is removed: " + isRemoved2);
        empHashSet2.forEach(System.out::println);
        System.out.println("\nThose hashCodes should be the same");
        System.out.println("----David's hashcode: " + david4.hashCode());
        System.out.println("----DavidForRemoval's hashcode: " + davidForRemoval2.hashCode());


        System.out.println("\n\n\n\nOnly equals() code added to EmployeeOnlyEquals.java\nLets see what happens...");
        System.out.println("Broken Contract version:");
        HashSet<EmployeeOnlyEquals> empHashSet3 = new HashSet<>();
        EmployeeOnlyEquals david5 = new EmployeeOnlyEquals("David", 32);
        EmployeeOnlyEquals john4 = new EmployeeOnlyEquals("John", 45);
        empHashSet3.add(david5);
        empHashSet3.add(john4);
        empHashSet3.forEach(System.out::println);
        EmployeeOnlyEquals davidForRemoval3 = new EmployeeOnlyEquals("David", 32);
        System.out.println("----David's Objects are equal? " + david5.equals(davidForRemoval3));
        boolean isRemoved3 = empHashSet3.remove(davidForRemoval3);
        System.out.println("David is removed: " + isRemoved3);
        empHashSet.forEach(System.out::println);

        System.out.println("----John's hashcode: " + john4.hashCode());
        System.out.println("Those hashCodes should be the same");
        System.out.println("----David's hashcode: " + david5.hashCode());
        System.out.println("----DavidForRemoval's hashcode: " + davidForRemoval3.hashCode());
    }

}
