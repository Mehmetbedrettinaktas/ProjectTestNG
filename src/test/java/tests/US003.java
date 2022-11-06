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
        SpendingGoodPage spengood = new SpendingGoodPage();

        //1. Vendor "url" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2. Vendor sign in butonuna tiklar
        spengood.signIn.click();
        //3. Vendor gecerli bir username veya email adresi girer
        spengood.userName.sendKeys(ConfigReader.getProperty("user"));
        //4.Vendor gecerli bir password girer
        spengood.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
        //5.Vendor SIGN IN butonuna tiklar
        spengood.userpassSignIn.click();
        Thread.sleep(3000);
        //6. Vendor acilan sayfada My Account butonuna tiklar
        spengood.myAccount.click();
        Thread.sleep(3000);
        //7. Vendor My Account altinda Orders butonuna tiklar
        spengood.orders.click();
        Thread.sleep(3000);
        //8. Vendor acilan Orders sayfasinda Brwse Products/Go Shop a tiklar
        WebElement submit = Driver.getDriver().
                findElement(By.xpath("//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);}

    @Test

    public void test02() throws InterruptedException {
        SpendingGoodPage spengood=new SpendingGoodPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //Vendor ürünler sayfasindan 5 adet ürün secer ve sectigi ürünleri tek tek sepete ekler

        for (int i = 0; i < spengood.conList.size(); i++) {
            Thread.sleep(2000);
            jse.executeScript("arguments[0].click();", spengood.conList.get(i));

            Thread.sleep(1000);
            try {
                if (spengood.sepeteEkle.isDisplayed()) {
                    spengood.sepeteEkle.click();
                    Thread.sleep(2000);
                    Driver.getDriver().navigate().back();
                    Driver.getDriver().navigate().back();
                } else
                    Driver.getDriver().navigate().back();
            } catch (Exception e) {
                Driver.getDriver().navigate().back();
            }

            int count = Integer.parseInt(spengood.sepetCount.getText());
            if (count == 5) {
                break;
            }
        }}
    @Test
    public static void test03() throws InterruptedException {
        SpendingGoodPage spengood=new SpendingGoodPage();

        //Vendor sepete tiklar
        ReusableMethods.waitFor(3);
        ReusableMethods.waitFor(3);
        spengood.cartButton.click();
        Thread.sleep(3000);
        //Vendor CHECKOUT butonunu görür ve tiklar
        spengood.checkout.click();}

    @Test
    public void test04(){
        SpendingGoodPage spengood=new SpendingGoodPage();
        spengood.billingFirstName.clear();
        spengood.billingFirstName.sendKeys("Ahmet4");
        spengood.lastName.clear();
        spengood.lastName.sendKeys("Tahmin4");
        spengood.companyName.clear();
        spengood.companyName.sendKeys("Mercedes4");
        //Vendor Country e tiklar ve ülke secer

        WebElement ddm = spengood.country;
        Select options = new Select(ddm);
        options.selectByVisibleText("Germany");
//Vendor Town/City,State,Zip Code,State,Email address bilgilerini eksiksiz doldurur
        spengood.postcode.clear();
        spengood.postcode.sendKeys("21325");
        spengood.town.clear();
        spengood.town.sendKeys("Stuttgart");

        WebElement ddm2 = spengood.state;
        Select options2 = new Select(ddm2);
        options2.selectByIndex(2);

        spengood.phone.clear();
        spengood.phone.sendKeys("01732154679");
        spengood.emailCheckout.clear();
        spengood.emailCheckout.sendKeys(ConfigReader.getProperty("email"));

        // Vendor eger isterse Order notes yazar
        spengood.orderNotes.sendKeys("Adres bilgileri tam dolduruldu",Keys.ENTER);}
    @Test
    public void test05(){
        SpendingGoodPage spengood=new SpendingGoodPage();
        Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(5);

        // Vendor YOUR ORDER bölümüne gelir,Payment Methods u secer ,PLACE ORDER a tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        if (!spengood.payatheDoor.isSelected()) {
            spengood.payatheDoor.click();
        }
        ReusableMethods.waitFor(2);
        //Vendor 'PLACE ORDER' a tiklar
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        jse1.executeScript("arguments[0].scrollIntoView(true);", spengood.placeOrder);
        jse1.executeScript("arguments[0].click()", spengood.placeOrder);
        // Vendor "Thank you. Your order has been received." yazisinin ciktigini dogrular
        String expectedThankYou = "Thank you. Your order has been received.";
        String actualThankYou = spengood.thankYou.getText();
        System.out.println(actualThankYou);
        Assert.assertEquals(expectedThankYou, actualThankYou);
        Driver.closeDriver();

    }
}






