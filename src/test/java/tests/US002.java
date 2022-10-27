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
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US002 {

        @Test
        public void Test01 () {

            SpendingGoodPage page=new SpendingGoodPage();

            // vendor http://spendinggood.com// sayfasina gider
            Driver.getDriver().get(ConfigReader.getProperty("spengood"));


            // Anasayfada Sign In simgesine tiklar
            SpendingGoodPage.SignIn.click();


            // Gecerli Email ve Password girer ve SIGN IN butonuna tiklar
            SpendingGoodPage.SignemailBox.sendKeys(ConfigReader.getProperty("mail"));
            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("Password"))
                    .sendKeys(Keys.ENTER).perform();

           ReusableMethods.waitFor(4);

            // My Account simgesine tiklar
            SpendingGoodPage.myAccountLink.click();

            // My Account göründügünü test eder
            Assert.assertTrue(SpendingGoodPage.myAccountLink.isDisplayed());
            Assert.assertTrue(SpendingGoodPage.myAccountTitle.isDisplayed());

            ReusableMethods.waitFor(2);

            // Orders, Downloads, addresses, account details,whislist ve Logout goruldügü konsolda yazilir
            List< String> mapl=new ArrayList<>();
            for (WebElement w:SpendingGoodPage.myAccountPageList) {
                mapl.add(w.getText());
                System.out.println(w.getText());

            }

            System.out.println("==============================");

            // Dashboard altında ise; Store manager, Orders, Downloads, Addresses , Account details,Wishlist
            //Support tickets, Followings ve Logout olmali ve konsolda görülmeli

            List< String> dhl=new ArrayList<>();
            for (WebElement w:SpendingGoodPage.dashboardList) {
                dhl.add(w.getText());
                System.out.println(w.getText());

            }

            Driver.closeDriver();

        }
    }





