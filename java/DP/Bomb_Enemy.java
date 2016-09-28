package DP;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * @author kaizhang
 *
 */
public class Bomb_Enemy {
	public int maxKilledEnemies(char[][] grid) {
	    if(grid==null||grid.length==0)
	        return 0;
	    int max=0;
	    MyStack[]rowStack=new MyStack[grid.length];
	    MyStack[]colStack=new MyStack[grid[0].length];
	    for(int i=0;i<grid.length;i++)
	        rowStack[i]=new MyStack(grid[0].length);
	    for(int i=0;i<grid[0].length;i++)
	        colStack[i]=new MyStack(grid.length);
	    for(int i=0;i<grid.length;i++)
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]=='E'){
	                rowStack[i].stack[rowStack[i].pointer]++;
	                colStack[j].stack[colStack[j].pointer]++;
	            }
	            else if(grid[i][j]=='W'){
	                rowStack[i].pointer++;
	                colStack[j].pointer++;
	            }
	        }
	    for(int i=grid.length-1;i>=0;i--)
	        for(int j=grid[0].length-1;j>=0;j--){
	            if(grid[i][j]=='0')
	                max=Math.max(max,rowStack[i].stack[rowStack[i].pointer]+colStack[j].stack[colStack[j].pointer]);
	            else if(grid[i][j]=='W'){
	                rowStack[i].pointer--;
	                colStack[j].pointer--;
	            }
	        }
	    return max;
	}

	class MyStack{
	    int[]stack;
	    int pointer;
	    public MyStack(int size){
	        stack=new int[size];
	        pointer=0;
	    }
	}
	    public static void main(String[] args) {
	    	Bomb_Enemy test = new Bomb_Enemy();
	    	String[] arr ={"0E00","E0WE","0E00"};
	    	char[][] input = new char[arr.length][arr[0].length()];
	    	for(int i = 0 ; i < arr.length; i++){
	    		for(int j = 0 ; j < input[0].length; j++){
	    			input[i][j] = arr[i].charAt(j);
	    		}
	    	}
	    	System.out.println(test.maxKilledEnemies(input));
	    }
}
