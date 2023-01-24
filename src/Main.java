import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1");
        List<Person> listPerson = new LinkedList<>(List.of(
                new Person(4),
                new Person(7),
                new Person(2),
                new Person(15),
                new Person(9)));

        findMinMax(listPerson.stream(), new SortByPerson(), (personMin, personMax) -> {
            System.out.println("Min: " + personMin.getAge());
            System.out.println("Max: " + personMax.getAge());
        });

        System.out.println("Задание №2");
        List<Integer> listInteger = new LinkedList<>(List.of(1, 4, 5, 3, 8, 6, 7, 9));
        System.out.println("список - " + listInteger);
        List<Integer> newListInteger = listInteger.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("количество четных - " + newListInteger.size());
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

