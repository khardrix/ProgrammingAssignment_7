/**********************************************************************************************************************
 **********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman   *****
 *****------------------------------------------------------------------------------------------------------------*****
 *****                                        Programming Assignment #7                                           *****
 *****____________________________________________________________________________________________________________*****
 *****                             This is an Exception class that extends Exception.                             *****
 *****                   This Exception class is used to handle the error when an element or Node                 *****
 *****            is not in the Array or LinkedList that is being searched for that particular element or         *****
 *****             when the missing element or Node is trying to be deleted from the Array or LinkedList.         *****
 *****                                                                                                            *****
 *****                         This Exception class contains two different Constructors:                          *****
 *****    - No-arg Constructor  - This Constructor passes a generic message to the parent Exception class to      *****
 *****                                indicate the element or Node was not found in the Array or LinkedList.      *****
 *****    - One-arg Constructor - This Constructor takes in, as a parameter, a String message to be passed        *****
 *****                                along to the parent class, Exception.                                       *****
 **********************************************************************************************************************
 **********************************************************************************************************************/

// Exception class that extends "Exception" for when an element is not found in the list we are searching
public class ItemNotFoundException extends Exception {

    // No-arg Constructor to output a default message when this Exception is thrown
    public ItemNotFoundException(){
        super("Item not found in the current List");
    }


    // 1-arg Constructor to take in a String to pass it to the Exception parent class Constructor in order to
        // print the passed in String message
    public ItemNotFoundException(String message){
        super(message);
    }
}
