

import java.util.StringTokenizer;

public class PNGreedy {
	public static String plot = new String ();
	
	public String print(String text,int LineWidth)
	  
	{ 	String plot = "";
		int defaultSpaceWidth=1;
		StringTokenizer st=new StringTokenizer(text);
		int SpaceLeft=LineWidth;
		int SpaceWidth=defaultSpaceWidth;
		while(st.hasMoreTokens())
		{
			String word=st.nextToken();
			if((word.length()+SpaceWidth)>SpaceLeft)
			{
			System.out.print("\n"+word+" ");
			plot += "\n"+word+" ";
				SpaceLeft=LineWidth-word.length();
			}
			else
			{
			System.out.print(word+" ");
				plot += word+" ";
				
				SpaceLeft-=(word.length()+SpaceWidth);
			}
			
		}
		return plot;
	}
	
}
