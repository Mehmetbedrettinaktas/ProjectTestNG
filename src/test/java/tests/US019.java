package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US019 extends TestBaseRapor {

    //US_19 TC01-->Vendor olarak takipcilerimin isimlerini,email adreslerini ve islemlerini görmeyelim

    //1.Vendor  "http://spendinggood.com/"  adresine  gider
    //2.Vendor 'Sign In' a tıklar
    //3.Vendor  gecerli Username girer
    //4.Vendor Password girer
    //5.Vendor 'SIGN IN' butonuna tiklar
    //6.Vendor 'My Account' a tiklar
    //7.Vendor 'Store Manager' a tiklar
    //8.Vendor 'Followers' a tiklar
    //9.Vendor takipcilerin  isimlerini(Name) görür
    //10.Vendor takipcilerin  Email adreslerini(Email) görür
    //11.Vendor takipcilerin islemlerini(Actions) görür


    @Test
    public void test01() throws IOException {
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Takipciler ", "Takipcilerin bilgileri");
        //1 Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a tıklar
        spendingGoodPage.signIn1.click();
        extentTest.info("SignIn butonuna basildi");
        //3.Vendor  gecerli Username girer
        //4.Vendor gecerli Password girer
        //5.Vendor 'SIGN IN' butonuna tiklar
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        extentTest.info("Gecerli Username girildi");
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Gecerli password girildi ve SIGN IN  butonuna tiklandi");
        ReusableMethods.waitFor(2);
        //6.Vendor 'My Account' a tiklar
        spendingGoodPage.myAccount.click();
        extentTest.info("My Account'a tiklandi");
        //7.Vendor 'Store Manager' a tiklar
        spendingGoodPage.storeManager.click();
        extentTest.info("Store Manager'a tiklandi");
        //8.Vendor 'Followers' a tiklar
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendingGoodPage.followers);
        jse.executeScript("arguments[0].click()", spendingGoodPage.followers);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("Bug01_");
        extentTest.info("Followers'a tiklandi");
        //9. Vendor takipcilerin  isimlerini(Name) görür
        String actualFollowers1 = spendingGoodPage.nameEmailActions.getText();
        String expectedFollewers1 = "No data in the table";
        softAssert.assertEquals(actualFollowers1, expectedFollewers1);
        extentTest.info("Takipcilerin isimleri görüntülenemedi");
        //10.Vendor takipcilerin  Email adreslerini(Email) görür
        String actualFollowers2 = spendingGoodPage.nameEmailActions.getText();
        String expectedFollewers2 = "No data in the table";
        softAssert.assertEquals(actualFollowers2, expectedFollewers2);
        extentTest.info("Takipcilerin Email adresleri görüntülenemedi");
        ReusableMethods.getScreenshot("Bug02_");
        //11.Vendor takipcilerin islemlerini(Actions) görür
        String actualFollowers3 = spendingGoodPage.nameEmailActions.getText();
        String expectedFollewers3 = "No data in the table";
        softAssert.assertEquals(actualFollowers3, expectedFollewers3);
        extentTest.info("Takipcilerin islemleri görüntülenemedi");
        softAssert.assertAll();
        extentTest.fail("Bug var:Takipcilerin isimleri, email adresleri ve islemleri görüntülenemedi");
        ReusableMethods.getScreenshot("Bug03_");
        Driver.closeDriver();


    }
}