/**********************************************************************************************************************
 **********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman   *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                        Programming Assignment #7                                           *****
 *****____________________________________________________________________________________________________________*****
 *****                                 This class is for an Ordered LinkedList.                                   *****
 *****                                   This class has three Instance datum:                                     *****
 ***** "front" - A Node variable that stores the pointer to the first Node / front Node / front of the            *****
 *****               Ordered LinkedList                                                                           *****
 ***** "size"  - An int variable that stores the current number of Nodes in the Ordered LinkedList                *****
 ***** "count" - An int variable that keeps track of the number of operations performed during certain methods:   *****
 *****             - insert(int x)                                                                                *****
 *****             - delete(int x)                                                                                *****
 *****             - search(int x)                                                                                *****
 *****                                                                                                            *****
 *****       This class has a No-arg Constructor that instantiates front to null, size to 0 and count to 0.       *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                   This class also has seven methods:                                       *****
 *****    - isEmpty()     - boolean method that returns whether the LinkedList is currently empty                 *****
 *****                          by checking to see if the Node "front" is equal to null.                          *****
 *****    - print()       - Traverses every Node in the Ordered LinkedList and prints to the console the int      *****
 *****                          value stored in the current Node this void method is examining                    *****
 *****    - insert(int x) - Insert the int value "x" into the Ordered LinkedList at the correct Node index.       *****
 *****                          This void method checks if the LinkedList is empty and if "x" is less than the int*****
 *****                          value of everything other Node. If either is the case, insert "x" into a new      *****
 *****                          Node and insert that Node at the beginning of the Ordered LinkedList and set      *****
 *****                          that Node to be the "front" Node. If neither is the case, search through the      *****
 *****                          Ordered LinkedList and insert "x" into a new Node at the correct location in      *****
 *****                          the Ordered LinkedList                                                            *****
 *****                          *   size  - Increment "size"  by 1 every time a Node is successfully inserted     *****
 *****                                          into the Ordered LinkedList.                                      *****
 *****                          *** count - Increment "count" each time a Node is examined and                    *****
 *****                                          when a Node is added to the Ordered LinkedList.                   *****
 *****    - delete(int x) - Delete the first Node in the Ordered LinkedList that has stores the int value of "x". *****
 *****                          This void method can throw an ItemNotFoundException if the LinkedList is empty or *****
 *****                          if there is no Node in the Ordered LinkedList that stores the int value of "x".   *****
 *****                          This method traverses the OrderedLinkedList from the "front" Node and then        *****
 *****                          moves on to the next Node and then the next Node and the next Node and so on      *****
 *****                          until it finds the first Node that stores the int value equal to "x" and          *****
 *****                          then sets the Node previous to that Node to point to the Node after the first     *****
 *****                          Node that stores the int value equal to "x". Therefore, no Node any longer        *****
 *****                          points to that Node. The Java Garbage Collector will then come along and          *****
 *****                          physically delete that Node by returning that Node to the Heap.                   *****
 *****                          This method uses the "Inchworm Search Approach."                                  *****
 *****                          *   size  - Decrement "size" whenever a Node is successfully deleted.             *****
 *****                          *** count - Increment "count" each time a Node is examined and                    *****
 *****                                      when a Node is deleted from the Ordered LinkedList.                   *****
 *****    - search(int x) - Use the "Inchworm Search Approach" to traverse through the entire Ordered LinkedList. *****
 *****                          This Node method can throw an ItemNotFoundException if the LinkedList is empty    *****
 *****                          of there is no Node in the OrderedLinkedList that stores an int value             *****
 *****                          equal to "x". Once the first Node to store an int value equal to "x" is found,    *****
 *****                          return that Node to where this Node method was called.                            *****
 *****                          The "Inchworm Search Approach" works by setting the previous Node equal to        *****
 *****                          the current Node ("scrunching up"), examine that Node, then set current Node      *****
 *****                          Node equal to the Node after current ("flattening out").                          *****
 *****                          *** count - Increment "count" each time a Node is examined.                       *****
 *****    - getSize()     - int method that returns the current size of the Ordered LinkedList, by returning      *****
 *****                          the int value of the int "size" variable.                                         *****
 *****    - getCount()    - int method that returns the number of operations performed with this class.           *****
 **********************************************************************************************************************
 **********************************************************************************************************************/

public class LinkedOrderedList {

    // Instance data, states, fields
    private Node front; // <-- The first or front Node of the Ordered LinkedList
    private int size; // <-- The current number of Nodes in the LinkedList
    // Counter variable to keep track of the number of operations performed in each applicable method
    private int count;


    // No-arg Constructor to create an empty LinkedList, set "size" to 0 and set "count" to 0
    public LinkedOrderedList(){
        this.front = null;
        this.size = 0;
        this.count = 0;
    }


    // boolean method to check if the Ordered LinkedList is empty
    public boolean isEmpty(){
        return (this.front == null);
    }


    // void method to traverse the LinkedList and print out all the elements
    public void print(){
        // Create a temporary Node called "temp" that is equal to the current front Node of the Ordered LinkedList
        Node temp = this.front;

        // while loop that checks that the Node "temp"'s value does not equal null (Which would mean that we have
            // reached the end of the Ordered LinkedList)
        while(temp != null){
            // Print to the console the value of the current Node we are looking at
            System.out.println(temp.getValue());
            // Set the Node variable "temp" to the next Node in the Ordered LinkedList
            temp = temp.getNext();
        }
    }


    // void method to insert a Node in the proper order in the Ordered LinkedList, based upon the value of the
        // int variable "value" in the Node Class
    public void insert(int x){
        // Create and Initialize a Node variable called "temp" to store the passed in int parameter, "x"
        Node temp = new Node(x,null);

        // if statement to check if the Ordered LinkedList is empty
        if(this.isEmpty()){
            // If so, set the front Node to the "temp" Node we created
            this.front = temp;

            // Increment the int value of the int variable "size", which keeps track of the size of the
                // Ordered LinkedList, by 1
            this.size++;

            // Insert the newly created "temp" Node at the front of the OrderedLinkedList. This takes one operation,
                // so increment the int value of the int variable "count"
            this.count++;
        }
        // else if statement to check if the value of the int variable x is less than the int value stored in
            // the front Node. If that is case, insert the "temp" Node to the front of the Ordered LinkedList
        else if(x < this.front.getValue()){
            // Set "temp"'s next field equal to front
            temp.setNext(this.front);
            // Set the "temp" Node variable we created to the front of the Ordered LinkedList
            this.front = temp;

            // Increment the int value of the int variable "size", which keeps track of the size of the
                // Ordered LinkedList, by 1
            this.size++;

            // Insert the newly created "temp" Node at the front of the OrderedLinkedList. This takes one operation,
                // so increment the int value of the int variable "count"
            this.count++;
        }
        // else statement that executes if the value of the passed in int variable "x" is greater than the
            // int value stored in front Node (at this point, we know the Ordered LinkedList is not empty).
            // So, we have to search through the Ordered LinkedList to find the correct location to insert
            // the newly created Node variable "temp" (using the "Inchworm Search Approach")
        else {
            // Create and Initialize a new Node variable "current" and set it equal to the current front Node of
                // the Ordered LinkedList. This Node will store the Node we are currently examining
            Node current = this.front;
            // Create and Initialize a new Node variable "previous" and set its value to null. This Node
                // will store the Node previous to the one we are examining
            Node previous = null;

            // while loop that loops while the value of the "current" Node does not equal null (meaning
                // we haven't reached the end of the Ordered LinkedList) and the int value of the passed in
                // parameter "x" is greater than the int value of the "current" Node we are examining
            while((current != null) && (x > current.getValue())){
                // Set the value of the "previous" Node equal to the value of the "current" Node (The "scrunch
                    // up" part of the "Inchworm Search Approach")
                previous = current;
                // Set the value of the "current" Node equal to the value of the next Node in the Ordered LinkedList
                    // (The "flattening out" part of the "Inchworm Search Approach")
                current = current.getNext();

                // Each time we look at a Node, that takes one operation. So, increment the int value of the int
                    // variable "count" by 1
                this.count++;
            }

            // Set the "previous" Node's next pointer reference equal to the "temp" Node that we created
            previous.setNext(temp);
            // Set the "temp" Node's (that we created) next pointer reference equal to the "current" Node that
                // we were examining
            temp.setNext(current);

            // Increment the int value of the int variable "size", which keeps track of the size of the
                // Ordered LinkedList, by 1
            this.size++;

            // Insert the newly created "temp" Node at the appropriate location. This takes one operation,
                // so increment the int value of the int variable "count", by 1
            this.count++;
        }
    }


    // void method to delete an element from the Ordered LinkedList, throw an ItemNotFoundException if the
        // Ordered LinkedList is empty, set the "front" Node to the next Node if we are deleting the first Node
        // (deleting "front") or we search down the Ordered LinkedList to find the Node we want to delete
    public void delete(int x) throws ItemNotFoundException {
        // if statement to check if the Ordered LinkedList is empty and if so, throw an ItemNotFoundException and pass it a
            // message to the 1-arg Constructor of ItemNotFoundException
        if(this.isEmpty()){
            // Throw a new ItemNotFoundException and pass a message to the 1-arg Constructor of ItemNotFoundException
            throw new ItemNotFoundException(x + " was not found in the Ordered LinkedList, because the " +
                    "Ordered LinkedList is empty. So, " + x + ", cannot be deleted, because it does not exist");
        }
        // else if statement to check if the int value of front is equal to the value we want to delete. If so,
            // we will delete the first Node ("front") and set "front" (the first Node) equal to the next Node
        else if((this.front.getValue() - x) == 0){
            // Set the Node of the first Node to the second Node
            this.front = this.front.getNext();

            // Decrement the int variable "size", which keeps track of the size of the Ordered LinkedList, by 1
            this.size--;

            // Since this Node was examined, we increment the operation int variable "count" by 1
            this.count++;

        }
        // else statement that executes if the Ordered LinkedList is not empty and we are not deleting the first Node
            // and we have to search through the Ordered LinkedList for the Node we want to delete
        else {
            // Set a copy of the "front" Node to the new created Node variable "current"
            Node current = this.front;
            // Create a new Node variable "previous" and Initialize it to null
            Node previous = null;

            // while loop that will loop while the Node variable "current" does not equal null (we haven't reached
                // the end of the Ordered LinkedList) and we have not found the Node with value we are looking for
                // (represented by the coding: "(current.getValue() - x) != 0"
            while((current != null) && ((current.getValue() - x) != 0)){
                // Set the "previous" Node to the "current" Node (Thereby, having "previous" and "current" equaling
                    // the same thing and "scrunching up")
                previous = current;
                // Set the value of the Node variable "current" to the next Node in the Ordered LinkedList,
                    // "current.getNext()" (Thereby, moving down the Ordered LinkedList and "flattening out" and
                    // completing the second step in the "Inchworm Search Approach")
                current = current.getNext();

                // Every time examine a Node, it is one operation. So, we increment the int variable
                    // "count" by 1
                this.count++;
            }

            // if statement to check if the Node variable "current" does not equal null. Meaning that we found the
                // Node with the int value we were looking for (We found the Node we were looking for)
            if(current != null){
                // Set the Node variable "previous"'s next Node value to the Node variable "current"'s next Node value.
                    // Therefore, nothing will any longer pointing at the original Node variable "current"'s Node and
                    // so, the Node "current" will be deleted by the Java Garbage Collector since there is no longer
                    // anything referencing it
                previous.setNext(current.getNext());

                // Decrement the int variable "size", which keeps track of the size of the Ordered LinkedList, by 1
                this.size--;

                // We are deleting a Node, which takes one operation. So, increment the int vaule of the int variable
                    // "count", by 1
                this.count++;
            }
            // else statement that executes if the list was not empty, the Node we were looking for (the Node whose
                // int value is equal to the int value passed in as an int parameter) was not the first node and
                // we did not find the Node value in the entire Ordered LinkedList. In which case, throw a new
                // ItemNotFoundException and pass a message to the ItemNotFoundException's 1-arg Constructor
            else {
                // Throw a new ItemNotFoundException and pass a message to its 1-arg Constructor
                throw new ItemNotFoundException(x + " was not found in the Ordered LinkedList, " +
                        "so it cannot be deleted");
            }
        }
    }


    // Node method to return the Node that is being searched for (whose int value matches the passed in int value)
    public Node search(int x) throws ItemNotFoundException{
        // Create a new Node variable "temp" and Initialize it to equal the Node "front"
        Node temp = this.front;

        // while loop that loops while the Node variable "temp" does not equal null (We haven't reach the
            // end of the Ordered LinkedList) and we haven't found the Node we are looking for (represented by
            // the coding: "(temp.getValue() - x) != 0")
        while((temp != null) && ((temp.getValue() - x) != 0)){
            // Set the value of the newly created Node variable "temp" to the next Node ("temp.getNext()")
            temp = temp.getNext();

            // Every time we examine a Node, it takes one operation. So, we increment the int variable "count"
                // by 1
            this.count++;

        }

        // if statement to check if the newly created Node variable "temp" is equal to null (meaning we did not
            // find the Node value we were looking for. The Node with the value that was passed in as an int parameter)
            // If so, throw a new ItemNotFoundException
        if(temp == null){
            // Throw a new ItemNotFoundException and pass a message to its 1-arg Constructor
            throw new ItemNotFoundException(x + " was not found in the Ordered LinkedList");
        }
        // else statement that executes if we found the Node we were looking for
        else {
            // Return the Node we were looking for
            return temp;
        }
    }


    // Getter method to return the int value of the int variable "size" which represents the current size of the
        // Ordered LinkedList or the current number of Nodes in the Ordered LinkedList
    public int getSize(){
        // Return the current size of the LinkedList
        return this.size;
    }


    // Getter method to return the int value of the int variable "count", which represents the number of operations
        // performed to complete different tasks with the Ordered LinkedList
    public int getCount(){
        // Return the number of operations performed in the Ordered LinkedList
        return this.count;
    }
}
