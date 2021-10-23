package easemytrip_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(css = "div.language_col select#LangSel")
	public List<WebElement> ClickOnLanguage;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> DisplayLanguages() {

		List<WebElement> alllangs = driver.findElements(By.cssSelector("div.language_col select#LangSel"));
		for (WebElement en : alllangs) {

			System.out.println(en.getText());
		}

		return alllangs;

	}

}
