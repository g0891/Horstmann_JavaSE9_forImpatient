package ch07;

import java.util.*;

public class Ch07_10 {

    public static void main(String[] args) {

        String[] cityNames = new String[] {"1", "2", "3", "4", "5", "6"};
        City[] cities = new City[cityNames.length];
        for (int i = 0; i < cityNames.length; i++) {
            cities[i] = new City(cityNames[i]);
        }
        //City of start
        cities[0].distanceMark = 0;
        cities[0].route.add(cities[0]);

        HashMap<City, Set<Neighbor>> map = new HashMap<>(Map.of(
                cities[0] , new HashSet<>(Set.of(
                        new Neighbor(cities[1], 10),
                        new Neighbor(cities[2], 30),
                        new Neighbor(cities[3], 50),
                        new Neighbor(cities[4], 10)
                )),
                cities[3] , new HashSet<>(Set.of(
                        new Neighbor(cities[1], 40)
                )),
                cities[4] , new HashSet<>(Set.of(
                        new Neighbor(cities[2], 10),
                        new Neighbor(cities[3], 30)
                ))
        ));

        PriorityQueue<City> notVisitedCities = reviseNotVisitedCities(cities);
        City currentCity;

        while ((currentCity = notVisitedCities.poll()) != null) {
            if (currentCity.distanceMark == Integer.MAX_VALUE) break;
            if (map.containsKey(currentCity)) {
                for (Neighbor neighbor : map.get(currentCity)) {
                    if (neighbor.city.visited) continue;
                    if (neighbor.city.distanceMark > neighbor.distanceSegment + currentCity.distanceMark) {
                        neighbor.city.distanceMark = neighbor.distanceSegment + currentCity.distanceMark;
                        neighbor.city.route = new ArrayList<>(currentCity.route);
                        neighbor.city.route.add(neighbor.city);
                    }
                }
            }
            currentCity.visited = true;

            notVisitedCities = reviseNotVisitedCities(cities);
        }

        System.out.println("City name : Distance : Route\n---------------------------");
        for (City city: cities) {
            System.out.println(city.name + " : "
                    + (city.distanceMark == Integer.MAX_VALUE ? "Not reachable" : city.distanceMark)
                    + " : " + city.route);
        }

    }

    static PriorityQueue<City> reviseNotVisitedCities(City[] cities) {
        PriorityQueue<City> notVisitedCities = new PriorityQueue<>(cities.length, (city1, city2) -> city1.distanceMark - city2.distanceMark);
        Arrays.stream(cities).filter(city -> !city.visited).forEach(notVisitedCities::add);
        return notVisitedCities;
    }

    static class Neighbor {
        City city;
        int distanceSegment;
        public Neighbor(City city, int distanceSegment) {
            this.city = city;
            this.distanceSegment = distanceSegment;
        }
    }

    static class City {
        String name;
        boolean visited;
        int distanceMark;
        List<City> route;

        public City(String name) {
            this.name = name;
            distanceMark = Integer.MAX_VALUE;
            route = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
