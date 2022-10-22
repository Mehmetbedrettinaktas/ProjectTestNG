package US;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import pages.SpendingGoodPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class VerificationCodeMethodFatma {

        static String email;

        static int code;

        public static void getEmailCode() {

            SpendingGoodPage page= new SpendingGoodPage();

            ReusableMethods.waitFor(2);

            //yeni tabda gecici email sitesine git

            Driver.getDriver().switchTo().newWindow(WindowType.TAB);

            Driver.getDriver().get("https://www.mohmal.com/tr/inbox");

            List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
            Driver.getDriver().switchTo().window(windowList.get(1));
            ReusableMethods.waitFor(2);

            email = SpendingGoodPage.geciciEmail.getText();
            System.out.println(email);

            Driver.getDriver().switchTo().window(windowList.get(0));

            ReusableMethods.waitFor(2);

            SpendingGoodPage.EmailBox.sendKeys(VerificationCodeMethodFatma.email);
            ReusableMethods.waitFor(1);

            SpendingGoodPage.verificationCodeBox.click();

            ReusableMethods.waitFor(2);

            Driver.getDriver().switchTo().window(windowList.get(1));

            ReusableMethods.waitFor(2);

            Driver.getDriver().navigate().refresh();


            SpendingGoodPage.geciciEmailBox.click();

            WebElement iframe = Driver.getDriver().findElement(By.cssSelector("div>#read>div>iframe")); //iframe gir
            Driver.getDriver().switchTo().frame(iframe);


            ReusableMethods.waitFor(2);
            code = Integer.parseInt(SpendingGoodPage.verificationCode.getText().replaceAll("\\D", ""));

            String code2 = String.valueOf(code);

            Driver.getDriver().switchTo().defaultContent(); //iframe den cikis


            Driver.getDriver().switchTo().window(windowList.get(0));

            SpendingGoodPage.verificationCodeBox.sendKeys(code2);
        }
    }

