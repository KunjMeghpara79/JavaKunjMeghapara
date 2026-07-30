import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

 class sample {
   public static void main() {
        List<Integer> list = Arrays.asList(1,2,5,6,10,11,20);
        Stream<Integer> stream = list.stream();

        stream
                .filter(n -> n <= 10)
                .map(n -> n*n)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}
