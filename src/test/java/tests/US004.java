package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US004 {

        @Test
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
            ReusableMethods.waitFor(3);

            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.tShirt.click();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            ReusableMethods.waitFor(2);
            actions.sendKeys(Keys.PAGE_UP);
            ReusableMethods.waitFor(2);
            //6.Vendor Cart a tiklar
            spengood.cartButton.click();
            //7.Vendor acilan pencerede VIEW Cart a tiklar
            ReusableMethods.waitFor(3);
            spengood.viewCart.click();
            //8.Vendor acilan sayfada ürünleri;product,Price,Ouantity,subtotal olarak görür
            spengood.myOrderproduct.isDisplayed();
            spengood.myOrderPrice.isDisplayed();
            spengood.myOrderQuantity.isDisplayed();
            spengood.myOrderSubTotal.isDisplayed();
            Driver.closeDriver();

        }

        @Test
        public void test7() {
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
            //9.Vendor ürünler sayfasindan adet ürün secer ve sectigi ürünleri tek tek sepete ekler
            // Update Cart ile rakam ortalamalarinin güncellenip güncellenemedigini kontrol eder kontrol eder
            spengood.cartButton.click();
            ReusableMethods.waitFor(3);

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
            ReusableMethods.waitFor(4);
            String artirilmisUrunDegeri = spengood.artieksiKutu.getText();
            System.out.println("urunun artirilmis sayi degeri=" + artirilmisUrunDegeri);
            ReusableMethods.waitFor(4);
            Assert.assertNotEquals(ilkUrunDegeri, artirilmisUrunDegeri, "ilk urun degeri artirilmis urunden bir fazladir");
            Driver.closeDriver();
        }


        @Test
        public void test8() {
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            ReusableMethods.waitFor(2);
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            ReusableMethods.waitFor(4);
            //9.Vendor ürünler sayfasindan ürün secer ve sectigi ürünu sepete ekler
            spengood.cartButton.click();

            ReusableMethods.waitFor(4);
            String ilkUrunDegeri2 = spengood.artieksiKutu.getText();
            System.out.println("urunun sayi degeri=" + ilkUrunDegeri2);
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
            Assert.assertNotEquals(ilkUrunDegeri2, azaltilmisUrunDegeri, "ilk urun degeri azaltilmis urunden bir eksiktir");
            Driver.closeDriver();
        }

        @Test
        public void test9() throws IOException {
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
// 1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
//2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
//3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
//4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
//5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
//6.Vendor Cart a tiklar
            actions.sendKeys(Keys.PAGE_UP);
            ReusableMethods.waitFor(3);
            spengood.cartButton.click();
            if (spengood.viewCart.isDisplayed()){
                spengood.viewCart.click();
                spengood.clearCartButton.click();
            }else {spengood.closeButton.click();}

            ReusableMethods.waitFor(2);

//7.Vendor View Cart a tiklar
            ReusableMethods.waitFor(2);
            spengood.search.sendKeys("Arcelik", Keys.ENTER);
            // actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.arcelik.click();
            ReusableMethods.waitFor(4);
//8.Vendor secili olan ürünlerde stok fazlasi ürün ekleyip eklenemedigini kontrol eder

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
        @Test
        public void test10() throws InterruptedException {

            SpendingGoodPage spengood=new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            Thread.sleep(3000);
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //6.Vendor Cart a tiklar
            Thread.sleep(3000);
            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.tShirt.click();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            ReusableMethods.waitFor(2);
            actions.sendKeys(Keys.PAGE_UP);
            spengood.cartButton.click();
            //6.Vendor View Cart a tiklar
            spengood.viewCart.click();
            Thread.sleep(3000);
            //7.Vendor acilan sayfada Coupon secenegini görür
            spengood.applyButton.isDisplayed();
            Driver.closeDriver();

        }
        @Test
        public void test11() throws InterruptedException {
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            Thread.sleep(3000);
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //6.Vendor Cart a tiklar
            Thread.sleep(3000);
            spengood.cartButton.click();
            //6.Vendor View Cart a tiklar
            spengood.viewCart.click();
            Thread.sleep(3000);
            //8.Vendor acilan sayfada shipping bilgilerini görür ve toplam rakami sagda populate eder
            spengood.shippinginfo.isDisplayed();
            Driver.closeDriver();
        }
        @Test
        public void test12() throws InterruptedException {
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            Thread.sleep(3000);
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //6.Vendor Cart a tiklar
            Thread.sleep(3000);
            spengood.cartButton.click();
            //6.Vendor View Cart a tiklar
            spengood.viewCart.click();
            Thread.sleep(3000);
            //8.Proceed to checkout butonunun ekranda oldugu teyit edilir
            spengood.procedToCheckOut.isDisplayed();
            Driver.closeDriver();

        }
        @Test
        public void test13() throws InterruptedException {
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            ReusableMethods.waitFor(2);
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            Thread.sleep(3000);
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            ReusableMethods.waitFor(2);
            //6.Vendor Cart a tiklar
            ReusableMethods.waitFor(3);

            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.tShirt.click();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            spengood.cartButton.click();
            ReusableMethods.waitFor(4);
            //6.Vendor View Cart a tiklar
            spengood.viewCart.click();
            Thread.sleep(3000);
            //8.Vendor acilan sayfada CONTINUE SHOPPING butonunu görür
            spengood.continueShopping.isDisplayed();
            Driver.closeDriver();

        }
        @Test
        public void test14() throws InterruptedException {
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            ReusableMethods.waitFor(2);
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            Thread.sleep(3000);
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //6.Vendor Cart a tiklar
            Thread.sleep(3000);
            spengood.cartButton.click();
            //6.Vendor View Cart a tiklar
            spengood.viewCart.click();
            Thread.sleep(3000);
            //8. Vendor acilan sayfada Clear Cart butonuna tiklar
            spengood.clearCartButton.click();
            //9. Vendor Your cart is currently empty yazisini görür
            Thread.sleep(3000);
            spengood.ClearTextYazisi.isDisplayed();
            //10.Cart a tiklayarak No Products in The Cart yazisini görür.
            Thread.sleep(3000);
            spengood.cartButton.click();
            Thread.sleep(3000);
            spengood.cartNoProductsYazisi.isDisplayed();
            Driver.closeDriver();

        }
    }








