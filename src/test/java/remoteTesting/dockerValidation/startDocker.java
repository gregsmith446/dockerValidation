package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class startDocker {
	
	public void startFile() throws IOException, InterruptedException
	{		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");
		
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
				if (currentLine.contains("registered to the hub and ready to use"))
				{
					System.out.println("Server up and running");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();
		}
		
		Thread.sleep(15000);
		Assert.assertTrue(flag);
		
		runtime.exec("cmd /c start scale.bat");
				
		Thread.sleep(15000);
	}
	
	
}
