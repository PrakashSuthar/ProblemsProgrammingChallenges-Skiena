import java.io.*;
import java.util.*;
/*
@author : Prakash Suthar.
@title: GraphicalEditor(Programming Challenges:The Programming Contest Training Manual)
@description:
Graphical editors such as Photoshop allow us to alter bit-mapped images in the same
way that text editors allow us to modify documents. Images are represented as an M×N
array of pixels, where each pixel has a given color.
Your task is to write a program which simulates a simple interactive graphical editor.

*/

class GraphicalEditor{
    static char Matrix[][];
    static int M=0;
    static int N=0;
    public static void main(String args[])throws IOException{
      //white=O
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      while(true){
        String command=br.readLine();
        String parts[]=command.split("\\s");
        if(parts[0]=="x")
          return;
        else if(parts[0].equals("I"))
        {
          //System.out.println("Creating Image.");
          int N=Integer.parseInt(parts[1]);
          int M=Integer.parseInt(parts[2]);
          GraphicalEditor.M=M;
          GraphicalEditor.N=N;
          Matrix=new char[M][N];
          for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
              Matrix[i][j]='O';
        }
        else if(parts[0].equals("C")){
          //System.out.println("Clearing Image");
          for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
              Matrix[i][j]='O';
        }
        else if(parts[0].equals("L")){//L X Y C -> Label pixel X Y with C
          int X=Integer.parseInt(parts[1]);
          int Y=Integer.parseInt(parts[2]);
          char C=parts[3].charAt(0);
          if(X<N && Y<M){
            Matrix[Y][X]=C;
          }
        }
        else if(parts[0].equals("V")){//Draw a vertical segment
            int X=Integer.parseInt(parts[1]);
            int Y1=Integer.parseInt(parts[2]);
            int Y2=Integer.parseInt(parts[3]);
            char C=parts[4].charAt(0);
            for(int i=Y1;i<=Y2;i++){
              Matrix[i][X]=C;
            }
        }
        else if(parts[0].equals("H")){
            int X1=Integer.parseInt(parts[1]);
            int X2=Integer.parseInt(parts[2]);
            int Y=Integer.parseInt(parts[3]);

            char C=parts[4].charAt(0);
            for(int i=X1;i<=X2;i++){
              Matrix[Y][i]=C;
            }
        }
        else if(parts[0].equals("K")){
          int X1=Integer.parseInt(parts[1]);
          int X2=Integer.parseInt(parts[2]);
          int Y1=Integer.parseInt(parts[3]);
          int Y2=Integer.parseInt(parts[4]);
          char C=parts[5].charAt(0);
          //Draw rectangle witth upper left=(X1,Y1)
          //Lower right corner=> (X2,Y2)
          for(int x=X1;x<=X2;x++){
            for(int y=Y1;y<=Y2;y++)
                Matrix[y][x]=C;
          }
        }
        else if(parts[0].equals("F")){//Fill region
            int X=Integer.parseInt(parts[1]);
            int Y=Integer.parseInt(parts[2]);
            char C=parts[3].charAt(0);
            chainFill(X,Y,C);
        }
        else if(parts[0].equals("S")){
            String name=parts[1];
            System.out.println(name);
            for(int i=0;i<Matrix.length;i++){
                for(int j=0;j<Matrix[0].length;j++){
                  System.out.print(Matrix[i][j]);
                }
              System.out.println();
            }
        }
      }



    }
    public static void chainFill(int X,int Y,char C ){
        if(X>-1 &&X <N &&Y>=0 && Y<M){
          //System.out.print("Filling Color...");
          char old_col=Matrix[Y][X];
          Matrix[Y][X]=C;
          if(inRegion(X-1,Y,old_col)){
            chainFill(X-1,Y,C);
          }
          if(inRegion(X+1,Y,old_col)){
            chainFill(X+1,Y,C);
          }
          if(inRegion(X,Y-1,old_col)){
            chainFill(X,Y-1,C);
          }
          if(inRegion(X,Y+1,old_col)){
            chainFill(X,Y+1,C);
          }

        }
    }
    public static boolean inRegion(int X,int Y,char C){
        if(X>=0 &&X <N && Y>=0 && Y<M){
            if(C==Matrix[Y][X]){
              return true;
            }
            else return false;
        }
        return false;
    }
}
