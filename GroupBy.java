package site.akshay.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupBy {
	public static void main( String[] args )
    {
        List <Person> personList = new ArrayList<Person>();
        personList.add(new Person("Sharon", 21, "Female"));
        personList.add(new Person("Maria", 18,  "Female"));
        personList.add(new Person("Jack", 21 ,"Male"));
        personList.add(new Person("James", 35,  "Male"));       
         
        Map<String, List<Person>> groupByGenderList = 
                personList.stream().collect(Collectors.groupingBy(Person::getGender));
         
        //Group by gender List : Female-> Persons and Male -> Persons
        System.out.println("1. Group persons by gender - get result in List: ");
        System.out.println(groupByGenderList.toString());
        System.out.println("-----------------------------------------------------------------------------------------------");
 
        Map<String, Set<Person>> groupByGenderSet = 
                personList.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.toSet()));
         
        //Group by gender Set: Female-> Persons and Male -> Persons
        System.out.println("2. Group persons by gender - get result in Set: ");
        System.out.println(groupByGenderSet.toString());
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        Map<String, Set<String>> groupByGenderAndFirstNameSet
        = personList.stream().collect(Collectors.groupingBy(Person::getGender, TreeMap::new,
                Collectors.mapping(Person::getName, Collectors.toSet())));    
        System.out.println("3. Group person by gender and get name of person - get result in Set: ");
        System.out.println(groupByGenderAndFirstNameSet.toString());
        System.out.println("-----------------------------------------------------------------------------------------------");
         
        Map<String, Long> countPersonByGender = personList.stream().
                collect(Collectors.groupingBy(Person::getGender,Collectors.counting()));
         
        System.out.println("4. Count person objects by gender: ");
        System.out.println(countPersonByGender.toString());     
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        Map<String, Optional<Person>> personByMaxAge = personList.stream().
                collect(Collectors.groupingBy(Person::getGender
                        ,Collectors.maxBy(Comparator.comparing(Person::getAge))));      
        System.out.println("5. Group person objects by gender and get person with max age: ");
        System.out.println(personByMaxAge.toString());
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        Map<String, IntSummaryStatistics> groupPersonsByAge = personList.stream().
                collect(Collectors.groupingBy(Person::getGender
                        ,Collectors.summarizingInt(Person::getAge)));       
        System.out.println("6. Group person objects by gender and get age statistics: ");
        System.out.println(groupPersonsByAge.toString());
        IntSummaryStatistics malesAge = groupPersonsByAge.get("Male");
        System.out.println("Avgerage male age:"+ malesAge.getAverage());
        System.out.println("Max male age:"+ malesAge.getMax());
        System.out.println("Min male age:"+ malesAge.getMin());
    }    
}