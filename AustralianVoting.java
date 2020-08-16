import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class AustralianVoting{

      public static void main(String args[]){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N=Integer.parseInt(br.readLine());
            String names[]=new String[N];
            for(int i=0;i<N;i++){
              names[i]=br.readLine();
            }
            String ballet;
            int priority[][]=new int[1000][N];

            int row=0;
            while(ballet=br.readLine()){
              String parts[]=ballet.split("\\s");
                for(int i=0;i<N;i++){
                    priority[row][i]=Integer.parseInt(parts[i]);
                }
                row++;
            }
            int curr[]=new int[row];
            for(int i=0;i<row;i++){
                
            }


        }
      }
}
