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
        @FindBy(id= "attributes_is_active_1")
        public WebElement colorRadioButton;
        @FindBy(id = "attributes_is_active_2")
        public WebElement sizeRadioButton;
        @FindBy(xpath = "//select[@id='attributes_value_2']")
        public WebElement sizeDdm;
        @FindBy(xpath = "//select[@id='attributes_value_1']")
        public WebElement colordropDownDown;
        @FindBy(xpath = "(//span[@title='Toggle Block'])[3]")
        public WebElement sizedropDownOk;
        @FindBy(id = "wcfm_products_manage_form_toptan-urun-gosterme-ayarlari_head")
        public WebElement toptanUrunGostermeAyarlari;
        @FindBy(xpath = "//select[@id='piecetype']")
        public WebElement pieceTypeDropDown;
        @FindBy(xpath = "//p[@class='unitpercart wcfm_title field_61d33933d88bd']")
        public WebElement unitsPerPieceYaziElementi;
        @FindBy(xpath = "(//*[text()='Min Order Quantity?'])[1]")
        public WebElement minOrderQuantity;
        @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
        public WebElement colorDdmSurchBox;
        @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
        public WebElement attributesSubmitButton;
        @FindBy(xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[2]")
        public WebElement toptanUrunGostermeAyarlariYaziElenemti;
        @FindBy(xpath = "//input[@id='unitpercart']")
        public WebElement unitsPerPiece;
        @FindBy(id= "wcfm_products_simple_submit_button")
        public WebElement tUgASubmit;
        @FindBy(xpath= "//tbody")
        public List<WebElement> ordersList;
        @FindBy(xpath= "(//*[text()='Orders'])[2]")
        public WebElement orderButton;
        @FindBy(xpath= "(//*[text()='Downloads'])[2]")
        public WebElement dowlands;
        @FindBy(xpath= "//tbody//tr//td")
        public List<WebElement> dowlandsProdockt;
        @FindBy(xpath= "(//*[text()='Addresses'])[2]")
        public WebElement adresses;
        @FindBy(xpath= "//tbody//tr")
        public List<WebElement> adressesWebElements;
        @FindBy(xpath= "(//*[text()='Account details'])[1]")
        public WebElement accountDetailsButton;
        @FindBy(xpath= "//input[@id='account_first_name']")
        public WebElement firstName;

























































        // ******************** Mustafa Bek Bey ***************



































































































        // ************ Mustafa Altin Bey ***************



































































































        // ************ Abdurrahim Bey ***************



































































































        // ************Suleyman bey ***************



































































































        // ************ Sefa bey ************
































































































    }


