package ch09;

import java.io.*;

public class Ch09_13 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Item item = new Item(5);
        Item item2 = (Item) clone(item);
        System.out.println(item2.i);
    }

    public static Object clone(Serializable object) throws IOException, ClassNotFoundException {
        byte[] arr;
        try (ByteArrayOutputStream arrStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(arrStream)) {
            out.writeObject(object);
            arr = arrStream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(arr)))
        {
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    static class Item implements Serializable {
        int i;
        Item(int i) {
            this.i = i;
        }
    }
}
