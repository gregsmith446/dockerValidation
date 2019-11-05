package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class firefoxStandAloneTest {

	public static void main(String[] args) throws MalformedURLException {
		
		// SETUP REMOTE WEB DRIVER
		
		// java class "URL"
		URL u = new URL("http://localhost:4444/wd/hub");
		// selenium class "capabilities"
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		// selenium class "RemoteWebDriver" takes as parameters (url, capabilities)
		RemoteWebDriver driver = new RemoteWebDriver(u, cap);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}

}
