package exercises1;

import java.util.*;
import java.util.stream.Collectors;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        //	Udskriver det største element i listen
        System.out.print("Maximum is: ");
        list.stream().max(Integer::compareTo).ifPresent(System.out::println);

        //	Afgør og udskriver om alle tallene i listen er mindre end 50
        System.out.print("All values are under 50: ");
        System.out.println(list.stream().allMatch(e -> e < 50));


        // 	Udskriver antallet af lige tal i listen
        System.out.println("Number of even values: " + list.stream().filter(e -> e % 2 == 0).count());


        //	Udskriver antallet af ulige tal i listen
        System.out.println("Number of uneven values: " + list.stream().filter(e -> e % 2 != 0).count());

        //  Udskriver
        //      Gennemsnittet af tallene i listen
        //      Antallet af tallene i listen
        //      Antallet af tallene i listen der er større end gennemsnittet
        //      Antallet af tallene i listen der er mindre end gennemsnittet
        System.out.println("Average: " + list.stream().mapToInt(e -> e).average().orElse(0));
        System.out.println("Number of values: " + list.size());
        System.out.println("Number of values above average: " + list.stream().filter(e -> e > list.stream().mapToInt(i -> i).average().orElse(0)).count());
        System.out.println("Number of values below average: " + list.stream().filter(e -> e < list.stream().mapToInt(i -> i).average().orElse(0)).count());

        //	Udskriver antallet af gange de forskellige tal forekommer i listen
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map);

        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
        map.entrySet().stream().sorted((e1, e2) -> e1.getKey() - e2.getKey()).forEach(System.out::println);
    }
}
