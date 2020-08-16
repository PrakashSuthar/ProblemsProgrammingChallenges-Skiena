import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
@author:Prakash Suthar
@Title:Check The Check:(Programming Challenges:The Programming Contest Training Manual)
@description:
Your task is to write a program that reads a chessboard configuration and identifies
whether a king is under attack (in check). A king is in check if it is on square which
can be taken by the opponent on his next move.
White pieces will be represented by uppercase letters, and black pieces by lowercase
letters. The white side will always be on the bottom of the board, with the black side
always on the top.
For those unfamiliar with chess, here are the movements of each piece:
Pawn (p or P): can only move straight ahead, one square at a time. However, it takes
pieces diagonally, and that is what concerns you in this problem.
Knight (n or N) : has an L-shaped movement shown below. It is the only piece that
can jump over other pieces.
Bishop (b or B) : can move any number of squares diagonally, either forward or
backward.
Rook (r or R) : can move any number of squares vertically or horizontally, either
forward or backward.
Queen (q or Q) : can move any number of squares in any direction (diagonally,
horizontally, or vertically) either forward or backward.
King (k or K) : can move one square at a time in any direction (diagonally,
horizontally, or vertically) either forward or backward.
*/
class CheckDCheck{
    static char chessBoard[][]=new char[8][8];
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<8;i++){
          String board=br.readLine();
          for(int j=0;j<8;j++){
            chessBoard[i][j]=board.charAt(j);
          }
        }
        System.out.println("ChessBoard:");
        for(int i=0;i<8;i++){
          for(int j=0;j<8;j++){
            System.out.print(chessBoard[i][j]);
          }
        }
        checkForCheck();
        //Upper Case Letter=White Piece...
        //Lower Case Letter=Black Piece...

        //Pawn (p or P): can only move straight ahead, one square at a time. However, it takes
        //pieces diagonally, and that is what concerns you in this problem.
        //Knight (n or N) : has an L-shaped movement shown below. It is the only piece that
        //can jump over other pieces.
        //Bishop (b or B) : can move any number of squares diagonally, either forward or
        //backward.
        //Rook (r or R) : can move any number of squares vertically or horizontally, either
        //forward or backward.
        //Queen (q or Q) : can move any number of squares in any direction (diagonally,
        //horizontally, or vertically) either forward or backward.
        //King (k or K) : can move one square at a time in any direction (diagonally,
        //horizontally, or vertically) either forward or backward.

    }
    public static void checkForCheck(){
      for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            if(chessBoard[i][j]=='k' ||chessBoard[i][j]=='K'){//k= King black
                //black king found at (i,j) position
                boolean white=chessBoard[i][j]=='K';
                System.out.println("Processing white Kings"+white+i+","+j);
                if(isKingAttackingKing(i,j,(white)?'k':'K')){

                  System.out.println(white?"black":"white" +" king is in check.");
                  return;
                }
            }
            else if(chessBoard[i][j]=='q'||chessBoard[i][j]=='Q'){
              boolean white=chessBoard[i][j]=='Q';
              if(isQueenAttackingKing(i,j,(white)?'k':'K')){
                System.out.println(white?"black":"white" +" king is in check.");
                return;
              }
            }
            else if(chessBoard[i][j]=='b'||chessBoard[i][j]=='B'){
              boolean white=chessBoard[i][j]=='B';
              System.out.println("White:"+white+"Bisop"+i+","+j);
              if(isBishopAttackingKing(i,j,(white)?'k':'K')){
                System.out.println((white?"black":"white" )+" king is in check.");
                return;
              }
            }
            else if(chessBoard[i][j]=='r'||chessBoard[i][j]=='R'){
              boolean white=chessBoard[i][j]=='R';
              if(isRookAttackingKing(i,j,(white)?'k':'K')){
                System.out.println(white?"black":"white" +" king is in check.");
                return;
              }
            }
            else if(chessBoard[i][j]=='n'||chessBoard[i][j]=='N'){
              boolean white=chessBoard[i][j]=='N';
              if(isKnightAttackingKing(i,j,(white)?'k':'K')){
                System.out.println(white?"black":"white" +" king is in check.");
                return;
              }
            }
            else if(chessBoard[i][j]=='p'){//black pawn can only move downwards..
                if(hasKing(i+1,j-1,'K') || hasKing(i+1,j+1,'K')){
                  System.out.println("white king is in check."+chessBoard[i][j]);
                  return;
                }
            }
            else if(chessBoard[i][j]=='P'){//black pawn can only move downwards..
                if(hasKing(i-1,j-1,'k') || hasKing(i-1,j+1,'k')){
                  System.out.println("black king is in check."+chessBoard[i][j]);
                  return;
                }
            }
        }//Inner for loop
    }//Outter for loop
    System.out.println("no king is in check");
  }

  public static boolean isKingAttackingKing(int i,int j,char ch){
      return (hasKing(i+1,j,ch) ||hasKing(i-1,j,ch) ||hasKing(i+1,j-1,ch) ||hasKing(i+1,j+1,ch) ||hasKing(i-1,j-1,ch) ||hasKing(i-1,j+1,ch) ||hasKing(i,j-1,ch) ||hasKing(i,j+1,ch));
  }
  public static boolean isQueenAttackingKing(int i,int j,char ch){
    if(checkDiagonal(i,j,ch))
      return true;
    if(checkLine(i,j,ch))
      return true;
    return false;
  }
  public static boolean isBishopAttackingKing(int i,int j,char ch){
    if(checkDiagonal(i,j,ch))
      return true;
    return false;
  }
  public static boolean isRookAttackingKing(int i,int j,char ch){
    if(checkLine(i,j,ch))
      return true;
    return false;
  }
  public static boolean isKnightAttackingKing(int i,int j,char ch){
    if(hasKing(i-2,j-1,ch)||hasKing(i-2,j+1,ch)||hasKing(i-1,j-2,ch)||hasKing(i-1,j+2,ch)||hasKing(i+2,j-1,ch)||hasKing(i+2,j+1,ch)||hasKing(i+1,j-2,ch)||hasKing(i+1,j+2,ch))
      return true;
    return false;
  }
  public static boolean checkLine(int i,int j,char ch){
    for(int x=i+1;x<8;x++){
      if(hasKing(x,j,ch))
        return true;
      else if(chessBoard[x][j]!='.')
        break;
    }
    for(int x=i-1;x>=0;x--){
      if(hasKing(x,j,ch))
        return true;
      else if(chessBoard[x][j]!='.')
        break;
    }

    for(int y=j+1;y<8;y++){
      if(hasKing(i,y,ch))
        return true;
      else if(chessBoard[i][y]!='.')
        break;
    }
    for(int y=j-1;y>=0;y--){
      if(hasKing(i,y,ch))
        return true;
      else if(chessBoard[i][y]!='.')
        break;
    }
    return false;
  }
  public static boolean checkDiagonal(int i,int j,char ch){
    for(int x1=i+1,y1=j+1;x1<8 &&y1<8;x1++,y1++){
      if(hasKing(x1,y1,ch)){
          return true;
        }
      else if(chessBoard[x1][y1]!='.'){
          break;
      }
    }

      for(int x1=i+1,y1=j-1;x1<8 &&y1>=0;x1++,y1--){
        if(hasKing(x1,y1,ch))
        return true;
      else if(chessBoard[x1][y1]!='.')
        break;
    }
    for(int x1=i-1,y1=j+1;x1>=0 &&y1<8;x1--,y1++){
      if(hasKing(x1,y1,ch))
        return true;
      else if(chessBoard[x1][y1]!='.')
        break;
    }
    for(int x1=i-1,y1=j-1;x1>=0 &&y1>=0;x1--,y1--){
      if(hasKing(x1,y1,ch))
        return true;
      else if(chessBoard[x1][y1]!='.')
        break;
    }
    return false;
  }
  //Checks if the x,y provided has actor 'ch' or not..
  public static boolean hasKing(int x,int y,char ch){
    if(x<0 ||x>=8 ||y<0 ||y>=8)
      return false;
    return chessBoard[x][y]==ch;
  }

}
/*
..k.....
pPp.pppp
........
.R......
........
........
PPPPPPPP
K.......

*/
