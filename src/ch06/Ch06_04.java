package ch06;

import java.util.ArrayList;
import java.util.Optional;

public class Ch06_04 {
    public static void main(String[] args) {
        Ch06_03.Table<Integer, String> table = new Ch06_03.Table<>();
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
        private ArrayList<Ch06_03.Entry<K,V>> map = new ArrayList<>();

        private Optional<Ch06_03.Entry<K,V>> getEntryByKey(K key) {
            if (key == null) {
                for (Ch06_03.Entry<K,V> e: map) {
                    if (e.getKey() == null) return Optional.of(e);
                }
            } else {
                for (Ch06_03.Entry<K,V> e: map) {
                    if (key.equals(e.getKey())) return Optional.of(e);
                }
            }
            return Optional.empty();
        }

        public Optional<V> get(K key) {
            Optional<Ch06_03.Entry<K,V>> entry = getEntryByKey(key);
            return entry.isEmpty() ? Optional.empty() : Optional.of(entry.get().getValue());
        }

        public void set(K key, V value) {
            Optional<Ch06_03.Entry<K,V>> entry = getEntryByKey(key);
            if (entry.isEmpty()) {
                map.add(new Ch06_03.Entry<>(key, value));
            } else {
                entry.get().setValue(value);
            }
        }

        public Optional<Ch06_03.Entry<K,V>> delete(K key) {
            Optional<Ch06_03.Entry<K,V>> entry = getEntryByKey(key);
            if (entry.isEmpty()) {
                return Optional.empty();
            } else {
                map.remove(entry.get());
                return entry;
            }
        }

        /* Entry can be defined without <K,V> but only when Entry class is not static,
           i.e. when the class entities creation only possible when the outer class Table<K,V> entity
           is created.*/
        class Entry {
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


}
