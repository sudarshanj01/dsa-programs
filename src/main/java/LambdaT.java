import java.util.function.*;

public class LambdaT {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (n) -> n % 2 == 0;

        System.out.println(isEven.test(2));

        Function<String,Integer> getLength = s -> s.length();
        System.out.println(getLength.apply("sudarshan"));

        Consumer<String> doAction = System.out::println;
        doAction.accept("sudarshan");

        Supplier<Integer> integerSupplier = () -> 1;
        int num = integerSupplier.get();
        System.out.println(num);

        BiFunction<String, String, Integer> getTotalLength = ((s, s2) -> s.length() + s2.length());
        System.out.println(getTotalLength.apply("sudarshan", "jadhav"));
    }

}

