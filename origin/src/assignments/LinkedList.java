package assignments;

public class LinkedList {
    protected Node head;

    //Adding one new node to the linked list
    public void addNewNode(String name) {
        Node newNode = new Node(name);
        boolean isUnique = true;
        //If we don't have any nodes in our linked list, then it will be our head
        if (head == null){
            head = newNode;
        }
        //If we have a loop in our linked list
        else if(checkForLoop() != null){
            System.out.println("You could not add any new nodes");
        }
        //If we already have at least one node in our linked list
        else{
            //First of all we point to the head of linked list
            Node lastNode = head;
            while (lastNode.nextNode != null){
                if (lastNode.name.equals(name)){
                    isUnique = false;
                    break;
                }
                //Then we point to last element of linked list
                lastNode = lastNode.nextNode;
            }

            //Check for unique node
            if (isUnique){
                //Insert a new node in our linked list
                lastNode.nextNode = newNode;
            }
            else{
                System.out.println("You should add only new unique nodes, use addLoop method to create a loop");
            }
        }
    }

    //Adding some nodes to the linked list
    public void addNewNodes(String[] names){
        for (String n : names){
            addNewNode(n);
        }
    }

    //Add loop from the last node in the linked list
    public void addLoop(String nodeName) {
        //If we don't have any nodes in our linked list, then it will be our head
        // And there will be one loop in itself
        if (head == null) {
            Node newNode = new Node(nodeName);
            head = newNode;
            head.nextNode = newNode;
        }
        //If we already have loop in our linked list
        else if (checkForLoop() != null){
            System.out.println("You already have a loop in this linked list");
        }
        //If we already have nodes in our linked list
        else{
            Node currentNode = head;
            boolean isPresent = false;
            //Trying to find node for loop
            while (currentNode.nextNode != null) {
                if(currentNode.name.equals(nodeName)){
                    isPresent = true;
                    break;
                }
                currentNode = currentNode.nextNode;
            }

            //Check if node is present in the linked list
            if (!isPresent){
                System.out.println("There is no node with name " + nodeName);
            }
            else{
                //Create loop
                Node lastNode = head;
                while (lastNode.nextNode != null) {
                    lastNode = lastNode.nextNode;
                }
                lastNode.nextNode = currentNode;
            }
        }
    }

    //Used Floyd’s loop detection algorithm
    public Node checkForLoop() {
        //If we don't have any nodes in our linked list or only 1 node
        if (head == null || head.nextNode == null){
            return null;
        }

        Node leftBound = head;
        leftBound = leftBound.nextNode;

        Node rightBound = head;
        rightBound = rightBound.nextNode.nextNode;

        //Try to find a loop in linked list
        while (rightBound != null && rightBound.nextNode != null){
            if (leftBound == rightBound){
                break;
            }
            leftBound = leftBound.nextNode;
            rightBound = rightBound.nextNode.nextNode;
        }

        //There is no loop in our linked list
        if (leftBound != rightBound){
            return null;
        }

        //There is a loop in our linked list
        //Return exact node - loop point
        leftBound = head;
        while (leftBound != rightBound){
            leftBound = leftBound.nextNode;
            rightBound = rightBound.nextNode;
        }

        return leftBound;
    }

    public boolean checkIfHeadIsPointForLoop(){
        return checkForLoop().name.equals(head.name);
    }

    public void printList() {
        Node currentNode = head;

        System.out.print("Linked list: ");
        if(checkForLoop() != null){
            Node lastNode = head;
            int iterator = checkIfHeadIsPointForLoop() ? 0 : -1;
            while (iterator < 1){
                if(lastNode.nextNode.equals(checkForLoop())) {
                    iterator++;
                }
                System.out.print(lastNode.name + " -> ");
                lastNode = lastNode.nextNode;
            }
            System.out.println(lastNode.name);
        }
        else{
            while (currentNode != null){
                if (currentNode.nextNode == null){
                    //End of linked list
                    System.out.print(currentNode.name);
                }
                else{
                    //Linked list
                    System.out.print(currentNode.name + " -> ");
                }
                currentNode = currentNode.nextNode;
            }
        }
        System.out.println("\n");
    }
}

