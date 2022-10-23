package US;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_005 {
    SpendingGoodPage spendingGoodPage = new SpendingGoodPage();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {

        // 1. Kullanici "http://spendinggood.com/" sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        // 2. Kullanici sign in butonuna tiklar
        spendingGoodPage.signIn.click();
        // 3. Kullanici gecerli bir username veya unique email adresi girer
        spendingGoodPage.userName.sendKeys(ConfigReader.getProperty("user"));
        // 4. Kullanici gecerli bir password girer
        // 5. Kullanici sign in kismina tiklar
        spendingGoodPage.password.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
        Thread.sleep(3000);
        // 6. Kullanici My Account'a tiklar
        spendingGoodPage.myAccount.click();
        // 7. Acilan sayfada Store Manager'e gider
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spendingGoodPage.storeManager.click();
        // 8. Store Manager'den Products kismina tiklar
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spendingGoodPage.products.click();
        // 9. Kullanici urun listenin gorunurlugunu dogrular
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Assert.assertTrue(spendingGoodPage.urunListe.isDisplayed());
        // 10. Kullanici status,stock,price,date görünürlügünü doğrular
        Assert.assertTrue(spendingGoodPage.status.isDisplayed());
        Assert.assertTrue(spendingGoodPage.stock.isDisplayed());
        Assert.assertTrue(spendingGoodPage.price.isDisplayed());
        Assert.assertTrue(spendingGoodPage.date.isDisplayed());

    }

    @Test
    public void test02() throws InterruptedException {
        // Acilan sayfada Add new butonuna tiklar
        spendingGoodPage.addNewButonu.click();
        // Kullanici urun icin Virtual seceneginin gorunur oldugunu test eder
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Assert.assertTrue(spendingGoodPage.virtualButonu.isDisplayed());
        // Kullanici urun icin Downloadable seceneginin gorunur oldugunu test eder
        Assert.assertTrue(spendingGoodPage.downloadableButonu.isDisplayed());

    }

    @Test
    public void test03() {
        // Kullanici Product Title sekmesine tiklar ve urun ismi yazar
        spendingGoodPage.productTitle.sendKeys("raincoat");
        // Kullanici Price($) sekmesine tiklar ve fiyat yazar
        spendingGoodPage.priceSekmesi.sendKeys("50");
    }

    @Test
    public void test04() throws InterruptedException {
        // Kullanıcı Bos Resim ikonunu tıklar ve Choose Image sayfasına gider
        spendingGoodPage.buyukBosResimIkonu.click();
        // Acilan sayfada Media Library sekmesine tiklar
        spendingGoodPage.mediaLibrary.click();
        Thread.sleep(3000);
        // Ekranda gorunen resimlerden bir tanesine tiklar ve SELECT butonuna tiklar
        spendingGoodPage.foto1.click();
        spendingGoodPage.selectButonu.click();
        Thread.sleep(3000);
        // Kullanici Buyuk Bos Resim altindaki Kucuk Bos Resim ikonuna tiklar
        spendingGoodPage.kucukBosResimIkonu.click();
        Thread.sleep(3000);
        // Ekranda gorunen resimlerden bir tanesine tiklar ve ADD TO GALLERY butonuna tiklar
        spendingGoodPage.foto2.click();
        spendingGoodPage.addToGallery.click();
        // Kullanici Categories menusunden bir secim yapar
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spendingGoodPage.categories.click();
        // Kullanici Product brands menusunden bir secim yapar
        spendingGoodPage.brands.click();
    }

    @Test
    public void test05() throws InterruptedException {
        // Kullanici Short Description ve Description kismina sectigi urunle ilgili tanitim yazar
        WebElement iframe1 = Driver.getDriver().findElement(By.xpath("//*[@id='excerpt_ifr']"));
        Driver.getDriver().switchTo().frame(iframe1);
        spendingGoodPage.shortDescription.sendKeys("raincoat");
        Driver.getDriver().switchTo().defaultContent();

        WebElement iframe2 = Driver.getDriver().findElement(By.xpath("//*[@id='description_ifr']"));
        Driver.getDriver().switchTo().frame(iframe2);
        spendingGoodPage.longDescription.sendKeys("the quality of raincoat is very good");
        Driver.getDriver().switchTo().defaultContent();
        // Kullanici Submit butonuna tiklar
        ReusableMethods.jsScrollClick(spendingGoodPage.submitButton);

    }
}

