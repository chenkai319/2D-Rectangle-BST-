/**
 * 
 * @author Hung Tran
 * @author Chenkai Ren
 *         The node class takes in 2 data type. T is actual object
 *         the node should hold and E is the data type of the
 *         node's ID.
 * 
 * @param <T>
 *            real object
 * @param <E>
 *            ID of the node
 * @version 1.0
 */
public class Node<T extends Comparable<T>, E extends Comparable<E>> {
    private T data;
    private E key;
    private int dept;
    private Node<T, E> leftChild;
    private Node<T, E> rightChild;
    private boolean deletedTarget;


    /**
     * Default constructor
     */
    public Node() {
        this.leftChild = null;
        this.rightChild = null;
        this.data = null;
        this.key = null;
        this.deletedTarget = false;
        this.dept = -1;
    }


    /**
     * paramertize constructor
     * 
     * @param item
     *            The item
     */
    public Node(T item) {
        this.data = item;
        this.leftChild = null;
        this.rightChild = null;
        this.key = null;
        this.deletedTarget = false;
        this.dept = -1;
    }


    /**
     * get the left child node
     * 
     * @return left child
     */
    public Node<T, E> getLeftChild() {
        return leftChild;
    }


    /**
     * get the right child node
     * 
     * @return right child
     */
    public Node<T, E> getRightChild() {
        return rightChild;
    }


    /**
     * get the data
     * 
     * @return data
     */
    public T getData() {
        return data;
    }


    /**
     * get the key of node
     * 
     * @return Node key
     */
    public E getKey() {
        return key;
    }


    /**
     * set left child node
     * 
     * @param child
     *            is a node child
     */
    public void setLeftChild(Node<T, E> child) {
        this.leftChild = child;
    }


    /**
     * set right child node
     * 
     * @param child
     *            a node child
     */
    public void setRightChild(Node<T, E> child) {
        this.rightChild = child;
    }


    /**
     * set data of the node
     * 
     * @param item
     *            The item
     */
    public void setData(T item) {
        this.data = item;
    }


    /**
     * set the key of the node
     * 
     * @param item
     *            The item
     */
    public void setKey(E item) {
        this.key = item;
    }


    /**
     * activate delete flag in the node
     */
    public void activateDelete() {
        this.deletedTarget = true;
    }


    /**
     * Deactivate delete flag in the node
     */
    public void deactivateDelete() {
        this.deletedTarget = false;
    }


    /**
     * check if the delete flag is on
     * 
     * @return true if the delete flag is on
     */
    public boolean isDeleteTarget() {
        return this.deletedTarget;
    }


    /**
     * check to see if the node is leaf
     * 
     * @return true if the node is a leaf
     */
    public boolean isLeaf() {
        return (this.leftChild == null && this.rightChild == null);
    }


    /**
     * set the depth of the node
     * 
     * @param level
     *            depth level of the current node
     */
    public void setDept(int level) {
        this.dept = level;
    }


    /**
     * get the depth of the node
     * 
     * @return the depth of the tree
     */
    public int getDept() {
        return this.dept;
    }
}
