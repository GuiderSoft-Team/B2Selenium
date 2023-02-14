package gun02;

public class ClassGenel {

    public int number;

    // instance initializer, constructerdan hemen önce otomatik calisir
    {
        System.out.println("instance initializer calisti");
    }

    static {
        System.out.println("static initializer");
    }

    public ClassGenel(){
        number = 3;
        System.out.println("Constructor Calisti\nnumber: " + number );
    }

    public static void main(String[] args) {

        ClassGenel cg = new ClassGenel();

    }


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

}
