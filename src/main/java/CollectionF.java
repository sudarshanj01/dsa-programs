import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionF {
    public static void main(String[] args) {

        List<String> names = List.of("John", "Jane", "Alex");
        List<Integer> nums = List.of(1, 2, 3, 4, 5);


        names.stream()
                .filter(n -> n.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(System.out::println);


        List<Integer> evens = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        int sum = nums.stream()
                .reduce(0, (a, b) -> a + b);

        List<Integer> sorted = nums.stream()
                .sorted()
                .collect(Collectors.toList());

        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        List<Integer> flat = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());


        System.out.println(evens);
        System.out.println(sum);
        System.out.println(sorted);
        System.out.println(flat);

        //optional
        Optional<String> optional = Optional.ofNullable(null);

        if (optional.isPresent()) System.out.println(optional.get());
        optional.ifPresentOrElse(System.out::println,() -> System.out.println("deafult"));
        System.out.println(optional.orElse("def"));
    }
}
