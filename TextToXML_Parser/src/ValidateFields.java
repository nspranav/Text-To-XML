import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateFields {

	String fields[];

	public ValidateFields(String[] fields)
	{
		this.fields=fields;
		//validateName(fields[0]);
	}
	public boolean  validateName(String name)
	{
		name=name.trim();
		//System.out.println(name);
		return name.chars().allMatch(x -> Character.isLetter(x));
	}
	public boolean validateNumber(String number)
	{
		number=number.trim();
		//System.out.println(number);
		return number.matches("\\(\\d{3}\\) \\d{3}-\\d{4}");
	}
	public boolean  validateZip(String zip)
	{
		try
		{
		zip=zip.trim();
		
		//System.out.println(zip.length());
		int n=Integer.parseInt(zip);
		if(n>=10000&&n<=99999)
		{
			return true;
		}
		return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean validateCity(String city)
	{
		city=city.trim();
		//System.out.println(city);
		if(city!=null)
			return true;
		return false;
	}
	
	public boolean validateDate(String Date)
	{
		Date=Date.trim();
		//System.out.println(Date);
		Date date=null;
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            date = sdf.parse(Date);
            if (!Date.equals(sdf.format(date))) {
                return false;
            }
            return true;
        } catch (ParseException ex) {
            return false;
        }
	}
}
