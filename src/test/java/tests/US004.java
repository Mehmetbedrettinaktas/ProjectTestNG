package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004 {


    @Test(priority = 1)
    public void test6() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        //1. Vendor "url" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2. Vendor sign in butonuna tiklar
        ReusableMethods.waitFor(3);
        spengood.signIn.click();
        //3. Vendor gecerli bir username veya email adresi girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"));
        //4.Vendor gecerli bir password girer
        spengood.password.sendKeys(ConfigReader.getProperty("pass"));
        //5.Vendor SIGN IN butonuna tiklar
        spengood.userpassSignIn.click();
        ReusableMethods.waitFor(4);
        //6.Vendor ürünler sayfasindan ürün secer ve sectigi sepete ekler
        spengood.search.sendKeys("T-Shirt", Keys.ENTER);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        spengood.tShirt.click();
        ReusableMethods.waitFor(2);
        spengood.plus.click();
        spengood.addToCart.click();
        //7.Vendor cartButton a tiklar
        spengood.cartButton.click();
        ReusableMethods.waitFor(3);
        //7.Vendor secilmis olan ürünleri artirip artiramadigini tek tek kontrol eder
        String ilkUrunDegeri = spengood.artieksiKutu.getText();
        System.out.println("urunun sayi degeri=" + ilkUrunDegeri);
        ReusableMethods.waitFor(4);
        spengood.viewCart.click();
        ReusableMethods.waitFor(4);
        spengood.plus.click();
        ReusableMethods.waitFor(4);
        spengood.updateCartButton.click();
        ReusableMethods.waitFor(4);
        spengood.cartButton.click();
        ReusableMethods.waitFor(5);
        String artirilmisUrunDegeri = spengood.artieksiKutu.getText();
        System.out.println("urunun artirilmis sayi degeri=" + artirilmisUrunDegeri);
        ReusableMethods.waitFor(5);
        Assert.assertNotEquals(ilkUrunDegeri, artirilmisUrunDegeri, "ilk urun degeri artirilmis urunden bir azdir");
        //8.Vendor secilmis olan ürünleri azaltip azaltamadigini tek tek kontrol eder
        ReusableMethods.waitFor(4);
        spengood.viewCart.click();
        ReusableMethods.waitFor(4);
        spengood.minusButton.click();
        ReusableMethods.waitFor(4);
        spengood.updateCartButton.click();
        ReusableMethods.waitFor(4);
        spengood.cartButton.click();
        ReusableMethods.waitFor(4);
        String azaltilmisUrunDegeri = spengood.artieksiKutu.getText();
        System.out.println("urunun azaltilmis sayi degeri=" + azaltilmisUrunDegeri);
        ReusableMethods.waitFor(4);
        Assert.assertNotEquals(artirilmisUrunDegeri, azaltilmisUrunDegeri, "ilk urun degeri azaltilmis urunden bir fazladir");
    }
    @Test(priority = 2)
    public void test7() {

        SpendingGoodPage spengood = new SpendingGoodPage();
        ReusableMethods.waitFor(3);
        //Vendor View Cart a tiklar
        spengood.viewCart.click();
        //Vendor acilan sayfada ürünleri;product,Price,Ouantity,subtotal olarak görür
        spengood.myOrderproduct.isDisplayed();
        spengood.myOrderPrice.isDisplayed();
        spengood.myOrderQuantity.isDisplayed();
        spengood.myOrderSubTotal.isDisplayed();

    }

    @Test(priority = 3)
    public void test8() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        //Vendor acilan sayfada Coupon secenegini görür
        spengood.applyButton.isDisplayed();
    }
    @Test(priority = 4)
    public void test9() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        //8.Vendor acilan sayfada shipping bilgilerini görür ve toplam rakami sagda populate eder
        spengood.shippinginfo.isDisplayed();

    }
    @Test(priority = 5)
    public void test10() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        //8.Proceed to checkout butonunun ekranda oldugu teyit edilir
        spengood.procedToCheckOut.isDisplayed();
    }

    @Test(priority = 6)
    public void test11() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        //8.Vendor acilan sayfada CONTINUE SHOPPING butonunu görür
        spengood.continueShopping.isDisplayed();
    }
    @Test(priority = 7)
    public void test12() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        spengood.clearCartButton.click();
        //Vendor Your cart is currently empty yazisini görür
        ReusableMethods.waitFor(3);
        spengood.ClearTextYazisi.isDisplayed();
        //Cart a tiklayarak No Products in The Cart yazisini görür.
        ReusableMethods.waitFor(3);
        spengood.cartButton.click();
        ReusableMethods.waitFor(3);
        spengood.cartNoProductsYazisi.isDisplayed();
        //Vendor close buttona tiklar
        ReusableMethods.waitFor(3);
        spengood.closeButton.click();
        ReusableMethods.waitFor(2);
    }
    @Test(priority = 8)
    public void test13() {
        SpendingGoodPage spengood = new SpendingGoodPage();
        //Vendor secili olan ürünlerde stok fazlasi ürün ekleyip eklenemedigini kontrol eder
        spengood.search.sendKeys("Arcelik", Keys.ENTER);
        spengood.arcelik.click();
        ReusableMethods.waitFor(4);
        String ilkStokDegeri = spengood.ilkinStokInformation.getText();
        ilkStokDegeri=ilkStokDegeri.replaceAll("\\D","");
        System.out.println(ilkStokDegeri);
        int ilkStokDegeriInt= Integer.parseInt(ilkStokDegeri);
        spengood.sonInStokInformation.clear();
        ReusableMethods.waitFor(4);
        ilkStokDegeriInt=ilkStokDegeriInt+1;
        String ilkStokDEgeri= String.valueOf(ilkStokDegeriInt);
        spengood.sonInStokInformation.sendKeys(ilkStokDEgeri);
        ReusableMethods.waitFor(4);
        String sonStokDegeri = spengood.sonInStokInformation.getText();
        System.out.println(sonStokDegeri);
        spengood.addToCart.click();
        ReusableMethods.waitFor(5);
        spengood.cartButton.click();
        ReusableMethods.waitFor(2);
        spengood.cartNoProductsYazisi.isDisplayed();
        Driver.closeDriver();

    }


}

