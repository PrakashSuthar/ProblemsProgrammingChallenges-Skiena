import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class JollyJumpers{

    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        String parts[]=line.split("\\s");
        int N=Integer.parseInt(parts[0]);
        int seq[]=new int[N];
        boolean present[]=new boolean[N-1];
        seq[0]=Integer.parseInt(parts[1]);
        int diff=0;
        boolean jolly=true;
        for(int i=2;i<=N;i++){
            seq[i-1]=Integer.parseInt(parts[i]);
            diff=Math.abs(seq[i-1]-seq[i-2]);
            //System.out.println("diff:"+diff+"jolly:"+jolly);
            if(!jolly || present[diff-1] ||((diff)>(N-1)) || diff==0){
                jolly=false;
            }
            else{
              present[diff-1]=true;
            }
        }
          if(!jolly)
            System.out.println("Not jolly.");
          else
            System.out.println("jolly");
    }

}
