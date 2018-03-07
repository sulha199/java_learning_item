/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;
//import org.

//import java.util.Co

/**
 *
 * @author Shulha_U3218
 */
public class StreamExample {

    public static void main(String args[]) {
        List<String> items = new ArrayList<String>();
        List<transaction> transactions = new ArrayList<>();

        items.add("one");
        items.add("two");
        items.add("three");

        transactions.add(new transaction(1, 100));
        transactions.add(new transaction(3, 80));
        transactions.add(new transaction(6, 120));
        transactions.add(new transaction(7, 40));
        transactions.add(new transaction(10, 50));

        Stream<String> stream = items.stream();
        Stream<transaction> streamt = transactions.stream();
        // using stream supplier, so the stream can be used several times by executing the lambda expression with no parameter
        Supplier<Stream<transaction>> transactionSupplier = () -> transactions.stream();

        // using stream on common type
        List<String> result = stream.filter(item -> item.startsWith("t")).peek(e -> System.out.println("Filtered value: " + e)).map(item -> item += 2).peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        // using stream on custom object
        List<transaction> resultt = streamt
                .filter(item -> {
                    return item.id > 3;
                })
                .map(item -> new transaction(item.id, item.value + 5))
                .collect(Collectors.toList());

        // using stream supplier, so the stream can be used several times
        transaction less = transactionSupplier.get().min(Comparator.comparing(item -> item.value)).get();
        List<transaction> tlist = transactionSupplier.get()
                .filter(item -> {
                    return item.id > 3;
                })
                .map(item -> new transaction(item.id, item.value + 5))
                .collect(Collectors.toList());
        System.out.println(result + "" + less);

        // ===================================
        // Flat Map for multidimensional array
        System.out.println("===== Flat Map for multidimensional array=====");
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
        //List<String> streamlists = temp.flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
        //Stream<String> flatstream = stringStream.filter(x -> "a".equals(x.toString()));
        List<String> streamflatlists = stringStream.filter(x -> "a".equals(x.toString())).collect(Collectors.toList());

        //======================
        //Stream + Set + flatMap
        System.out.println("===== Flat Map + Set =====");
        Student1 obj1 = new Student1();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student1 obj2 = new Student1();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student1> list = new ArrayList<>();
        list.add(obj1);
//        list.add(obj2);

        List<String> collect
                = list.stream()
                        .map(x -> x.getBook()) //Stream<Set<String>>
                        .flatMap(x -> x.stream()) //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));

        //===========================
        // findAny and findFirst in parallel operation
        List<Integer> listF = Arrays.asList(1, 2, 3, 4, 5);
        Supplier<Stream<Integer>> FSupplier = () -> listF.stream();
        Optional<Integer> resultFAny = FSupplier.get()
                .parallel()
                .filter(num -> num < 4).findAny();
        Optional<Integer> resultFFirst = FSupplier.get()
                .parallel()
                .filter(num -> num < 4).findFirst();

        

    }

}

//public static <T> Collector<T, ?, ArrayList<T>> toArrayList() {
//    return Collectors.toCollection(ArrayList::new);
//}
class transaction {

    public int id;
    public int value;

    public transaction(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void add5() {
        this.value += 5;
    }

}

class Student1 {

    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public String getName() {
        return name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

}
