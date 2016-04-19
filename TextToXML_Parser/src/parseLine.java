
public class parseLine {

	private String delim;
	private String line;
	
	public parseLine(String line,String delim)
	{
		this.delim=delim;
		this.line=line;
	}
	
	public String[] createTokens()
	{
		return line.split(delim);
	}
	
}
