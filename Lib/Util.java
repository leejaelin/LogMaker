import java.util.Calendar;

public class Util {
	public static String GetCurrentDate()
	{
		Calendar today = Calendar.getInstance();
		StringBuilder YYYYMMDD = new StringBuilder();
		YYYYMMDD.append(String.format("%04d", today.get(Calendar.YEAR)));
		YYYYMMDD.append(String.format("%02d", today.get(Calendar.MONTH)));
		YYYYMMDD.append(String.format("%02d", today.get(Calendar.DATE)));
		return YYYYMMDD.toString();
	}
}
