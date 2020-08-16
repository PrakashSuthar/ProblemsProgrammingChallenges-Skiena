import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
/*
@author: Prakash Suthar
@title: Interpreter(Programming Challenges:The Programming Contest Training Manual)
@description:
A certain computer has ten registers and 1,000 words of RAM. Each register or
RAM location holds a three-digit integer between 0 and 999. Instructions are encoded
as three-digit integers and stored in RAM. The encodings are as follows:
100 means halt
2dn means set register d to n (between 0 and 9)
3dn means add n to register d
4dn means multiply register d by n
5ds means set register d to the value of register s
6ds means add the value of register s to register d
7ds means multiply register d by the value of register s
8da means set register d to the value in RAM whose address is in register a
9sa means set the value in RAM whose address is in register a to that of register s
0ds means goto the location in register d unless register s contains 0
All registers initially contain 000. The initial content of the RAM is read from standard input. The first instruction to be executed is at RAM address 0. All results are
reduced modulo 1,000.
*/
class Interpreter{
      static int reg[];//=new reg[10];
      static String mem[];//=new int[1000];
    public static void main(String args[])throws IOException{
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          String command=br.readLine();
          int N=Integer.parseInt(command);//No of test cases...
          for(int i=0;i<N;i++){
            initializeCPU();
            int loc_ctr=0;
            while(true && loc_ctr<1000){
            mem[loc_ctr]=br.readLine();
            if(mem[loc_ctr++].equals("100"))
                break;
            }
            //Now that input is ready, execute the instructions in memory...

            loc_ctr=0;//read memory from 0th address...
            command=mem[loc_ctr];
            int ins=1;//number of instructions executed...
            while (!command.equals("100")){//100 == halt
              //System.out.println(loc_ctr+":"+command);
              int opcode=Integer.parseInt(""+command.charAt(0));
              int reg_no=Integer.parseInt(""+command.charAt(1));
              int n=Integer.parseInt(""+command.charAt(2));
              if(opcode==2){//Set reg to 0<=n<=9
                  reg[reg_no]=n;
              }
              else if(opcode==3){//Add n
                  reg[reg_no]+=n;
                  reg[reg_no]%=1000;
              }
              else if(opcode==4){//Multiply by n
                  //reg[reg_no]
                  reg[reg_no]*=n;
                  reg[reg_no]%=1000;
              }
              else if(opcode ==5){
                reg[reg_no]=reg[n];
              }
              else if(opcode ==6){
                reg[reg_no]+=reg[n];
                reg[reg_no]%=1000;
              }
              else if(opcode ==7){ //multiply reg d into reg s..
                reg[reg_no]*=reg[n];
                reg[reg_no]%=1000;
              }
              else if(opcode==8){
                //8da means set register d to the value in RAM whose address is in register a
                reg[reg_no]=Integer.parseInt(mem[reg[n]]);

              }
              else if(opcode==9){
                //9sa means set the value in RAM whose address is in register a to that of register s
                int reg_content=reg[reg_no];
                if(reg_content<10){
                  mem[reg[n]]="00"+reg[reg_no];
                }
                else if(reg_content<100){
                  mem[reg[n]]="0"+reg[reg_no];
                }
                else{
                  mem[reg[n]]=""+reg[reg_no];
                }
              }
              else if(opcode==0){
                //0ds means goto the location in register d unless register s contains 0
                if(reg[n]!=0){
                    loc_ctr=reg[reg_no]-1;
                }
              }
              loc_ctr++;
              ins++;
              command=mem[loc_ctr];
            }
            System.out.println(ins);
          }
    }

    public static void initializeCPU(){
        reg=new int[10];
        mem=new String[1000];
        Arrays.fill(mem,"000");
    }
}

/*
Sample Input
1
299
492
495
22 1. Getting Started
399
492
495
399
283
279
689
078
100
000
000
000
Sample Output
16
*/
