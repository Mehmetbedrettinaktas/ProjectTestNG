package us8Akin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C03 extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException, IOException {

        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("Pozitif Test","Urun agirlik ve boyutlari girildi");

        //   1- Vendor http://spendinggood.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("http://spendinggood.com/ sayfasina gidildi");

        //   2- Vendor acilan pencereden sign in simgesine tiklar
        spengood.signIn.click();
        extentTest.info("Sign in simgesine tiklandi");

        //   3- Vendor username or email address alanina gecerli bir kullanici adi veya email girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"), Keys.ENTER);
        extentTest.info("Username or email address alanina gecerli bir kullanici adi veya email gidildi");

        //   4- Vendor password alanina gecerli bir sifre girer
        //   5- Vendor 'Sign in' butonuna tiklar
        spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
        extentTest.info("Password alanina gecerli bir sifre girildi");
        extentTest.info("Sign in butonuna tiklandi");

        Thread.sleep(3000);

        //   6- Vendor acilan sayfada 'My Account' simgesine tiklar
        spengood.myAccount.click();
        extentTest.info("My Account simgesine tiklandi");

        //   7- Vendor "Store Manager" baslikli simgeyi tiklar
        spengood.storeManager.click();
        extentTest.info("Store Manager baslikli simgeyi tiklandi");

        //   8- Vendor acilan yeni sayfada 'Products' basligini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spengood.products.click();
        extentTest.info("Products basligini tiklandi");

        //   9- Vendor bir urunun uzerine tiklar
        WebElement gateaway = spengood.gateaway;
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", gateaway);
        jse.executeScript("arguments[0].click();", gateaway);

        extentTest.info("Bir urunun uzerine tiklandi");

        //    10- Vendor 'Shipping' simgesine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spengood.shipping.click();
        extentTest.info("Shipping simgesine tiklandi");

        //   11- Vendor 'Weight' alanina paketin agirligini kilogram cinsinden  girer
        spengood.weight.clear();
        spengood.weight.sendKeys(ConfigReader.getProperty("agirlik"));
        extentTest.info("Weight alanina paketin agirligi kilogram cinsinden girildi");

        //   12- Vendor 'Dimensions' alanina sirasiyla uzunluk,genislik ve yukseklik  degerlerini cm cisinden girer

        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("uzunluk")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("genislik")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("yukseklik")).perform();
        extentTest.info("Dimensions alanina sirasiyla uzunluk,genislik ve yukseklik  degerleri cm cisinden girildi");

        ReusableMethods.getScreenshot("Volume");

        //   13- Vendor submit butonuna tiklar
        WebElement submit = spengood.submit;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        extentTest.info("Submit butonuna tiklandi");

        //   14- Vendor "Product Successfully Published." yazisini gorur
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(spengood.yazi));
        Assert.assertTrue(spengood.yazi.isDisplayed());
        extentTest.pass("Product Successfully Published. yazisi goruldu");

        Driver.closeDriver();

    }
}
