package CommonUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

public void maximizewindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}

public void WaitWebelementToLoad(WebDriver driver) {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

public void handledropdown(WebElement target,String text) {
	
	Select s = new Select(target);
	s.selectByVisibleText(text);
}

public void mousehover(WebDriver driver,WebElement target) {
	
	Actions a = new Actions(driver);
	a.moveToElement(target);
	a.perform();
}
}
