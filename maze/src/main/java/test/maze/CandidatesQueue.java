/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.maze;
/**
 *
 * @author vorkna
 */
public class CandidatesQueue {
    int top=0;
    int [] can = new int[100];
    
    public int top(){
        int temp = can[0];
        for(int i=0;i<top;i++){
            can[i]=can[i+1];
        }
        if(top>0)
            top--;
        else
            can[0]=-1;
        
        return temp;
    }
    
    public void add(int a,int b){
        //System.out.println(top+1);
        can[top++]=a;
        can[top++]=b;
    }
    
        public String debug(){
        String out="";
        for(int i=0;i<top;i++){
            out+=can[i];
        }
        return out;
    }
    
}