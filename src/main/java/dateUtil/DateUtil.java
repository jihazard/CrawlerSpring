package dateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static int checkStatus(String date) throws ParseException{
	
		SimpleDateFormat currentTimeKor = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = currentTimeKor.format ( currentTime );
		
		Date today = new SimpleDateFormat("yyyy.MM.dd").parse(mTime);
		Date writeDate = new SimpleDateFormat("yyyy.MM.dd").parse(date);
		
		Date before7Day = new Date ( );
		before7Day.setTime ( today.getTime ( ) - ( (long) 1000 * 60 * 60 * 24 * 15 ) );
     
		int result = before7Day.compareTo(writeDate);
		
		if(result < 0) {
			return 1;
		}
		return 0;
	}
}
