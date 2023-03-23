/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.maze;

/**
 *
 * @author bas
 */
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class MazeGenerator2 {
    private int rows, cols;
    public int[][] maze;
    private int startX, startY;
    private int goalX, goalY;
    private Random rand;
    private String maze_file = "";

    public MazeGenerator2(int rows, int cols, int startX, int startY, int goalX, int goalY) {
        this.rows = rows;
        this.cols = cols;
        this.startX = startX;
        this.startY = startY;
        this.goalX = goalX;
        this.goalY = goalY;
        this.maze = new int[rows][cols];
        this.rand = new Random();
    }

    public void generateMaze() {
        //initial maze
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = 1;
            }
        }

        //set start and goal to 0
        maze[startX][startY] = 0;
        maze[goalX][goalY] = 0;

        //recursive backtracking
        generateMazeRecursive(startX, startY);

        //print maze
        //return maze;
        printMaze();
    }
    
    //@Overload
        public int[][] generateMaze(int m) {
        //initial maze
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = 1;
            }
        }

        //set start and goal to 0
        maze[startX][startY] = 0;
        maze[goalX][goalY] = 0;

        //recursive backtracking
        generateMazeRecursive(startX, startY);
        
        maze[goalX][goalY-1]=0;
        //print maze
        return maze;
        //printMaze();
    }

    public void generateMazeRecursive(int x, int y) {
        //random directions
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(1);  // up
        directions.add(2);  // right
        directions.add(3);  // down
        directions.add(4);  // left
        Collections.shuffle(directions, rand);


        for (int direction : directions) {
            int newX = x;
            int newY = y;
            if (direction == 1) {         // up
                newY-=2;
            } else if (direction == 2) {  // right
                newX+=2;
            } else if (direction == 3) {  // down
                newY+=2;
            } else if (direction == 4) {  // left
                newX-=2;
            }

            // check if new position is valid
            if (newX < 1 || newY < 1 || newX >= rows - 1 || newY >= cols - 1) {
                continue;
            }
            if (maze[newX][newY] != 1) {
                continue;
            }

            // connect cells
            if (direction == 1) {  // up
                maze[x][y - 1] = 0;
                maze[x][y - 2] = 0;
            } else if (direction == 2) {  // right
                maze[x + 1][y] = 0;
                maze[x + 2][y] = 0;
            } else if (direction == 3) {  // down
                maze[x][y + 1] = 0;
                maze[x][y + 2] = 0;
            } else if (direction == 4) {  // left
                maze[x - 1][y] = 0;
                maze[x - 2][y] = 0;
            }

            // recursively new position
            generateMazeRecursive(newX, newY);
        }
    }

    //convert to number
    private void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == startX && j == startY) {
                    System.out.print("S");
                    maze_file += "S";
                } else if (i == goalX && j == goalY) {
                    System.out.print("G");
                    maze_file += "G";
                } else if(i == goalX && j == goalY-1){
                    System.out.print(" ");  //ถ้าอยากเปลี่ยนเป็น 0 ก็เปลี่้ยนตรงนี้
                    maze_file += " ";
                } else if (maze[i][j] == 1) {
                    System.out.print("1");
                    maze_file += "1";
                } else {
                    System.out.print(" ");  //ถ้าอยากเปลี่ยนเป็น 0 ก็เปลี่้ยนตรงนี้
                    maze_file += " ";
                }        
            }
            System.out.println();
            maze_file += "\n";
        }
        write_file(maze_file);
    }

    //write file
    public void write_file(String maze){
        try{
            FileWriter fWriter = new FileWriter("C:/Users/LENOVO/Desktop/HCU/HCU2_2/Principle AI/maze2/maze.txt");  //path of file text
            fWriter.write(maze);
            System.out.println("Create file successful!");
            fWriter.close();
        }catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("rows : "); 
        int rows = sc.nextInt()+1;
        System.out.print("cols : "); 
        int cols = sc.nextInt()+1;
        int startX = 1;
        int startY = 1;
        int goalX = rows - 2;
        int goalY = cols - 2;

        MazeGenerator2 mazeGenerator = new MazeGenerator2(rows, cols, startX, startY, goalX, goalY);
        mazeGenerator.generateMaze();
    }
}