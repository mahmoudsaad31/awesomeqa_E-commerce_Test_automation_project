package com.awesomeqa.pages;

import com.awesomeqa.utils.BrowserActions;
import com.awesomeqa.utils.ElementActions;
import com.awesomeqa.utils.Validations;
import com.awesomeqa.utils.Waits;
import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import com.awesomeqa.utils.report.LogsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {


    // locators
    private By MyAccount = By.cssSelector("[title='My Account']");
    private By Register = By.linkText("Register");
    private By Login = By.linkText("Login");
    private By SearchBar = By.name("search");
    private By SearchButton = By.cssSelector(".col-sm-5 button");
    private By Currency = By.xpath("//*[@class='btn-group']/button");
    private By CurrencyLabel = By.xpath("//*[@class='btn-group']/button/strong");
    private By Euro = By.cssSelector("button[name='EUR']");
    private By PoundSterling = By.cssSelector("button[name='GBP']");
    private By UsDollar = By.cssSelector("button[name='USD']");
    private By Msg = By.className("alert");
    private By CartIcon = By.cssSelector("#cart button");
    private By CartIconMSG = By.xpath("//p[.='Your shopping cart is empty!']");
    private By ViewCart = By.partialLinkText("Cart");
    private By CheckOut = By.partialLinkText("Checkout");
    private By productPrice = By.cssSelector(".price");
    private By ProductComparison = By.linkText("product comparison");


    // constructor
    public HomePage() {
    }

    // actions
    public void navigateToHomePage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("homeURL"));
    }

    public void clickOnProductComparison() {
        ElementActions.clickElement(ProductComparison);
    }

    public void clickOnSpecificProductTOseeDetails(String ProductName) {
        By product = By.xpath("//a[text()='" + ProductName + "']");
        ElementActions.clickElement(product);
    }

    public void AddSpecificProductToCart(String ProductName) {
        By AddToCartButton = RelativeLocator.with(By.xpath("//*[@class='button-group']/button[1]")).below(By.xpath("//a[text()='" + ProductName + "']"));
        ElementActions.clickElement(AddToCartButton);
    }

    public void AddSpecificProductToWishList(String ProductName) {
        By AddToWishListButton = RelativeLocator.with(By.cssSelector("[data-original-title='Add to Wish List']")).below(By.xpath("//a[text()='" + ProductName + "']"));
        ElementActions.clickElement(AddToWishListButton);
    }

    public void AddSpecificProductToComparison(String ProductName) {
        By AddTOComparisonButton = RelativeLocator.with(By.cssSelector("[data-original-title='Compare this Product']")).toRightOf(By.xpath("//a[text()='" + ProductName + "']"));
        ElementActions.clickElement(AddTOComparisonButton);
    }

    public void RemoveSpecificProductFromCart(String ProductName) {
        LogsUtils.info("removing product ", ProductName, " from cart ");
        By RemoveProduct = RelativeLocator.with(By.cssSelector("button[title='Remove']")).toRightOf(By.linkText(ProductName));
        ElementActions.clickElement(RemoveProduct);
    }


    public void assertProductRemovedFromCart(String ProductName) {
        By product = By.xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]");
        Validations.validateNotEquals(ElementActions.getData(product), ProductName);
        LogsUtils.info("assert" + ProductName + "RemovedFromCart");
    }


    public void clickOnMyAccount() {
        ElementActions.clickElement(MyAccount);
    }

    public void clickOnRegister() {
        ElementActions.clickElement(Register);
    }

    public void clickOnLogin() {
        ElementActions.clickElement(Login);
    }

    public void searchFeature(String searchData) {
        ElementActions.sendData(SearchBar, searchData);
        ElementActions.clickElement(SearchButton);
    }

    public void clickOnCurrency() {
        ElementActions.clickElement(Currency);
    }

    public void clickOnEuro() {
        ElementActions.clickElement(Euro);
    }

    public void clickOnPoundSterling() {
        ElementActions.clickElement(PoundSterling);
    }

    public void clickOnUsDollar() {
        ElementActions.clickElement(UsDollar);
    }

    public void clickOnCartIcon() {
        ElementActions.clickElement(CartIcon);
    }

    public void clickOnViewCartIcon() {
        ElementActions.clickElement(ViewCart);
    }

    public void clickOnCheckOutIcon() {
        ElementActions.clickElement(CheckOut);
    }


    public String getPageMSG() {
        return ElementActions.getData(Msg);
    }

    public String getCartIconMSG() {
        return ElementActions.getData(CartIconMSG);
    }

    public String getCUrrencyLabel() {
        return ElementActions.getData(CurrencyLabel);
    }


    public void assertProductAddedToCart(String ProductName) {
        Waits.sleepForCertainTime(2000);
        Validations.validateContains(getPageMSG(), "Success: You have added " + ProductName + " to your shopping cart!");
    }

    public void assertProductAddedToWishList(String ProductName) {
        Waits.sleepForCertainTime(2000);
        Validations.validateContains(getPageMSG(), "Success: You have added " + ProductName + " to your wish list!");
    }

    public void assertProductAddedToComparison(String ProductName) {
        Waits.sleepForCertainTime(2000);
        Validations.validateContains(getPageMSG(), "Success: You have added " + ProductName + " to your product comparison!");
    }

    public void assertDirectedToCheckOutPage() {
        Waits.sleepForCertainTime(2000);
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("ckeckoutPageTile"));
    }


    public void assertCurrencyChangedToNewCurrency(String Currency) {
        Waits.waitForTextToBe(CurrencyLabel, Currency);
        Validations.validateEquals(getCUrrencyLabel(), Currency);
    }

    public String getProductPrice() {
        return ElementActions.getData(productPrice);
    }

    public void assertcurrencyChangedInproductPrice(String Currency) {
        Validations.validateContains(getProductPrice(), Currency);
    }

    public void assertDirectedToLoginPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("loginPageTitle"));
    }

    public void assertDirectedToRegisterPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("RegisterPageTitle"));
    }

    public void assertsuccessfullSearchForSpecificWord(String searchdata) {
        Validations.validateContains(getSearchedpagetitle(), searchdata);

    }

    private String getSearchedpagetitle() {
        return BrowserActions.getPageTitle();
    }

    public void assertDirectedToViewCartPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("ShopingCartPageTitle"));
    }

    public void assertDirectedToProductComparisonPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("ProductComparisonPageTitle"));
    }

}
