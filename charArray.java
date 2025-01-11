import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    System.out.println("Hello, Dcoder!");
    Scanner sc=new Scanner(System.in);
    
    String s=sc.nextLine();
    char c[]=s.toCharArray();
    int count=0;
    for(int i=0;i<c.length;i++){
      if(c[i]>='a' && c[i]<='z'){
        System.out.print(c[i]+" ");
        count++;
      }
    }
    System.out.println("\n"+(c.length-count)+"non character");
   }
 }
