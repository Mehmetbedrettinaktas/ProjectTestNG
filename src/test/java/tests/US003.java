package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US003  {
    @Test

    public void test01() throws InterruptedException {
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();

        //1. Vendor "url" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2. Vendor sign in butonuna tiklar
        spendingGoodPage.signIn.click();
        //3. Vendor gecerli bir username veya email adresi girer
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        //4.Vendor gecerli bir password girer
        spendingGoodPage.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
        //5.Vendor SIGN IN butonuna tiklar
        spendingGoodPage.userpassSignIn.click();
        Thread.sleep(3000);
        //6. Vendor acilan sayfada My Account butonuna tiklar
        spendingGoodPage.myAccount.click();
        Thread.sleep(3000);
        //7. Vendor My Account altinda Orders butonuna tiklar
        spendingGoodPage.orders.click();
        Thread.sleep(3000);
        //8. Vendor acilan Orders sayfasinda Brwse Products/Go Shop a tiklar
        WebElement submit = Driver.getDriver().
                findElement(By.xpath("//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);}

    @Test

    public void test02() throws InterruptedException {
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //Vendor ürünler sayfasindan 5 adet ürün secer ve sectigi ürünleri tek tek sepete ekler

        for (int i = 0; i < spendingGoodPage.conList.size(); i++) {
            Thread.sleep(2000);
            jse.executeScript("arguments[0].click();", spendingGoodPage.conList.get(i));

            Thread.sleep(1000);
            try {
                if (spendingGoodPage.sepeteEkle.isDisplayed()) {
                    spendingGoodPage.sepeteEkle.click();
                    Thread.sleep(2000);
                    Driver.getDriver().navigate().back();
                    Driver.getDriver().navigate().back();
                } else
                    Driver.getDriver().navigate().back();
            } catch (Exception e) {
                Driver.getDriver().navigate().back();
            }

            int count = Integer.parseInt(spendingGoodPage.sepetCount.getText());
            if (count == 5) {
                break;
            }
        }}
    @Test
    public static void test03() throws InterruptedException {
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();

        //Vendor sepete tiklar
        ReusableMethods.waitFor(3);
        ReusableMethods.waitFor(3);
        spendingGoodPage.cartButton.click();
        Thread.sleep(3000);
        //Vendor CHECKOUT butonunu görür ve tiklar
        spendingGoodPage.checkout.click();}

    @Test
    public void test04(){
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
        spendingGoodPage.billingFirstName.clear();
        spendingGoodPage.billingFirstName.sendKeys("Ahmet4");
        spendingGoodPage.lastName.clear();
        spendingGoodPage.lastName.sendKeys("Tahmin4");
        spendingGoodPage.companyName.clear();
        spendingGoodPage.companyName.sendKeys("Mercedes4");
        //Vendor Country e tiklar ve ülke secer

        WebElement ddm = spendingGoodPage.country;
        Select options = new Select(ddm);
        options.selectByVisibleText("Germany");
//Vendor Town/City,State,Zip Code,State,Email address bilgilerini eksiksiz doldurur
        spendingGoodPage.postcode.clear();
        spendingGoodPage.postcode.sendKeys("21325");
        spendingGoodPage.town.clear();
        spendingGoodPage.town.sendKeys("Stuttgart");

        WebElement ddm2 = spendingGoodPage.state;
        Select options2 = new Select(ddm2);
        options2.selectByIndex(2);

        spendingGoodPage.phone.clear();
        spendingGoodPage.phone.sendKeys("01732154679");
        spendingGoodPage.emailCheckout.clear();
        spendingGoodPage.emailCheckout.sendKeys(ConfigReader.getProperty("email"));

        // Vendor eger isterse Order notes yazar
        spendingGoodPage.orderNotes.sendKeys("Adres bilgileri tam dolduruldu",Keys.ENTER);}
    @Test
    public void test05(){
        SpendingGoodPage spendingGoodPage = new SpendingGoodPage();;
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(5);

        // Vendor YOUR ORDER bölümüne gelir,Payment Methods u secer ,PLACE ORDER a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        if (!spendingGoodPage.payatheDoor.isSelected()) {
            spendingGoodPage.payatheDoor.click();
        }
        ReusableMethods.waitFor(2);
        //Vendor 'PLACE ORDER' a tiklar
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        jse1.executeScript("arguments[0].scrollIntoView(true);", spendingGoodPage.placeOrder);
        jse1.executeScript("arguments[0].click()", spendingGoodPage.placeOrder);
        // Vendor "Thank you. Your order has been received." yazisinin ciktigini dogrular
        String expectedThankYou = "Thank you. Your order has been received.";
        String actualThankYou = spendingGoodPage.thankYou.getText();
        System.out.println(actualThankYou);
        Assert.assertEquals(expectedThankYou, actualThankYou);
        Driver.closeDriver();

    }
}






