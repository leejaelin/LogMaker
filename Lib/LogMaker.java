import java.io.File;
import java.io.IOException;

public class LogMaker {
	public LogMaker()
	{
		
	}
	
	public void Run()
	{
		processPerfomanceLog("");
		//processDisconnectLog("");		
	}
	
	private void processPerfomanceLog( String path )
	{
		FileIO tmpFile = new FileIO( FileIO.E_TYPE.WRITE, "D:\\tmp.txt" );
				
		File dir = new File( "D:\\" );
		if( !dir.isDirectory() )
			return;
		
		File []dirList = dir.listFiles();
		for( File file : dirList )
		{	
			if( !file.isFile() )
				continue;
			
			char []read = new char[(int) file.length()];
			FileIO readFile = new FileIO(FileIO.E_TYPE.READ, file.getPath());
			
			try 
			{
				readFile.GetInputsStream().read( read );
				tmpFile.Write( new String( read  ) );
			} 
			catch (IOException e) 
			{
				continue;
			}
			finally
			{
				readFile.Close();
			}
		}
		tmpFile.Close();
	}
	
	private void processDisconnectLog( String path )
	{
		FileIO tmpFile = new FileIO( FileIO.E_TYPE.WRITE, "D:\\tmp2.txt" );
		
		File dir = new File( "D:\\" );
		File []dirList = dir.listFiles();
		for( File file : dirList )
		{				
			tmpFile.Write( file.getPath() + '\n');
		}
		
		tmpFile.Close();
	}
}
