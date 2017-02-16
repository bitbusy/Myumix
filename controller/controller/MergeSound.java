package controller;

/*this is merging given list of all file into  a  single file..  it's works on wav formet file
 * 
 * 
 * 
 */

import java.util.List;
import java.io.File;

public class MergeSound {

	
	
public static Exception input(List<String> l,String out,int bit)
	{
	
		try
		{
		WavFile[] wavefile=new WavFile[l.size()];
		
		for(int i=0;i<l.size();i++)
			wavefile[i]=WavFile.openWavFile(new File(l.get(i)));
			
		WavFile wavout=WavFile.newWavFile(new File(out),bit,wavefile[0].getNumFrames(),16,44100);
		
		double[] temp=new double[2];
		double[] abdata=new double[2];
		boolean flag=false;
		while(true)
		{
			abdata[0]=0;
		for(WavFile wav:wavefile)
		{
			if(wav.getFramesRemaining()==0)
				{flag=true;break;}
			wav.readFrames(temp,1);
			abdata[0]+=temp[0];
			abdata[1]+=temp[1];
			
		}
			if(flag)
				break;
			abdata[0]/=l.size();
			abdata[1]/=l.size();
			wavout.writeFrames(abdata,1);
			
			
		}
		wavout.close();
		}catch(Exception ex)
		{
			return ex;
		}
		
		return null;
	}
	
	
	
	
}
