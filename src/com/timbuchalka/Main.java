package com.timbuchalka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        //It specifies that the lambda function takes a String as input and returns a String as output.
        //The 's' string input parameter is used in the for loop to iterate over the characters of the string s.
        Function<String, String> lambdaFunction =  s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

//        System.out.println(lambdaFunction.apply("1234567890"));
        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

        //Supplier<String>: This is the type declaration for the lambda expression.
        // In this case, it represents a supplier that does not take any input arguments (Supplier) and returns a String.
        // The Supplier interface is part of the Java 8 functional interfaces and it has a single method called get().
//        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava = () -> { return "I love Java!"; };
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //The list values will be used for declaring a "stream" in the following line
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name ->
//                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);


        // This code performs several operations on a list of names (topNames2015) and prints them in a specific format.
        // Let's break down each step:
        // topNames2015.stream(): This line converts the list topNames2015 into a stream. A stream is a sequence of elements
        // that can be processed in parallel or sequentially.
        //.map(name -> name.substring(0, 1).toUpperCase() + name.substring(1)): Here, each name in the stream is transformed
        // using the map operation. The lambda expression name -> name.substring(0, 1).toUpperCase() + name.substring(1) is applied to
        // each name. This lambda expression takes the first character of each name (name.substring(0, 1)), converts it to uppercase
        // using the toUpperCase() method, and then concatenates it with the rest of the name (name.substring(1)).
        // Essentially, this operation capitalizes the first letter of each name.
        //.sorted(String::compareTo): This operation sorts the stream elements in ascending order using the natural ordering of strings. The String::compareTo method reference is used to compare and sort the elements.
        //.forEach(System.out::println): Finally, the forEach operation is applied to each element in the stream, and the System.out.println method reference is used to print each element on a new line.

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());


    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}












