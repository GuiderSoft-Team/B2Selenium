package gun02.classRunOrder;

public class Main {


    /*
       Bir class calistirildiginda
       1.  static vars okunur
       2.  static initializer calisir
       3.  main'e gelir, nesne new yapildiginda
       4.  instance vars okunur
       5.  instance initializer calisir
       6.  constructor calisir -> nesne create edilmis olur -> new tamamlanir
       7.  yapilacak islemler yürütülür
    */

    static String mainStaticVariable = "Main static variable";
    static {
        System.out.println("Main class statik variable okundu");
        System.out.println("Main class statik initializer calisti");
    }

    public static void main(String[] args) {

        /*
            bu main calistirilirsa
            1. öncelikle bu Main class'inin statikleri okunur
            2. ChildClass'dan nesne olusturuldugu icin
                a. Önce ChildClass'in Parent'inin sonra kendisinin statikleri
                b. Daha sonra instance'lari okunur
         */
        ChildClass childClass = new ChildClass();


    }




}
