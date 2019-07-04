/**********************************************************************************************************************
 **********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman   *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                        Programming Assignment #7                                           *****
 *****____________________________________________________________________________________________________________*****
 *****               Node class to use with the LinkedUnorderedList and LinkedOrderedList classes.                *****
 *****                                     Each Node has two instance data:                                       *****
 *****                         An int variable that stores an int value of the Node and                           *****
 *****                         a reference variable or pointer the next Node in the List.                         *****
 *****                                                                                                            *****
 *****                 This Node class has a Two-arg Constructor and Getters and Setters for both                 *****
 *****           the int value and the Node reference variable that points to the next Node in the List.          *****
 **********************************************************************************************************************
 **********************************************************************************************************************/

public class Node {

    // Instance data, fields, states
    private int value; // <-- int variable that stores the int value of this Node
    private Node next; // <-- Node variable to reference or point to the next Node in the List


    // Two-arg Constructor for instantiating a Node Object
    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }


    // Getter for the int value "value" variable
    public int getValue() {
        return this.value;
    }


    // Setter for the int value "value" variable
    public void setValue(int value) {
        this.value = value;
    }


    // Getter for the Node variable "next"
    public Node getNext() {
        return next;
    }


    // Setter for the Node variable "next"
    public void setNext(Node next) {
        this.next = next;
    }
}
