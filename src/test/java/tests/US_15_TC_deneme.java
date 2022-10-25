package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.io.IOException;

public class US_15_TC_deneme  {

    SpendingGoodPage spendinGoodPage = new SpendingGoodPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test(priority = 1)
    public void testTC_01() throws InterruptedException, IOException {
        //1.Store Manager  https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(3000);
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
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement kupon = spendinGoodPage.coupons;
        jse.executeScript("arguments[0].scrollIntoView(true);", kupon);
        jse.executeScript("arguments[0].click();", kupon);
        //spendinGoodPage.coupons.click();
        //8.Coupons sayfasinda Add New'i tiklar
        Thread.sleep(1000);
        spendinGoodPage.addNeww.click();
        //9.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC15001");
        //10.Limit butonuna tiklar
        WebElement limit = spendinGoodPage.limitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", limit);
        jse.executeScript("arguments[0].click();", limit);
        //spendinGoodPage.limitButton.click();
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
        jse.executeScript("arguments[0].scrollIntoView(true);", limit);
        jse.executeScript("arguments[0].click();", limit);
        //spendinGoodPage.limitButton.click();
        //17.Usage limit per coupon kutusundaki girilen miktarin istenen degere esit oldugunu test eder
        Thread.sleep(1000);
        Assert.assertEquals(spendinGoodPage.limitPerCoupon.getAttribute("value"), "3");
        //ReusableMethods.getScreenshotWebElement("LimitTabloPer", spendinGoodPage.limitPerCoupon);
        Thread.sleep(1000);
        //18.Limit usage to X items kutusundaki girilen miktarin istenen degere esit oldugunu test eder
        Assert.assertEquals(spendinGoodPage.limitUsageXitems.getAttribute("value"), "5");
       // ReusableMethods.getScreenshotWebElement("LimitTabloXitem", spendinGoodPage.limitUsageXitems);
        Thread.sleep(1000);
        //19.User limit per User kutusundaki girilen miktarin istenen degere esit oldugunu test eder
        Assert.assertEquals(spendinGoodPage.limitperUser.getAttribute("value"), "2");
      //  ReusableMethods.getScreenshotWebElement("LimitTabloUser", spendinGoodPage.limitperUser);
        Thread.sleep(1000);

        //ReusableMethods.getScreenshotWebElement("LimitTablo", spendinGoodPage.limitFoto);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //  ReusableMethods.getScreenshot("LimitTablo");
        Thread.sleep(1000);
       // extentTest=extentReports.createTest("Pozitif Test","Store Manager kuponlara limitlemeler yapabilmeli");
       // extentTest.pass("Kuponda limitlemeler uygulanabiliyor");
        Thread.sleep(1000);

        jse.executeScript("arguments[0].scrollIntoView(true);", kupon);
        jse.executeScript("arguments[0].click();", kupon);

        for (int i = 0; i <1 ; i++) {
            WebElement dlt = spendinGoodPage.delete;
            jse.executeScript("arguments[0].scrollIntoView(true);", dlt);
            jse.executeScript("arguments[0].click();", dlt);
            Driver.getDriver().switchTo().alert().accept();
            Thread.sleep(2000);
        }
        Driver.closeDriver();


    }
}
