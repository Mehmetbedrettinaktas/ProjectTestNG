package US;

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

public class US001_NegatifTestler extends TestBaseRapor {


    SpendingGoodPage spendingGoodPage = new SpendingGoodPage();

    @Test (priority = 1)
    public void bosEmail() throws InterruptedException {
        extentTest=extentReports.createTest("BosEmail","Kullanici Hesap Acma islemlerini yaparken Email kutusunu bos birakmamali");
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

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");

        Assert.assertTrue(SpendingGoodPage.bosEmailHataMesaji.isDisplayed());
        ReusableMethods.waitFor(4);
        extentTest.pass("Email kutusu bos birakildiginda ekranda hata mesaji ciktigi goruntulendi");
        extentTest.pass("Email yazilmadigindan dolayi register yapilamadi");
        Driver.getDriver().navigate().refresh();

    }

    @Test (priority = 2)
    public void gecersizEmail() throws InterruptedException {
        extentTest=extentReports.createTest("GecersizEmail","Kullanici Hesap Acma islemlerini yaparken gecerli bir Email girmeli");
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
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");

        Assert.assertTrue(SpendingGoodPage.gecersizEmailHataMesaji.isDisplayed());//
        extentTest.pass("Gecersiz Email girildiginde ekranda hata mesaji ciktigi goruntulendi");
        extentTest.pass("Gecersiz email girildiginden dolayi Register olunamadi");

        Driver.getDriver().navigate().refresh();

    }



    @Test (priority = 3)
    public void GecersizPassword() throws InterruptedException {
        extentTest=extentReports.createTest("GecersizPassword","Kullanici Gulch Password girmeden Vendor hesabi olusturamamali");
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("Spendinggood anasayfaya gidildi");

       SpendingGoodPage.register.click();
        Thread.sleep(3000);
        extentTest.info("Register butonuna tiklandi");

        SpendingGoodPage.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tiklandi");

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();
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
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        extentTest.info("ExplicitlyWait methodu kullanildi");

        extentTest.pass("Kullanici Gulch Password girmedigi icin register yapilamadi");

        //  Driver.closeDriver();

    }

}





