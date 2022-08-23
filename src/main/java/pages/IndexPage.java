package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IndexPage {

	WebDriver driver;
	String before = "todo[";
	String after = "]";
	WebElement element;
	String displayed_text;
	String updated_text;
	int i = 0, j = 0;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Test 1: Validate when the toggle all check box is CHECKED, all check boxes
	 * for list items are also CHECKED ON.
	 */

	@FindBy(how = How.NAME, using = "allbox")
	WebElement toggleAll_Element;
	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement first_Element;
	@FindBy(how = How.NAME, using = "todo[1]")
	WebElement second_Element;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Remove']")
	WebElement remove_Element;

	public void clickToggleAllElement() {
		if (toggleAll_Element.isDisplayed())
			toggleAll_Element.click();
	}

	public void validateElementAreChecked() {
		while (i < 10) {
			if (existsElement(before + i + after)) {
				if ((driver.findElement(By.name(before + i + after)).isSelected())) {
					i++;
				}
			} else {
				break;
			}
		}
		System.out.println("Checkboxes are checked");
	}


	public void validateRemoveItem() {
		while (j < 10) {
			if (existsElement(before + j + after)) {
				driver.findElement(By.name(before + j + after)).click();
				displayed_text = driver.findElement(By.name(before + j + after)).getText();
				remove_Element.click();
				break;
			} else {
				j++;
			}
		}
		updated_text = driver.findElement(By.name(before + (j + 1) + after)).getText();
		if (!(updated_text.equals(displayed_text))) {
			System.out.println("Item is Removed" + j);
		}
	}

	public void validateToggleAllAndRemove1() {
		toggleAll_Element.click();
		remove_Element.click();
		if (!existsElement("todo[1]")) {

			System.out.println("All Checkboxes Removed and Deleted Succesfully!");
		}
	}

	public boolean existsElement(String id) {
		try {
			driver.findElement(By.name(id));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
