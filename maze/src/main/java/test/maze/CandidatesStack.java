/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.maze;

/**
 *
 * @author vorkna
 */
public class CandidatesStack {
    int top=0;
    int [] can = new int[100];
    
    public int top(){
        //System.out.println(top-1);
        if(top>0)
            return can[--top];
        int temp=can[top];
        can[top]=-1;
        return temp;
    }    
    public void add(int a){
        //System.out.println(top+1);
        can[top++]=a;
        
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
