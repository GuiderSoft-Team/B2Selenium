package gun18.oop;

public class Main {

    public static void main(String[] args) {

        Test1 t1 = new Test1();
        Test2 t2 = new Test2();

        System.out.println("t1.getNum() = " + t1.getNum());
        System.out.println("BaseStatic.getNum() = " + BaseStatic.getNum());
        System.out.println("t2.getNum() = " + t2.getNum());
        System.out.println("BaseStatic.getNum() = " + BaseStatic.getNum());


    }
}
