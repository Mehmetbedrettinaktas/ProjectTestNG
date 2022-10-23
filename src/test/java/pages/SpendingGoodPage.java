package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SpendingGoodPage {


        public SpendingGoodPage() {

                PageFactory.initElements(Driver.getDriver(), this);

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

        @FindBy(xpath = "//*[text()='Registration Successfully Completed.']")
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



        @FindBy(xpath = "//*[@value='Sign In']")
        public WebElement userpassSignIn;
        @FindBy(xpath = "//a[text()='Orders']")
        public WebElement orders;
        @FindBy(xpath = "//*[@name='add-to-cart']")
        public WebElement addToCart;
        @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
        public WebElement cartButton;
        @FindBy(xpath = "//*[.='Checkout']")
        public WebElement checkout;
        @FindBy(xpath = "//a[@class='button wc-forward']")
        public WebElement viewCart;
        @FindBy(xpath = "//button[@name='apply_coupon']")
        public WebElement applyButton;
        @FindBy(xpath = "//p[@class='woocommerce-shipping-destination']")
        public WebElement shippinginfo;
        @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
        public WebElement procedToCheckOut;
        @FindBy(xpath = "//*[text()='Continue Shopping']")
        public WebElement continueShopping;
        @FindBy(xpath = "//button[@name='clear_cart']")
        public WebElement clearCartButton;
        @FindBy(xpath = "//p[text()='Your cart is currently empty.']")
        public WebElement ClearTextYazisi;
        @FindBy(xpath = "//p[text()='No products in the cart.']")
        public WebElement cartNoProductsYazisi;
        @FindBy(xpath = "(//input[@class='form-control'])[1]")
        public WebElement search;
        @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/div/h3/a")
        public WebElement tShirt;
        @FindBy(xpath = "//*[@title='Plus']")
        public WebElement plus;
        @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
        public WebElement cart;
        @FindBy(xpath = "//input[@name='billing_first_name']")
        public WebElement firstName;
        @FindBy(xpath = "//button[@id='place_order']")
        public WebElement placeOrder;
        @FindBy(xpath = "//*[text()='Thank you. Your order has been received.']")
        public WebElement thankYou;
        @FindBy(xpath = "//li[@class='wc_payment_method payment_method_cod']")
        public WebElement payAtTheDoor;
        @FindBy(xpath = "//input[@name='billing_last_name']")
        public WebElement lastName;
        @FindBy(xpath = "//input[@name='billing_company']")
        public WebElement companyName;
        @FindBy(xpath = "//select[@id='billing_country']")
        public WebElement country;
        @FindBy(xpath = "//input[@id='billing_postcode']")
        public WebElement postcode;
        @FindBy(xpath = "//input[@id='billing_city']")
        public WebElement town;
        @FindBy(xpath = "//select[@id='billing_state']")
        public WebElement state;
        @FindBy(xpath = "//input[@id='billing_phone']")
        public WebElement phone;
        @FindBy(xpath = "//input[@id='billing_email']")
        public WebElement emailCheckout;
        @FindBy(xpath = "//*[@id='order_comments']")
        public WebElement orderNotes;
        @FindBy(xpath = "//*[text()='Product']")
        public WebElement myOrderproduct;
        @FindBy(xpath = "//*[text()='Price']")
        public WebElement myOrderPrice;
        @FindBy(xpath = "//*[text()='Quantity']")
        public WebElement myOrderQuantity;
        @FindBy(xpath = "//*[text()='Subtotal']")
        public WebElement myOrderSubTotal;
        @FindBy(xpath = "//button[@title='Minus']")
        public WebElement minusButton;
        @FindBy(xpath = "//div[@id='product-14989']")
        public WebElement superKahramanOyuncak;
        @FindBy(xpath = "//div[@id='product-15375']")
        public WebElement hoparlor;
        @FindBy(xpath = "//div[@id='product-15391']")
        public WebElement arcelik;
        @FindBy(xpath = "//div[@id='product-14986']")
        public WebElement kalemlik;
        @FindBy(xpath = "(//span[@class='quantity'])[1]")
        public WebElement artieksiKutu;
        @FindBy(xpath = "//*[@name='update_cart']")
        public WebElement updateCartButton;

        @FindBy(xpath = "//p[@class='stock in-stock']")
        public WebElement ilkinStokInformation;

        @FindBy(xpath = "//input[@type='number']")
        public WebElement sonInStokInformation;









































































































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



































































































        // ************ Sefa bey ************
































































































    }


