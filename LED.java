import java.io.*;
import java.util.*;
/*
@author Prakash Suthar
@title:LCD Display (Programming Challenges:The Programming Contest Training Manual)
@description:A friend of yours has just bought a new computer. Before this, the most powerful
machine he ever used was a pocket calculator. He is a little disappointed because he
liked the LCD display of his calculator more than the screen on his new computer! To
make him happy, write a program that prints numbers in LCD display style.
*/
class LED{
    static boolean[][] one={{false,false,false},
                       {false,false,true},
                       {false,false,false},
                       {false,false,true},
                       {false,false,false}
      };
      static boolean[][] two={{false,true,false},
                         {false,false,true},
                         {false,true,false},
                         {true,false,false},
                         {false,true,false}
        };
        static boolean[][] three={{false,true,false},
                           {false,false,true},
                           {false,true,false},
                           {false,false,true},
                           {false,true,false}
          };
          static boolean[][] four={{false,false,false},
                             {true,false,true},
                             {false,true,false},
                             {false,false,true},
                             {false,false,false}
            };
          static boolean[][] five={{false,true,false},
                               {true,false,false},
                               {false,true,false},
                               {false,false,true},
                               {false,true,false}
              };
          static boolean[][] six={{false,true,false},
                                 {true,false,false},
                                 {false,true,false},
                                 {true,false,true},
                                 {false,true,false}
                };
          static boolean[][] seven={{false,true,false},
                                   {false,false,true},
                                   {false,false,false},
                                   {false,false,true},
                                   {false,false,false}
                  };
          static boolean[][] eight={{false,true,false},
                                     {true,false,true},
                                     {false,true,false},
                                     {true,false,true},
                                     {false,true,false}
                    };
          static boolean[][] nine={{false,true,false},
                                       {true,false,true},
                                       {false,true,false},
                                       {false,false,true},
                                       {false,true,false}
                      };
          static boolean[][] zero={{false,true,false},
                                 {true,false,true},
                                 {false,false,false},
                                 {true,false,true},
                                 {false,true,false}
                };

    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        int size=sc.nextInt();


        String seq=sc.next();
        if(size==0)
          System.exit(1);
        //exit with code 1 on size=0.
        printSequence(seq,size);
    }
    public static void printSequence(String seq,int size){
      int count=0;
      int l=0;
        for(int i=0;i<5;i++){//all five segments of height..

          if(i%2==1)//.i.e.,i==1,3 then the same line should be repeated size times..
            l=0;
          else
            l=size-1;// below while loop should run only once
            while(l++<size){//Repeat entire line l++ times
              for(int j=0;j<seq.length();j++){
                char ch=seq.charAt(j);
                boolean num[][]=getMatrix(ch);
                //--------------------------------------------------------------
                //when line contains - horizontal..
                if(i==0 ||i==2 ||i==4){
                  System.out.print(" ");
                }
                else{
                  if(num[i][0]==true)
                    System.out.print("|");
                  else
                    System.out.print(" ");
                }
                //1st character of line printed..
                //--------------------------------------------------------------
                //to print second character...
                int l2=size;
                while(l2>0){
                    if(num[i][1]==false)
                      System.out.print(" ");
                    else{
                        System.out.print("-");
                    }
                      l2--;
                }
                //To print 2nd character ends here...
                //--------------------------------------------------------------
                //=============to print last charactart of the digit============
                if((i==0 ||i==2 ||i==4)){
                  System.out.print(" ");
                }
                else{
                  if(num[i][2]==true)
                    System.out.print("|");
                  else
                    System.out.print(" ");
                }
                //============to print last charactart of the digit=============
                System.out.print(" ");
                //An extra space between each digit
              }
              System.out.println();
            }

        }
    }
    //getMatrix returns the static boolean matrix corresponding to the digit ...
    public static boolean[][] getMatrix(char ch){
      boolean num[][]=new boolean [5][3];
      switch (ch){
        case '1':
        num=one;
        break;
        case '2':
        num=two;
        break;
        case '3':
        num=three;
        break;
        case '4':
        num=four;
        break;
        case '5':
        num=five;
        break;
        case '6':
        num=six;
        break;
        case '7':
        num=seven;
        break;
        case '8':
        num=eight;
        break;
        case '9':
        num=nine;
        break;
        case '0':
        num=zero;
        break;
      }
      return num;
    }
}

/*
Sample Input
2 12345

Sample Output
-- -- --
| | || ||
| | || ||
-- -- -- --
|| | | |
|| | | |
-- -- --
*/
