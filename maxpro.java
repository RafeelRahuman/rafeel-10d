import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] con = {1, 10, 2, 6, 5, 3};
        
        System.out.println("Maxium Product"+ maxProduct(con));
    }
    public static  int maxProduct(int[] con){
        if(con.length<1){
            throw new IllegalArgumentException("Array must contain elements");
        }
        Arrays.sort(con);
        
        int n=con.length;
        return Math.max(con[n-1]*con[n-2],con[0]*con[1]);
    }
}
