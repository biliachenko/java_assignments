package assignments;

public class Node {
    protected String name;
    protected Node nextNode;

    //Default constructor
    Node(){
        name = null;
        nextNode = null;
    }

    //Constructor with name
    Node(String name){
        this.name = name;
        nextNode = null;
    }
}
