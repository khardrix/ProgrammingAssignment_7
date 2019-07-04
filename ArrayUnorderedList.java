/**********************************************************************************************************************
 **********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman   *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                        Programming Assignment #7                                           *****
 *****____________________________________________________________________________________________________________*****
 *****                                   This class is for an Unordered Array.                                    *****
 *****                                    This class has four Instance datum:                                     *****
 ***** "values"  - An int array that stores all the elements of our Unordered Array                               *****
 ***** "size"    - An int variable that stores the current number of elements in the Unordered Array              *****
 ***** "maxSize" - An int variable that stores the current size of the Unordered Array (maximum number of         *****
 *****                 int elements the Unordered Array can currently store)                                      *****
 ***** "count"   - An int variable that keeps track of the number of operations performed during certain methods: *****
 *****               - insert(int x)                                                                              *****
 *****               - delete(int x)                                                                              *****
 *****               - search(int x)                                                                              *****
 *****                                                                                                            *****
 *****       This class has a No-arg Constructor that instantiates maxSize to 10 (and therefore instantiates      *****
 *****      the Unordered Array values to a maximum size of 10 elements) and instantiates size and count to 0     *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                       This class also has 10 methods:                                      *****
 *****    - isFull()          - boolean method that returns whether the Unordered Array is currently full         *****
 *****                              by checking to see if the current size of the Unordered Array is equal to     *****
 *****                              the current maximum size of the Unordered Array.                              *****
 *****    - isEmpty()         - boolean method that returns whether the Unordered Array is currently empty        *****
 *****                              by checking to see if the current size of the Unordered Array is equal to 0.  *****
 *****    - print()           - void method that traverses through the entire Unordered Array and prints          *****
 *****                              to the console, every element's int value inside the Unordered Array.         *****
 *****    - destroy()         - void method that deletes the entire Unordered Array by setting size and maxSize   *****
 *****                              to 0 and the Unordered int Array "values" to null.                            *****
 *****    - insert(int x)     - void method that checks if the Unordered Array is already full by calling the     *****
 *****                              isFull() method. If the Unordered Array is full, then call the void           *****
 *****                              arrayDouble() method that performs Array Doubling (doubles the size of        *****
 *****                              the Unordered Array and doubles the int value of the int variable             *****
 *****                              maxSize). Then, inserts the passed in int variable "x" into an                *****
 *****                              element at the end of the Unordered Array.                                    *****
 *****                              * size     - Increment the int value of the int variable "size" by 1 to       *****
 *****                                               reflect the size of the Unordered Array growing by 1.        *****
 *****                              ** maxSize - If the Unordered Array has to be doubled in order to             *****
 *****                                               insert an element at the end of the Unordered Array,         *****
 *****                                               then double the int value of the int variable maxSize.       *****
 *****                              *** count  - Inserting an element into the Unordered Array takes one          *****
 *****                                               operation, so increment the int value of the int             *****
 *****                                               int variable "count" by 1.                                   *****
 *****    - delete(int x)     - void method that traverses the Unordered Array from the beginning to the end      *****
 *****                              checking whether the current element's int value the loop is looking at       *****
 *****                              is equal to the int value of the passed in int variable "x". If so,           *****
 *****                              then delete that element (this will only delete the first occurrence          *****
 *****                              of "x"). If there is no element in the Unordered Array that has an int        *****
 *****                              value equal to "x", then throw an ItemNotFoundException and pass              *****
 *****                              a message to its One-arg Constructor.                                         *****
 *****                              * size    - Decrement the int value of the int variable "size" by 1           *****
 *****                                              each time an element is deleted from the Unordered Array.     *****
 *****                              *** count - Each time the loop looks at an element to check its int value,    *****
 *****                                              that is considered one operation, so increment the int        *****
 *****                                              value of the int variable "count" by 1. Also, each time       *****
 *****                                              delete(int x) successfully deletes an element, that is        *****
 *****                                              considered one operation. So, increment the int value         *****
 *****                                              of the int variable "count" by 1.                             *****
 *****    - search(int x)     - int method that returns the element that contains the int value stored in         *****
 *****                              the passed in int variable "x" by returning the index of that element or      *****
 *****                              if that element is not found, throw an ItemNotFoundException and pass it      *****
 *****                              a message to its One-arg Constructor.                                         *****
 *****                              *** count - Each time the loop looks at an int element's value, that is       *****
 *****                                              considered one operation, so increment the int value of       *****
 *****                                              the int variable "count" by 1.                                *****
 *****    - arrayDouble()     - void method that creates and instantiates an int array called "temp" and          *****
 *****                              then starts looping. Copying each element of the current "values" array       *****
 *****                              into the "temp" array. "temp" is instantiated to be twice the size of the     *****
 *****                              "values" array. Once all the elements from "values" have been copied into     *****
 *****                              "temp", "temp" is assigned to "values", becoming the new "values" Unordered   *****
 *****                              Array.                                                                        *****
 *****                              ** maxSize - maxSize is multiplied by 2.                                      *****
 *****    - getSize()         - int method that returns the current size of the Unordered Array, by returning     *****
 *****                              the int value of the int "size" variable.                                     *****
 *****    - getCount()        - int method that returns the number of operations performed with this class.       *****
 **********************************************************************************************************************
 **********************************************************************************************************************/

public class ArrayUnorderedList {

    // Instance data, states, fields
    private int[] values; // <-- The int Array
    private int size; // <-- The current number of elements in the Array
    private int maxSize; // <-- The maximum number of elements in the current Array
    // Counter variable to keep track of the number of operations performed in each applicable method
    private int count;


    // No-arg Constructor to create an empty Array with 10 elements by setting "maxSize" to 10 and
        // setting "size" and "count" to 0
    public ArrayUnorderedList(){
        this.maxSize = 10;
        values = new int[this.maxSize];
        this.size = 0;
        this.count = 0;
    }


    // boolean method to check if the Array is full
    public boolean isFull(){
        return (this.maxSize == this.size);
    }


    // boolean method to check if the Array is empty
    public boolean isEmpty(){
        return (this.size == 0);
    }


    // void method to traverse the Array and print out all the elements
    public void print(){
        // for loop that starts at the beginning of the Array and traverses each element in the Array
        for(int i = 0; i < this.size; i++){
            // Print to the console the value of the current element we are looking at
            System.out.println(values[i]);
        }
    }


    // void method to destroy the Array (remove all the elements and set the size to 0, maxSize to 0 and values to null)
    public void destroy(){
        this.size = 0;
        this.maxSize = 0;
        this.values = null;
    }


    // void method to insert an element into the unordered Array at the end
    public void insert(int x){
        // if statement to check if the Array is full and if so, call the void method to perform Array Doubling
        if(isFull()){
            arrayDouble();
        }
        // Insert the passed in int value into the Array at the end of the current Array and
            // increment the "size" variable that keeps track of the current size of the Array
        values[size] = x;
        size++;
        // Inserting takes 1 operation, so increment the int variable "count" by 1
        this.count++;
    }


    // void method to delete an element from the Array
    public void delete(int x) throws ItemNotFoundException {
        // int variable to store the value of the index where our element value was found, if the element value
            // was not found the search() method will throw an ItemNotFoundException
        int index = search(x);
        // Replace the element value with last element value in the Array. This move takes one operation, so
            // increment the value of the int variable "count" by 1
        this.values[index] = this.values[(this.size - 1)];
        count++;
        // Decrement the current size of the Array, to make the last element inaccessible. In essence, "deleting" it
        this.size--;
    }


    // int method to search through the Array for the element we are looking for and
        // throws an ItemNotFoundException if we don't find the element we were looking for
    public int search(int x) throws ItemNotFoundException {
        // int variable that will be returned to give the value of the index where our element was found.
            // This variable is Initialized to "-1", since "-1" is not a legal index.
        int location = -1;
        // for loop to search through our Array for the element we are looking for.
            // This for loop runs as long as we haven't reached the end of the Array and the element has not been found
        for(int i = 0; (i < this.maxSize) && (location == -1); i++){
            if(this.values[i] == x){
                location = i;
            }
            // Each element that is looked at is one operation, so increment the value of the int variable "count" by 1
            count++;
        }

        // if statement to check if the int variable "location" is still equal to "-1", which would mean
            // that we did not found the element we were looking for. In that case, we throw a ItemNotFoundException
            // and pass it a message (using the 1-arg Constructor)
        if(location == -1){
            throw new ItemNotFoundException(x + " was not found in the Unordered Array");
        }

        // return statement to return the value of the int variable "location", which is the index of the element
            // we were looking for
        return location;
    }


    // void method to perform Array Doubling (double the maximum size of the Array)
    public void arrayDouble(){
        // if statement to check if the length of the int Array is equal to the maximum size of the Array
        if(this.isFull()){
            // Double the value of the maximum size of the Array int variable (maxSize)
            this.maxSize *= 2;
            // Create and Initialize a temporary int Array called "temp" and set it's size to the new value of "maxSize"
            int[] temp = new int[this.maxSize];
            // for loop to copy the old Array into the newly created temporary Array "temp"
            for(int i = 0; i < this.size; i++){
                temp[i] = this.values[i];
            }
            // Set our old Array equal to the newly created temporary Array "temp"
                // ***** The Java Garbage Collector will come along and physically delete the old Array
                // by returning it to the Heap *****
            this.values = temp;
        }
    }


    // Getter method to return the int value of the int variable "size" which represents the current size of the Array
    public int getSize(){
        // Return the current size of the Array
        return this.size;
    }


    // Getter method to return the int value of the int variable "count" which represents the number of operations
        // performed to complete different tasks with the Array
    public int getCount(){
        // Return the number of operations performed in the Array
        return this.count;
    }
}
