package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_03 extends TestBaseRapor{


        SpendingGoodPage spengood=new SpendingGoodPage();
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        @Test(priority = 1)
        public void test01() throws InterruptedException {
            extentTest = extentReports.createTest("TC_001", "Orders da Browse products/ Go Shop a gidilmeli.");

            //1. Vendor "url" adresine gider 1. Vendor "url" adresine gider

            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            ReusableMethods.waitFor(2);
            extentTest.info("url adresine gidildi");
            // Vendor sign in butonuna tiklar
            spengood.signIn.click();
            extentTest.info("signin butonuna tiklandi");
            // Vendor gecerli bir username veya email adresi girer
            //Vendor gecerli bir password girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
            extentTest.info("Kullanici adi ve password girildi");
            //Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            spengood.userpassSignIn.click();
            // Vendor acilan sayfada My Account butonuna tiklar
            Thread.sleep(3000);
            spengood.myAccount.click();
            extentTest.info("My Account butonuna tiklandi");
            // Vendor My Account altinda Orders butonuna tiklar
            spengood.orders.click();
            extentTest.info("Orders a tiklandi");
            // Vendor acilan Orders sayfasinda BROWSE PRODUCTS a tiklar
            Thread.sleep(3000);
            WebElement submit = Driver.getDriver().
                    findElement(By.xpath("//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']"));
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", submit);
            jse.executeScript("arguments[0].click();", submit);
            extentTest.info("Go Shop a tiklanarak urunler sayfasina giris yapildi");
        }


        @Test(priority = 2)

        public void test2() throws InterruptedException {
            extentTest = extentReports.createTest("TC_002", "5 urun secilmeli ve Secilen ürünler tek tek sepete aktarılmalı.");
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions = new Actions(Driver.getDriver());

            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //6. Vendor acilan sayfada My Account butonuna tiklar
            spengood.myAccount.click();
            Thread.sleep(3000);
            //7. Vendor My Account altinda Orders butonuna tiklar
            spengood.orders.click();
            Thread.sleep(3000);
            //8. Vendor acilan Orders sayfasinda Brwse Products/Go Shop a tiklar
            WebElement submit = Driver.getDriver().
                    findElement(By.xpath("//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']"));
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", submit);
            jse.executeScript("arguments[0].click();", submit);
            extentTest.info("Urunler sayfasina girildi");
            //9.Vendor ürünler sayfasindan 5 adet ürün secer ve sectigi ürünleri tek tek sepete ekler

            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.tShirt.click();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            extentTest.info("Sepete T-Shirt eklendi");


            spengood.search.sendKeys("super kahraman oyuncak", Keys.ENTER);
            ReusableMethods.waitFor(2);
            spengood.superKahramanOyuncak.click();
            ReusableMethods.waitFor(2);
            actions.sendKeys(Keys.PAGE_UP).perform();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            extentTest.info("Sepete super kahraman oyuncak eklendi");

            spengood.search.sendKeys("hoparlor", Keys.ENTER);
            ReusableMethods.waitFor(2);
            spengood.hoparlor.click();
            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            extentTest.info("Sepete hoparlör eklendi");

            spengood.search.sendKeys("Arcelik", Keys.ENTER);
            ReusableMethods.waitFor(2);
            spengood.arcelik.click();
            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            extentTest.info("Sepete arcelik eklendi");


            spengood.search.sendKeys("kalemlik", Keys.ENTER);
            ReusableMethods.waitFor(2);
            spengood.kalemlik.click();
            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            extentTest.info("Sepete kalemlik eklendi");
            extentTest.info("Sepete toplamda 5 adet ürün eklendi");
            Driver.closeDriver();


        }


        @Test (priority = 3)

        public void test3() throws InterruptedException {
            extentTest = extentReports.createTest("TC_003", "Sepete ve ordan checkout a gidilmeli.");
            SpendingGoodPage spengood = new SpendingGoodPage();
            Actions actions=new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //9.Vendor ürünler sayfasindan sepete urun ekler
            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.tShirt.click();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            //6.Vendor sepete tiklar
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(3);
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(3);
            spengood.cartButton.click();
            Thread.sleep(3000);
            //7.Vendor CHECKOUT butonunu görür ve tiklar
            spengood.checkout.click();
            Driver.closeDriver();

        }
        @Test(priority = 4)
        public void test04() {
            extentTest = extentReports.createTest("TC_003", "Tum address bilgileri tam olarak girilmeli.");
            SpendingGoodPage spengood=new SpendingGoodPage();
            Actions actions=new Actions(Driver.getDriver());
            Faker faker=new Faker();
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            ReusableMethods.waitFor(3);
            //9.Vendor ürünler sayfasindan  ürün secer ve sectigi ürünü sepete ekler
            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(2);
            spengood.tShirt.click();
            ReusableMethods.waitFor(2);
            spengood.plus.click();
            spengood.addToCart.click();
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(2);
            extentTest.info("Sepete urun eklendi");
            //6.Vendor sepete tiklar
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(3);
            spengood.cartButton.click();
            ReusableMethods.waitFor(3);
            extentTest.info("Sepete tiklendi");
            //7. Vendor chockout a tiklar
            spengood.checkout.click();
            extentTest.info("Checkout a tiklandi");
            //8. Vendor acilan sayfada BILLING DETAILS e gelir
            //9. VendorFirst name,Last name,Company name bilgilerini girer
            spengood.firstName.clear();
            spengood.firstName.sendKeys("Ahmet4");
            spengood.lastName.clear();
            spengood.lastName.sendKeys("Tahmin4");
            spengood.companyName.clear();
            spengood.companyName.sendKeys("Mercedes4");
            //10.Vendor Country e tiklar ve ülke secer

            WebElement ddm = spengood.country;
            Select options = new Select(ddm);
            options.selectByVisibleText("Germany");
            //11.Vendor Town/City,State,Zip Code,State,Email address bilgilerini eksiksiz doldurur
            spengood.postcode.clear();
            spengood.postcode.sendKeys("21325");
            spengood.town.clear();
            spengood.town.sendKeys("Stuttgart");
            WebElement ddm2 = spengood.state;
            Select options2 = new Select(ddm2);
            options2.selectByIndex(2);
            spengood.phone.clear();
            spengood.phone.sendKeys("01732154679");
            spengood.emailCheckout.clear();
            spengood.emailCheckout.sendKeys(ConfigReader.getProperty("email"));
            //12. Vendor eger isterse Order notes yazar
            spengood.orderNotes.sendKeys("Adres bilgileri tam dolduruldu",Keys.ENTER);
            extentTest.info("Adres bilgileri eksiksiz dolduruldu");
            Driver.closeDriver();

        }

        @Test(priority = 5)
        public void test5() throws InterruptedException {
            extentTest = extentReports.createTest("TC_003",
                    "Billing bilgileri tam olarak eklenmeli ve place order diyerek order yapılmalı ");
            SpendingGoodPage spengood=new SpendingGoodPage();
            Actions actions=new Actions(Driver.getDriver());
            //1. Vendor "url" adresine gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            //2. Vendor sign in butonuna tiklar
            spengood.signIn.click();
            //3. Vendor gecerli bir username veya email adresi girer
            spengood.userName.sendKeys(ConfigReader.getProperty("user"));
            //4.Vendor gecerli bir password girer
            spengood.password.sendKeys(ConfigReader.getProperty("pass"));
            //5.Vendor SIGN IN butonuna tiklar
            spengood.userpassSignIn.click();
            Thread.sleep(3000);
            //6. Vendor Search alaninda T-Shirt aratir ilk cikan ilk Tshirt i secer
            spengood.search.sendKeys("T-Shirt", Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(3000);
            spengood.tShirt.click();
            //7. Tshirt adedini 2 secer
            spengood.plus.click();
            //8.Vendor   'ADD TO CART'a tiklar
            spengood.addToCart.click();
            //9.Vendor  'CART' butonuna tiklar
            spengood.cart.click();
            Thread.sleep(3000);
            //  7. Vendor chockout a tiklar
            spengood.checkout.click();
            //  8. Vendor BILLING DETAILS e gelir ve adress bilgilerini eksiksiz girer
            spengood.firstName.clear();
            spengood.firstName.sendKeys("Ahmet4");
            spengood.lastName.clear();
            spengood.lastName.sendKeys("Tahmin4");
            spengood.companyName.clear();
            spengood.companyName.sendKeys("Mercedes4");
            WebElement ddm = spengood.country;
            Select options = new Select(ddm);
            options.selectByVisibleText("Germany");

            spengood.postcode.clear();
            spengood.postcode.sendKeys("21325");
            spengood.town.clear();
            spengood.town.sendKeys("Stuttgart");

            WebElement ddm2 = spengood.state;
            Select options2 = new Select(ddm2);
            options2.selectByIndex(2);
            spengood.phone.clear();
            spengood.phone.sendKeys("01732154679");
            spengood.emailCheckout.clear();
            spengood.emailCheckout.sendKeys(ConfigReader.getProperty("email"));

            //  9. Vendor YOUR ORDER bölümüne gelir,Payment Methods u secer ,PLACE ORDER a tiklarS
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(3);
            if (!spengood.payAtTheDoor.isSelected()) {
                spengood.payAtTheDoor.click();
            }
            ReusableMethods.waitFor(2);
            extentTest.info("Odeme bilgileri girildi");
            //12.Vendor 'PLACE ORDER' a tiklar
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", spengood.placeOrder);
            jse.executeScript("arguments[0].click()", spengood.placeOrder);
            //13. Vendor "Thank you. Your order has been received." yazisinin ciktigini dogrular
            String expectedThankYou = "Thank you. Your order has been received.";
            String actualThankYou = spengood.thankYou.getText();
            System.out.println(actualThankYou);
            Assert.assertEquals(expectedThankYou, actualThankYou);
            extentTest.info("Place Ordera tiklandi");
            extentTest.info("Thank you. Your order has been received yazisi goruldu");
            Driver.closeDriver();

        }
    }


