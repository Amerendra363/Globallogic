package practice;


   class practice
   {
       public static void main(String args[])
       {
           long start, end;  
           start = System.currentTimeMillis();
           for (int i = 0; i < 10000000; i++);
           end = System.currentTimeMillis();
           System.out.print(end - start);
       }
   }