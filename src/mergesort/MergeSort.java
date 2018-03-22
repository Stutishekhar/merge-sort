
package mergesort;
import java.util.Arrays;

public class MergeSort 
{
    public static int[] sort(int[] numbers,int l, int r)
    {
        if(l<r)
        {
        int m = (l+r)/2;
        System.out.printf("m = %d, sort(numbers, %d, %d), sort(numbers, %d, %d), merge(%d, %d, %d)\n",m,l,m,m+1,r,l,m,r);
        sort(numbers,l,m);
        sort(numbers,m+1,r);
        merge(numbers,l,m,r);
        }
        return numbers;
    }
    
    public static void merge(int[] numbers, int l, int m, int r)
    {
        int size1 = m-l+1;
        int size2 = r-m;
        int[] temp1 = new int [size1];
        int[] temp2 = new int [size2];
        
        //copying elements
        for(int i=0;i<size1;i++)
        {
            temp1[i] = numbers[l+i];
        }
        for(int j=0;j<size2;j++)
        {
            temp2[j] = numbers[m+1+j];
        }
        System.out.println("copying done");
        System.out.print("temp1 = ");
        System.out.println(Arrays.toString(temp1));
        System.out.print("temp2 = ");
        System.out.println(Arrays.toString(temp2));
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while( i < size1 && j < size2)
        {
            if(temp1[i]<=temp2[j])
            {
                numbers[k] = temp1[i];
                i++;
            }
            else
            {
                numbers[k] = temp2[j];
                j++;
            }
            k++;
        }
        
        while (i < size1)
        {
            numbers[k] = temp1[i];
            i++;
            k++;
        }
      
        while (j < size2)
        {
            numbers[k] = temp2[j];
            j++;
            k++;
        }
        System.out.println("merging done\n");
        System.out.println(Arrays.toString(numbers));
    }

   
    public static void main(String[] args) 
    {
       int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
       int[] sortedNumbers;
       System.out.println(Arrays.toString(randomNumbers)); 
       sortedNumbers = sort(randomNumbers,0,randomNumbers.length-1);
       System.out.println(Arrays.toString(sortedNumbers)); 
    }
    
}
