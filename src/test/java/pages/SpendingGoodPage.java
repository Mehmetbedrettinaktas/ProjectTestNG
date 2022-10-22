package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SpendingGoodPage {

    public SpendingGoodPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


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


    @FindBy(xpath = "//*[text()='Gateaway']")
    public WebElement gateaway;

    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;


    @FindBy(xpath = "(//*[contains(text(),'Product Successfully Published.')])[1]")
    public WebElement yazi;



}
