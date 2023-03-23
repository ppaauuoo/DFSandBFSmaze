/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.maze;


/**
 *
 * @author vorkna
 */
public class DeptFirstSearchV2 {
    static CandidatesStack can = new CandidatesStack();
    static Temp t = new Temp();
    static int path = 2;
    static int size = 1;
    static int mazesize = 11;
    static int[][] mapsize = new int[mazesize][mazesize];
     static int goalX,goalY;
    
    
    public DeptFirstSearchV2(int size,int mazesize,int[][] mapsize,int goalX,int goalY){
        this.size =size;
        this.mazesize=mazesize;
        this.mapsize = mapsize;
        this.goalX=goalX;
        this.goalY=goalY;
    }
        //good looking show
        public static void formatGen(){
                for(int i=0;i<mazesize;i+=size){
                        for(int j=0;j<mazesize;j+=size){
                                switch (mapsize[i][j]){
                                        case 1 : 
                                                System.out.print("X ");
                                                break;
                                        case 0:
                                                System.out.print("© ");
                                                break;
                                        case -99:
                                                System.out.print(":D ");
                                                break;
                                        default:
                                                System.out.print("  ");
                                }
                        }
                        System.out.print("\n");
                }
                System.out.print("\n");
        }
        //show
        public static void showGen(){
                for(int i=0;i<mazesize;i+=size){
                        for(int j=0;j<mazesize;j+=size){
                            System.out.print(mapsize[i][j]+" ");
                        }
                        System.out.print("\n");
                }
                System.out.print("\n");
        }
        //check surround node
    public int checkMove(int x,int y){
        int count=0;
        if(mapsize[x][y-size]==0) //left
            count++;
        if(mapsize[x+size][y]==0) //down
            count++;
        if(mapsize[x][y+size]==0) //right
            count++;
        if(mapsize[x-size][y]==0) //up
            count++;
        return count;
    }
    //coord need to flip cause stack
    public void getNodePos(int x,int y){
        if(mapsize[x-size][y]==0) //up
            can.add(x-size,y);
        if(mapsize[x][y+size]==0) //right
            can.add(x,y+size);
        if(mapsize[x+size][y]==0) //down
            can.add(x+size,y);
        if(mapsize[x][y-size]==0) //left
            can.add(x,y-size);
        
        
        
    }
    //check if should save
    public boolean saveNode(int x,int y){
        if(checkMove(x,y)>1){
            getNodePos(x,y);
            return true;
        }else{
            return false;
        }
    }
    //get next pos
    public Temp next(int x,int y){
        Temp t;
        if(mapsize[x][y-size]==0){
            return t = new Temp(x,y-size);
        }
        if(mapsize[x+size][y]==0){
            return  t = new Temp(x+size,y);
        }
        if(mapsize[x][y+size]==0){
            return t = new Temp(x,y+size);
        }
        if(mapsize[x-size][y]==0){
             return t = new Temp(x-size,y);
        }
        return null;
    }
    //core mechanic
    public void move(int x,int y){
        //check if goal
        if(goalX==x&&goalY==y){
            mapsize[x][y]=-99;
            showGen();
            return;
        }
        //check if full
        if(x==-1){
            return;
        }
        //make footprint and show
        mapsize[x][y]=path;
        showGen();
        //check if a node and save
        if(saveNode(x,y)){
            t.y=can.top(); //already have the next pos
            t.x=can.top();
        }else{
            t=next(x,y); //get next pos
        }
        //check if deadend and change path
        if(t==null){
            y=can.top(); //check path by get former pos
            x=can.top();
            path++;
            move(x,y);
        }else
            move(t.x,t.y);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //extra not important
    public void move(int x,int y,int a){
        //check if goal
        if(goalX==x&&goalY==y){
            mapsize[x][y]=-99;
            return;
        }
        //check if full
        if(x==-1){
            return;
        }
        //make footprint and show
        mapsize[x][y]=path;
        //check if a node and save
        if(saveNode(x,y)){
            t.y=can.top();
            t.x=can.top();
        }else{
            t=next(x,y);
        }
        //check if deadend and change path
        if(t==null){
            y=can.top();
            x=can.top();
            path++;
            move(x,y,1);
        }else
            move(t.x,t.y,1);
    }
    


}
