package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendingGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US022 {
    Actions actions =new Actions(Driver.getDriver());
    SpendingGoodPage spendingGoodPage = new SpendingGoodPage();


    @Test
    public void test01() throws InterruptedException {

        //1- user spendingood anasayfasina gider

        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(3000);
        //  2- Anasayfada trending kategorisinde tumunu gor linki oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.TrendingButton.isDisplayed();

        //  3- Trending kategorisindeki tumunu gor linkine tiklar
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.TrendingButton.click();


        //  4- Trending kategorisinin ana sayfasina gidildigini test eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("trending"));






    }


    @Test
    public void test02() throws InterruptedException {





        //1-user spendingood anasayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(3000);
        //3- Trending kategorisindeki tumunu gor linkine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.TrendingButton.click();

        //  3- Dropdown menude Sort by : Default Sorting uzerine tiklar
        spendingGoodPage.dropDownMenu.click();
        //  4- Dropdown menude Sort by popularity uzerine tiklar

        Select select = new Select(spendingGoodPage.dropDownMenu);
        ReusableMethods.waitFor(2);
        select.selectByIndex(1);
        // 5- Urunlerin populerlige (popularity) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("popularity"));

        //  6- Dropdown menude Sort by average rating uzerine tiklar
        ReusableMethods.waitFor(2);
        select.selectByIndex(2);
        //  7- Urunlerin en cok oy alana (rating) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("rating"));
        //  8- Dropdown menude Sort by latest uzerine tiklar
        ReusableMethods.waitFor(2);
        select.selectByIndex(3);
        //  9- Urunlerin en yeniye(date) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("date"));
        //  10- Dropdown menude Sort by price:low to high uzerine tiklar
        ReusableMethods.waitFor(2);
        select.selectByIndex(4);
        //  11- Urunlerin dusukten yuksek fiyata (price) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("price"));
        //  12- Dropdown menude Sort by price:high to low uzerine tiklar
        ReusableMethods.waitFor(5);
        select.selectByIndex(5);
        //  13- Urunlerin yuksekten dusuk fiyata (price-desc) gore siralandigini test eder
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("price-desc"));

        // Driver.closeDriver();





    }
    @Test
    public void test03() throws InterruptedException {

        //1-user spendingood anasayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(3000);
        //3- Trending kategorisindeki tumunu gor linkine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.TrendingButton.click();

        //  3- Dropdown menude Sort by : Default Sorting uzerine tiklar
        spendingGoodPage.dropDownMenu.click();
        //  4- Dropdown menude Sort by popularity uzerine tiklar

        Select select = new Select(spendingGoodPage.dropDownMenu);
        ReusableMethods.waitFor(2);
        select.selectByIndex(4);
        ReusableMethods.waitFor(3);
        //  4- Ekrana gelen urunlerin dusuk fiyattan yuksek fiyata dogru siralandigini test eder

        ReusableMethods.waitFor(10);
        // Asagıdaki islem ile fiyati dusukten yuksege olan urunlerin fiyatları String bir list'e atılmıstır
        List<String> list = new ArrayList<>();
        for (WebElement w : spendingGoodPage.urunFiyatHighToLowListWE) {
            list.add(w.getText());
        }
        System.out.println(list);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(0) = " + list.get(1));
        System.out.println("list.get(0) = " + list.get(2));
        System.out.println("list.get(0) = " + list.get(3));
        System.out.println("list.get(0) = " + list.get(4));
        System.out.println("list.get(0) = " + list.get(5));
        System.out.println("list.get(0) = " + list.get(6));


        System.out.println("list.size() = " + list.size());

        // Asagıdaki islem ile String List teki elemanların icinden rakam dısındaki kararterler cıkarılmıstır
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replace("$", ""));
            list.set(i, list.get(i).replace(",", ""));
        }
        System.out.println("Rakamlardan olusan String List = " + list);  //[1.99, 5.00, 5.00, 5.00, 5.00, 7.00 9.00, 8.00 10.00]
        //Asagıdaki işlem ile list'in elemanlarında indirimden onceki fiyatlar cıkarılmıstır.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(" ")) {
                list.set(i, list.get(i).substring(0, list.get(i).indexOf(" ")));  // i = 7.00 9.00    1200.00 1400.00
                // list.get(i).indexOf(" ") --> bize bosluk olan karakterin indexini rakam olarak dondurur.
            }
        }

        //   System.out.println("abc.substring(0,6) = " + abc.substring(0, 7));     // 1200.00


        ///System.out.println(abc.indexOf(" "));
        //
        System.out.println("list eski fiyatlardan arindirilmis = " + list);

        List<Double> listDoubleActual = new ArrayList<>();
        for (String w : list) {
            listDoubleActual.add(Double.valueOf(w));
        }

        System.out.println("String den cevrilmis listDoubleActual = " + listDoubleActual);

        // Asagıda bu doublelist yeni bir arraylist olarak listDoubleexpected isimli yeni bir liste atanmıs,
        // Collections.sort komutu ile bu listenin elemanlari kucukten buyuge siralanmis
        // Assert ise de 2 liste karsilastirilmistir.

        List<Double> listDoubleExpected = new ArrayList<Double>(listDoubleActual);

        System.out.println(listDoubleExpected);

        //  ikinci yol
        //  for (Double w:listDoubleActual) {
        //      listDoubleExpected.add(w);
        //  }
        Collections.sort(listDoubleExpected);

        System.out.println("listDoubleExpected = " + listDoubleExpected);

        org.testng.Assert.assertEquals(listDoubleActual, listDoubleExpected);


    }

    @Test
    public void test04() throws InterruptedException {

        //1-user spendingood anasayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spengood"));
        Thread.sleep(3000);
        //3- Trending kategorisindeki tumunu gor linkine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendingGoodPage.TrendingButton.click();

        //  3- Dropdown menude Sort by : Default Sorting uzerine tiklar
        spendingGoodPage.dropDownMenu.click();
        //  4- Dropdown menude Sort by popularity uzerine tiklar

        Select select = new Select(spendingGoodPage.dropDownMenu);
        ReusableMethods.waitFor(2);
        select.selectByIndex(4);
        ReusableMethods.waitFor(3);
        //  4- Ekrana gelen urunlerin yuksek fiyattan dusuk  fiyata dogru siralandigini test eder

        ReusableMethods.waitFor(10);
        // Asagıdaki islem ile fiyati dusukten yuksege olan urunlerin fiyatları String bir list'e atılmıstır
        List<String> list = new ArrayList<>();
        for (WebElement w : spendingGoodPage.urunFiyatHighToLowListWE) {
            list.add(w.getText());
        }
        System.out.println(list);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(0) = " + list.get(1));
        System.out.println("list.get(0) = " + list.get(2));
        System.out.println("list.get(0) = " + list.get(3));
        System.out.println("list.get(0) = " + list.get(4));
        System.out.println("list.get(0) = " + list.get(5));
        System.out.println("list.get(0) = " + list.get(6));


        System.out.println("list.size() = " + list.size());

        // Asagıdaki islem ile String List teki elemanların icinden rakam dısındaki kararterler cıkarılmıstır
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).replace("$",""));
            list.set(i,list.get(i).replace(",",""));
        }
        System.out.println("Rakamlardan olusan String List = " + list);
        //Asagıdaki işlem ile list'in elemanlarında indirimden onceki fiyatlar cıkarılmıstır.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(" ")) {
                list.set(i,list.get(i).substring(0,list.get(i).indexOf(" ")));
                // list.get(i).indexOf(" ") --> bize bosluk olan karakterin indexini rakam olarak dondurur.
            }
        }

        //   System.out.println("abc.substring(0,6) = " + abc.substring(0, 7));


        System.out.println("list eski fiyatlardan arindirilmis = " + list);

        List<Double> listDoubleActual = new ArrayList<>();
        for (String w:list) {
            listDoubleActual.add(Double.valueOf(w));
        }

        System.out.println("String den cevrilmis listDoubleActual = " + listDoubleActual);

        // Asagıda bu doublelist yeni bir arraylist olarak listDoubleexpected isimli yeni bir liste atanmıs,
        // Collections.sort komutu ile bu listenin elemanlari kucukten buyuge siralanmis
        // Assert ise de 2 liste karsilastirilmistir.

        List<Double> listDoubleExpected = new ArrayList<Double>(listDoubleActual);

        System.out.println(listDoubleExpected);

        //  ikinci yol
        //  for (Double w:listDoubleActual) {
        //      listDoubleExpected.add(w);
        //  }
        Collections.sort(listDoubleExpected);

        System.out.println("listDoubleExpected = " + listDoubleExpected);
        Collections.reverse(listDoubleExpected);

        System.out.println("listDoubleExpected Reverse = " + listDoubleExpected);

        List<Double> listDoubleReverse = new ArrayList<Double>(listDoubleExpected);
        System.out.println("listDoubleReverseExpected = " + listDoubleReverse);//System.out.println("listDoubleExpected = " + listDoubleExpected);

        org.testng.Assert.assertEquals(listDoubleReverse,listDoubleExpected);
    }

}
