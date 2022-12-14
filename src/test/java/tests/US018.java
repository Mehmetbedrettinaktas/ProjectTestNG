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

public class US018 extends TestBaseRapor {

    static SpendingGoodPage spendingGoodPage;
    static Actions actions;
    static SoftAssert softAssert;
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

        actions = new Actions(Driver.getDriver());
        spendingGoodPage = new SpendingGoodPage();
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        ReusableMethods.waitFor(5);
        spendingGoodPage.signIn1.click();
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
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
        Driver.closeDriver();
    }


    public static void urunEklemeMethod() {
        actions = new Actions(Driver.getDriver());
        spendingGoodPage = new SpendingGoodPage();
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        ReusableMethods.waitFor(5);
        spendingGoodPage.signIn1.click();
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
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
        spendingGoodPage.firstName1.clear();
        spendingGoodPage.firstName1.sendKeys(Faker.instance().name().firstName());
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
        Driver.closeDriver();

    }


    @Test()
    public static void testTC01() {// US_18_TC01-->Vendor olarak gelen siparisi onaylayabilmeliyim
        actions = new Actions(Driver.getDriver());
        softAssert = new SoftAssert();
        spendingGoodPage = new SpendingGoodPage();
        extentTest = extentReports.createTest("Siparis onay", "Siparis edilen ??r??n onaylanmasi");
        //1 Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a t??klar
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
        //8.Vendor 'Orders a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.ordersStoreManager.click();
        extentTest.info("Orders'a tiklandi");
        //9.Vendor siparis listesindeki  siparis edilen ??r??n?? onaylar("Mark as Complete"ye tiklar)
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(15);
        spendingGoodPage.markAsComplete.click();
        ReusableMethods.waitFor(5);
        extentTest.info("Mark as Complete'ye tiklandi");
        //10.Vendor cikan alert yazisini kabul eder.
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alert yazisi kabul edildi");
        //11.Vendor ??r??n?? onayladigini dogrular
        ReusableMethods.waitFor(20);
        softAssert.assertTrue(spendingGoodPage.viewDetails.isDisplayed());
        extentTest.pass("??r??n??n onaylandigi dogrulandi");
        softAssert.assertAll();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendingGoodPage.LogoutButton);
        jse.executeScript("arguments[0].click()", spendingGoodPage.LogoutButton);
        Driver.closeDriver();

    }

    @Test(dependsOnMethods = "testTC01")
    //US_18 TC_02-->Store manager olarak ??r??n?? geri iade talebinde bulunabilabilmeliyim
    public static void testTC02() {
        actions = new Actions(Driver.getDriver());
        softAssert = new SoftAssert();
        spendingGoodPage = new SpendingGoodPage();
        extentTest = extentReports.createTest("Iade talebi", "Siparis edilen ??r??n?? geri iade talebinde bulunma");
        // Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a t??klar
        ReusableMethods.waitFor(3);
        spendingGoodPage.signIn1.click();
        // spendinGoodPage.signIn1.click();
        extentTest.info("SignIn butonuna basildi");
        //3.Vendor  gecerli Username girer
        //4.Vendor gecerli Password girer
        //5.Vendor 'SIGN IN' butonuna tiklar
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        extentTest.info("Gecerli Username girildi");
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Gecerli password girildi ve SIGN IN  butonuna tiklandi");
        ReusableMethods.waitFor(3);
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
        //9.Vendor onaylamis oldugu ??r??n??n  'Refund Request' butonuna tiklar
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
        //11.Vendor  ??r??n?? geri iade sebebini yazar
        spendingGoodPage.refundRequestsReason.sendKeys("Stokta ??r??n kalmadi");
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
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendingGoodPage.LogoutButton);
        jse.executeScript("arguments[0].click()", spendingGoodPage.LogoutButton);
        Driver.closeDriver();

    }


    @Test(dependsOnMethods = "testTC02")
    // US_18 TC_03-->Vendor olarak geri iade edilen ??r??n??n RequestID,OrderID,Amount,Type ve Reason'u g??rebilmeliyim
    public static void testTC03() {
        actions = new Actions(Driver.getDriver());
        softAssert = new SoftAssert();
        spendingGoodPage = new SpendingGoodPage();
        extentTest = extentReports.createTest("Iade bilgileri", "Iade edilen ??r??n??n bilgilarini g??r??nt??leme");
        //1 Vendor  "http://spendinggood.com/"  adresine  gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        extentTest.info("SpendingGood sayfasina gidildi");
        //2 Vendor 'Sign In' a t??klare
        ReusableMethods.waitFor(5);
        spendingGoodPage.signIn1.click();
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
        //9.Vendor geri iade edilen ??r??n??n  geri isteme ID'sini (RequestID) g??r??r
        requestIDlistSize = spendingGoodPage.requestIDlist.size();
        System.out.println("Yeni requestIDlistSize= " + requestIDlistSize);
        softAssert.assertTrue(spendingGoodPage.requestIDlist.get(requestIDlistSize - 1).getText().contains("#"));
        softAssert.assertTrue(spendingGoodPage.requestIDlist.get(requestIDlistSize - 1).isDisplayed());
        extentTest.info("Geri isteme ID'si (RequestID) g??r??ld??");
        //10.Vendor geri iade edilen  ??r??n??n ID 'sini (Order ID) g??r??r
        orderIDlistSize = spendingGoodPage.orderIDlist.size();
        System.out.println("Yeni orderIDlistSize= " + orderIDlistSize);
        softAssert.assertTrue(spendingGoodPage.orderIDlist.get(orderIDlistSize - 1).getText().contains("#"));
        softAssert.assertTrue(spendingGoodPage.orderIDlist.get(orderIDlistSize - 1).isDisplayed());
        extentTest.info("??r??n??n ID'si (OrderID) g??r??ld??");
        //11.Vendor geri iade edilen  ??r??n??n sayisini (Amount) g??r??r
        amountSListSize = spendingGoodPage.amountList.size();
        System.out.println("Yeni amountListSize= " + amountSListSize);
        softAssert.assertTrue(spendingGoodPage.amountList.get(amountSListSize - 1).getText().contains("$"));
        softAssert.assertTrue(spendingGoodPage.amountList.get(amountSListSize - 1).isDisplayed());
        extentTest.info("??r??n??n miktari (Amount) g??r??ld??");
        //12.Vendor geri iade edilen ??r??n??n tipini (Type) g??r??r
        typeListSize = spendingGoodPage.typeIDlist.size();
        System.out.println("Yeni typeListSize= " + typeListSize);
        softAssert.assertTrue(spendingGoodPage.typeIDlist.get(typeListSize - 1).getText().contains("Refund"));
        softAssert.assertTrue(spendingGoodPage.typeIDlist.get(typeListSize - 1).isDisplayed());
        extentTest.info("??r??n??n Tipi (Type) g??r??ld??");
        //13.Vendor ??r??n??n  geri iade edilme sebebini (Reason) g??r??r
        reasonListSize = spendingGoodPage.reasonList.size();
        System.out.println("Yeni reasonListSize= " + reasonListSize);
        softAssert.assertFalse(spendingGoodPage.reasonList.get(reasonListSize - 1).getText().isEmpty());
        softAssert.assertTrue(spendingGoodPage.reasonList.get(reasonListSize - 1).isDisplayed());
        extentTest.pass("??r??n??n geri iade edilme sebebi (Reason) g??r??ld??");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}


