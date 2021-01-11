package ch08;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ch08_08 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("John", "NYC", "male", List.of("play guitar", "reed books")),
                new User("Mary", "NYC", "female", List.of("scating")),
                new User("Sam", "NYC", "female", null),
                new User("John", "LA", null, List.of("windsurfing")),
                new User("Pam", "LA", "other", List.of("snowboarding", "reading"))
        ));

        Map<String, List<String>> gendersByCity = users.stream().collect(Collectors.groupingBy(
                User::getCity,
                Collectors.flatMapping(
                        user -> user.getGender().stream(),
                        Collectors.toList()
                )
        ));

        gendersByCity.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println();

        Map<String, List<String>> habitsByCity = users.stream().collect(Collectors.groupingBy(
                User::getCity,
                Collectors.flatMapping(
                        user -> user.getHabits().stream().flatMap(List::stream),
                        Collectors.toList()
                )
        ));
        habitsByCity.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));



    }

    public static class User {
        String name;
        String city;
        String gender;
        List<String> habits;

        public User(String name, String city, String gender, List<String> habits) {
            this.name = name;
            this.city = city;
            this.gender = gender;
            this.habits = habits;
        }

        public Optional<String> getGender() {
            return Optional.ofNullable(gender);
        };

        public Optional<List<String>> getHabits() {
            return Optional.ofNullable(habits);
        }

        public String getCity() {
            return city;
        }
    }
}
