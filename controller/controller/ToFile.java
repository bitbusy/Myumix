package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ToFile {
	
	
	public static String ToFileWrite(InputStream file,String filename)
	{
		
		try
		{
			
		FileOutputStream out = new FileOutputStream(filename); 
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int data = file.read();
        while (data >= 0) {
            outputStream.write(data);
            data = file.read();
        }
        byte[] bytesToWriteTo = outputStream.toByteArray();
		out.write(bytesToWriteTo);
		out.flush();
		out.close();

		}
		catch(Exception ex)
		{
			//return ex.toString();
		}
		
		return filename;
	}
	
	public static InputStream toInputStream(String str)
	{ FileInputStream in;
		try
	{
		in=new FileInputStream(new File(str));
	}catch(Exception ex)
	{
		return null;
	}
		 return (InputStream)in;
	}

}
