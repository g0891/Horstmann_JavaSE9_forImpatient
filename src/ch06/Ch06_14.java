package ch06;

import java.util.ArrayList;

public class Ch06_14 {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Exception ex = null;
        for (T elem: elems) {
            try {
                elem.close();
            } catch (Exception e) {
                e.initCause(ex);
                ex = e;
            }
        }
        if (ex != null) throw ex;
    }
}
