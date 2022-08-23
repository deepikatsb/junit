package pages;

import org.openqa.selenium.WebElement;

public class BasePage {

	public Boolean isFirstElementChecked(WebElement element) {
		return element.isSelected();
	}
}
