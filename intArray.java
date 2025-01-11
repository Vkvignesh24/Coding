import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    System.out.println("Hello, Dcoder!");
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(n);
    String s=Integer.toString(n);
    int a[]=new int[s.length()];
    for(int i=0;i<s.length();i++){
      a[i]=s.charAt(i)-'0';
    }
    for(int e=0;e<s.length();e++)
      System.out.print(a[e]+" ");
   }
 }
