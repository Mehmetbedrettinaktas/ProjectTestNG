package tests;

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
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

public class US009_TC002 extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException, IOException {

        SpendingGoodPage spengood = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("Pozitif Test","Urun teslimat suresi girildi fakat urun hacmi belirlenemedi");

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

        //    11- Vendor 'Processing Time' sekmesine tiklar  ve urunu teslimat yapacagi sureyi secer
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spengood.processingTime.click();

        WebElement time = spengood.processingTime;
        Select select = new Select(time);

        List<WebElement> timeList = select.getOptions();
        int expectedSayi = 10;
        int actualSayi = timeList.size();
        Assert.assertEquals(expectedSayi, actualSayi);
        extentTest.info("Processing Time sekmesine tiklandi ve urunu teslimat yapacagi sure secildi");

        Thread.sleep(2000);

        //    12- Vendor urun hacmini belirler
        String actualText = spengood.shippingClass.getText();
        String expectedText = "Volume";
        Assert.assertNotEquals(expectedText, actualText);
        extentTest.info("Urun hacmi belirlenemedi");


        Driver.closeDriver();

    }
}

