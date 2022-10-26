package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US021 {

    //1 Vendor  "http://spendinggood.com/"  adresine  gider
    //2 Vendor 'Sign In' a tıklar
    //3.Vendor  gecerli Username girer
    //4.Vendor gecerli Password girer
    //5.Vendor 'SIGN IN' butonuna tiklar
    //6.Vendor 'My Account' a tiklar
    //7.Vendor 'Store Manager' a tiklar
    //8.Vendor ' Reports' a tiklar..
    //9.Vendor yilik raporlari (Year) görüntüleyebilmeli
    //10.Vendor en son ay raporunu(Last Month) görüntüleyebilmeli
    //11.Vendor  mevcut ay raporunu(This Month) görüntüleyebilmeli
    //12.Vendor  son 7 gün raporunu(Last 7 Days) görüntüleyebilmeli
    //13.Vendor specific bir tarih araliginda rapor görüntüleyebilmeli
    @Test
    public void test01() {
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        //1 Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2 Vendor 'Sign In' a tıklar
        spendingGoodPage.signIn1.click();
        //3.Vendor  gecerli Username girer
        //4.Vendor gecerli Password girer
        //5.Vendor 'SIGN IN' butonuna tiklar
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        //6.Vendor 'My Account' a tiklar
        spendingGoodPage.myAccount.click();
        //7.Vendor 'Store Manager' a tiklar
        spendingGoodPage.storeManager.click();
        //8.Vendor ' Reports' a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.reports.click();
        //9.Vendor yilik raporlari (Year) görüntüleyebilmeli
        spendingGoodPage.reportsyear.click();
        Assert.assertTrue(spendingGoodPage.rapor.isDisplayed());
        //10.Vendor en son ay raporunu(Last Month) görüntüleyebilmeli
        spendingGoodPage.lastmonth.click();
        Assert.assertTrue(spendingGoodPage.rapor.isDisplayed());
        //11.Vendor  mevcut ay raporunu(This Month) görüntüleyebilmeli
        spendingGoodPage.thismonath.click();
        Assert.assertTrue(spendingGoodPage.rapor.isDisplayed());
        //12.Vendor  son 7 gün raporunu(Last 7 Days) görüntüleyebilmeli
        spendingGoodPage.last7days.click();
        Assert.assertTrue(spendingGoodPage.rapor.isDisplayed());
        //13.Vendor specific bir tarih araliginda rapor görüntüleyebilmeli
        spendingGoodPage.custom.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        spendingGoodPage.date1.click();
        ReusableMethods.waitFor(2);
        spendingGoodPage.date2.click();
        Assert.assertTrue(spendingGoodPage.rapor.isDisplayed());
        Driver.closeDriver();
    }
}
