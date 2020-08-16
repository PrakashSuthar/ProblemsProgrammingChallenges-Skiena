
import java.io.*;
import java.util.*;
/*
@author: Prakash Suthar
@Title:Minesweeper (Programming Challenges:The Programming Contest Training Manual)
@description:
 Have you ever played Minesweeper? This cute little game comes with a certain operating system whose name we can’t remember. The goal of the game is to find where
all the mines are located within a M × N field.
The game shows a number in a square which tells you how many mines there are
adjacent to that square. Each square has at most eight adjacent squares. The 4×4 field
on the left contains two mines, each represented by a * character. If we represent the
same field by the hint numbers described above, we end up with the field on the right:
*...
....
.*..
....

turns into-->
*100
2210
1*10
1110
*/
class Minesweeper{
        static String field[];
  public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        String rowsCols=br.readLine();
        String spl[]=rowsCols.split("\\s");
        int n=Integer.parseInt(spl[0]);
        int m=Integer.parseInt(spl[1]);
        field=new String[n];
        String res[]=new String[n];
        String line;
        for(int i=0;i<n;i++){
          field[i]=br.readLine();
        }
        for(int i=0;i<n;i++){
          res[i]="";
          for(int j=0;j<m;j++){
              char ch=field[i].charAt(j);
              int mines=0;

              if(ch!='*'){//put appropriate number in the square...
                  //Check all 8 squares on its side...
                  if(isMine(i-1,j,n,m))//squares exist to left..
                    mines++;
                  if(isMine(i-1,j-1,n,m))
                    mines++;
                  if(isMine(i-1,j+1,n,m))
                    mines++;
                  if(isMine(i,j-1,n,m))
                    mines++;
                  if(isMine(i,j+1,n,m))
                    mines++;
                  if(isMine(i+1,j-1,n,m))
                    mines++;
                  if(isMine(i+1,j,n,m))
                    mines++;
                  if(isMine(i+1,j+1,n,m))
                    mines++;
                  res[i]+=""+mines;
              }
              else
                  res[i]+="*";
          }
          System.out.println(res[i]);
        }

  }
  public static boolean isMine(int i,int j,int n,int m){
        if(i==-1 ||j==-1 ||i==n ||j==m)
            return false;
        if(field[i].charAt(j)=='*')
            return true;
        return false;
  }
}
