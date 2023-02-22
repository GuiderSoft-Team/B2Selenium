package gun02.classRunOrder;

public class ChildClass extends ParentClass{

    String parentInstanceVariable = "Child instance variable";
    public static String parentStaticVariable = "Child static variable";

    static {
        System.out.println("Child Static variables okundu");
        System.out.println("Child static initializer calisti");
    }


    // instance initializer
    {
        System.out.println("Child Instance variables okundu");
        System.out.println("Child Instance initializer calisti");
    }


    // Constructor
    public ChildClass() {
        System.out.println("Child Constructor Calisti");
    }



    public static void main(String[] args) {
        /*
            bu hic bir is yapmayan main calistirilirsa
            bu class'in ve parent'in statikleri okunur
         */
    }
}
