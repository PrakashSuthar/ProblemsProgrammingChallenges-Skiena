import java.io.*;
import java.util.*;
/*
@author: Prakash Suthar
@Title:The Trip (Programming Challenges:The Programming Contest Training Manual)
@description:A group of students are members of a club that travels annually to different locations. Their destinations in the past have included Indianapolis, Phoenix, Nashville,
Philadelphia, San Jose, and Atlanta. This spring they are planning a trip to Eindhoven.
The group agrees in advance to share expenses equally, but it is not practical to share
every expense as it occurs. Thus individuals in the group pay for particular things, such
as meals, hotels, taxi rides, and plane tickets. After the trip, each student’s expenses
are tallied and money is exchanged so that the net cost to each is the same, to within
one cent. In the past, this money exchange has been tedious and time consuming. Your
job is to compute, from a list of expenses, the minimum amount of money that must
change hands in order to equalize (within one cent) all the students’ costs.
*/
class TheTrip{
      public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int N=sc.nextInt();
          float arr[]=new float[N];
          float avg=0;
          for(int i=0;i<N;i++){
              avg+=arr[i]=sc.nextFloat();
          }
          avg/=N;
          avg=Math.round(avg*100)/100;//to round a number use Math.round(num*100)/100;
          System.out.println("Average:"+avg);
          Arrays.sort(arr);
          float totalSwapped=0;
          int j=0;
          for(int i=0;i<N &&arr[i]<avg;i++){
              totalSwapped+=(avg-arr[i]);

          }
          System.out.println(totalSwapped);
      }
}
/*
Sample Input:
3
10.00
20.00
30.00
Sample Output:
$10.00
*/
