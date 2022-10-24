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
        //US_005

        @FindBy(xpath = "//tbody")
        public WebElement urunListe;
        @FindBy(xpath = "//*[@aria-label='Status']")
        public WebElement status;
        @FindBy(xpath = "//*[@aria-label='Stock']")
        public WebElement stock;
        @FindBy(xpath = "//*[@aria-label='Price: activate to sort column ascending']")
        public WebElement price;
        @FindBy(xpath = "//*[@aria-label='Date: activate to sort column ascending']")
        public WebElement date;
        @FindBy(xpath = "(//span[text()='Add New'])[1]")
        public WebElement addNewButonu;
        @FindBy(xpath = "//input[@id='is_virtual']")
        public WebElement virtualButonu;
        @FindBy(xpath = "//input[@id='is_downloadable']")
        public WebElement downloadableButonu;
        @FindBy(xpath = "//input[@id='pro_title']")
        public WebElement productTitle;
        @FindBy(xpath = "//input[@id='regular_price']")
        public WebElement priceSekmesi;
        @FindBy(xpath = "//img[@id='featured_img_display']")
        public WebElement buyukBosResimIkonu;
        @FindBy(xpath = "//button[@id='menu-item-browse']")
        public WebElement mediaLibrary;
        @FindBy(xpath = "(//*[@class='thumbnail'])[2]")
        public WebElement foto1;
        @FindBy(xpath = "//button[text()='Select']")
        public WebElement selectButonu;
        @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
        public WebElement kucukBosResimIkonu;
        @FindBy(xpath = "(//div[@class='thumbnail'])[16]")
        public WebElement foto2;
        @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
        public WebElement addToGallery;
        @FindBy(xpath = "//input[@value='401']")
        public WebElement categories;
        @FindBy(xpath = "//input[@value='335']")
        public WebElement brands;
        @FindBy(xpath = "//*[@data-id='excerpt']")
        public WebElement shortDescription;
        @FindBy(xpath = "//*[@data-id='description']")
        public WebElement longDescription;
        @FindBy(xpath = "//input[@name='submit-data']")
        public WebElement submitButton;

        // US_006

        @FindBy(xpath = "//input[@value='225']")
        public WebElement BestSeller;
        @FindBy(xpath = "//input[@value='235']")
        public WebElement HealthAndBeauty;
        @FindBy(xpath = "//input[@value='230']")
        public WebElement Electronics;
        @FindBy(xpath = "//input[@value='228']")
        public WebElement HomeAndGarden;
        @FindBy(xpath = "//input[@value='227']")
        public WebElement Trending;
        @FindBy(xpath = "//input[@value='232']")
        public WebElement BooksMusicFilm;
        @FindBy(xpath = "//input[@value='344']")
        public WebElement Fashion;
        @FindBy(xpath = "//input[@value='405']")
        public WebElement Games;
        @FindBy(xpath = "//input[@value='229']")
        public WebElement Accessories;
        @FindBy(xpath = "//input[@value='226']")
        public WebElement NewArrivals;

        // US_007

        @FindBy(xpath = "//input[@value='35']")
        public WebElement ElegantAutoGroup;
        @FindBy(xpath = "//input[@value='41']")
        public WebElement GreenGrass;
        @FindBy(xpath = "//input[@value='46']")
        public WebElement NodeJS;
        @FindBy(xpath = "//input[@value='47']")
        public WebElement NS8;
        @FindBy(xpath = "//input[@value='50']")
        public WebElement RED;
        @FindBy(xpath = "//input[@value='52']")
        public WebElement SkysuiteTech;
        @FindBy(xpath = "//input[@value='55']")
        public WebElement Sterling;














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
    //   @FindBy(xpath = "//span[text()='Sign In ']")
    //   public WebElement signIn;
        @FindBy(xpath = "(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[1]")
        public WebElement eMailButton;
      //  @FindBy(xpath = "(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]")
      //  public WebElement password;
        @FindBy(xpath = "//*[@name='login']")
        public WebElement signInButton;
    //  @FindBy(xpath = "(//*[text()='My Account'])[1]")
    //  public WebElement myAccount;
    //  @FindBy(xpath = "//*[text()='Store Manager']")
    //  public WebElement storeManager;
        @FindBy(xpath = "(//*[@class='text'])[6]")
        public WebElement coupons;
        @FindBy(xpath = "(//*[text()='Add New'])[1]")
        public WebElement addNeww;
        @FindBy(xpath = "//*[@id='title']")
        public WebElement codeBox;
        @FindBy(xpath = "//*[@id='description']")
        public WebElement descriptionBox;
        @FindBy(xpath = "//*[@id='discount_type']")
        public WebElement percentageDiscount;
        @FindBy(xpath = "//*[@id='discount_type']")
        public WebElement fixedProductDiscount;
        @FindBy(xpath = "//*[@id='coupon_amount']")
        public WebElement discountAmaunt;
        @FindBy(xpath = "//*[@id='expiry_date']")
        public WebElement expiryDateBox;
        @FindBy(xpath = "//*[@id='free_shipping']")
        public WebElement freeShippingBox;
        @FindBy(xpath = "//*[@id='show_on_store']")
        public WebElement showOnStoreBox;
     //  @FindBy(xpath = "(//*[@class='wcfm_submit_button'])[1]")
     //  public WebElement submitButton;
        @FindBy(xpath = "//*[@name='draft-data']")
        public WebElement draftButton;
        @FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
        public WebElement couponSuccesfullySaved;
        @FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
        public WebElement couponSuccesfullyPublished;
        @FindBy(xpath = "//*[@id='wcfm_coupon_manager_submit']")
        public WebElement pleaseInsertYazisi;
        @FindBy(xpath = "(//*[@type='text'])[3]")
        public WebElement minimumSpend;
        @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele wcfm_non_negative_input'])[2]")
        public WebElement maximumSpend;
        @FindBy(xpath = "//*[@id='individual_use']")
        public WebElement individualUse;
        @FindBy(xpath = "//*[@id='exclude_sale_items']")
        public WebElement excludeSale;
     //   @FindBy(xpath = "(//*[@class='select2-search__field'])[1]")
     //   public WebElement products;
        @FindBy(xpath = "(//*[@class='select2-search__field'])[2]")
        public WebElement excludeProducts;
        @FindBy(xpath = "(//*[@class='select2-search__field'])[3]")
        public WebElement productCategories;
        @FindBy(xpath = "(//*[@class='select2-search__field'])[4]")
        public WebElement excludeCategories;
        @FindBy(xpath = "//*[@id='customer_email']")
        public WebElement emailRestriction;
        @FindBy(xpath = "//*[@class='page_collapsible collapse-close']")
        public WebElement limitButton;
        @FindBy(xpath = "(//*[@class='wcfm-text wcfm-text-limit wcfm_non_negative_input wcfm_ele'])[1]")
        public WebElement limitPerCoupon;
        @FindBy(xpath = "(//*[@class='wcfm-text wcfm-text-limit wcfm_non_negative_input wcfm_ele'])[2]")
        public WebElement limitUsageXitems;
        @FindBy(xpath = "(//*[@class='wcfm-text wcfm-text-limit wcfm_non_negative_input wcfm_ele'])[3]")
        public WebElement limitperUser;
        @FindBy(xpath = "//*[@class='select2-results__option select2-results__option--highlighted']")
        public WebElement urun;
        @FindBy(xpath = "(//*[@class='select2-selection__choice'])[1]")
        public WebElement choiceProductsKAt;
        @FindBy(xpath = "(//*[@class='select2-selection__choice'])[2]")
        public WebElement choiceProductsExcKat;

























        // ************ Mustafa Altin Bey ***************



































































































        // ************ Abdurrahim Bey ***************



































































































        // ************Suleyman bey ***************



































































































        // ************ Sefa bey ************
































































































    }


