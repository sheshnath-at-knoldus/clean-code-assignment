
import java.util.*;
import jav.lang.*;

public class Main
{
    /* mergesort algorithm is used to sort the array
    */
	
	    //merging two array in this function leftarray and rightarray
		void merge(int array[], int beg, int mid, int end)    
		{    
			int index_left_array, index_right_array;  
			int length_left_array = mid - beg + 1;    
			int length_right_array = end - mid;    
			
		/* temporary Arrays */  
				int leftarray[] = new int[length_left_array];  
				int rightarray[] = new int[length_right_array];  
			
			/* copy data to temp arrays */  
			for (index_left_array = 0; index_left_array < length_left_array; index_left_array++)    
				leftarray[index_left_array] = array[beg + index_left_array]; 

			for (index_right_array = 0; index_right_array < length_right_array; index_right_array++)    
				rightarray[index_right_array] = array[mid + 1 + index_right_array];    
			
			int index_of_left_subarry = 0; /* initial index of first sub-array */  
			int index_of_right_subarray= 0; /* initial index of second sub-array */   
			int index_of_merged_subarray = beg;  /* initial index of merged sub-array */  
			
			while (index_of_left_subarry < length_left_array && index_of_right_subarray < length_right_array)    
			{    	if(leftarray[index_of_left_subarry] <= rightarray[index_of_right_subarray])    
				{  
					array[index_of_merged_subarray] = leftarray[index_of_left_subarry];         
					index_of_left_subarry++;    
				}    
				else    
				{    
					array[index_of_merged_subarray] = rightarray[index_of_right_subarray];    
					index_of_right_subarray++;    
				}    
				index_of_merged_subarray++;    
			}   
			
			
			while (index_of_left_subarry<length_left_array)    
			{   array[index_of_merged_subarray] = leftarray[index_of_left_subarry];    
				index_of_left_subarry ++;    
				index_of_merged_subarray ++;    
			}    
			
			while (index_of_right_subarray < length_right_array)    
			{   array[index_of_merged_subarray] = rightarray[index_of_right_subarray];    
				index_of_right_subarray++;    
				index_of_merged_subarray++;    
			}    
		}    
	  

     /*Here sorting of array is performed in this function*/

		void mergeSort(int array[], int beg, int end)  
		{  
			if (beg < end)   
			{  
				int mid = (beg + end) / 2;  
				mergeSort(array, beg, mid);  
				mergeSort(array, mid + 1, end);  
				merge(array, beg, mid, end);  
			}  
		}   
	      
		/*main method */

	public static void main(String[] args) 
	{
		
        //creating input variable  using scanner class
		
		Main object =new Main();
		Scanner input =new Scanner(System.in);
		int size_of_array;
		
        // input the size of array 
		size_of_array =input.nextInt();
		
        // array creation 
        int first_array[] =new int[size_of_array];
        int second_array[] = new int[size_of_array];	
        
		//array input

		for(int i=0;i<size_of_array;i++)
		{
		    first_array[i]=input.nextInt();
		}

		// coping array from first to second array

		for(int index=0;index<size_of_array;index++)
		{
		    second_array[index]=first_array[index];
		}
		
		//calling mergesort method  
        object.mergeSort(second_array, 0, size_of_array - 1);
		
		System.out.println();
		System.out.print("[");

        /*comparing two arrays and printing the indexes according to the sorted array */
			
		for(int i=0;i<size_of_array;i++)
	    {
			
		   for(int j=0;j<size_of_array;j++)
		   {
	
		       if(first_array[i]==second_array[j])
		       {
		           
		           System.out.print( " "+ j);
		       }
		   }
		}
        System.out.println(" ]");
	}
}

