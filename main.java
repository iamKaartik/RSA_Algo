import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        long startTime = System.nanoTime();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        
        
        System.out.print("Enter the value of pa : ");
        int pa = Integer.parseInt(bf.readLine());
        System.out.println();
        
        System.out.print("Enter the value of qa : ");
        int qa = Integer.parseInt(bf.readLine());
        System.out.println();
        
        // encryption of text.
        
        int eb = 13;           // value of eb has to be a prime number in order to get GCD equivalent to 1.
        
        int Na = pa * qa;
        
        int QNa = (pa - 1) * (qa - 1);
        
        System.out.print("Enter the message : ");
        String s = bf.readLine();
        s = s.toLowerCase();
        
        System.out.println();
        
        int a[] = new int[s.length()];
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            int ch = s.charAt(i) - 'a';
            
            a[i] = (int)(Math.pow(ch,eb) % Na);
            hm.put(a[i],ch);
        }
        System.out.print("Encryted Text : ");
        for(int i=0; i<s.length(); i++)
        {
            System.out.print(a[i]+ " ");
        }
        
        System.out.println();
        
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        
        //System.out.println("Time elapsed for Encryption= " + timeElapsed / 1000000000 + " sec");
        
        
        //decryption of text.
        
        int db = 0;
        
        for(int i=0; i<a.length; i++)
        {
            int qq = 1 + ((i+1) * QNa);
            if(qq % eb == 0 )
            {
                db =(int) qq/ 13;
                break;
            }
            
        }
        
        System.out.println();
        System.out.println("Value of d = "+ db);
        
        System.out.println();
        System.out.print ("Decrypted text : ");
        
        for(int i=0; i<a.length; i++)
        {
            int x = a[i];
            long y = (long) ( Math.pow(db,x) % Na);
            
            if(hm.containsKey(a[i]))
            System.out.print((char)((hm.get(a[i]))+'a'));
            
        }
        System.out.println();
        
        System.out.println("Time elapsed = " + timeElapsed / 1000000000 + " sec");
    }
}
