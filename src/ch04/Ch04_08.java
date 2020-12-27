package ch04;

import java.util.ArrayList;

public class Ch04_08 {
    public static void main(String[] args) {
        int[] arr = new int[2];
        ArrayList<String> arrgen= new ArrayList<>();
        int basicType = 1; // not used cause getClass() is not applicable to basic types
        InternalClass iclass = new InternalClass();

        System.out.println("Array int[]\n-------------");
        System.out.println("getCanonicalName: " + arr.getClass().getCanonicalName());
        System.out.println("getSimpleName: " + arr.getClass().getSimpleName());
        System.out.println("getTypeName: " + arr.getClass().getTypeName());
        System.out.println("getName: " + arr.getClass().getName());
        System.out.println("toString: " + arr.getClass().toString());
        System.out.println("toGenericString: " + arr.getClass().toGenericString());

        System.out.println("\nArrayList<String>\n-------------");
        System.out.println("getCanonicalName: " + arrgen.getClass().getCanonicalName());
        System.out.println("getSimpleName: " + arrgen.getClass().getSimpleName());
        System.out.println("getTypeName: " + arrgen.getClass().getTypeName());
        System.out.println("getName: " + arrgen.getClass().getName());
        System.out.println("toString: " + arrgen.getClass().toString());
        System.out.println("toGenericString: " + arrgen.getClass().toGenericString());

        System.out.println("\nInternalClass\n-------------");
        System.out.println("getCanonicalName: " + iclass.getClass().getCanonicalName());
        System.out.println("getSimpleName: " + iclass.getClass().getSimpleName());
        System.out.println("getTypeName: " + iclass.getClass().getTypeName());
        System.out.println("getName: " + iclass.getClass().getName());
        System.out.println("toString: " + iclass.getClass().toString());
        System.out.println("toGenericString: " + iclass.getClass().toGenericString());


    }

    static class InternalClass {}
}
