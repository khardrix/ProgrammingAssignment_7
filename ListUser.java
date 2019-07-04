/**********************************************************************************************************************
 **********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman   *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                        Programming Assignment #7                                           *****
 *****____________________________________________________________________________________________________________*****
 *****         This is the Main class of the program that uses the other six classes in order to operate.         *****
 *****                                                                                                            *****
 *****                              This class performs eight different operations:                               *****
 *****        1. This class creates an int Array and fills it with 1,000 randomly generated ints                  *****
 *****               in the range from 0 to 999,999.                                                              *****
 *****        2. Create four different Objects. One for each type of List class that this program contains:       *****
 *****               - LinkedUnorderedList - Unordered LinkedList class                                           *****
 *****               - LinkedOrderedList   - Ordered LinkedList class                                             *****
 *****               - ArrayUnorderedList  - Unordered Array class                                                *****
 *****               - ArrayOrderedList    - Ordered Array class                                                  *****
 *****        3. Insert the first 500 elements from the int array containing the random ints this program         *****
 *****               created, called "array" into each of the four List class Objects we created and              *****
 *****               instantiated.                                                                                *****
 *****        4. Generate 25 random numbers in the range of 0 - 499 and delete the element or Node at that        *****
 *****               index in each of the four List Objects.                                                      *****
 *****        5. Insert the last 500 elements from the int array containing the random ints this program          *****
 *****               created, called "array" into eaach of the four List class Objects we created and             *****
 *****               instantiated.                                                                                *****
 *****        6. Generate 25 random numbers in the range of 500 - 999 and delete the element or Node at that      *****
 *****               index in each of the four List Objects.                                                      *****
 *****        7. Generate 100 random numbers in the range of 0 - 999 and search for the element or Node at        *****
 *****               that index in each of the four List Objects (that index may not exist from all the deleting) *****
 *****        8. Print out the number of operations it took to perform the actions in steps 3 - 7 by each         *****
 *****               of the four List Objects.                                                                    *****
 *****____________________________________________________________________________________________________________*****
 *****        9. Change the number of deletions in the first 500 indices from 25 to 50. Change the number of      *****
 *****               deletions in the last 500 indices from 25 to 50. Change the number of searches performed     *****
 *****               in the entire List Objects from 100 searches to 250 searches.                                *****
 *****       10. Print out the number of operations it took to perform the actions in steps 3 - 7 by each         *****
 *****               of the four List Objects with the new number of operations.                                  *****
 *****       11. Change the number of deletions in the first 500 indices from 50 to 100. Change the number of     *****
 *****               deletions in the last 500 indices from 50 to 100. Change the number of searches performed    *****
 *****               in the entire List Objects from 250 searches to 1,000 searches.                              *****
 *****       12. Print out the number of operations it took to perform the actions in steps 3 - 7 by each         *****
 *****               of the four List Objects with the new number of operations.                                  *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****          You have to change the numbers in the program and re-run the program each time you change         *****
 *****                                 the number of deletions and searches and                                   *****
 *****                   print out those number of operations by each of the four List Objects.                   *****
 *****                                              (Steps 9 - 12)                                                *****
 *****                                                                                                            *****
 *****____________________________________________________________________________________________________________*****
 *****                                            EXPLANATION:                                                    *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                              Results:                                                      *****
 *****            The Unordered LinkedList takes the least amount of operations at first, because                 *****
 *****inserting is Order(1) in an Unordered LinkedList and with a vastly smaller number of deletions and searches *****
 *****               which are Order(n), the Unordered LinkedList gives the best results.                         *****
 *****  As the number of deletions and searches increases, the Ordered Array starts to have the best performance  *****
 *****                      because that is the only List that can use the Binary Search and                      *****
 *****                                  the Binary Search is Order(log n).                                        *****
 *****               Binary Searching is exponentially better performing than the Sequential Search               *****
 *****                              used in all the other List Object classes.                                    *****
 *****                    In order to delete an element or Node, that requires searching,                         *****
 *****           so that would explain why the Ordered Array ends up with vastly better performance               *****
 *****                            when more searches and deletions are performed.                                 *****
 *****                                                                                                            *****
 *****                              When I might use each of the four List types:                                 *****
 *****            Unordered LinkedList - I would use this List class if I just wanted to do a bunch of inserting  *****
 *****                                       and didn't care about searching or deleting or where the Nodes       *****
 *****                                       were inserted. Like when making a list of items to bring on          *****
 *****                                       vacation.                                                            *****
 *****              Ordered LinkedList - I might use this List class if I wanted to have an ordered list, but     *****
 *****                                       wasn't planning on deleting or searching a lot. Like if I was        *****
 *****                                       making an alphabetical list of DVDs I owned.                         *****
 *****                 Unordered Array - I might use this List class when I wanted to create a list of items      *****
 *****                                       that I didn't care about their order. Like a grocery list and        *****
 *****                                       would be inserting a lot, but not searching or deleting.             *****
 *****                   Ordered Array - I would use this list if I was planning on making a list that I would    *****
 *****                                       would be searching a lot. Whether searching to find an element or    *****
 *****                                       Node or searching to perform some other operation, like deleting.    *****
 *****                                       I would choose the Ordered Array for this, because it is the only    *****
 *****                                       List that can use the Binary Search. Like if I was making an         *****
 *****                                       inventory of CDs that I own if I was going to buy and sell CDs.      *****
 **********************************************************************************************************************
 **********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import java.util.Random;


public class ListUser {


    public static void main(String[] args) {

        // LOCAL VARIABLE(s) declaration(s)
        Random random = new Random(); // <-- Random variable to generate random numbers
        int[] array = new int[1_000]; // <-- Array variable that references an Array with 1,000 random int elements
        ArrayUnorderedList arrayUL = new ArrayUnorderedList(); // <-- Reference variable to an unordered Array
        ArrayOrderedList arrayOL = new ArrayOrderedList(); // <-- Reference variable to an ordered Array
        LinkedUnorderedList linkedUL = new LinkedUnorderedList(); // <-- Reference variable to an unordered LinkedList
        LinkedOrderedList linkedOL = new LinkedOrderedList(); // <-- Reference variable to an ordered LinkedList

        // for loop to fill the int Array "array" with 1,000 random ints
        for(int i = 0; i < array.length; i++){
            // Assign a random int value (in the range from 0 - 999,999) to the specified (by "i") element of
                // the int Array "array"
            array[i] = random.nextInt(1_000_000);
        }

        // for loop to insert the first 500 elements of the int Array "array" into the four Lists
        for(int i = 0; i < 500; i ++){
            arrayUL.insert(array[i]); // <-- Insert into the Unordered Array
            arrayOL.insert(array[i]); // <-- Insert into the Ordered Array
            linkedUL.insert(array[i]); // <-- Insert into the Unordered LinkedList
            linkedOL.insert(array[i]); // <-- Insert into the Ordered LinkedList
        }

        // for loop to randomly generate 25 numbers (in the range 0 - 499) and delete the int value/Node at that
            // index in each of the four different Lists
            // (Each attempt could result in throwing an ItemNotFoundException)
        // Different versions of the for loop to be used to get different results to find out which list has the best
            // performance
        for(int i = 0; i < 100; i++){
        // for(int i = 0; i < 50; i++){
        // for(int i = 0; i < 25; i++){
            // int variable to store a random int value in the of 0 - 499
            int temp = array[random.nextInt(500)];

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "arrayUL"
            try {
                arrayUL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "arrayUL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "arrayOL"
            try {
                arrayOL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "arrayOL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "LinkedUL"
            try {
                linkedUL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "linkedUL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "LinkedOL"
            try {
                linkedOL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "linkedOL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }
        }

        // for loop to insert the values from the int Array "array" at indices 500 - 999 into the four different Lists
        for(int i = 500; i < array.length; i++){
            arrayUL.insert(array[i]); // <-- Insert into the Unordered Array
            arrayOL.insert(array[i]); // <-- Insert into the Ordered Array
            linkedUL.insert(array[i]); // <-- Insert into the Unordered LinkedList
            linkedOL.insert(array[i]); // <-- Insert into the Ordered LinkedList
        }

        // for loop to randomly generate 25 numbers (in the range 500 - 999) and delete the int value/Node at that
            // index in each of the four different Lists
            // (Each attempt could result in throwing an ItemNotFoundException)
        // Different versions of the for loop to be used to get different results to find out which list has the best
            // performance
        for(int i = 0; i < 100; i++){
        // for(int i = 0; i < 50; i++){
        // for(int i = 0; i < 25; i++){
            // int variable to store a random int value in the of 500 - 999
            int temp = array[(random.nextInt(500) + 500)];

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "arrayUL"
            try {
                arrayUL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "arrayUL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "arrayOL"
            try {
                arrayOL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "arrayOL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "LinkedUL"
            try {
                linkedUL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "linkedUL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to delete the value from the index (specified by the random value "temp")
                // from "LinkedOL"
            try {
                linkedOL.delete(temp);
            }
            // catch block in case the index, with the value of "temp", was not found in "linkedOL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }
        }

        // for loop to randomly generate 100 numbers (in the range 0 - 999) and search the int value/Node at that
            // index in each of the four different Lists
            // (Each attempt could result in throwing an ItemNotFoundException)
        // Different versions of the for loop to be used to get different results to find out which list has the best
            // performance
        for(int i = 0; i < 1_000; i++){
        // for(int i = 0; i < 250; i++){
        // for(int i = 0; i < 100; i++){
            // int variable to store a random int value in the of 0 - 999
            int temp = array[(random.nextInt(1_000))];

            // try block to attempt to search the Unordered Array at the index indicated by the int value of "temp"
            try {
                arrayUL.search(temp);
            }
            // catch block in case the element at the index specified by "temp" was not found in "arrayUL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to search the Ordered Array at the index indicated by the int value of "temp"
            try {
                arrayOL.bSearch(temp);
            }
            // catch block in case the element at the index specified by "temp" was not found in "arrayOL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to search the Unordered LinkedList at the index indicated by the int value of "temp"
            try {
                linkedUL.search(temp);
            }
            // catch block in case the element at the index specified by "temp" was not found in "linkedUL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }

            // try block to attempt to search the Ordered LinkedList at the index indicated by the int value of "temp"
            try {
                linkedOL.search(temp);
            }
            // catch block in case the element at the index specified by "temp" was not found in "linkedOL"
            catch(ItemNotFoundException e){
                // System.out.println(e);
            }
        }

        // Print to the console the number of operations performed by each of the four different types of Lists
            // during the execution of this program/class (inserts, deletions and searches)
        System.out.println("Unordered linked list count: " + linkedUL.getCount());
        System.out.println("Ordered linked list count: " + linkedOL.getCount());
        System.out.println("Unordered array count: " + arrayUL.getCount());
        System.out.println("Ordered array count: " + arrayOL.getCount());
    }
}
