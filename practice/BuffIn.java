import java.io.*;
public class BuffIn{
public static void main(String args[]){
        FileInputStream fin=null;
        BufferedInputStream bin=null;
        try{
             fin=new FileInputStream("BuffIn.java");
             bin =new BufferedInputStream(fin);
              int ch=0;
              while((ch=bin.read())>-1)
                    {
                        System.out.print((char) ch);
                     }
            }catch(IOException e){System.out.println(e.getMessage());}


   } 


}