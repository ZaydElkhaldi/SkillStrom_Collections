package Abstraction;

// Collection - A group of objects housed in a type

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        //

        // .contains -> check for na item in the list
        // .add -> put a new item in out list
        // .remove -> remove an item from the list
        // Iterator -> allows fore each iteration of items in the list

        // Whole collection operations
        //  .containsAll -> check if all elements in one collection are present in another
        // .addAll -> add all elements of one collection into another
        // removeAll -> opposite of addAll
        // .clear -> clears all elements in a single collection
        // .retainAll -> remove all item from a target collection
        // toArray -> returns an array of elements for array operations

        // Traversing collections
        // 1. Aggregate operations
        // 2. For each construct
        // 3. Iterators

        // Lambda expressions: functional programming construct in java
//
//        stringList.stream()
//                .filter(e -> e.length() > 0)
//                .forEach(e -> System.out.println(e));
//
//
//        // Equivalent to
//        for (String item : stringList) {
//            if (item.length() > 0) {
//                System.out.println(item);
//            }
//        }

        Employee employee1 = new Employee(50000);
        Employee employee2 = new Employee(55000);
        Employee employee3 = new Employee(65001);

        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);

        int totalSalary = employeesList.stream()
                .collect(Collectors.summingInt(Employee::getSalary));

        // Iterator -> object that enables moving through a collection
        // and potentially removing from the collection

        for (Iterator<Employee> emp = (Iterator<Employee>) employeesList.iterator().next(); emp.hasNext(); ) {
            if (emp.next().getSalary() > totalSalary) {
                emp.remove();
            }
        }


    }
}

// interface Iterator<E> {
// boolean hasNext(); // returns true if more elements to move through
// E next(); // gets next element in the collection
// void remove(); // removes the last elements returned by next

class Employee {
    private int salary;

    public Employee(int money) {
        this.salary = money;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}