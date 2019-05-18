import java.util.Stack;
import java.util.Iterator;

/**
 * This data structure used to store the collection of rectangles
 * and will be in the Binary Search Tree
 * 
 * @author Chenkairen
 * @author Hung Tran
 *
 * @param <T>
 *            Actual Object
 * @param <E>
 *            Key data type
 * 
 * @version 1.0
 */

public class BinarySearchTree<T extends Comparable<T>, E extends Comparable<E>>
    implements Iterable<Node<T, E>> {
    private Node<T, E> root;
    private int nodeCount;


    /**
     * Default constructor
     */
    public BinarySearchTree() {
        root = null;
        this.nodeCount = 0;
    }


    /**
     * clear the tree
     */
    public void clear() {
        root = null;
        this.nodeCount = 0;
    }


    /***** HELPER*FUNCTIONS ********/
    /**
     * Depth helper
     * 
     * @param subTreeNode
     *            The node
     * @param level
     *            the depth level
     */
    private void setDepthHelper(Node<T, E> subTreeNode, int level) {
        if (subTreeNode == null) {
            return;
        }
        else {
            subTreeNode.setDept(level);
            setDepthHelper(subTreeNode.getLeftChild(), level + 1);
            setDepthHelper(subTreeNode.getRightChild(), level + 1);
        }
    }


    /**
     * Delete maximum node
     * 
     * @param subTreeNode
     *            the node
     * @return the node
     */
    private Node<T, E> deleteMax(Node<T, E> subTreeNode) {
        if (subTreeNode.getRightChild() == null) {
            return subTreeNode.getLeftChild();
        }
        subTreeNode.setRightChild(deleteMax(subTreeNode.getRightChild()));
        return subTreeNode;
    }


    /**
     * get maximum node
     * 
     * @param subTreeNode
     *            the node
     * @return the max node
     */
    private Node<T, E> getMax(Node<T, E> subTreeNode) {
        if (subTreeNode.getRightChild() == null) {
            return subTreeNode;
        }
        return getMax(subTreeNode.getRightChild());
    }


    /**
     * The helper function that take in a subtree node, it will look for
     * the target item by traversing through the tree
     * 
     * @param subTreeNode
     *            the node
     * @param target
     *            the remove target
     * @return an updated node
     */
    private Node<T, E> removeHelper(Node<T, E> subTreeNode, T target) {
        if (target == null) {
            return null;
        }
        // go to the right of the tree if target is bigger than current node
        if (subTreeNode.getData().compareTo(target) > 0) /* move */
        {
            subTreeNode.setLeftChild(removeHelper(subTreeNode.getLeftChild(),
                target));
        }
        // go to the left of the tree if target is smaller than current node
        else if (subTreeNode.getData().compareTo(target) < 0) {
            subTreeNode.setRightChild(removeHelper(subTreeNode.getRightChild(),
                target));
        }
        else if (!subTreeNode.isDeleteTarget()) {
            subTreeNode.setLeftChild(removeHelper(subTreeNode.getLeftChild(),
                target));
        }
        else // Found target
        {
            if (subTreeNode.getLeftChild() == null) {
                return subTreeNode.getRightChild();
            }
            else {
                Node<T, E> temp = getMax(subTreeNode.getLeftChild());
                temp.activateDelete();
                subTreeNode.setData(temp.getData());
                subTreeNode.deactivateDelete();
                subTreeNode.setLeftChild(deleteMax(subTreeNode.getLeftChild()));
            }
        }
        return subTreeNode;
    }


    /**
     * Find the node base on its name
     * 
     * @param subTreeNode
     *            the node
     * @param target
     *            find item
     * @return found item
     */
    public T findNodeHelper(Node<T, E> subTreeNode, T target) {
        if (subTreeNode == null) {
            return null;
        }

        if (subTreeNode.getData().compareTo(target) == 0) {
            subTreeNode.activateDelete();
            return subTreeNode.getData();
        }

        else if (findNodeHelper(subTreeNode.getLeftChild(), target) == null) {
            return findNodeHelper(subTreeNode.getRightChild(), target);
        }
        else {
            return findNodeHelper(subTreeNode.getLeftChild(), target);
        }
    }


    /**
     * Search all element
     * 
     * @param subTreeNode
     *            the node
     * @param target
     *            The target to search for
     * @return an object
     */
    private T searchAllHelper(Node<T, E> subTreeNode, T target) {
        if (subTreeNode == null) {
            return null;
        }

        if (subTreeNode.getData().compareTo(target) == 0) {
            System.out.println(subTreeNode.getData().toString());
            return searchAllHelper(subTreeNode.getLeftChild(), target);
        }
        else if (subTreeNode.getData().compareTo(target) > 0) {
            return searchAllHelper(subTreeNode.getLeftChild(), target);
        }
        else {
            return searchAllHelper(subTreeNode.getRightChild(), target);
        }
    }


    /**
     * take in a subtree node then dumb it.
     * 
     * @param subTreeNode
     *            the target node
     */
    private void dumpHelper(Node<T, E> subTreeNode) {
        if (subTreeNode != null) {
            dumpHelper(subTreeNode.getLeftChild());
            if (subTreeNode != null) {
                System.out.println("Node has depth " + subTreeNode.getDept()
                    + ", Value " + subTreeNode.getData().toString());
            }
            dumpHelper(subTreeNode.getRightChild());
        }
    }


    /**
     * Insert a node into the tree with BST order.
     * 
     * @param subTreeNode
     *            the node
     * @param item
     *            the item needed to insert
     * @return an node
     */
    private Node<T, E> insertHelper(Node<T, E> subTreeNode, T item) {
        if (subTreeNode == null) {
            return new Node<T, E>(item);
        }
        if (item.compareTo(subTreeNode.getData()) <= 0) {
            subTreeNode.setLeftChild(this.insertHelper(subTreeNode
                .getLeftChild(), item));
        }
        else {
            subTreeNode.setRightChild(this.insertHelper(subTreeNode
                .getRightChild(), item));
        }
        return subTreeNode;
    }


    /********* END*HELPER*FUNCTIONS ***************/

    /**
     * check to see if the tree is empty
     * 
     * @return true if the tree is empty
     */
    public boolean isTreeEmpty() {
        return (root == null);
    }


    /**
     * Insert an item into a tree
     * 
     * @param item
     *            the item
     */
    public void insert(T item) {
        {
            root = insertHelper(root, item);
        }
        nodeCount++;
    }


    /**
     * remove item from a tree
     * 
     * @param target
     *            the remove target
     * @param flag
     *            the flag is off if remove target by finding it in
     *            the tree first
     *            If the flag is on, it will remove which node has deleted
     *            flag activated without finding it
     * @return true if the item is removed
     */
    public boolean remove(T target, boolean flag) {
        if (target == null) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (!flag) {
            T targetFound = findNodeHelper(root, target);
            if (targetFound == null) {
                return false;
            }
            root = removeHelper(root, targetFound);
        }
        else {
            root = removeHelper(root, target);
        }

        nodeCount--;
        return true;
    }


    /**
     * search item from a tree
     * 
     * @param target
     *            the item to search for
     * @return true if item is found
     */
    public boolean search(T target) {

        if (findNodeHelper(root, target) == null) {
            return false;
        }
        this.searchAllHelper(root, target);
        return true;
    }


    /**
     * Dump a tree
     */
    public void dump() {
        if (this.isTreeEmpty()) {
            System.out.println("Node has depth 0, Value (null)");
            System.out.println("BST size is: " + this.nodeCount);
        }
        else {
            this.setDepthHelper(root, 0);
            dumpHelper(root);
            System.out.println("BST size is: " + this.nodeCount);
        }
    }


    /**
     * @Override override iterator
     */
    @Override
    public Iterator<Node<T, E>> iterator() {
        return new BTSIterator(this);
    }


    /**
     * create an iteration of a tree with inorder tranverse.
     * 
     * @author Hung Tran
     * @author Chenkai Ren
     * @version 1.0
     */
    class BTSIterator implements Iterator<Node<T, E>> {
        private Node<T, E> currentNode;
        private Stack<Node<T, E>> container = new Stack<Node<T, E>>();


        /**
         * default iterator
         * 
         * @param bst
         *            binary search tree
         */
        public BTSIterator(BinarySearchTree<T, E> bst) {
            currentNode = root;
            while (currentNode != null) {
                container.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
        }


        /**
         * check to see if the next item is available
         * 
         * @return true if there is next node
         */
        public boolean hasNext() {
            return (!(currentNode == null && container.isEmpty()));
        }


        /**
         * get the next item
         * 
         * @return the next item
         */
        public Node<T, E> next() {
            while (currentNode != null) {
                container.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }

            Node<T, E> temp = container.pop();
            currentNode = temp;
            currentNode = currentNode.getRightChild();

            return temp;
        }
    }
}
