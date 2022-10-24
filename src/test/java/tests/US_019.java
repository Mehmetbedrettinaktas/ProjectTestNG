package tests;

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

public class US_019 extends TestBaseRapor {

    //1 Vendor  "http://spendinggood.com/"  adresine  gider
    //2 Vendor 'Sign In' a tıklar
    //3.Vendor  gecerli Username girer
    //4.Vendor Password girer
    //5.Vendor 'SIGN IN' butonuna tiklar
    //6.Vendor 'My Account' a tiklar
    //7.Vendor 'Store Manager' a tiklar
    //8.Vendor 'Followers' a tiklar
    //9. Vendor takipcilerin  isimlerini(Name) görür
    //10.Vendor takipcilerin  Email adreslerini(Email) görür
    //11.Vendor takipcilerin islemlerini(Actions) görür


    @Test
    public void test01() throws IOException {
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();
        // US_19 TC01-->Vendor olarak takipcilerimin isimlerini,email adreslerini ve islemlerini görmeyelim
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Store Manager'a tiklandi");
        //8.Vendor 'Followers' a tiklar
        ReusableMethods.waitFor(2);
        spendingGoodPage.followers.click();
        extentTest.info("Followers'a tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //9. Vendor takipcilerin  isimlerini(Name) görür
        String actualFollowers1 = spendingGoodPage.nameEmailActions.getText();
        String expectedFollewers1 = "No data in the table";
        softAssert.assertNotEquals(actualFollowers1, expectedFollewers1, "Takipcilerin isimleri gorulemedi");
        extentTest.info("Takipcilerin isimleri görüldü");
        //10.Vendor takipcilerin  Email adreslerini(Email) görür
        String actualFollowers2 = spendingGoodPage.nameEmailActions.getText();
        String expectedFollewers2 = "No data in the table";
        softAssert.assertNotEquals(actualFollowers2, expectedFollewers2, "Takipcilerin Email adresleri gorulemedi");
        extentTest.info("Takipcilerin Email adresleri görüldü");
        //11.Vendor takipcilerin islemlerini(Actions) görür
        String actualFollowers3 = spendingGoodPage.nameEmailActions.getText();
        String expectedFollewers3 = "No data in the table";
        softAssert.assertNotEquals(actualFollowers3, expectedFollewers3, "Takipcilerin islemleri gorulemedi");
        extentTest.info("Takipcilerin islemleri görüldü");
        softAssert.assertAll();
        extentTest.pass("Takipcilerin bilgileri görüldü");

        Driver.closeDriver();


    }

}

