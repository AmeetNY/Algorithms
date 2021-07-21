/**
 * 
 */
package leetcode.string.longestsubstring;

/**
 * @author Ameet
 *
 */
public class MedianOfTwoSortedArrayOfDifferentLength 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] x = {};//{1, 3, 8, 9, 15};
        int[] y = {2, 3};//{7, 11, 18, 19, 21, 25};

        MedianOfTwoSortedArrayOfDifferentLength mm = new MedianOfTwoSortedArrayOfDifferentLength();
        double median = mm.findMedianSortedArrays(x, y);
        System.out.println("Median is : "+median);

	}

	public double findMedianSortedArrays(int input1[], int input2[]) 
	{
		if(input1.length > input2.length)
		{
			return findMedianSortedArrays(input2, input1);
		}
		
		int x = input1.length;
		int y = input2.length;
		
		int low = 0; //start is first index of array->x 
		int high = x; //end is last index of array - x
		
		while(low <= high)
		{
			int partitionX = (low+high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX)
			{
				if( (x+y) % 2 == 0)
					return  ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				else
					 return (double)Math.max(maxLeftX, maxLeftY);
			}
			else
				if(maxLeftX > minRightY)
				{
					//move left to x
					high = partitionX-1;
				}
				else
				{
					//move right to x
					low = partitionX+1;
				}
		}
		
		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
		
	}

}