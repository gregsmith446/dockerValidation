package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class startDocker {
	
	@Test
	public void startFile() throws IOException, InterruptedException
	{
		boolean flag = false;
		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");
		
		String f = "output.txt";
		BufferedReader reader = new BufferedReader(new FileReader(f));
		
		String currentLine = reader.readLine();
		
		while (currentLine != null)
		{
			if (currentLine.contains("Registering the node to the hub"))
			{
				System.out.println("Found the text");
				flag = true;
				break;
			}
			currentLine = reader.readLine();
		}
		
		reader.close();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	
	
}
