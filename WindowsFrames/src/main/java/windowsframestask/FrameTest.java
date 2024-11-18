package windowsframestask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {

	WebDriver driver = new ChromeDriver();

	public void launchApp() {
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void frameswtich()

	{
		WebElement topframe = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topframe);
		WebElement leftframe = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(leftframe);
		System.out.println(driver.getPageSource());
		driver.switchTo().defaultContent();
		WebElement middleframe = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleframe);
		System.out.println(driver.getPageSource());
		driver.switchTo().defaultContent();
		WebElement rightframe = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(rightframe);
		System.out.println(driver.getPageSource());
		driver.switchTo().defaultContent();
		WebElement bottomframe = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottomframe);
		System.out.println(driver.getPageSource());
		driver.switchTo().defaultContent();
		driver.close();

	}

	public static void main(String[] args) {

		FrameTest FT = new FrameTest();
		FT.launchApp();
		FT.frameswtich();

	}

}
