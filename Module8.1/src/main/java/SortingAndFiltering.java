import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Define the Person class with fields: name, age, and city.
class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

// Main class for sorting and filtering Person objects.
public class SortingAndFiltering {
    public static void main(String[] args) {
        // Create a list of Person objects.
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28, "New York"));
        people.add(new Person("Bob", 22, "Los Angeles"));
        people.add(new Person("Charlie", 35, "New York"));
        people.add(new Person("David", 30, "Chicago"));

        // Sort the list by age in ascending order using lambda expressions and Comparator.
        Collections.sort(people, Comparator.comparingInt(Person::getAge));

        // Filter the list to keep only people from a specific city (e.g., "New York") using lambda expressions and removeIf.
        String targetCity = "New York";
        people.removeIf(person -> !person.getCity().equals(targetCity));

        // Display the sorted and filtered list.
        System.out.println("Sorted and Filtered List:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
