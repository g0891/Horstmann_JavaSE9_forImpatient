package ch06;

import java.util.ArrayList;
import java.util.Optional;

public class Ch06_03 {
    public static void main(String[] args) {
        Table<Integer, String> table = new Table<>();
        table.set(1, "hello");
        System.out.println(table.get(2).orElse("-- No key found --"));
        table.set(null, "Null value");
        System.out.println(table.get(null).orElse("-- No key found --"));
        table.set(null, "New null value");
        System.out.println(table.get(null).orElse("-- No key found --"));
        table.delete(null);
        System.out.println(table.get(null).orElse("-- No key found --"));
    }

    static class Table<K,V> {
        private ArrayList<Entry<K,V>> map = new ArrayList<>();

        private Optional<Entry<K,V>> getEntryByKey(K key) {
            if (key == null) {
                for (Entry<K,V> e: map) {
                    if (e.getKey() == null) return Optional.of(e);
                }
            } else {
                for (Entry<K,V> e: map) {
                    if (key.equals(e.getKey())) return Optional.of(e);
                }
            }
            return Optional.empty();
        }

        public Optional<V> get(K key) {
            Optional<Entry<K,V>> entry = getEntryByKey(key);
            return entry.isEmpty() ? Optional.empty() : Optional.of(entry.get().getValue());
        }

        public void set(K key, V value) {
            Optional<Entry<K,V>> entry = getEntryByKey(key);
            if (entry.isEmpty()) {
                map.add(new Entry<>(key, value));
            } else {
                entry.get().setValue(value);
            }
        }

        public Optional<Entry<K,V>> delete(K key) {
            Optional<Entry<K,V>> entry = getEntryByKey(key);
            if (entry.isEmpty()) {
                return Optional.empty();
            } else {
                map.remove(entry.get());
                return entry;
            }
        }


    }

    static class Entry<K,V> {
        private K key;
        private V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
