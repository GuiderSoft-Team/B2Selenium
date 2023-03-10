package gun18;

public class SystemProperty {

    public static void main(String[] args) {


        //System.getProperties().forEach((k,v)-> System.out.println(k + " : " + v));

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
    }
}

