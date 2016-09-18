import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class FileIO
{	
	private FileReader fileReader;
	private FileWriter fileWriter;
	private E_TYPE fileType;
	public static enum E_TYPE
	{
		READ,
		WRITE,
	}
	
	public FileIO()
	{
		
	}
	
	protected void finalize() throws Throwable
	{
		this.Close();
	}
	
	public FileIO( E_TYPE type, String path )
	{
		this();
		fileType = type;
		try 
		{
			switch( type )
			{
			case READ:
				fileReader = new FileReader( path );
				break;
			case WRITE:				
				try {
					fileWriter = new FileWriter( path );
				} catch (IOException e) {
					return;
				}
				break;
			}
		} 
		catch (FileNotFoundException e) 
		{
			return;
		}
	}
	
	public void Write( String msg )
	{
		if( null == fileWriter )
			return;
		
		try
		{
			for( int i = 0; i < msg.length(); ++i )
			{
			    fileWriter.append( msg.charAt(i) );
			}
		} 
		catch (IOException e) 
		{
			return;
		}
	}
	
	public FileReader GetInputsStream()
	{
		return this.fileReader;
	}
	
	public void Close()
	{
		switch( fileType )
		{
		case READ:
			if( null == fileReader )
				return;
			try {
				fileReader.close();
			} catch (IOException e) {
				return;
			}
			break;
		case WRITE:
			if( null == fileWriter )
				return;
			try {
				fileWriter.close();
			} catch (IOException e) {
				return;
			}
			break;
		}		
	}
}
