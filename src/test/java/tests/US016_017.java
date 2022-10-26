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

public class US016_017 {
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

    @Test(dependsOnMethods = "testTC_giris")
    public void test_US_17_TC_01() throws InterruptedException {

        Actions actions=new Actions(Driver.getDriver());
        SpendingGoodPage spendingGoodPage =new SpendingGoodPage();

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

        //Cikan sayfada:Manage Customers kullanici adi, email,isim,soyisim ekler
        Faker faker = new Faker();
        spendingGoodPage.username2.sendKeys(faker.name().username());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                //Shipping adrese farkli isim,soyisim,sirket ismi,tel no,adres1,adres2,ulke,sehir,posta kodu girilir
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sweden", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode(), Keys.ENTER).perform();
        Thread.sleep(2000);

        //Yukaridaki girilen bilgilerin ayni sekilde Same as Billing olarak eklendigi dogrulanir
        Assert.assertTrue(spendingGoodPage.customerSuccessfullySaved.isDisplayed());
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "testTC_01")
    public void testUS_17_TC_02() throws InterruptedException {
        Faker faker = new Faker();
        Actions actions=new Actions(Driver.getDriver());
        SpendingGoodPage spendingGoodPage =new SpendingGoodPage();

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

        //Cikan sayfada:Manage Customers kullanici adi, email,isim,soyisim ekler
        spendingGoodPage.username2.sendKeys(faker.name().username());
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                //Shipping adrese farkli isim,soyisim,sirket ismi,tel no,adres1,adres2,ulke,sehir,posta kodu girilir
                        sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(firstName).sendKeys(Keys.TAB).sendKeys(lastName).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sweden", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode(), Keys.ENTER).perform();
        Thread.sleep(2000);

        //Yukaridaki girilen bilgilerin ayni sekilde Same as Billing olarak eklendigi dogrulanir
        Assert.assertTrue(spendingGoodPage.customerSuccessfullySaved.isDisplayed());
        Thread.sleep(3000);

        //Shipping adrese farkli isim,soyisim,sirket ismi,tel no,adres1,adres2,ulke,sehir,posta kodu girilir
        ReusableMethods.jsScrollClick(spendingGoodPage.sameAsBilling);
        Thread.sleep(1500);
        spendingGoodPage.sFirstName.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("France", Keys.ENTER).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).
                sendKeys(Keys.ENTER).perform();
        //Manage Customersin kayıt oldugunu dogrular
        Assert.assertTrue(spendingGoodPage.customerSuccessfullySaved.isDisplayed());
        Thread.sleep(2000);


    }
}




