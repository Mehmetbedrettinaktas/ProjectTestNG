package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_018 extends TestBaseRapor {

    static SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
    static Actions actions = new Actions(Driver.getDriver());
    static SoftAssert softAssert = new SoftAssert();
    static int requestIDlistSize;
    static int orderIDlistSize;
    static int amountSListSize;
    static int typeListSize;
    static int reasonListSize;

    static {
        refundSizeMethod();
        urunEklemeMethod();

    }

    public static void refundSizeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("spendinggood"));
        ReusableMethods.waitFor(5);
        spendingGoodPage.signIn1.click();
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        spendingGoodPage.myAccount.click();
        spendingGoodPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.refund.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.nextButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
        requestIDlistSize = spendingGoodPage.requestIDlist.size();
        System.out.println("Eski requestIDlistSize= " + spendingGoodPage.requestIDlist.size());
        orderIDlistSize = spendingGoodPage.orderIDlist.size();
        System.out.println("Eski orderIDlistSize= " + spendingGoodPage.orderIDlist.size());
        amountSListSize = spendingGoodPage.amountList.size();
        System.out.println("Eski amountListSize= " + spendingGoodPage.amountList.size());
        typeListSize = spendingGoodPage.typeIDlist.size();
        System.out.println("Eski typeIDlistSize= " + spendingGoodPage.typeIDlist.size());
        reasonListSize = spendingGoodPage.reasonList.size();
        System.out.println("Eski reasonSlistSize= " + spendingGoodPage.reasonList.size());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendingGoodPage.LogoutButton);
        jse.executeScript("arguments[0].click()", spendingGoodPage.LogoutButton);


    }


    public static void urunEklemeMethod() {

        Driver.getDriver().get(ConfigReader.getProperty("spendinggood"));
        ReusableMethods.waitFor(5);
        spendingGoodPage.signIn1.click();
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        spendingGoodPage.search.sendKeys("T-Shirt", Keys.ENTER);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        spendingGoodPage.tShirt.click();
        ReusableMethods.waitFor(2);
        spendingGoodPage.plus.click();
        spendingGoodPage.addToCart.click();
        spendingGoodPage.cart.click();
        spendingGoodPage.checkout.click();
        ReusableMethods.waitFor(3);
        spendingGoodPage.firstName.clear();
        spendingGoodPage.firstName.sendKeys(Faker.instance().name().firstName());
        spendingGoodPage.lastName.clear();
        spendingGoodPage.lastName.sendKeys(Faker.instance().name().lastName());
        spendingGoodPage.companyName.clear();
        spendingGoodPage.companyName.sendKeys("Mercedes");
        WebElement ddm = spendingGoodPage.country;
        Select options = new Select(ddm);
        options.selectByVisibleText("Germany");
        spendingGoodPage.streetAddress.clear();
        spendingGoodPage.streetAddress.sendKeys("20");
        spendingGoodPage.streetAddress_2.clear();
        spendingGoodPage.streetAddress_2.sendKeys("C");
        spendingGoodPage.postcode.clear();
        spendingGoodPage.postcode.sendKeys("36457");
        spendingGoodPage.town.clear();
        spendingGoodPage.town.sendKeys("Stuttgart");
        WebElement ddm2 = spendingGoodPage.state;
        Select options2 = new Select(ddm2);
        options2.selectByIndex(1);
        spendingGoodPage.phone.clear();
        spendingGoodPage.phone.sendKeys("017321546788");
        spendingGoodPage.emailCheckout.clear();
        spendingGoodPage.emailCheckout.sendKeys(Faker.instance().internet().emailAddress());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendingGoodPage.payAtTheDoor.click();
        ReusableMethods.waitFor(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendingGoodPage.placeOrder);
        jse.executeScript("arguments[0].click()", spendingGoodPage.placeOrder);
        ReusableMethods.waitFor(2);
        String expectedThankYou = "Thank you. Your order has been received.";
        String actualThankYou = spendingGoodPage.thankYou.getText();
        System.out.println(actualThankYou);
        Assert.assertEquals(expectedThankYou, actualThankYou);
        spendingGoodPage.signOut.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        JavascriptExecutor js4 = (JavascriptExecutor) Driver.getDriver();
        js4.executeScript("arguments[0].click()", spendingGoodPage.logOut2);


    }


    @Test()
    public static void testTC01() {
        // US_18_TC01-->Vendor olarak gelen siparisi onaylayabilmeliyim
        extentTest = extentReports.createTest("Siparis onay", "Siparis edilen ürün onaylanmasi");
        //1 Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spendinggood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a tıklar
        spendingGoodPage.signIn1.click();
        extentTest.info("SignIn butonuna basildi");
        //3.Vendor  gecerli Username girer
        //4.Vendor gecerli Password girer
        //5.Vendor 'SIGN IN' butonuna tiklar
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Gecerli Username girildi");
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Gecerli password girildi ve SIGN IN  butonuna tiklandi");
        ReusableMethods.waitFor(2);
        //6.Vendor 'My Account' a tiklar
        spendingGoodPage.myAccount.click();
        extentTest.info("My Account'a tiklandi");
        //7.Vendor 'Store Manager' a tiklar
        spendingGoodPage.storeManager.click();
        extentTest.info("Store Manager'a tiklandi");
        //8.Vendor 'Orders a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.ordersStoreManager.click();
        extentTest.info("Orders'a tiklandi");
        //9.Vendor siparis listesindeki  siparis edilen ürünü onaylar("Mark as Complete"ye tiklar)
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(15);
        spendingGoodPage.markAsComplete.click();
        ReusableMethods.waitFor(5);
        extentTest.info("Mark as Complete'ye tiklandi");
        //10.Vendor cikan alert yazisini kabul eder.
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alert yazisi kabul edildi");
        //11.Vendor ürünü onayladigini dogrular
        ReusableMethods.waitFor(20);
        softAssert.assertTrue(spendingGoodPage.viewDetails.isDisplayed());
        extentTest.pass("Ürünün onaylandigi dogrulandi");
        softAssert.assertAll();
        //  extentTest.pass("Gelen siparis onaylandi");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", SpendingGoodPage.LogoutButton);
        jse.executeScript("arguments[0].click()", SpendingGoodPage.LogoutButton);


    }

    @Test(dependsOnMethods = "testTC01")
    public static void testTC02() {
        //US_18 TC_02-->Store manager olarak ürünü geri iade talebinde bulunabilabilmeliyim
        extentTest = extentReports.createTest("Iade talebi", "Siparis edilen ürünü geri iade talebinde bulunma");
        // Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spendinggood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a tıklar
        ReusableMethods.waitFor(3);
        spendingGoodPage.signIn1.click();
        // spendinGoodPage.signIn1.click();
        extentTest.info("SignIn butonuna basildi");
        //3.Vendor  gecerli Username girer
        //4.Vendor gecerli Password girer
        //5.Vendor 'SIGN IN' butonuna tiklar
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Gecerli Username girildi");
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Gecerli password girildi ve SIGN IN  butonuna tiklandi");
        ReusableMethods.waitFor(2);
        //6.Vendor 'My Account' a tiklar
        spendingGoodPage.myAccount.click();
        extentTest.info("My Account'a tiklandi");
        //7.Vendor 'Store Manager' a tiklar
        spendingGoodPage.storeManager.click();
        extentTest.info("Store Manager'a tiklandi");
        //8.Vendor 'Orders a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.ordersStoreManager.click();
        extentTest.info("Orders'a tiklandi");
        //9.Vendor onaylamis oldugu ürünün  'Refund Request' butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(20);
        spendingGoodPage.refundRequest.click();
        extentTest.info("Refund Request'a tiklandi");
        //10.Vendor acilan sayfada 'Full Refund'u secer
        ReusableMethods.waitFor(5);
        WebElement ddm = spendingGoodPage.requestMode;
        Select options = new Select(ddm);
        options.selectByIndex(0);
        extentTest.info("Full Refund  secildi");
        //11.Vendor  ürünü geri iade sebebini yazar
        spendingGoodPage.refundRequestsReason.sendKeys("Stokta ürün kalmadi");
        extentTest.info("Geri iade sebebi yazildi");
        //12.Vendor 'Submit' butonuna tiklar
        spendingGoodPage.submitRefund.click();
        extentTest.info("Submit butonuna tiklandi");
        //13.Vendor cikan yazinin "Refund requests successfully processed." oldugunu dogrular
        String expectedSucces = "Refund requests successfully processed.";
        String actualSucces = spendingGoodPage.refundSucces.getText();
        softAssert.assertEquals(expectedSucces, actualSucces);
        extentTest.pass("Refund requests successfully processed. yazisi dogrulandi");
        softAssert.assertAll();
        //   extentTest.pass("Geri iade etme talabinde bulunuldu");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", SpendingGoodPage.LogoutButton);
        jse.executeScript("arguments[0].click()", SpendingGoodPage.LogoutButton);


    }


    @Test(dependsOnMethods = "testTC02")
    public static void testTC03() {
        // US_18 TC_03-->Vendor olarak geri iade edilen ürünün RequestID,OrderID,Amount,Type ve Reason'u görebilmeliyim
        extentTest = extentReports.createTest("Iade bilgileri", "Iade edilen ürünün bilgilarini görüntüleme");
        //1 Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spendinggood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a tıklare
        ReusableMethods.waitFor(5);
        spendingGoodPage.signIn1.click();
        //3.Vendor  gecerli Username girer
        //4.Vendor gecerli Password girer
        //5.Vendor 'SIGN IN' butonuna tiklar
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Gecerli Username girildi");
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Gecerli password girildi ve SIGN IN  butonuna tiklandi");
        ReusableMethods.waitFor(2);
        //6.Vendor 'My Account' a tiklar
        spendingGoodPage.myAccount.click();
        extentTest.info("My Account'a tiklandi");
        //7.Vendor 'Store Manager' a tiklar
        spendingGoodPage.storeManager.click();
        extentTest.info("Store Manager'a tiklandi");
        //8.Vendor 'Refund' a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.refund.click();
        extentTest.info("Refund'a tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.nextButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
        extentTest.info("Next butonuna tiklandi diger sayfaya gecildi");
        //9.Vendor geri iade edilen ürünün  geri isteme ID'sini (RequestID) görür
        requestIDlistSize = spendingGoodPage.requestIDlist.size();
        System.out.println("Yeni requestIDlistSize= " + requestIDlistSize);
        softAssert.assertTrue(spendingGoodPage.requestIDlist.get(requestIDlistSize - 1).getText().contains("#"));
        softAssert.assertTrue(spendingGoodPage.requestIDlist.get(requestIDlistSize - 1).isDisplayed());
        extentTest.info("Geri isteme ID'si (RequestID) görüldü");
        //10.Vendor geri iade edilen  ürünün ID 'sini (Order ID) görür
        orderIDlistSize = spendingGoodPage.orderIDlist.size();
        System.out.println("Yeni orderIDlistSize= " + orderIDlistSize);
        softAssert.assertTrue(spendingGoodPage.orderIDlist.get(orderIDlistSize - 1).getText().contains("#"));
        softAssert.assertTrue(spendingGoodPage.orderIDlist.get(orderIDlistSize - 1).isDisplayed());
        extentTest.info("Ürünün ID'si (OrderID) görüldü");
        //11.Vendor geri iade edilen  ürünün sayisini (Amount) görür
        amountSListSize = spendingGoodPage.amountList.size();
        System.out.println("Yeni amountListSize= " + amountSListSize);
        softAssert.assertTrue(spendingGoodPage.amountList.get(amountSListSize - 1).getText().contains("$"));
        softAssert.assertTrue(spendingGoodPage.amountList.get(amountSListSize - 1).isDisplayed());
        extentTest.info("Ürünün miktari (Amount) görüldü");
        //12.Vendor geri iade edilen ürünün tipini (Type) görür
        typeListSize = spendingGoodPage.typeIDlist.size();
        System.out.println("Yeni typeListSize= " + typeListSize);
        softAssert.assertTrue(spendingGoodPage.typeIDlist.get(typeListSize - 1).getText().contains("Refund"));
        softAssert.assertTrue(spendingGoodPage.typeIDlist.get(typeListSize - 1).isDisplayed());
        extentTest.info("Ürünün Tipi (Type) görüldü");
        //13.Vendor ürünün  geri iade edilme sebebini (Reason) görür
        reasonListSize = spendingGoodPage.reasonList.size();
        System.out.println("Yeni reasonListSize= " + reasonListSize);
        softAssert.assertFalse(spendingGoodPage.reasonList.get(reasonListSize - 1).getText().isEmpty());
        softAssert.assertTrue(spendingGoodPage.reasonList.get(reasonListSize - 1).isDisplayed());
        extentTest.pass("Ürünün geri iade edilme sebebi (Reason) görüldü");


    }
}

