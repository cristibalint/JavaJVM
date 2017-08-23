/*
* Application that demonstrates Java Garbage Collection
*
**/

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Sawtooth {

    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 320000; i++) {
            Object obj = new GC();
            long address = addressOf(obj);
            System.out.println(address);
        }
    }

    private static long addressOf(Object o) {
        Object[] array = new Object[] {o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
        case 4:
            objectAddress = unsafe.getInt(array, baseOffset);
            break;
        case 8:
            objectAddress = unsafe.getLong(array, baseOffset);
            break;
        default:
            throw new Error("unsupported address size: " + addressSize);
        }

        return objectAddress;
    }

    private static class GC {
        long data;
        long a;
        long aa;
        long aaa;
        long aaaa;
        long aaaaa;
        long aaaaaa;
        long aaaaaaa;
        long aaaaaaaa;
        long aaaaaaaaa;
        long aaaaaaaaaa;
        long aaaaaaaaaaa;
        long aaaaaaaaaaaa;
        long aaaaaaaaaaaaa;
        long aaaaaaaaaaaaaa;
        long aaaaaaaaaaaaaaa;
        long aaaaaaaaaaaaaaaa;
        long aaaaaaaaaaaaaaaaa;
    }
}
