package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;


public class US014 {



    SpendingGoodPage spendinGoodPage = new SpendingGoodPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebElement kupon = spendinGoodPage.coupons;


    @Test(priority = 1)
    public void testTC_01() throws InterruptedException {
        //1.Store Manager  https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(3000);
        //2.Sign in Butonuma Tiklar
        spendinGoodPage.signIn.click();
        //3.Gecerli Email ve Password girer
        spendinGoodPage.eMailButton.sendKeys(ConfigReader.getProperty("userName"));
        spendinGoodPage.password.sendKeys(ConfigReader.getProperty("pass"));
        //4.sign in Butonuna tiklar
        spendinGoodPage.signInButton.click();
        //5.My Account butonuna tiklar
        Thread.sleep(3000);
        spendinGoodPage.myAccount.click();
        //6.Store Manager butonuna tiklar
        spendinGoodPage.storeManager.click();
        //7.Store manager sayfasinda Coupons‘ u tiklar
        WebElement kupon = spendinGoodPage.coupons;
        jse.executeScript("arguments[0].scrollIntoView(true);", kupon);
        jse.executeScript("arguments[0].click();", kupon);

    }

    @Test(priority = 2)
    public void testTC_02() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14002");
        //3.Istenen Minimum spend miktari girer
        spendinGoodPage.minimumSpend.sendKeys("50");
        //4.Istenen Minimum spend miktari girer
        spendinGoodPage.maximumSpend.sendKeys("500");
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        System.out.println(spendinGoodPage.minimumSpend.getAttribute("value"));
        //7.sayfada minimum degerin girilen minimum deger oldugunu dogrular
        Assert.assertEquals(spendinGoodPage.minimumSpend.getAttribute("value"), "50");
        //8.sayfada miaximum degerin girilen maximum deger oldugunu dogrular
        Assert.assertEquals(spendinGoodPage.maximumSpend.getAttribute("value"), "500");

    }

    @Test(priority = 3)
    public void testTC_03() throws InterruptedException {

        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14003");
        //3.Istenen Minimum spend miktari girer
        spendinGoodPage.minimumSpend.sendKeys("500");
        //4.Istenen Max spend miktari girer
        spendinGoodPage.maximumSpend.sendKeys("50");
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        //7.sayfada minimum degerin girilen minimum deger oldugunu dogrular
        Assert.assertEquals(spendinGoodPage.minimumSpend.getAttribute("value"), "500");
        //8.sayfada miaximum degerin girilen maximum deger oldugunu dogrular
        Assert.assertEquals(spendinGoodPage.maximumSpend.getAttribute("value"), "50");
        //9.MaximumSpend degerinin ayni kuponda minimumSpend degerinden kucuk girilebildigini test eder
        String min = spendinGoodPage.minimumSpend.getAttribute("value");
        String max = spendinGoodPage.maximumSpend.getAttribute("value");
        Integer degerMin = Integer.valueOf(min);
        Integer degerMax = Integer.valueOf(max);
        System.out.println(degerMin);
        System.out.println(degerMax);
        boolean sonuc = degerMax < degerMin;
        System.out.println(sonuc);
        Assert.assertTrue(sonuc);

    }

    @Test(priority = 4)
    public void testTC_04() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14004");
        //3.Individual use only seceneginni tiklar
        WebElement individual = spendinGoodPage.individualUse;
        jse.executeScript("arguments[0].scrollIntoView(true);", individual);
        jse.executeScript("arguments[0].click();", individual);
        //4.Exclude sale items secenegini tiklar
        WebElement exclude = spendinGoodPage.excludeSale;
        jse.executeScript("arguments[0].scrollIntoView(true);", exclude);
        jse.executeScript("arguments[0].click();", exclude);
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        //7.individual Use only kutusunun secili oldugunu dogrular
        Assert.assertTrue(spendinGoodPage.individualUse.isSelected());
        //8.Exclude sale items kutusunun secili oldugunu dogrular
        Assert.assertTrue(spendinGoodPage.excludeSale.isSelected());

    }

    @Test(priority = 5)
    public void testTC_05() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14005");
        //3.Products kutusuna istenen ürünler yazilir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String urunler = "T-Shirt";
        spendinGoodPage.product.sendKeys(urunler);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        //4.Exclude products kutusuna exclude edilecek urunler yazilir
        String excludeUrunler = "Arcelik";
        spendinGoodPage.excludeProducts.sendKeys(excludeUrunler);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Thread.sleep(1000);
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(1000);
        //7.Products kutusunda girilen urunlerin goruldugunu test eder
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        WebElement product = spendinGoodPage.product;
        jse.executeScript("arguments[0].scrollIntoView(true);", product);
        jse.executeScript("arguments[0].click();", product);
        //spendinGoodPage.product.click();
        String girilenUrun = spendinGoodPage.choiceProductsKAt.getText().substring(1);
        Assert.assertEquals(girilenUrun, urunler);
        //8.Products exclude kutusunda girilen urunlerin goruldugunu test eder
        Thread.sleep(2000);
        WebElement excProduct = spendinGoodPage.excludeProducts;
        jse.executeScript("arguments[0].scrollIntoView(true);", excProduct);
        jse.executeScript("arguments[0].click();", excProduct);
        spendinGoodPage.excludeProducts.click();
        Assert.assertEquals(spendinGoodPage.choiceProductsExcKat.getText().substring(1), excludeUrunler);
        Thread.sleep(2000);

    }

    @Test(priority = 6)
    public void testTC_06() throws InterruptedException {

        //1.Coupons sayfasinda Add New'i tiklar
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14006");
        //3.Products kutusuna istenen ürünler yazilir
        String urunler = "Arcelik";
        spendinGoodPage.product.sendKeys(urunler);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        //4.Exclude products kutusuna ayni istenen urunler yazilir
        spendinGoodPage.excludeProducts.sendKeys(urunler);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        Thread.sleep(2000);
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        //7.Products kutusundaki üurunlerin girilen urunler ile exclude kutusundaki urunlerin ayni oldugunu  test eder
        Assert.assertEquals(spendinGoodPage.choiceProductsKAt.getText(), spendinGoodPage.choiceProductsExcKat.getText());

    }

    @Test(priority = 7)
    public void testTC_07() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14007");
        //3.Products kategori kutusuna istenen ürünler yazilir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String urunKategori = "Clothes";
        spendinGoodPage.productCategories.sendKeys(urunKategori);
        Thread.sleep(1000);
        spendinGoodPage.urun.click();
        //4.Exclude products kategori kutusuna exclude edilecek urunler yazilir
        String excludeKategori = "Electronics";
        spendinGoodPage.excludeCategories.sendKeys(excludeKategori);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinGoodPage.productCategories.click();
        //7.Products kategorisi kutusunda girilen urunlerin goruldugunu test eder
        Assert.assertEquals(spendinGoodPage.choiceProductsKAt.getText().substring(1), urunKategori);
        //8.Exclude Products kategorisi kutusunda girilen urunlerin goruldugunu test eder
        Assert.assertEquals(spendinGoodPage.choiceProductsExcKat.getText().substring(1), excludeKategori);


    }

    @Test(priority = 8)
    public void testTC_08() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14008");
        //3.Products kategori kutusuna istenen kategoriler yazilir
        String urunKategori = "Clothes";
        spendinGoodPage.productCategories.sendKeys(urunKategori);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        //4.Exclude products kategori kutusuna products ile ayni kategoriler yazilir
        spendinGoodPage.excludeCategories.sendKeys(urunKategori);
        Thread.sleep(2000);
        spendinGoodPage.urun.click();
        //5.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinGoodPage.productCategories.click();
        //7.Products ve Exclude Products kategori kutularindaki secili kategorilerin ayni goruldugunu test eder
        Assert.assertEquals(spendinGoodPage.choiceProductsKAt.getText().substring(1), spendinGoodPage.choiceProductsExcKat.getText().substring(1));
        Thread.sleep(2000);

    }

    @Test(priority = 9)
    public void testTC_09() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        spendinGoodPage.addNeww.click();
        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC14009");
        //3.Email Restrictions kutusuna istenen email adresleri yazilir
        String mailler = "mail1@gmail.com, mail2@gmail.com, mail3@gmail.com";
        spendinGoodPage.emailRestriction.sendKeys(mailler);
        //4.submit butonuna tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //5.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(2000);
        //6.Email Restrictions kutusundaki maillerin girilen mailler oldugunu test eder
        Assert.assertEquals(spendinGoodPage.emailRestriction.getAttribute("value"), mailler);
        Thread.sleep(2000);

        Driver.closeDriver();
    }
}
