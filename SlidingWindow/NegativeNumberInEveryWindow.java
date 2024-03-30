import java.util.*;
public class NegativeNumberInEveryWindow
{
	public static void main(String[] args) {
		int[] a = new int[]{1,2,-1,-2,0,1,-1,2};
		int k = 3, j = 0;
		int[] ans = new int[a.length-(k-1)];
		for(int i=0;i<a.length-(k-1);i++){
		    if(j < i){
		        j = i;
		    }
		    while(j<(i+(k-1)) && a[j] >= 0){
		        j++;
		    }
		    ans[i] = (a[j]<0)?a[j]:0;
		    System.out.println(a[i] + " " + a[i+1] + " " + a[i+2] + " | J: "+ a[j]);
		}
		System.out.println(Arrays.toString(ans));
	}
}
