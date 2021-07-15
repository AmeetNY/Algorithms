/**
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically. 
 *
 */
package leetcode.surroundedregions;

/**
 * @author Ameet
 *
 */
public class Surrounded_Regions_Done
{
	private  static boolean seen = false;
	
	public static void main(String[] args) 
	{
		//char board[][] = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

		//char board[][] = {{'X'}};

		//char board[][] = {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
		//[['X','O','X'],['X','O','X'],['X','O','X']]

		char board[][] = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
		
		Surrounded_Regions_Done surrounded_Regions = new Surrounded_Regions_Done();
		int r = board.length;
		
			if(r<=1)
	            return;
			
			int c  = board[0].length;
			
			if(c<=1)
	            return;
			
			boolean visited[][] = new boolean[r][c];
		
		System.out.println("Given matrix: ");
		surrounded_Regions.print_matrix(board, r, c);
		
		for(int i=1; i<r-1; i++)
		{
			for(int j=1; j<c-1; j++)
			{
				if(board[i][j]=='O' && !visited[i][j])
				{
					seen = false;
					surrounded_Regions.dfs(board, i, j, r, c, visited);
					if(seen==false)
						surrounded_Regions.mark(board, i,  j, r,  c);
					seen = true;
				}
			}
		}
		
		System.out.println("Solved matrix: ");
		surrounded_Regions.print_matrix(board, r, c);
	}
	
	public void dfs(char board[][], int i, int j, int r,  int c, boolean visited[][])
	{
		if(i<0 || i> r-1 || j<0 || j>c-1)
			return;
		
		if(board[i][j] == 'X' || visited[i][j])
			return;
		
		if(i<=0 || i>=r-1 || j<=0 || j>=c-1)
			seen = true;
		
		visited[i][j] = true;
		dfs(board, i-1,  j , r, c, visited);
		dfs(board, i+1,  j , r, c, visited);
		dfs(board, i,  j-1 , r, c, visited);
		dfs(board, i,  j+1 , r, c, visited);
	}
	
	public void mark(char board[][], int i, int j,  int r,  int c)
	{
		if(i<0 || i>r-1 || j<0 || j>c-1)
			return;
			
		if(board[i][j] == 'X')
			return;
		
		board[i][j] = 'X';
		mark(board, i+1, j, r, c);
		mark(board, i-1, j, r, c);
		mark(board, i, j-1, r, c);
		mark(board, i, j+1, r, c);
	}
	
	public void print_matrix(char board[][], int m , int n) 
	{
		for (int i = 0; i < m; i++) 
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(" "+board[i][j] + " ");
			}

			System.out.println();
		}
	}

}
