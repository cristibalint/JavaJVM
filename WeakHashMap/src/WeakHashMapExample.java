import java.util.Date;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Application that demonstrates the use of WeakHashMapExample in Java.
 */
public class WeakHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<Person, PersonMetaData> weakHashMap = new WeakHashMap<>();

        Person cris = new Person();
        weakHashMap.put(cris, new PersonMetaData());
        Thread.sleep(100);

        PersonMetaData p1 = weakHashMap.get(cris);
        System.out.println(p1);

        cris = null;
        System.gc();
        System.gc();

        System.out.println("WeakHashMap contains " + weakHashMap.values().size() + " values.");

        if(weakHashMap.containsValue(p1)) {
            System.out.println("WeakHashMap still contains key");
        } else {
            System.out.println("WeakHashMap key is gone");
        }
    }
}

final class Person {

}

class PersonMetaData {
    Date date;

    PersonMetaData() {
        date = new Date();
    }

    @Override
    public String toString() {
        return "PersonMetaData {"
                + "date=" + date
                + "}";
    }
}