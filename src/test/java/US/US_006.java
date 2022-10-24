package US;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_006 {
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
        // 9. Acilan sayfada Add new butonuna tiklar
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        spendingGoodPage.addNewButonu.click();
        // 10. Kullanici Categories menusunden Best Seller kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.BestSeller);
        Assert.assertTrue(spendingGoodPage.BestSeller.isEnabled());

    }

    @Test
    public void test02() {
        // Kullanici Categories menusunden Health&Beauty kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.HealthAndBeauty);
        Assert.assertTrue(spendingGoodPage.HealthAndBeauty.isEnabled());

    }

    @Test
    public void test03() {
        // Kullanici Categories menusunden Electronics kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.Electronics);
        Assert.assertTrue(spendingGoodPage.Electronics.isEnabled());
    }

    @Test
    public void test04() {
        //  Kullanici Categories menusunden Home&Garden kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.HomeAndGarden);
        Assert.assertTrue(spendingGoodPage.HomeAndGarden.isEnabled());
    }

    @Test
    public void test05() {
        // Kullanici Categories menusunden Trending kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.Trending);
        Assert.assertTrue(spendingGoodPage.Trending.isEnabled());
    }

    @Test
    public void test06() {
        // Kullanici Categories menusunden Books&Music&Film kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.BooksMusicFilm);
        Assert.assertTrue(spendingGoodPage.BooksMusicFilm.isEnabled());

    }

    @Test
    public void test07() {
        // Kullanici Categories menusunden Fashion kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.Fashion);
        Assert.assertTrue(spendingGoodPage.Fashion.isEnabled());

    }

    @Test
    public void test08() {
        // Kullanici Categories menusunden Games kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.Games);
        Assert.assertTrue(spendingGoodPage.Games.isEnabled());

    }

    @Test
    public void test09() {
        // Kullanici Categories menusunden Accessories kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.Accessories);
        Assert.assertTrue(spendingGoodPage.Accessories.isEnabled());

    }

    @Test
    public void test10() {
        // Kullanici Categories menusunden New Arrivals kategorisini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.NewArrivals);
        Assert.assertTrue(spendingGoodPage.NewArrivals.isEnabled());

    }
}

