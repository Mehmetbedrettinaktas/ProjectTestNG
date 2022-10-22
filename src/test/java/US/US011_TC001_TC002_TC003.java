package US;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ResuableMethods;

import java.time.Duration;

public class US011_TC001_TC002_TC003 {
    Select select;
    JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert= new SoftAssert();
    SpendingGoodPage sgp=new SpendingGoodPage();
    @Test()
    public void testCase001() throws InterruptedException {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        Thread.sleep(3000);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(3000);
        //6. Kullanici Store Manger sekmesini tiklayabilmeli
        sgp.storeManager.click();
        //7.Kullanici Store Manager sayfasini gormeli
        String expectedYaziElementi="Store Manager";
        String actualYaziElementi=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualYaziElementi.contains(expectedYaziElementi));
        //8. Kullanici Products sekmesindeki addNew butonunu tiklayabilmeli
        sgp.products.click();
        WebElement addNew=wait.until(ExpectedConditions.visibilityOf(sgp.addNew));
        addNew.click();
        Thread.sleep(2000);
        // 9. kullanici Toptan Ürün gösterme Ayarlarini  tiklayabilmeli
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement tUgAyarlari=sgp.toptanUrunGostermeAyarlari;
        jse.executeScript("arguments[0].scrollIntoView(true);", tUgAyarlari);
        jse.executeScript("arguments[0].click()", tUgAyarlari);
        //10. Kullanici acilan sayfada Piece Type (urun Cesidi) girebilmeli
        WebElement dropDown= sgp.pieceTypeDropDown;
        select=new Select(dropDown);
        select.selectByVisibleText("Piece");
        actions.sendKeys(Keys.TAB).sendKeys("3").sendKeys(Keys.TAB).sendKeys("4").perform();
        softAssert.assertAll();
        Driver.closeDriver();

    }
    @Test()
    public void testCase002() throws InterruptedException {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        Thread.sleep(3000);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
       ResuableMethods.waitFor(2);
        //6. Kullanici Store Manger sekmesini tiklayabilmeli
        sgp.storeManager.click();
        //7.Kullanici Store Manager sayfasini gormeli
        String expectedYaziElementi="Store Manager";
        String actualYaziElementi=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualYaziElementi.contains(expectedYaziElementi));
        //8. Kullanici Products sekmesindeki addNew butonunu tiklayabilmeli
        sgp.products.click();
        WebElement addNew=wait.until(ExpectedConditions.visibilityOf(sgp.addNew));
        addNew.click();
        Thread.sleep(2000);
        // 9. kullanici Toptan Ürün gösterme Ayarlarini  tiklayabilmeli
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement tUgAyarlari=sgp.toptanUrunGostermeAyarlari;
        jse.executeScript("arguments[0].scrollIntoView(true);", tUgAyarlari);
        jse.executeScript("arguments[0].click()", tUgAyarlari);
        //10. Kullanici acilan sayfada Units per Piece kismini gorebilmeli
       sgp.unitsPerPieceYaziElementi.isDisplayed();
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test()
    public void testCase003() throws InterruptedException {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        Thread.sleep(3000);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(3000);
        //6. Kullanici Store Manger sekmesini tiklayabilmeli
        sgp.storeManager.click();
        //7.Kullanici Store Manager sayfasini gormeli
        String expectedYaziElementi="Store Manager";
        String actualYaziElementi=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualYaziElementi.contains(expectedYaziElementi));
        //8. Kullanici Products sekmesindeki addNew butonunu tiklayabilmeli
        sgp.products.click();
        WebElement addNew=wait.until(ExpectedConditions.visibilityOf(sgp.addNew));
        addNew.click();
        Thread.sleep(2000);
        // 9. kullanici Toptan Ürün gösterme Ayarlarini gorebilmeli ve tiklayabilmeli
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement tUgAyarlari=sgp.toptanUrunGostermeAyarlari;
        jse.executeScript("arguments[0].scrollIntoView(true);", tUgAyarlari);
        jse.executeScript("arguments[0].click()", tUgAyarlari);

        //10. Kullanici acilan sayfada Min order quantity(minimum Siparis miktari) girebilmeli

        softAssert.assertAll();
    }
}
