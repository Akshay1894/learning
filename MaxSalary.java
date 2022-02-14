package site.akshay.java8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class Payroll
{
    private String employee;
    private Integer income;
 
    public Payroll(String employee, Integer income)
    {
        this.employee = employee;
        this.income = income;
    }
 
    public Integer getIncome() {
        return income;
    }
 
    @Override
    public String toString() {
        return "[" + employee + ", " + String.valueOf(income) + "]";
    }
 
}
 
class MaxSalary
{
    // Program to demonstrate `Collectors.minBy()` and `Collectors.maxBy()`
    // methods in Java 8 and above
    public static void main(String[] args)
    {
        Payroll p1 = new Payroll("Employee1", 115000);
        Payroll p2 = new Payroll("Employee2", 100000);
        Payroll p3 = new Payroll("Employee3", 120000);
 
        List<Payroll> salaries = Arrays.asList(p1, p2, p3);
 
        // get a person with the minimum income
        Payroll min = salaries.stream()
                            .collect(Collectors.minBy(
                                Comparator.comparingInt(Payroll::getIncome)))
                            .get();
        System.out.println("Employee with minimum Salary " + min);
 
        // get a person with the maximum income
        Payroll max = salaries.stream()
                            .collect(Collectors.maxBy(
                                Comparator.comparingInt(Payroll::getIncome)))
                            .get();
        System.out.println("Employee with maximum Salary " + max);
        
        int maxSalary = salaries.stream().map(Payroll::getIncome).max(Integer::compare).get();
        System.out.println("Max salary :"+maxSalary);
        
        salaries.stream()
		 .filter(emp -> emp.getIncome() == (salaries.stream().map(Payroll::getIncome).max(Integer::compare).get()))
		 .forEach(System.out::println);
    }
}