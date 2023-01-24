import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
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
        //List<Person> listPerson = new LinkedList<>();

        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        };

        findMinMax(listPerson.stream(), personComparator, (intMin, intMax) -> {
            System.out.println("Min: " + intMin);
            System.out.println("Max: " + intMax);
        });

        System.out.println("Задание №2");
        List<Integer> listInteger = new LinkedList<>(List.of(1, 4, 5, 3, 8, 6, 7, 9));
        System.out.println("список - " + listInteger);
        List<Integer> newListInteger = listInteger.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("количество четных - " + newListInteger.size());
    }

    public static void findMinMax(Stream<Person> stream,
                                  Comparator<Person> order,
                                  BiConsumer <Integer, Integer> minMaxConsumer) {

        List<Person> listPersonSort = stream.sorted(order).toList();
        if (listPersonSort.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            int min = listPersonSort.get(0).getAge();
            int max = listPersonSort.get(listPersonSort.size()-1).getAge();
            minMaxConsumer.accept(min, max);
        }
    }
}

