public class FireModel
{
    public static int SIZE = 100;
    private FireCell[][] myGrid;
    private FireView myView;
    private boolean safe = true;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */

    public void solve()
    {
    	for(int i = 0; i < SIZE; ++i) {
    		solveHelper(myGrid, SIZE - 1, i);
    	}
    	if(safe == false) {
    		System.out.println("Onett is in danger!");
    	}else if(safe == true) {
    		System.out.println("Onett is safe!");
    	}
      //myView.updateView(myGrid);
    }
    
    private void solveHelper(FireCell[][] grid, int x, int y) {
    	myView.updateView(myGrid);
    	try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(grid[x][y].getStatus() != FireCell.GREEN) {
			return;
		}
		
		if(x == 0) {
			safe = false;
		}
		grid[x][y].setStatus(FireCell.BURNING);
		if(x + 1 < SIZE) {
			solveHelper(grid, x+1, y);
		}
		if(y + 1 < SIZE) {
			solveHelper(grid, x, y+1);
		}
		if(x - 1 >= 0) {
			solveHelper(grid, x-1, y);
		}
		if(y - 1 >= 0) {
			solveHelper(grid, x, y-1);
		}
    }


}
