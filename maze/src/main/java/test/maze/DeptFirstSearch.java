/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.maze;

import javax.swing.JOptionPane;


/**
 *
 * @author vorkna
 */
public class DeptFirstSearch {
    static CandidatesStack can = new CandidatesStack();
    static int path = 2;
    static int size = 1;
    static int mazesize = 11;
    static int[][] mapsize = new int[mazesize][mazesize];
    
    
    public DeptFirstSearch(int size,int mazesize,int[][] mapsize){
        this.size =size;
        this.mazesize=mazesize;
        this.mapsize = mapsize;
    }
    
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
                    default:
                        System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    public static void showGen(){
        for(int i=0;i<mazesize;i+=size){
            for(int j=0;j<mazesize;j+=size){
                System.out.print(mapsize[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    
        
    public static int countWay(int x, int y){
            int count=0;
            if(mapsize[x-size][y]==0)
                count++;
             if(mapsize[x][y-size]==0)
                 count++;
             if(mapsize[x+size][y]==0)
                 count++;
             if(mapsize[x][y+size]==0)
                 count++;
             return count;
    }
    
    public static boolean checkCan(int x,int y){
             if(countWay(x,y)>1){
                 can.add(x);
                 can.add(y);
                 return false;
             }
             if(countWay(x,y)<=0){ //ตัน
                 mapsize[x][y]=path;
                 path++;
                 return true;
             }
             if(can.top==-1){
                 return false;
             }
             return false;
    }
    
    public static void move(int x , int y){
        Temp t;
         if(checkCan(x,y)){
                y=can.top();
                x=can.top();
                t = moving(x,y);
                mapsize[t.x][t.y]=path-1;
                showGen();
                if(t.x<=0&&t.y<=0)
                        move(t.x,t.y);
                else{
                        JOptionPane.showMessageDialog(null,"Done");
                        return;
                }
        }
                //System.out.println(x+" "+y+" "+can.debug());
                t = moving(x,y);
                mapsize[t.x][t.y]=path;
                showGen();
                if(t.x!=-1&&t.y!=-1)
                    move(t.x,t.y);
                else{
                        //JOptionPane.showMessageDialog(null,"Done");
                        return;
                }
        showGen();
}
 
    public static Temp moving(int x,int y){
        Temp t = new Temp();   
        if(x==-1||y==-1){}
        else if(mapsize[x][y-size]==0){
            t = new Temp(x,y-size);
         }else if(mapsize[x+size][y]==0){
             t = new Temp(x+size,y);
         }else if(mapsize[x][y+size]==0){
             t = new Temp(x,y+size);
         }else if(mapsize[x-size][y]==0){
             t = new Temp(x-size,y);
         }
         return t;
    }
}
