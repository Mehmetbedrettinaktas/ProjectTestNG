package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SpendingGoodPage {


        public SpendingGoodPage(){

            PageFactory.initElements(Driver.getDriver(),this);

        }
// ******************  Fatma Hanim ***************************

        // SIGN IN //

        @FindBy(css = ".login.inline-type")
        public static WebElement ilksignButton;

        @FindBy(xpath = "//*[@id='username']")
        public static WebElement SignemailBox;

        @FindBy(css = "#password")
        public WebElement passwordBox;

        @FindBy(css = ".woocommerce-form-login__submit")
        public WebElement ikinciSignIn;
        @FindBy(xpath = "(//a[.='My Account'])[1]")
        public static WebElement myAccountLink;

        @FindBy(css = "div>h2.page-title")
        public static WebElement myAccountTitle;
        //MY ACCOUNT LISTE YAZDIRMA LOCATELERI //
        @FindBy(css = ".icon-box.text-center>a>p")
        public static List<WebElement> myAccountPageList;

        @FindBy(css = ".woocommerce-MyAccount-navigation>ul>li")
        public static List<WebElement> dashboardList;

        //REGISTER LOCATELERI ///

        @FindBy(css = ".register.inline-type")
        public static WebElement register;
        @FindBy(xpath = "//*[text()='Become a Vendor']  ")
        public static WebElement BecomeVendor;
        @FindBy(xpath = "//*[@id='user_email']")
        public static WebElement EmailBox;
        @FindBy(css = "#passoword")
        public static WebElement PasswordBox;
        @FindBy(xpath = " //input[@id='passoword'] ")
        public static WebElement ConfirmPwdBox;
        @FindBy(css = ".wcfm_email_verified_input")
        public static WebElement verificationCodeBox;
        @FindBy(css = ".wcfm-message.wcfm-success")
        public static WebElement registrationSuccessfully;
        @FindBy(xpath = "//*[.='Not right now']")
        public static WebElement notRightNowButton;
        @FindBy(css = ".page-title")
        public static WebElement storeManagerTitle;
        @FindBy(xpath = "//*[@id=\"wcfm_menu\"]/div[18]/a/span[2]")
        public static WebElement LogoutButton;


        /////VENDOR HESABI NEGATIF TESTLER ICIN  ////

        @FindBy(xpath = "//input[@id='wcfm_membership_register_button']")
        public static WebElement registerbutton;
        @FindBy(xpath = "//*[text()='Email: This field is required.']")
        public static WebElement bosEmailHataMesaji;

        @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
        public static WebElement gecersizEmailHataMesaji;

        @FindBy(xpath ="//*[text()='Registration Successfully Completed.']")
        public static WebElement gecersizPasswordHataliMesaji;

        /////////////////////////////////////////////////////////////
        //verification code div.email method classi
        @FindBy(css = "div.email")
        public static WebElement geciciEmail;
        @FindBy(css = "a#renew")
        public WebElement emailBoxRefresh;
        @FindBy(xpath = "//tbody//tr[1]")
        public static WebElement geciciEmailBox;
        @FindBy(xpath = "//tbody//tr[2]")
        public WebElement onayEmail;
        @FindBy(xpath = "//*[@id='body_content_inner']")
        public static WebElement verificationCode;
        @FindBy(xpath = "//*[.='Visit now ...']")
        public WebElement visitNow;



















































































        // ************ Mihrican Hanim ************


































































































        // ************ Sirin Hanim ************




































































































        // ************ Mehmet Akin Bey ***********************
        @FindBy(xpath = "//*[text()='Sign In ']")
        public WebElement signIn;

        @FindBy(xpath = "//*[@id='username']")
        public WebElement userName;

        @FindBy(xpath = "//*[@id='password']")
        public WebElement password;

        @FindBy(xpath = "//li[@id='menu-item-1074']")
        public WebElement myAccount;

        @FindBy(xpath = "//*[text()='Store Manager']")
        public WebElement storeManager;

        @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
        public WebElement products;

        @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
        public WebElement addNew;

        @FindBy(xpath = "//*[@id='manage_stock']")
        public WebElement manageStock;

        @FindBy(xpath = "//*[@id='stock_qty']")
        public WebElement stockQty;

        @FindBy(xpath = "//*[@id='backorders']")
        public WebElement backOrders;

        @FindBy(xpath = "//*[text()='Shipping']")
        public WebElement shipping;

        @FindBy(xpath = "//*[@id='weight']")
        public WebElement weight;

        @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
        public WebElement processingTime;

        @FindBy(xpath = "//*[@class='shipping_class wcfm_title']")
        public WebElement shippingClass;

























































        // ************ Mehmet Aktas Bey ***************
        @FindBy(xpath = "//button[@name='login']")
        public WebElement signIn2;
        @FindBy(xpath = "//h2[text()='My Account']")
        public WebElement myAccountYazisi;
        @FindBy(xpath = "//h2[text()='Store Manager']")
        public WebElement storeManegerYazisi;
        @FindBy(xpath = "(//*[text()='Attributes'])[1]")
        public WebElement attributes;
        @FindBy(xpath = "//input[@id='attributes_is_active_1']")
        public WebElement colorButton;
        @FindBy(xpath = "//input[@id='attributes_is_active_2']")
        public WebElement sizeButton;
        @FindBy(xpath = "(// input[@class='select2-search__field'])[2]")
        public WebElement sizeDdmSurchBox;
        @FindBy(xpath = "(//span[@title='Toggle Block'])[2]")
        public WebElement colordropDownOk;
        @FindBy(xpath = "(//span[@title='Toggle Block'])[3]")
        public WebElement sizedropDownOk;
        @FindBy(xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[1]")
        public WebElement toptanUrunGostermeAyarlari;
        @FindBy(xpath = "//select[@id='piecetype']")
        public WebElement pieceTypeSurchBox;
        @FindBy(xpath = "(//*[text()='Units Per Piece'])[1]")
        public WebElement unitsPerPiece;
        @FindBy(xpath = "(//*[text()='Min Order Quantity?'])[1]")
        public WebElement minOrderQuantity;
        @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
        public WebElement colorDdmSurchBox;
        @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
        public WebElement attributesSubmitButton;
        @FindBy(xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[2]")
        public WebElement toptanUrunGostermeAyarlariYaziElenemti;



































































        // ******************** Mustafa Bek Bey ***************



































































































        // ************ Mustafa Altin Bey ***************



































































































        // ************ Abdurrahim Bey ***************



































































































        // ************Suleyman bey ***************
        @FindBy(xpath = "//*[text()='Sign In ']")
        public WebElement signIn1;
        @FindBy(xpath = "//span[contains(text(),'Reviews')]")
        public WebElement reviews;
        @FindBy(xpath = " //span[contains(text(),'Reports')]")
        public WebElement reports;
        @FindBy(xpath = "//*[text()='Product Reviews']")
        public WebElement producktreviews;
        @FindBy(xpath = "(//*[@class='wcfmmp-author-meta'])[1]")
        public WebElement author;
        @FindBy(xpath = "(//*[@class='wcfmmp-comments-content'])[1]")
        public WebElement comment;
        @FindBy(xpath = "(//*[@class='wcfmmp-rating'])[1]")
        public WebElement rating;
        @FindBy(xpath = "//*[text()='15 October 2022 16:48']")
        public WebElement dated;
        @FindBy(xpath = "//*[text()='Year']")
        public WebElement reportsyear;
        @FindBy(xpath = "//*[text()='Last Month']")
        public WebElement lastmonth;
        @FindBy(xpath = "(//*[text()='This Month'])[1]")
        public WebElement thismonath;
        @FindBy(xpath = "//*[text()='Last 7 Days']")
        public WebElement last7days;
        @FindBy(xpath = "//*[@class='wcfm-date-range']")
        public WebElement custom;
        @FindBy(xpath = "//*[@id='chart-placeholder-canvas']")
        public WebElement rapor;
        @FindBy(xpath = "(//div[text()='18'])[1]")
        public WebElement date1;
        @FindBy(xpath = "(//div[text()='18'])[2]")
        public WebElement date2;


































































































        // ************ Sefa bey ************
































































































    }


