package hw5.services.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = "//select")
    private List<WebElement> sixDropdowns;

    @FindBy(xpath = "//*[@type='checkbox']")
    private List<WebElement> sixCheckBoxes;

    @FindBy(xpath = "//tbody//td[3]/a")
    private List<WebElement> sixUsernames;

    @FindBy(xpath = "//tbody//td[4]//span")
    private List<WebElement> sixDescriprions;

    @FindBy(xpath = "//tbody/tr/td[1]")
    protected List<WebElement> numbers;

    @FindBy(xpath = "//tbody//tr/td//a")
    private List<WebElement> nameList;

    @FindBy(xpath = "//tbody//div/span")
    private List<WebElement> heroesList;

    @FindBy(css = "select")
    protected List<WebElement> dropdowns;

    @FindBy(xpath = "//tbody//tr")
    protected List<WebElement> selectCheckboxForSergeyIvan;

    @FindBy(xpath = "//li[contains(text(), 'Vip: condition changed to true')]")
    private WebElement assertRow;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public String getSixDropdowns() {
        return String.valueOf(sixDropdowns.size());
    }

    public String getSixCheckboxes() {
        return String.valueOf(sixCheckBoxes.size());
    }

    public String getSixUsernames() {
        return String.valueOf(sixUsernames.size());
    }

    public String getSixDescription() {
        return String.valueOf(sixDescriprions.size());
    }

    public List<String> getNumber() {
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            listName.add(numbers.get(i).getText());
        }
        return listName;
    }

    public List<String> getUser() {
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            listName.add(nameList.get(i).getText());
        }
        return listName;
    }

    public List<String> getDescription() {
        List<String> listDescription = new ArrayList<>();

        String[] wolverineArrStr = heroesList.get(0).getText().split(" ");
        String wolverine = wolverineArrStr[0];

        String[] spiderManArrStr = heroesList.get(1).getText().split(" ");
        String spider = spiderManArrStr[0] + " " + spiderManArrStr[1];

        String[] punisherArrStr = heroesList.get(2).getText().split(" ");
        String punisher = punisherArrStr[0];

        String[] captainArrStr = heroesList.get(3).getText().split("\n");
        String capitan = captainArrStr[0] + " " + captainArrStr[1];

        String[] cyclopeArrStr = heroesList.get(4).getText().split("\n");
        String cyclope = cyclopeArrStr[0] + " " + cyclopeArrStr[1];

        String[] hulkArrStr = heroesList.get(5).getText().split("\n");
        String hulk = hulkArrStr[0] + hulkArrStr[1];

        listDescription.add(wolverine);
        listDescription.add(spider);
        listDescription.add(punisher);
        listDescription.add(capitan);
        listDescription.add(cyclope);
        listDescription.add(hulk);

        return listDescription;
    }

    public List<String> getRomanRole() {
        String[] resList = dropdowns.get(0).getText().split("\n");
        List<String> listRole = new ArrayList<>();
        for (int i = 0; i < resList.length; i++) {
            listRole.add(resList[i].trim());
        }
        return listRole;
    }

    //Exercise 3:

    public void selectVipCheckbox(String vip, String name) {
        for (WebElement element: selectCheckboxForSergeyIvan) {
            if (element.getText().contains(name)) {
                //System.out.println(element.getText());
                element.findElement(By.tagName("input")).click();
                //e.findElement(By.linkText(vip)).click();
            }
        }
    }

    public String getAssertRow() {
        return assertRow.getText().substring(9);
    }
}