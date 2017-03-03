package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
    private String location;
	public int getRow()
    {
		int row = Integer.parseInt(location.substring(1));
        return row - 1;
    }

    @Override
    public int getCol()
    {
    	//return the index of where the letter is
    	int col = location.charAt(0);
    	return col - 65;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        location = cellName;
    }

}
