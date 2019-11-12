package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class stopDocker {

	@Test
	public void stopFile() throws IOException, InterruptedException
	{		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerDown.bat");
		
		String f = "output.txt";
		boolean flag = false;
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 80);
		Long stopNow = cal.getTimeInMillis();
		Thread.sleep(3000);
		
		while (System.currentTimeMillis() < stopNow)
		{
			if (flag)
			{
				break;
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String currentLine = reader.readLine();
			
			while (currentLine != null && !flag)
			{
				if (currentLine.contains("selenium-hub exited"))
				{
					System.out.println("Found the server shutdown text");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();
		}
		
		Thread.sleep(18000);
		Assert.assertTrue(flag);
		
		File fi = new File("output.txt");
		if(fi.delete())
		{
			System.out.println("log file deleted successfully");
		}
	}
}




