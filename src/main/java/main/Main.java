package main;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {

    }

    public int countA(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') count++;
        }
        return count;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    private void run1() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("file.txt"))) {
//            List<String> strings = new ArrayList<>();
//            String line;
//            while ((line = reader.readLine())!=null) {
//                strings.add(line);
//            }
            List<String> strings = reader.lines().collect(Collectors.toList());
            strings.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Person> people = List.of(
                new Person("Ivan", 25),
                new Person("Petr", 53),
                new Person("Ivan", 37),
                new Person("Maria", 26)
        );
//        System.out.println(people.getClass().getSimpleName());
//        people.add(new Person("qwe",12));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.dat"))) {
            oos.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.dat"))) {
            Object object = ois.readObject();
            List<Person> list = new ArrayList<>((List<Person>) object);
            System.out.println(list.getClass().getCanonicalName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
