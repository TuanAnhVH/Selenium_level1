package railway;

import common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainPriceListPage extends GeneralPage{

    //Elements
    protected WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        String path = String.format("//li[text()='%s to %s']//ancestor::tr//a[@class='BoxLink']", departStation, arriveStation);
        return this.getElement(By.xpath(path));
    }

    //Methods
    public void checkPrice(String departStation, String arriveStation) {
        clickOnElement(getBtnCheckPrice(departStation, arriveStation));
    }
}
