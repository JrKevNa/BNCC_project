package Project;

import java.util.Collections;
import java.util.Vector;

class BubbleSort
{
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
 
    /* Prints the array */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method to test above
    public static void main(String[] args) 
    {
        
        //create first Vector object
        Vector v1 = new Vector();
       
        //Add elements to Vector
        v1.add("1");
        v1.add("2");
        v1.add("3");
        v1.add("4");
        v1.add("5");
       
        //create another Vector object
        Vector v2 = new Vector();
       
        //Add elements to Vector
        v2.add("One");
        v2.add("Two");
        v2.add("Three");
        v2.add("Four");
        v2.add("Five");
       
        /*
          To copy elements of one Java Vector to another use,
          static void copy(List dstList, List sourceList) method of Collections class.
         
          This method copies all elements of source list to destination list. After copy
          index of the elements in both source and destination lists would be identical.
         
          The destination list must be long enough to hold all copied elements. If it is
          longer than that, the rest of the destination list's elments would remain
          unaffected.       
        */ 
       
        System.out.println("Before copy, Second Vector Contains : " + v2);
       
        //copy all elements of Vector to another Vector using copy 
        //method of Collections class
        Collections.copy(v2,v1);
       
        /*
          Please note that, If destination Vector object is not long enough 
          to hold all elements of source Vector, 
          it throws IndexOutOfBoundsException.
        */
     
        System.out.println("After copy, Second Vector Contains : " + v2);   
        
        System.out.println("After copy, First Vector Contains : " + v1); 
      }
}