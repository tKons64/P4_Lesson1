import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Person> list = new LinkedList<>(List.of(
                new Person(4),
                new Person(7),
                new Person(2),
                new Person(15),
                new Person(9)));

        findMinMax(list.stream(), new SortByPerson(), (personMin, personMax) -> {
            System.out.println("Min: " + personMin);
            System.out.println("Max: " + personMax);
        });

        List<Person> list2 = list.stream().sorted().toList();

    }

    public static void findMinMax(Stream<Person> stream,
                                  Comparator<Person> order,
                                  BiConsumer <Person, Person> minMaxConsumer) {

        List<Person> listPersonSort = stream.sorted(order).toList();
        Person min = listPersonSort.get(0);
        Person max = listPersonSort.get(listPersonSort.size()-1);
        minMaxConsumer.accept(min, max);
    }
}

