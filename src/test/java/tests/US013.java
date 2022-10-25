package tests;

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

public class US013 {
    SpendingGoodPage spendinGoodPage = new SpendingGoodPage();
    Select select;
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();



    @Test(priority = 1)
    public void testTC_01() throws InterruptedException {
        //1.Store Manager  https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));

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
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.coupons.click();

        //8.Coupons sayfasinda Add New'i tiklar
        spendinGoodPage.addNeww.click();

        //9.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13001");

        //10.Draft‘i tiklar
        WebElement draft = spendinGoodPage.draftButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", draft);
        jse.executeScript("arguments[0].click();", draft);

        //11.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedDraftSonucYazisi = "Coupon Successfully Saved.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullySaved.getText(), expectedDraftSonucYazisi);
        //System.out.println(spendinGoodPage.couponSuccesfullySaved.getText());

        //12.Sayfada Coupons'u tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.coupons.click();

        //13.Coupons Listing'de olusturulan taslak kupon kodunun goruldugunu test eder
        String expectedCode = "TC13001 -- Draft";
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText(), expectedCode);

    }

    @Test(priority = 2)
    public void testTC_02() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        spendinGoodPage.addNeww.click();

        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13002");

        //3.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);


        //4.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(3000);

        //5.Sayfada Coupons'u tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.coupons.click();
        Thread.sleep(2000);

        //6.Coupons Listing'de Publised edilen kupon kodunun goruldugunu test eder
        String expectedCode = "TC13002";
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[1]")).getText(), expectedCode);
    }


    @Test(priority = 3)
    public void testTC_03() throws InterruptedException {

        //1.Coupons sayfasinda Add New'i tiklar
        Thread.sleep(3000);
        //actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();

        //2.Code kismini bos birakir
        spendinGoodPage.codeBox.sendKeys("");

        //3.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        Thread.sleep(3000);

        //4.Kupon Kodu girilmeden kupon olusturulamadigini dogrular
        String expectedPleaseInsert = "Please insert atleast Coupon Title before submit.";
        Assert.assertEquals(spendinGoodPage.pleaseInsertYazisi.getText(), expectedPleaseInsert);

    }

    @Test(priority = 4)
    public void testTC_04() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        spendinGoodPage.addNeww.click();

        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13004");

        //3.Description kismina istenen Description'i yazar
        String istenenDescription = "Customer discount  on all products";
        spendinGoodPage.descriptionBox.sendKeys(istenenDescription);

        //3.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);


        //4.Coupon Successfully Saved yazisinin gorundugunu dogrular
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void testTC_05() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();

        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13005");

        //3.Discount Type kisminda "Percentage discount" secenegini tiklar
        spendinGoodPage.percentageDiscount.click();
        //4.Discount amaunt kismina istenen miktari yazar
        spendinGoodPage.discountAmaunt.clear();
        Thread.sleep(1000);
        spendinGoodPage.discountAmaunt.sendKeys("10");
        //5.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);
        //6.Coupon Successfully Published yazisinin gorundugunu test eder
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);

        //7.Sayfada Coupons'u tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        spendinGoodPage.coupons.click();

        //8.Coupons Listing'de olusturulan kuponun Discount Type'in "Percentage discount" oldugunu  test eder
        String expectedDiscountType = "Percentage discount";
        System.out.println(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText());
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText(), expectedDiscountType);

        //9.Coupons Listing'de olusturulan kuponun Amaunt'un 10 oldugunu dogrular
        String expectedDiscountAmaunt = "10";
        System.out.println(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText());
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText(), expectedDiscountAmaunt);

    }

    @Test(priority = 6)
    public void testTC_06() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();

        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13006");

        //3.Discount Type kisminda "Fixed Product Discount" secenegini tiklar
        WebElement ddm = Driver.getDriver().findElement(By.xpath("//*[@id='discount_type']"));
        ddm.sendKeys("Fixed Product Discount");
        spendinGoodPage.fixedProductDiscount.click();

        //4.Discount amaunt kismina istenen miktari yazar
        spendinGoodPage.discountAmaunt.clear();
        Thread.sleep(1000);
        spendinGoodPage.discountAmaunt.sendKeys("10");

        //5.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);

        //6.Coupon Successfully Published yazisinin gorundugunu test eder
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);

        //7.Sayfada Coupons'u tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        spendinGoodPage.coupons.click();

        //8.Coupons Listing'de olusturulan kuponun Discount Type'in "Fixed product discount" oldugunu  test eder
        String expectedDiscountType = "Fixed product discount";
        System.out.println(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText());
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[2]")).getText(), expectedDiscountType);

        //9.Coupons Listing'de olusturulan kuponun Amaunt'un 10 oldugunu dogrular
        String expectedDiscountAmaunt = "10";
        System.out.println(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText());
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[3]")).getText(), expectedDiscountAmaunt);

    }

    @Test(priority = 7)
    public void testTC_07() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.addNeww.click();

        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13007");
        //3.Coupon expiry date'i tiklar
        spendinGoodPage.expiryDateBox.click();
        //4.istenen yil, ay ve gun degerlerini girer
        WebElement ddm = Driver.getDriver().findElement(By.xpath("//*[@id='expiry_date']"));
        ddm.sendKeys("2022-12-31");
        spendinGoodPage.fixedProductDiscount.click();

        //5.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);

        //6.Coupon Successfully Published yazisinin gorundugunu test eder
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);

        //7.Sayfada Coupons'u tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        spendinGoodPage.coupons.click();

        //8.Coupons Listing'de olusturulan kuponun Expiry Datei'nin "December 31, 2022" oldugunu dogrular
        String expectedExpriyDateType = "December 31, 2022";
        System.out.println(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[5]")).getText());
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[5]")).getText(), expectedExpriyDateType);

    }

    @Test(priority = 8)
    public void testTC_08() throws InterruptedException {
        //1.Coupons sayfasinda Add New'i tiklar
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        spendinGoodPage.addNeww.click();

        //2.Code kismina istenen kodu yazar
        spendinGoodPage.codeBox.sendKeys("TC13008");

        //3.Ücretsiz gönderime izin ver/Allow free shipping secenegine tiklar
        spendinGoodPage.freeShippingBox.click();

        //4.magaza sayfasinda goster/Show on store kutusunu tiklar
        spendinGoodPage.showOnStoreBox.click();

        //5.Submit‘i tiklar
        WebElement submit = spendinGoodPage.submitButton;
        jse.executeScript("arguments[0].scrollIntoView(true);", submit);
        jse.executeScript("arguments[0].click();", submit);

        //6.Coupon Successfully Published yazisinin gorundugunu test eder
        String expectedSubmitSonucYazisi = "Coupon Successfully Published.";
        Assert.assertEquals(spendinGoodPage.couponSuccesfullyPublished.getText(), expectedSubmitSonucYazisi);

        //7.Coupon sayfasinda Allow free Shipping seceneginin isaretli oldugunu dogrular
        Thread.sleep(3000);
        Assert.assertTrue(spendinGoodPage.freeShippingBox.isSelected());

        //8.Coupon sayfasinda Show on Store seceneginin isaretli oldugunu dogrular
        Assert.assertTrue(spendinGoodPage.showOnStoreBox.isSelected());

        Thread.sleep(5000);

        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinGoodPage.coupons.click();
        for (int i = 0; i < 9; i++) {
            Driver.getDriver().findElement(By.xpath("(//*[@class='wcfm_coupon_delete wcfm-action-icon'])[1]")).click();
            Driver.getDriver().switchTo().alert().accept();
            Thread.sleep(3000);
        }
        Driver.closeDriver();
    }
}
