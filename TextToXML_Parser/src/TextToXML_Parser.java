import java.io.*;
import java.util.Scanner;

public class TextToXML_Parser {

	public static void main(String[] args) {
		
		
		File file;
		Scanner input = null;
		String delim="\t";
		PrintWriter writer = null;
		int i=0;
		ValidateFields fl=null;
		try
		{
			file = new File("data.txt");
			input = new Scanner(file);
			writer = new PrintWriter("data.xml", "UTF-8");
			writer.println("<POLICIES>");
		while(input.hasNext()) {
			String nextLine = input.nextLine();
		    i++;
		    if(i>1)
		    {
		    	String tokens[]=new parseLine(nextLine,delim).createTokens();
		    	if(tokens.length==5)
		    	{
		    		writer.println("<POLICY>");
		    		fl=new ValidateFields(tokens);
		    		if(fl.validateName(tokens[0]))
		    		{
		    			writer.println("<INSURED_NAME>"+tokens[0]+"</INSURED_NAME>");
		    		}
		    		else
		    		{
		    			writer.println("<INSURED_NAME type=\"Error\" Line=\""+i+"\"></INSURED_NAME>");
		    		}
		    		if(fl.validateNumber(tokens[1]))
		    		{
		    			writer.println("<PHONE_NUMBER>"+tokens[1]+"</PHONE_NUMBER>");
		    		}
		    		else
		    		{
		    			writer.println("<PHONE_NUMBER type=\"Error\" Line=\""+i+"\"></PHONE_NUMBER>");
		    		}
		    		if(fl.validateZip(tokens[2]))
		    		{
		    			
		    			writer.println("<ZIP>"+tokens[2]+"</ZIP>");
		    		}
		    		else
		    		{
		    			writer.println("<ZIP type=\"Error\" Line=\""+i+"\"></ZIP>");
		    		}		
		    		if(fl.validateCity(tokens[3]))
		    		{
		    			writer.println("<CITY>"+tokens[3]+"</CITY>");
		    		}
		    		else
		    		{
		    			writer.println("<CITY type=\"Error\" Line=\""+i+"\"></CITY>");
		    		}
		    		if(fl.validateDate(tokens[4]))
		    		{
		    			writer.println("<INSURANCE_DATE>"+tokens[4]+"</INSURANCE_DATE>");
		    		}
		    		else
		    		{
		    			writer.println("<INSURANCE_DATE type=\"Error\" Line=\""+i+"\"></INSURANCE_DATE>");
		    		}
		    		writer.println("</POLICY>");
		    	}
		    	else
		    	{
		    		writer.println("<POLICY type=\"Error\" Line=\""+i+"\"></POLICY>");
		    	}
		    }
		    
		}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println(ex);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			input.close();
			writer.println("</POLICIES>");
			writer.close();
		}
	}

}
