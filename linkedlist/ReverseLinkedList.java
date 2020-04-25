/*Reverse a linked List by 2 methods ->
space -> O(1)
time->O(n)
 Iterative method
Recursive method*/
/*Input: Head of following linked list
  1->2->3->4->NULL
  Output: Linked list should be changed to,
  4->3->2->1->NULL

  Input: Head of following linked list
  1->2->3->4->5->NULL
  Output: Linked list should be changed to,
  5->4->3->2->1->NULL

  Input: NULL
  Output: NULL

  Input: 1->NULL
  Output: 1->NULL*/
import java.util.*;

public class ReverseLinkedList extends LinkedList {

  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    list.head = new Node(85);
    list.head.next = new Node(15);
    list.head.next.next = new Node(4);
    list.head.next.next.next = new Node(20);

    System.out.println("Given Linked list");
    printList(head);
    System.out.println("Which method to choose");
    System.out.println("1.Iterative Method");
    System.out.println("2.Recursive method");
    System.out.println("enter your choice");
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    switch (a) {
      case 1:
        head = reverseIteratively(head);
        break;
      case 2:
        head = reverseRecursively(head);
      default:
        break;
    }
    System.out.println("Reversed linked list ");
    printList(head);

  }

  public static Node reverseRecursively(Node head) {
    if (head == null) {
      return head;
    }
    Node P = head;
    Node Q = P.next;
    if (Q == null) {
      return P;
    }
    Q = reverseRecursively(Q);
    P.next.next = P;
    P.next = null;
    return Q;
  }

  public static Node reverseIteratively(Node head) {
    Node prev = null;
    Node curr = head;
    Node next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }

  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data);
      if (node.next != null) {
        System.out.print("->");
      }
      node = node.next;
    }
    System.out.println();
  }
}

class  LinkedList {

  static Node head;

  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }
}