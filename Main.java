import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22),
                new Person("David", 35)
        );

        //Filter persons older than 25
        List<Person> filteredPersons = persons.stream()
                .filter(person -> person.getAge() > 25)
                .collect(Collectors.toList());

        System.out.println("Persons older than 25: " + filteredPersons);

    //Map persons to their names
    List<String> names = persons.stream()
            .map(Person::getName)
            .collect(Collectors.toList());

        System.out.println("Names of all persons: " + names);


    //Calculate the total age of all persons
             int totalAge = persons.stream()
                    .mapToInt(Person::getAge)
                     .reduce(0, Integer::sum);

              System.out.println("Total age of all persons: " + totalAge);
}
}
