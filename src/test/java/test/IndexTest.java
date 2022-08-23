package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.IndexPage;
import util.BrowserFactory;

public class IndexTest {

	WebDriver driver;
	IndexPage indexPage;
	
	@Test
	public void validateToggleAllElement() {
		
		driver = BrowserFactory.init();
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.clickToggleAllElement();
		indexPage.validateElementAreChecked();
		BrowserFactory.tearDown();
		
	}
	/*
	 * Test 2: Validate that a single list item could be removed using the remove
	 * button when a single checkbox is selected.
	 */
	@Test
	public void usershouldBeAbleToRemoveSingleItemUsingRemove() {
		driver = BrowserFactory.init();
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.validateRemoveItem();
		BrowserFactory.tearDown();
		
	}
	/*
	 * Test 3: Validate that all list item could be removed using the remove button
	 * and when "Toggle All" functionality is on.
	 */
	@Test
	public void userShouldBeableToRemoveAllItemsWithtoggleAllAndRemoveButton() {
		driver = BrowserFactory.init();
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.validateToggleAllAndRemove1();
		BrowserFactory.tearDown();
	}

}
