import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

/**
 * Application that display information about GC beans.
 */
public class MXBean {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean bean : list)  {
            System.out.println("Name: " + bean.getName());
            System.out.println("Number of collections: " + bean.getCollectionCount());
            System.out.println("Collection time: " + bean.getCollectionTime() + " ms");
            System.out.println("Pool names: " + Arrays.toString(bean.getMemoryPoolNames()));
        }
    }
}
