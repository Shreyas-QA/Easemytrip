package easemytrip_Testes;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import easemytrip_Pages.HomePage;

public class HomeTest extends BaseTest {

	@Test
	public void GetAllLanguages() {

		HomePage hpage = PageFactory.initElements(driver, HomePage.class);

		hpage.DisplayLanguages();
	}

}
