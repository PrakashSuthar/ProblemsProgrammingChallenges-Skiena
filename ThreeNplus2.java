import java.io.*;
import java.util.*;
/*
@author Prakash Suthar
@title:The 3n+1 Problem (Programming Challenges:The Programming Contest Training Manual)
@description:Consider the following algorithm to generate a sequence of numbers. Start with an
integer n. If n is even, divide by 2. If n is odd, multiply by 3 and add 1. Repeat this
process with the new value of n, terminating when n = 1. For example, the following
sequence of numbers will be generated for n = 22:
22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
It is conjectured (but not yet proven) that this algorithm will terminate at n = 1 for
every integer n. Still, the conjecture holds for all integers up to at least 1, 000, 000.
For an input n, the cycle-length of n is the number of numbers generated up to and
including the 1. In the example above, the cycle length of 22 is 16. Given any two
numbers i and j, you are to determine the maximum cycle length over all numbers
between i and j, including both endpoints.
*/

class ThreeNplus2{

    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            String parts[]=s.split("\\s");
            int A=Integer.parseInt(parts[0]);
            int B=Integer.parseInt(parts[1]);
            int maxCycleLen=0;
            for(int i=A;i<=B;i++){
              int C=i;
              int len=1;
              while(C!=1){
                if(C%2==0)//C is even
                  C=C/2;
                else{
                  C=3*C+1;// --->>>>  n=3n+1
                }
                len++;
              }
              if(maxCycleLen<len)
                maxCycleLen=len;
            }
            System.out.println(maxCycleLen);
        }
    }

}
/*
Sample Input
1 10
100 200
201 210
900 1000
Sample Output
1 10 20
100 200 125
201 210 89
900 1000 174
*/
