import student.TestCase;

/**
 * This class is to test the node class for preparing
 * binary search tree.
 * 
 * @author Chenkai Ren
 * @author Hung Tran
 * @version 1.0
 */
public class NodeTest extends TestCase {
    private Node<String, String> n1;
    private Node<String, String> n2;
    private String str;


    /**
     * this is a set up for the node;
     */
    public void setUp() {
        n1 = new Node<String, String>();
        str = "string";
        n2 = new Node<String, String>(str);
    }


    /**
     * test to see if it returns the correct child
     */
    public void testGetLeftChild() {
        assertNull(n1.getLeftChild());
        assertNull(n2.getLeftChild());
    }


    /**
     * test to see if it returns the correct child
     */
    public void testGetRightChild() {
        assertNull(n1.getRightChild());
        assertNull(n2.getRightChild());
    }


    /**
     * test getting the data of a node
     */
    public void testGetData() {
        assertEquals(str, n2.getData());
    }


    /**
     * testing if get key method
     */
    public void testGetKey() {
        assertNull(n2.getKey());
    }


    /**
     * testing to set the node's left child
     */
    public void testSetLeftChild() {
        String str2 = "Hello";
        Node<String, String> left = new Node<String, String>(str2);
        n2.setLeftChild(left);
        assertEquals(left, n2.getLeftChild());
    }


    /**
     * testing to set the node's right child
     */
    public void testSetRightChild() {
        String str2 = "Hello";
        Node<String, String> right = new Node<String, String>(str2);
        n2.setRightChild(right);
        assertEquals(right, n2.getRightChild());
    }


    /**
     * testing to set the data of a node
     */
    public void testSetData() {
        String str2 = "Hello";
        n2.setData(str2);
        assertEquals(str2, n2.getData());
    }


    /**
     * test to set the key of a node
     * test to get the key of a node
     */
    public void testSetKey() {
        String str2 = "Hello";
        n2.setKey(str2);
        assertEquals(str2, n2.getKey());
    }


    /**
     * testing isDeleteTarget method. return true
     * if it's being deleted.
     * 
     */
    public void testDeleteAcitvate() {
        assertFalse(n2.isDeleteTarget());
        n2.activateDelete();
        assertTrue(n2.isDeleteTarget());
    }


    /**
     * test if a node has leaf
     * case1: no left or right child
     * case2: only left child
     * case3: only right child
     */
    public void testIsLeaf() {
        // test when no left or right child
        assertTrue(n2.isLeaf());

        // adding left child
        String str2 = "Hello";
        Node<String, String> left = new Node<String, String>(str2);
        n2.setLeftChild(left);
        assertFalse(n2.isLeaf());

        // adding right child
        Node<String, String> right = new Node<String, String>(str2);
        n2.setRightChild(right);
        assertFalse(n2.isLeaf());
    }


    /**
     * testing if setting the dept is correct
     * testing if getting the dept number is correct.
     */
    public void testSetAndGetDept() {
        assertEquals(-1, n2.getDept());
        assertEquals(-1, n1.getDept());
        n2.setDept(4);
        assertEquals(4, n2.getDept());
    }
}
