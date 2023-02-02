package fileprocessing;
import java.io.*;
import java.util.Random;

public class Main {
    /**
     * @return double
     */
       private double no[]=new double[10];
        public double[] numbers(){
      
        Random r=new Random();
        for(int i=0;i<no.length;i++){
            double n=r.nextDouble();
            no[i]=n;
            System.out.println(no[i]);
           }
        return no;}
    /**
     * @param no
     * @throws IOException 
     */   
        public void write() throws IOException{
        File f=new File("file4.txt");
        FileOutputStream outputstream=new FileOutputStream(f);
        DataOutputStream doutputstream=new DataOutputStream(outputstream);
        for(double nos:no){
        doutputstream.writeBytes(""+ nos + " \n ");}
            System.out.println("");
        doutputstream.close();
         }
    /**
     * @throws IOException 
     */
    public void read() throws IOException{
        File f=new File("file4.txt");
        FileInputStream inputstream=new FileInputStream(f);
        DataInputStream dinputstream=new DataInputStream(inputstream);
        System.out.println(dinputstream.readDouble());
        dinputstream.close();
      }
   /** public void delete(){
        File f=new File("file4.txt");
        f.delete();
    }*/
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
       Main m=new Main();
       double no[]=m.numbers();
        
       m.write();
       m.read();
      // m.delete();
        }
}
