/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package test.maze;

import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author vorkna
 */



public class Maze implements Serializable{
       static final int size = 1;
       static final int mazesize = 11;
       
       //int[][] mazemap = new int[mazesize][mazesize];
       static final int rows = mazesize;
       static final int cols = mazesize;
       static final int startX = 1;
       static final int startY = 1;
       static final int goalX = 9;
       static final int goalY = 9;
       //initialize map
       static MazeGenerator2 mg2 = new MazeGenerator2(rows,cols,startX,startY,goalX,goalY);
       static final int[][] mazemap = mg2.generateMaze(1);
       
    
    public static void main(String[] args){
       
       //initialize search algorithm
       DeptFirstSearchV2 dfs = new DeptFirstSearchV2(size,mazesize,mazemap,goalX,goalY);
       BreadthFirstSearch bfs = new BreadthFirstSearch(size,mazesize,mazemap,goalX,goalY);
        //input
       Scanner sc = new Scanner(System.in);
       System.out.println("what do you want (1.dfs2.bfs)");
       int temp = sc.nextInt();
       if( temp==1){ //dept first search
            dfs.move(size,size);
            dfs.formatGen();
        }else if( temp==2){ //breadth first search
            bfs.move(size,size);
            bfs.formatGen();
       }else{ //not important shouldn't care
             Temp t = new Temp(mazemap);
            dfs = new DeptFirstSearchV2(size,mazesize,t.getMap(),goalX,goalY);
            System.out.println("you found our secret! \nthis one is the DFS");
            dfs.move(size,size,1);
            dfs.formatGen();
            bfs = new BreadthFirstSearch(size,mazesize,t.getMap(),goalX,goalY);
            System.out.println("and this is the BFS");
            bfs.move(size,size,1);
            bfs.formatGen();
        }
    }
}