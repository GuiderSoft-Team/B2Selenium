package gun02;


import org.testng.Assert;
import org.testng.annotations.Test;

public class _03TestNGTestAnnotation {

    // @Test Annotation'i her methodu müstakil olarak executable hale getirir, main gibi
    // test calistirildiginda o class'dan nesne olusturularak calistirilir.
    //

    @Test
    public void test9(){
        Assert.assertTrue(true);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1, 2, "Sayilar esit degil");
    }

}
