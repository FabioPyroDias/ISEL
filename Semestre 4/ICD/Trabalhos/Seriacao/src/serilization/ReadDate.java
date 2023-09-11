package serilization;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;


public class ReadDate 
{
	public static void main(String argv[]) throws Exception 
	{
		FileInputStream fis = new FileInputStream("date.out");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Date date = (Date) ois.readObject();
		
		System.out.println("The date is: "+date);
		
		ois.close();
		fis.close();
	}
} // end Date