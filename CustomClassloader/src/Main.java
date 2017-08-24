import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static void main(String[] args) {
        URL url;
        try {
            url = new URL("file:///"+System.getProperty("user.dir")+"/CustomClassloader/resources/quoter.jar");
            URLClassLoader ucl = new URLClassLoader(new URL[]{url});
            Class clazz = ucl.loadClass("com.example.Quote");
            Object o = clazz.newInstance();
            System.out.println(o.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
