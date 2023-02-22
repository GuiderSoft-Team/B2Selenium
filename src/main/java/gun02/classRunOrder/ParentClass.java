package gun02.classRunOrder;

public class ParentClass {

    String parentInstanceVariable = "Parent instance variable";
    public static String parentStaticVariable = "Parent static variable";

    static {
        System.out.println("Parent Static variables okundu");
        System.out.println("Parent static initializer calisti");
    }


    // instance initializer
    {
        System.out.println("Parent Instance variables okundu");
        System.out.println("Parent Instance initializer calisti");
    }


    // Constructor
    public ParentClass() {
        System.out.println("Parent Constructor Calisti");
    }

}
