package US;

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

public class US_015_TC001 {

    SpendingGoodPage spendinGoodPage = new SpendingGoodPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test(priority = 1)
    public void testTC_01() throws InterruptedException {
        //1.Store Manager  https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(2000);
        //2.Sign in Butonuma Tiklar
        spendinGoodPage.signIn.click();
        //3.Gecerli Email ve Password girer
        spendinGoodPage.eMailButton.sendKeys(ConfigReader.getProperty("userName"));
        spendinGoodPage.password.sendKeys(ConfigReader.getProperty("pass"));
        //4.sign in Butonuna tiklar
        spendinGoodPage.signInButton.click();
        //5.My Account butonuna tiklar
        Thread.sleep(3000);
        spendinGoodPage.myAccount.click();
        //6.Store Manager butonuna tiklar
        spendinGoodPage.storeManager.click();
        //7.Store manager sayfasinda Coupons‘ u tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.coupons.click();
        //8.Coupons sayfasinda Add New'i tiklar
        spendinGoodPage.addNeww.click();
        //9.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC150001");
        //10.Limit butonuna tiklar
        spendinGoodPage.limitButton.click();
        //11.Usage limit per coupon kutusuna istenen limit miktarini yazar
        spendinGoodPage.limitPerCoupon.sendKeys("3");
        //12.Limit usage to X items kutusuna istenen limit miktarini yazar
        spendinGoodPage.limitUsageXitems.sendKeys("5");
        //13.Usage limit per user kutusuna istenen limit miktarini yazar
        spendinGoodPage.limitperUser.sendKeys("2");
        //14.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //15.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(3000);
        //16.limit butonunu tiklar
        spendinGoodPage.limitButton.click();
        //17.Usage limit per coupon kutusundaki girilen miktarin istenen degere esit oldugunu test eder
        Assert.assertEquals(spendinGoodPage.limitPerCoupon.getAttribute("value"), "3");
        //18.Limit usage to X items kutusundaki girilen miktarin istenen degere esit oldugunu test eder
        Assert.assertEquals(spendinGoodPage.limitUsageXitems.getAttribute("value"), "5");
        //19.User limit per User kutusundaki girilen miktarin istenen degere esit oldugunu test eder
        Assert.assertEquals(spendinGoodPage.limitperUser.getAttribute("value"), "2");

    }
}
