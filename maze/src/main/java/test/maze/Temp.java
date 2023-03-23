/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.maze;

/**
 *
 * @author vorkna
 */
public class Temp {
    public int x,y;
    private int[][] mazemap;
    public Temp(){
        x=-1;
        y=-1;
    }
    Temp(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Temp(int [][] mazemap){
        this.mazemap=mazemap;
    }
    
    public int[][] getMap(){
        return mazemap;
    }
}
