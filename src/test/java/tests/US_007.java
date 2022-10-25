package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_007 {

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
        //10. Kullanici Product brands menusunden Elegant Auto group brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.ElegantAutoGroup);
        Assert.assertTrue(spendingGoodPage.ElegantAutoGroup.isEnabled());
    }

    @Test
    public void test02() {
        // Kullanici Product brands menusunden Green Grass brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.GreenGrass);
        Assert.assertTrue(spendingGoodPage.GreenGrass.isEnabled());
    }

    @Test
    public void test03() {
        // Kullanici Product brands menusunden NodeJS brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.NodeJS);
        Assert.assertTrue(spendingGoodPage.NodeJS.isEnabled());
    }

    @Test
    public void test04() {
        // Kullanici Product brands menusunden NS8 brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.NS8);
        Assert.assertTrue(spendingGoodPage.NS8.isEnabled());
    }

    @Test
    public void test05() {
        // Kullanici Product brands menusunden RED brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.RED);
        Assert.assertTrue(spendingGoodPage.RED.isEnabled());
    }

    @Test
    public void test06() {
        // Kullanici Product brands menusunden Skysuite Tech brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.SkysuiteTech);
        Assert.assertTrue(spendingGoodPage.SkysuiteTech.isEnabled());
    }

    @Test
    public void test07() {
        // Kullanici Product brands menusunden Sterling brandini secer ve secildigini test eder
        ReusableMethods.jsScrollClick(spendingGoodPage.Sterling);
        Assert.assertTrue(spendingGoodPage.Sterling.isEnabled());
    }
}
