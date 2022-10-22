package US;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ResuableMethods;

import java.time.Duration;
import java.util.List;

public class US012_TC001_TC002_TC003_TC004 {
    Select select;
    JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert= new SoftAssert();
    SpendingGoodPage sgp=new SpendingGoodPage();
    @Test()
    public void testCase001()  {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        ResuableMethods.waitFor(2);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        ResuableMethods.waitFor(2);
        //6. kullanici Store manager olarak orders(siparisler) button'nunu tiklayabilmeli
       sgp.orderButton.click();
        //7. kullanici acilan sayfada siparisler listesini gorebilmeli
        List<WebElement> siparislerListesi=sgp.ordersList;
        System.out.println("siparisler listesi: "+siparislerListesi);
        for (WebElement w:siparislerListesi
             ) {
            System.out.println(w.getText()+" ");
        }
        Driver.closeDriver();
    }
    @Test()
    public void testCase002()  {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        ResuableMethods.waitFor(2);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        ResuableMethods.waitFor(2);
        //6.Kullanici Store Manager olarak Dowlands(Indirilenler) buttonunu tiklayabilmeli
        sgp.dowlands.click();
        //7. Kullanici Store Manager olarak  acilan sayfada eger indirilen ürün listesi varsa görebilmeli
        List<WebElement> dowlandsProdocktListesi=sgp.dowlandsProdockt;

            for (WebElement w :dowlandsProdocktListesi
            ) {
                System.out.println(w.getText()+" ");
            }
            Driver.closeDriver();
    }
    @Test()
    public void testCase003()  {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        ResuableMethods.waitFor(2);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        ResuableMethods.waitFor(2);
        // 6. kullanici acilan sayfada daha önce girilen fatura adresi ve gönderim adresini görebilmeli
        sgp.adresses.click();
        //7.Kullanici Fatura adres bilgisi ve gönderim adres bilgilerini listeleyebilmeli
        List<WebElement> adressesListesi=sgp.adressesWebElements;

        for (WebElement w : adressesListesi
        ) {
            System.out.println(w.getText()+" ");
        }
        Driver.closeDriver();


    }@Test()
    public void testCase004()  {
        // 1. Kullanici https://spendinggood.com/my-account-2/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        //2.Kullanici Sign In buttonuna tiklayarak sign In sayfasina gorebilmeli
        sgp.signIn.click();
        //3. Kullanici gecerli bir Kullanici adi veya gecerli email adresi girebilmeli
        sgp.userName.sendKeys(ConfigReader.getProperty("user"), Keys.TAB);
        //4.Kullanici gecerli bir password ile sayfaya giris yapabilmeli
        sgp.password.sendKeys(ConfigReader.getProperty("pass"),Keys.TAB);
        sgp.signIn2.click();
        ResuableMethods.waitFor(2);
        //5. Kullanici sisteme giris yaptiktan  sonra My Account sayfasini gormeli
        sgp.myAccount.click();
        String expectedResult="My Account";
        String actualResult=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualResult.contains(expectedResult));
        ResuableMethods.waitFor(2);
        //6. Acilan sayfada kullanici hesap bilgisi ve eposta adres bilgisini gorebilmeli
        sgp.accountDetailsButton.click();
        //7.  Kullanici Adressleri ve eposta adresini göncelleyebilmeli
        sgp.firstName.click();
        actions.sendKeys(Keys.CLEAR).sendKeys("mehmet").sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys("aktas").sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys("AktasMehmet")
                .sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys("aktas@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("03414")
                .sendKeys(Keys.TAB).sendKeys("003414").sendKeys(Keys.TAB).sendKeys("003414").perform();
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
