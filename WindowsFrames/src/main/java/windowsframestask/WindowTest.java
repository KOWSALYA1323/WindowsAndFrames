package windowsframestask;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTest {
	WebDriver driver = new ChromeDriver();
	String secondWindow;

	public void launchApp() {
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void newWindow() {

		driver.findElement(By.linkText("Click Here")).click();
		String title = driver.getTitle();
		System.out.println("Before opening the new window-- " + title);

	}

	public void switchToNewTab() {

		driver.switchTo().newWindow(WindowType.WINDOW);
		secondWindow = driver.getWindowHandle();
		System.out.println("The current url " + driver.getCurrentUrl());
		System.out.println("The current title " + driver.getTitle());
		driver.close();
		driver.switchTo().defaultContent();

	}

	public static void main(String[] args) {
		WindowTest WT = new WindowTest();
		WT.launchApp();
		WT.newWindow();
		WT.switchToNewTab();

	}

}
