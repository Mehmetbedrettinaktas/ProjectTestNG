package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;



import java.time.Duration;

public class US001 extends TestBaseRapor {


    @Test (priority = 1)
    public void Registration ()  {

        SpendingGoodPage page = new SpendingGoodPage();

        //1 - vendor http://spendinggood.com// sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

        //2 -  Register simgesine tiklar
        SpendingGoodPage.register.click();

        //3 - Acilan pencerede Becamo a vendor butonuna tiklar
        SpendingGoodPage.BecomeVendor.click();

        //4 - Registration'in email , password , confirm pasword gorunur oldugunu dogrular
        Assert.assertTrue(SpendingGoodPage.EmailBox.isDisplayed()
                && SpendingGoodPage.PasswordBox.isDisplayed()
                && SpendingGoodPage.ConfirmPwdBox.isDisplayed());


        //5 - Gecerli email adresi girer
        //6 - Email adresine gelen dogrulama kodunu verfication code'a girer
        VerificationCode.getEmailCode();

        //7 - Gecerli  password  ve ayni sifreyi confirm password'e girer ve Register Butonuna tiklar

        SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("password"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("confirmpassword")).sendKeys(Keys.ENTER).perform();


        //8 - Registration Successfully Completed. mesajinin goruntulendigini dogrular
        Assert.assertTrue(SpendingGoodPage.registrationSuccessfully.isDisplayed());
        ReusableMethods.waitFor(2);


        //9 Not Right now butonuna tiklar
        SpendingGoodPage.notRightNowButton.click();

        //10- Store Manager'in goruntulendigini dogrular
        Assert.assertTrue(SpendingGoodPage.storeManagerTitle.isDisplayed());

        // 11 Logout simgesine tiklar
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", SpendingGoodPage.LogoutButton);
        jse.executeScript("arguments[0].click()", SpendingGoodPage.LogoutButton);

        Driver.quitDriver();


    }

        @Test(priority = 2)
              public void bosEmail () throws InterruptedException {
            SpendingGoodPage page = new SpendingGoodPage();
            ReusableMethods.waitFor(2);
            extentTest = extentReports.createTest("BosEmail", "Kullanici Hesap Acma islemlerini yaparken Email kutusunu bos birakmamali");
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));

            extentTest.info("Spendinggood anasayfaya gidildi");

            SpendingGoodPage.register.click();
            extentTest.info("Register butonuna tiklandi");
            SpendingGoodPage.BecomeVendor.click();
            extentTest.info("Become a Vendor butonuna tiklandi");

            SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("password"));
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("confirmpassword")).sendKeys(Keys.ENTER).perform();

            Thread.sleep(2000);
            extentTest.info("Email kutusu bos birakildi password ve confirm password girilerek Register butonuna tiklandi");

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
            extentTest.info("ExplicitlyWait methodu kullanildi");

            Assert.assertTrue(SpendingGoodPage.bosEmailHataMesaji.isDisplayed());
            ReusableMethods.waitFor(4);
            extentTest.pass("Email kutusu bos birakildiginda ekranda hata mesaji ciktigi goruntulendi");
            extentTest.pass("Email yazilmadigindan dolayi register yapilamadi");
            Driver.closeDriver();

        }

        @Test(priority = 3)
        public void gecersizEmail () throws InterruptedException {
            SpendingGoodPage page = new SpendingGoodPage();
            extentTest = extentReports.createTest("GecersizEmail", "Kullanici Hesap Acma islemlerini yaparken gecerli bir Email girmeli");
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            extentTest.info("Spendinggood anasayfaya gidildi");

            SpendingGoodPage.register.click();
            extentTest.info("Register butonuna tiklandi");
            ReusableMethods.waitFor(3);
            SpendingGoodPage.BecomeVendor.click();
            extentTest.info("Become a Vendor butonuna tiklandi");


            SpendingGoodPage.EmailBox.sendKeys(ConfigReader.getProperty("WrongEmail"));
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.TAB)
                    .sendKeys("confirmpassword")
                    .sendKeys(Keys.ENTER).perform();
            extentTest.info("Gecersiz Email girildi ve Register butonuna tiklandi");

            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
            extentTest.info("ExplicitlyWait methodu kullanildi");

            Assert.assertTrue(SpendingGoodPage.gecersizEmailHataMesaji.isDisplayed());//
            extentTest.pass("Gecersiz Email girildiginde ekranda hata mesaji ciktigi goruntulendi");
            extentTest.pass("Gecersiz email girildiginden dolayi Register olunamadi");

            Driver.closeDriver();

        }


        @Test(priority = 4)
        public void GecersizPassword () throws InterruptedException {
            SpendingGoodPage page = new SpendingGoodPage();
            extentTest = extentReports.createTest("GecersizPassword", "Kullanici Gulch Password girmeden Vendor hesabi olusturamamali");
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));
            extentTest.info("Spendinggood anasayfaya gidildi");

            SpendingGoodPage.register.click();
            Thread.sleep(3000);
            extentTest.info("Register butonuna tiklandi");

            SpendingGoodPage.BecomeVendor.click();
            extentTest.info("Become a Vendor butonuna tiklandi");

            Actions actions = new Actions(Driver.getDriver());
            Faker faker = new Faker();
            String fakeMail = faker.internet().emailAddress();
            actions.click(SpendingGoodPage.EmailBox)
                    .sendKeys(fakeMail)
                    .sendKeys(Keys.TAB)
                    .perform();
            extentTest.info("email kutusu butonuna tiklandi ve faker class ile unique ve gecerli bir email girildi");

            SpendingGoodPage.PasswordBox.sendKeys(ConfigReader.getProperty("WrongPassword"));
            actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("WrongConfirmPassword")).sendKeys(Keys.TAB)
                    .sendKeys(Keys.ENTER).perform();
            extentTest.info("Password ve Confirm Password kutusuna Gulch olmayan sifre girildi");
            ReusableMethods.waitFor(4);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
            extentTest.info("ExplicitlyWait methodu kullanildi");

            extentTest.pass("Kullanici Gulch Password girmedigi icin register yapilamadi");


            Driver.closeDriver();



        }

    }




