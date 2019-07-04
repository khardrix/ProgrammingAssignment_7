/**********************************************************************************************************************
 **********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman   *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                        Programming Assignment #7                                           *****
 *****____________________________________________________________________________________________________________*****
 *****                                    This class is for an Ordered Array.                                     *****
 *****                                    This class has four Instance datum:                                     *****
 ***** "values"  - An int array that stores all the elements of our Ordered Array                                 *****
 ***** "size"    - An int variable that stores the current number of elements in the Ordered Array                *****
 ***** "maxSize" - An int variable that stores the current size of the Ordered Array (maximum number of           *****
 *****                 int elements the Ordered Array can currently store)                                        *****
 ***** "count"   - An int variable that keeps track of the number of operations performed during certain methods: *****
 *****               - insert(int x)                                                                              *****
 *****               - delete(int x)                                                                              *****
 *****               - search(int x)                                                                              *****
 *****                                                                                                            *****
 *****       This class has a No-arg Constructor that instantiates maxSize to 10 (and therefore instantiates      *****
 *****       the Ordered Array values to a maximum size of 10 elements) and instantiates size and count to 0      *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                       This class also has 10 methods:                                      *****
 *****    - isFull()          - boolean method that returns whether the Ordered Array is currently full           *****
 *****                              by checking to see if the current size of the Ordered Array is equal to       *****
 *****                              the current maximum size of the Ordered Array.                                *****
 *****    - isEmpty()         - boolean method that returns whether the Ordered Array is currently empty          *****
 *****                              by checking to see if the current size of the Ordered Array is equal to 0.    *****
 *****    - print()           - void method that traverses through the entire Ordered Array and prints            *****
 *****                              to the console, every element's int value inside the Ordered Array.           *****
 *****    - destroy()         - void method that deletes the entire Ordered Array by setting size and maxSize to 0*****
 *****                              and the Ordered int Array "values" to null.                                   *****
 *****    - insert(int x)     - void method that checks if the Ordered Array is currently full and if so          *****
 *****                              call the arrayDouble() method that performs Array Doubling. Then, loops       *****
 *****                              starting from the end of the current Ordered Array and works its way          *****
 *****                              towards the beginning of the Ordered Array, checking to see if the passed in  *****
 *****                              int variable "x" is less than the previous element to the element we are      *****
 *****                              looking at and shifting each element up to make room for the element we are   *****
 *****                              going to insert. Once we find an element whose previous element's value is    *****
 *****                              greater than or equal to the passed in int value "x", we insert "x" into      *****
 *****                              the Ordered Array and increment size.                                         *****
 *****                              * size     - Increment the int value of the int variable "size" by 1          *****
 *****                                               every time we insert an element into the Ordered Array.      *****
 *****                              ** maxSize - If Array Doubling was performed, multiply the int value of       *****
 *****                                               maxSize by 2.                                                *****
 *****                              *** count  - Every element that we look at while searching for the correct    *****
 *****                                               location to insert the passed int value "x", increment       *****
 *****                                               the int value of the int variable "count" by 1, because      *****
 *****                                               that is considered one operation. Also, increment "count"    *****
 *****                                               by 1 every time an element is successfully inserted into the *****
 *****                                               Ordered Array, because that too is considered an operation.  *****
 *****    - delete(int x)     - void element to delete an element from the Ordered Array. This method can throw   *****
 *****                              an ItemNotFoundException if the Array is empty or there is no element that    *****
 *****                              has an int value equal to the passed in int variable, "x". This method calls  *****
 *****                              the bSearch() method ("bSearch" stands for "Binary Search") and assigns the   *****
 *****                              the returned int value to the int variable "temp". Then, this method loops,   *****
 *****                              starting from the index "temp" and working our way to the end of the Ordered  *****
 *****                              Array. Each time we go through the loop, we shift the element we are currently*****
 *****                              looking at and shift it down to cover up the previous element. Eventually,    *****
 *****                              we will have shifted every element (starting from index "temp") down to       *****
 *****                              cover up the previous element and thereby deleting the element that had same  *****
 *****                              int value as the passed in int value, "x". After we successfully delete the   *****
 *****                              element we were trying to delete, we decrement by 1 "size" to reflect that    *****
 *****                              the Ordered Array's length has shrank by 1.                                   *****
 *****                              * size    - Decrement the int value of the int variable "size" by 1, each time*****
 *****                                              we successfully delete an element.                            *****
 *****                              *** count - Increment the int value of the int variable "count" by 1 each time*****
 *****                                              we look at an element while searching for the element to      *****
 *****                                              delete. Also, decrement "count" by 1 every time we            *****
 *****                                              successfully delete an element.                               *****
 *****    - bSearch(int item) - int method that performs a Binary Search on the Ordered Array and either returns  *****
 *****                              the int index of the int value of the passed in int variable, "item", or      *****
 *****                              if the the int value "item" is not found, throw an ItemNotFoundException. The *****
 *****                              Binary Search works by assigning a minimum int index (called "low"), a maximum*****
 *****                              int index (called "high") and calculates the middle of the current part of    *****
 *****                              the Ordered Array that we are searching by adding "low" to "high" and         *****
 *****                              dividing that value by 2 and assigning that value to "mid". The Binary Search *****
 *****                              keeps looping and seeing if "mid" is equal to "item". Exiting the loop and    *****
 *****                              returning that int index if so. If not, keep looping until the end of the     *****
 *****                              Ordered Array and throwing an ItemNotFoundException if the item is never      *****
 *****                              found.                                                                        *****
 *****                              *** count - Every time this method loops and we examine an element, that      *****
 *****                                          is considered one operation. So, increment the int value of       *****
 *****                                          int variable "count" by 1 each time.                              *****
 *****    - arrayDouble()     - void method that creates and instantiates an int array called "temp" and          *****
 *****                              then starts looping. Copying each element of the current "values" array       *****
 *****                              into the "temp" array. "temp" is instantiated to be twice the size of the     *****
 *****                              "values" array. Once all the elements from "values" have been copied into     *****
 *****                              "temp", "temp" is assigned to "values", becoming the new "values" Ordered     *****
 *****                              Array.                                                                        *****
 *****                              ** maxSize - maxSize is multiplied by 2.                                      *****
 *****    - getSize()         - int method that returns the current size of the Ordered Array, by returning       *****
 *****                              the int value of the int "size" variable.                                     *****
 *****    - getCount()        - int method that returns the number of operations performed with this class.       *****
 **********************************************************************************************************************
 **********************************************************************************************************************/

public class ArrayOrderedList {

    // Instance data, states, fields
    private int[] values; // <-- The int Array
    private int size; // <-- The current number of elements in the Array
    private int maxSize; // <-- The maximum number of elements in the current Array
    // Counter variable to keep track of the number of operations performed in each applicable method
    private int count;


    // No-arg Constructor to create an empty Array with 10 elements by setting "maxSize" to 10 and
        // setting "size" and "count" to 0
    public ArrayOrderedList(){
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


    // void method to insert the passed in int value in the correct order (location) in the ordered Array
    public void insert(int x){
        // if statement to check if the Array is full and if so, call the void method to perform Array Doubling
        if(isFull()){
            arrayDouble();
        }

        // boolean variable to keep track if we are done searching through the entire ordered Array
        boolean done = false;

        // for loop that starts at the right side (end/rear) of the ordered Array and works its way to the left
            // towards the front of the ordered Array, shifting the elements up as it loops until it finds
            // the element we are looking for (to make room for the new element).
            // This for loop keeps looping as long as we haven't reached the end (front) of the ordered Array and
            // we haven't found the element we are looking for
        for(int i = this.size; (i > 0) && (!done); i--){
            // if statement that checks if the passed in element value "x" is less than the value of the element
                // to the left (the previous element) of the element we are currently looking at
            if(x < this.values[(i-1)]){
                // Set the value of the current element to the value of previous element (element to the left of
                    // the current element)
                this.values[i] = this.values[(i-1)];

                // Each time we shift an element up it counts as one operation, so we increment the value of the
                    // int variable "count" by 1
                this.count++;
            }
            // else statement that executes if the value of the current element we are looking at is greater than or
                // equal to the value that was passed into the ordered Array
            else {
                // Set the value of the current element to the passed in int value "x"
                this.values[i] = x;
                // Set the boolean variable "done" to true, so we can exit the for loop
                done = true;
                // Increment the value of the int variable "size" that keeps track of the current size of the ordered
                    // Array by 1
                this.size++;
            }
        }

        // if statement that checks and executes if we searched the entire ordered Array and did not find the element
            // value we were looking for (the value "x" that was passed in as a parameter). If this is the case,
            // then insert the passed in int value at the front (or beginning or left side) of the ordered Array and
            // increment the int variable "size" that keeps track of the current size of the ordered Array by 1
        if(!done){
            // Insert the passed in int variable "x" to the first position or index (index 0)
            this.values[0] = x;
            // Increment the value of the int variable "size" that keeps track of the current size of the ordered
                // Array by 1
            this.size++;
            // Increment the int value of the int variable "count" by 1, because inserting takes one operation
            this.count++;
        }
    }


    // void method to delete an element value from the ordered Array
    public void delete(int x) throws ItemNotFoundException {
        // int variable to store a temporary int value to be used with this method
        int temp = bSearch(x);

        // for loop that starts at the int index of the ordered Array and shifts all the values down to cover up
            // the element that we deleted. This for loop works its way up the ordered Array and keeps looping
            // until we reach the last int index
        for(int i = temp; i < (this.size - 1); i++){
            // Set the value of the current int element to the value of the int value of the next element in
                // the ordered Array
            this.values[i] = this.values[(i + 1)];

            // Each time we shift an element down it counts as one operation, so we increment the value of the
                // int variable "count" by 1
            this.count++;
        }
        // Decrement the value of the int variable "size" by 1 to keep accurate track of the number of
            // elements in the ordered Array
        this.size--;
    }


    // int method to perform a Binary Search that will search the ordered Array for the passed in (as a parameter)
        // int value "item" and return the index of that element.
    public int bSearch(int item) throws ItemNotFoundException{
        // Declarations and instantiations of the "high", "mid" and "low" int values to be used in the Binary Search
        int high = (this.size - 1), low = 0, mid = ((high + low) / 2);

        // while loop that loops while the value of the int "low" variable is less than or equal to the int variable
            // "high" (if we keep looping, eventually "low" will be greater than "high") and we have not found the
            // item (value) we are looking for (represented by "this.values[mid] != item")
        while((low <= high) && (this.values[mid] != item)){
            // if statement that checks if the value at the index equal to the int value of the int variable "mid"
                // in the ordered Array is greater than the value of the passed in int value "item". If so,
                // then set the value of the int variable "high" equal to the value of the int value of the int variable
                // "mid" minus 1
            if(this.values[mid] > item){
                high = (mid - 1);
            }
            // else if statement that checks if the int value at the index of the int value of the int variable "mid"
                // of the ordered Array is less than the int value of the passed in int variable "item". If so,
                // then set the int value of the int variable "low" to the value of the int variable "mid" minus 1
            else if(this.values[mid] < item){
                low = (mid + 1);
            }
            // Set the int value of the int variable "mid" equal to the int value of the int variable "low", plus
                // the int value of the int variable "high" divided by 2
            mid = ((low + high) / 2);

            // Each loop iteration is counted as one operation, so increment the value of the int variable "count" by 1
            this.count++;
        }

        // if statement that checks if the index at the int value of the int variable "mid" of the ordered Array
            // "values" is equal to the int value of the passed in int variable "item" and if so, return that int index.
            // This means that we found the int value we were searching for
        if(this.values[mid] == item){
            return mid;
        }
        // else statement that executes if we did not find the int value we were looking for and if so, throw an
            // ItemNotFoundException and pass a message to its One-arg Constructor
        else {
            throw new ItemNotFoundException(item + " was not found in the Ordered Array");
        }
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


