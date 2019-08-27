package tech.hiyinyougen.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * @author yinyg
 * @date 2019/4/22
 */
public class HelloWorld {
    public static void main(String[] args) {
        List<String> mutants = new ArrayList<>();

        mutants.add("Professor X");
        mutants.add("Magneto");
        mutants.add("Storm");
//        mutants.add("Jean Grey");
//        mutants.add("Wolverine");
//        mutants.add("Mystique");

        // Obtain a Stream to the mutants List.
        Stream<String> mutantStream = mutants.stream();

        // Getting Spliterator object on mutantStream.
        Spliterator<String> mutantList = mutantStream.spliterator();

        Spliterator<String> splitList1 = mutantList;

        // .trySplit() method
        Spliterator<String> splitList2 = splitList1.trySplit();

        // If splitList1 could be split, use splitList2 first.
        if (splitList2 != null) {
            System.out.println("\nOutput from splitList2:");
            splitList2.forEachRemaining((n) -> System.out.println(n));
        }

        // Now, use the splitList1
        System.out.println("\nOutput from splitList1:");
        splitList1.forEachRemaining((n) -> System.out.println(n));
    }
}
