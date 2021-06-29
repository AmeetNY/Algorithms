/**
 * 
 */
package leetcode.levenshtein.distance;

/**
 * @author Ameet
 *
 */
public class LevenshteinDistanceAlgo 
{
	public static void main(String[] args)
	{
		System.out.println(" Levenshetein Distance is : "+getMinDistByLevenshteinAlgo("FLOMAX", "VOLMAX"));
	}

	public static int getMinDistByLevenshteinAlgo(String str1, String str2)
	{
		int T[][] = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<str1.length()+1; i++)
		{
			for(int j=0; j<str2.length()+1; j++)
			{
				if(i==0 && j==0)
					T[i][j] = 0;
				else
					if(i==0)
						T[i][j] = T[i][j-1]+1;
					else
						if(j==0)
							T[i][j] = T[i-1][j]+1;
						else
						{
							//if(str1[i-1].equals(str2[j-1]))
							if(str1.charAt(i-1) == str2.charAt(j-1))
								T[i][j] = T[i-1][j-1];
							else
								T[i][j] = getMin(T[i][j-1], T[i-1][j],T[i-1][j-1])+1;
						}
			}
		}
		return T[str1.length()][str2.length()];
	}
	
	public static int getMin(int x, int y, int z)
	{
		int min = 0;
		min = Math.min(x, y);
		return Math.min(z, min);
	}
}
