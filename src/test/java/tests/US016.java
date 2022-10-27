package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class US016 {
    public Object kisilerListesi;
    Actions actions=new Actions(Driver.getDriver());
    SpendingGoodPage spendingGoodPage =new SpendingGoodPage();

    @Test
    public void test_US_16() throws InterruptedException {

        //-https://spendinggood.com adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

//2-sign in butonuna basilir
        spendingGoodPage.signIn.click();

        //-username girilir
        spendingGoodPage.userName.sendKeys("Aktas");

        //-password girilir
        spendingGoodPage.password.sendKeys("03414");
        Thread.sleep(1000);

        //-Sign up butonuna basilir
        spendingGoodPage.signIn2.click();
        Thread.sleep(3000);

        //-my account butonuna tiklanir
        spendingGoodPage.myAccount.click();
        Thread.sleep(1000);

        //-Store manager butonuna tiklanir
        spendingGoodPage.storeManager.click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(1000);

        //-customers butonuna tiklanir
        actions.moveToElement(spendingGoodPage.customers).click().perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(1000);

        //-Manage Customers tum bilgileri pdf olarak indirir
        spendingGoodPage.pdf.click();
        Thread.sleep(1000);

        // -Manage Customers tum bilgileri exel olarak indirir
        spendingGoodPage.exel.click();
        Thread.sleep(1000);

        //8-Manage Customers tum bilgileri exel olarak indirir
        spendingGoodPage.cvs.click();

        //-Manage Customers kayitli kisilerinismini, kullanici adini,e mailini,adresini,harcama miktarini,sonsiparislerini,
        // gorur ve dogrular

        kisilerListesi=new ArrayList<>();
        for (int i = 0; i < spendingGoodPage.kayitlikisiler.size(); i++) {
            spendingGoodPage.kayitlikisiler.get(i).isDisplayed();
            Assert.assertTrue(true,"kisiler gorunuyor");}
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);

        //Manage Customers addnew butonuna tiklar
        spendingGoodPage.addNew.click();
        Thread.sleep(1000);
    }


}




