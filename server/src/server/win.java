package server;

public class win {
	int [][]board=new int[14][14] ;
	
	//constructor to initialize board array with zeros
	public win()
	{
		for(int i=0;i<14;i++)
			for(int j=0;j<14;j++)
				board[i][j]=0;
		
	}
	// pre-condition (x & y) inside of array 
	// return-condition the winner number or no one win
	//(4---> no one wine )(3---> if game blocked )  
	public int play(int x,int y,int person)
	{
            
          	board[x][y]=person;
		int tmp=board[x][y];
 
		//colum check up board[x][y];
		for(int i=x+1;i<x+5;i++)
		{
			if(i==14)
				break;
			else if(board[i][y]!=tmp)
				break;
			else if(i==(x+4))
				return tmp;
		}
		
		//colum check down board[x][y];
		for(int i=x-1;i>x-5;i--)
		{
			if(i==-1)
				break;
			if(board[i][y]!=tmp)
				break;
			else if(i==(x-4))
				return tmp;
		}
		//row check up board[x][y];
		for(int i=y+1;i<y+5;i++)
		{
			if(i==14)
				break;
			if(board[x][i]!=tmp)
				break;
			else if(i==(y+4))
				return tmp;
		}
		//row check down board[x][y];
		for(int i=y-1;i>y-5;i--)
		{
			if(i==-1)
				break;

			if(board[x][i]!=tmp)
				break;
			else if(i==(y-4))
				return tmp;
		}
		int x1=x,y1=y;
		// Dimen down board[x][y];
		for(int i=0;i<4;i++)
		{
			x1++;
			y1++;
			if(x1 == 14||y1 == 14)
				break;

			if(board[x1][y1] != tmp)
				break;
		    if(i==3)
		    	return tmp;
		}
		x1=x;
		y1=y;
		// Dimen up board[x][y];
		for(int i=0;i<4;i++)
		{
			x1--;
			y1--;
			if(x1 == -1||y1 == -1)
				break;
			
			if(board[x1][y1] != tmp)
				break;
		    if(i==3)
		    	return tmp;
		}
		x1=x;
		y1=y;		
		// Dimen2 down board[x][y];
				for(int i=0;i<4;i++)
				{
					x1++;
					y1--;
					if(x1 == 14||y1 == -1)
						break;
					if(board[x1][y1] != tmp)
						break;
				    if(i==3)
				    	return tmp;
				}
				x1=x;
				y1=y;
				// Dimen2 upboard[x][y];
				for(int i=0;i<4;i++)
				{
					x1--;
					y1++;
					if(x1 == -1||y1 == 14)
						break;
	
					if(board[x1][y1] != tmp)
						break;
				    if(i==3)
				    	return tmp;
				}
				//if game blocked
			//	if(play_num==196)
			//		return 3;

boolean bool=true;
for(int i=0;i<14;i++)
{
for(int j=0;j<14;j++)
{
    if(board[i][j]==0)
    {    bool=false;
break;
    }
    
}
if(!bool)
    break;
}
if(bool)
    return 3;                            return 4;
        
        }

}
