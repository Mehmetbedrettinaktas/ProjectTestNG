package tests;

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
import utilities.ReusableMethods;


import java.time.Duration;

public class US010 {
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
        //9. Kullanici acilan listesdede Attributes sacenegi gorebilmeli
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.SPACE).perform();
        sgp.attributes.isDisplayed();
        //10. kullanici Attributes sekmesini tiklayabilmeli
        sgp.attributes.click();
        //11. kullanici Attributes basligi altinda Color secenegi gorebilmeli
        sgp.colorRadioButton.click();

        //12. Kullanici istedigi rengi secebilmeli
        //sgp.colorRadioButton.click();
        ReusableMethods.waitFor(2);
        //sgp.colordropDownOk.click();
       // sgp.colorDdmSurchBox.click();
        WebElement dropDownColor=sgp.colordropDown;
        select=new Select(dropDownColor);
        select.selectByVisibleText("Black");
        softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Black");
        //System.out.println(select.getFirstSelectedOption().getText());
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
        //9. Kullanici acilan listesdede Attributes sacenegi gorebilmeli
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.SPACE).perform();
        sgp.attributes.isDisplayed();
        //10. kullanici Attributes sekmesini tiklayabilmeli
        sgp.attributes.click();
        //11. kullanici Attributes basligi altinda Size secenegi gorebilmeli
        sgp.sizeRadioButton.click();
        //12. Kullanici istedigi Size'i secebilmeli
        WebElement dropDownSize=sgp.sizeDdm;
        select=new Select(dropDownSize);
        select.selectByVisibleText("Large");
        softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Large");
        softAssert.assertAll();
         Driver.closeDriver();
    }
}
