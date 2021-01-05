package ch07;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ch07_13 {
    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(3);
        cache.put(1,"One");
        System.out.println(cache);
        cache.put(2,"Two");
        System.out.println(cache);
        cache.put(3,"Three");
        System.out.println(cache);
        cache.put(4,"Four");
        System.out.println(cache);
    }

    public static class Cache<K,V> extends LinkedHashMap<K,V> {
        private final int MAX_ENTRIES;

        public Cache(int max) {
            if (max <= 0) throw new IllegalArgumentException("Cache size can't be lower or equal to zero.");
            MAX_ENTRIES = max;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    }

}
