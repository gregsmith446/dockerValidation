package remoteTesting.dockerValidation;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromeTest3 {
	
@Test	
public void test3() throws MalformedURLException {
				
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL u = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(u, cap);
		
		driver.get("http://www.bing.com");
		System.out.println(driver.getTitle());
	}
}
