package pages;

import org.openqa.selenium.By;
import utils.TestUtils;

public class OrderModal extends BasePage {

    private static final By BTN_PLACE_ORDER = By.xpath("//button[normalize-space()='Place Order']");
    private static final By MODAL           = By.id("orderModal");
    private static final By TOTAL_LABEL     = By.id("totalm");

    private static final By NAME     = By.id("name");
    private static final By COUNTRY  = By.id("country");
    private static final By CITY     = By.id("city");
    private static final By CARD     = By.id("card");
    private static final By MONTH    = By.id("month");
    private static final By YEAR     = By.id("year");
    private static final By BTN_PURCHASE = By.xpath("//button[normalize-space()='Purchase']");

    private static final By SUCCESS_MODAL = By.cssSelector(".sweet-alert.showSweetAlert.visible");
    private static final By SUCCESS_TITLE = By.cssSelector(".sweet-alert.showSweetAlert.visible h2");

    public void clickPlaceOrder() { TestUtils.clickWithFallback(BTN_PLACE_ORDER); }
    public void waitOpen() { TestUtils.waitVisible(MODAL, 8); }

    public int getModalTotal() {
        String t = TestUtils.waitNonEmptyText(TOTAL_LABEL, 8);
        return Integer.parseInt(t.replaceAll("[^0-9]", ""));
    }

    public void fill(String name, String country, String city, String card, String month, String year) {
        TestUtils.type(NAME, name = "Hafidz Fauzi");
        TestUtils.type(COUNTRY, country = "Indonesia");
        TestUtils.type(CITY, city = "Cilacap");
        TestUtils.type(CARD, card ="230209045");
        TestUtils.type(MONTH, month = "12");
        TestUtils.type(YEAR, year = "2025");
    }

    public void purchase() {
        TestUtils.clickWithFallback(BTN_PURCHASE);
    }

    public boolean successVisible() {
        try {
            TestUtils.waitVisible(SUCCESS_MODAL, 8);
            String title = TestUtils.waitNonEmptyText(SUCCESS_TITLE, 6);
            return title.trim().equals("Thank you for your purchase!");
        } catch (Exception e) {
            return false;
        }
    }
}
