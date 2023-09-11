package serilization;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;


public class SaveDate 
{
	public static void main(String argv[]) throws Exception 
	{
		FileOutputStream fos = new FileOutputStream("date.out");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Date date = new Date();
		
		oos.writeObject(date);
				
		System.out.println("Objecto Date escrito no ficheiro: " + date);
		
		oos.close();
		fos.close();
	}
} // end SaveDate