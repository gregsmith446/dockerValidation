package remoteTesting.dockerValidation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class chromeTest1 {
	
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException
	{
		startDocker s = new startDocker();
		s.startFile();
	}
	
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException
	{
		stopDocker d = new stopDocker();
		d.stopFile();
	}
	
@Test	
public void test1() throws MalformedURLException {
				
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL u = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(u, cap);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}
}
