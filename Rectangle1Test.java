
/**
 * 
 */
import student.TestCase;

/**
 * This is the test for our main class rectangle1 class
 * This class will store collection of rectangles and
 * use binary search tree to store all the rectangles
 * including the features inside the rectangles.
 * In this test class, we will examine many features.
 * 
 * @author Chenkai Ren
 * @author Hung Tran
 * @version 1
 */
public class Rectangle1Test extends TestCase {
    private Rectangle1 rectangle1;
    private BinarySearchTree<Rectangle, String> bst;
    private Rectangle a;
    private Rectangle a2;
    private Rectangle b;
    private Rectangle b2;
    private Rectangle d;
    private Rectangle e;
    private Rectangle g;
    private Rectangle f;
    private Rectangle p;
    private Rectangle l;


    /**
     * Set-up for test cases.
     * creating 12 rectangles with same names
     * and different coordinates.
     */
    public void setUp() {
        rectangle1 = new Rectangle1();
        bst = new BinarySearchTree<Rectangle, String>();
        a = new Rectangle("a", 1, 1, 1, 3);
        a2 = new Rectangle("a2", 10, 1, 4, 1);
        b = new Rectangle("b", 2, 6, 3, 1);
        b2 = new Rectangle("b2", 4, 7, 1, 3);
        d = new Rectangle("d", 7, 1, 1, 3);
        e = new Rectangle("e", 6, 2, 3, 1);
        g = new Rectangle("g", 8, 7, 4, 1);
        f = new Rectangle("f", 8, 6, 4, 1);
        p = new Rectangle("p", 6, 3, 3, 1);
        l = new Rectangle("l", 0, 1, 4, 4);
    }


    /**
     * test error
     * 
     * @throws Exception
     *             error output
     */
    public void testInsertError() throws Exception {
        // false String---------------------------------
        String[] args2 = new String[3];
        args2[0] = "thrownException";

        Exception z = null;
        try {
            rectangle1.insertErr(args2);

        }
        catch (Exception exception) {
            z = exception;
        }
        assertTrue(z instanceof IllegalArgumentException);

        // false String with coordinate incorrect--------
        String[] args3 = new String[6];
        args3[0] = "insert";
        args3[1] = "A";
        args3[2] = "A";
        args3[3] = "1";
        args3[4] = "1";
        args3[5] = "3";
        Exception e2 = null;
        try {
            rectangle1.insertErr(args3);

        }
        catch (Exception exception) {
            e2 = exception;
        }
        assertTrue(e2 instanceof IllegalArgumentException);

        // true string-------------------------------------
        String[] args = new String[6];
        args[0] = "insert";
        args[1] = "A";
        args[2] = "1";
        args[3] = "1";
        args[4] = "1";
        args[5] = "3";
        assertFalse(rectangle1.insertErr(args));

        // true string but out of bound-----------------------

        String[] args4 = new String[6];
        args4[0] = "insert";
        args4[1] = "A";
        args4[2] = "-1";
        args4[3] = "1";
        args4[4] = "-3";
        args4[5] = "3";
        assertTrue(rectangle1.insertErr(args4));

        String[] args5 = new String[6];
        args5[0] = "insert";
        args5[1] = "*";
        args5[2] = "1";
        args5[3] = "2";
        args5[4] = "3";
        args5[5] = "4";
        assertTrue(rectangle1.insertErr(args5));
    }


    /**
     * test remove
     */
    public void testRemoveErr() {
        // false String---------------------------------
        String[] args2 = new String[1];
        args2[0] = "thrownException";

        Exception z = null;
        try {
            rectangle1.removeErr(args2);

        }
        catch (Exception exception) {
            z = exception;
        }
        assertTrue(z instanceof IllegalArgumentException);

        args2 = new String[2];
        args2[0] = "remove";
        args2[1] = "A";
        Exception e3 = null;
        try {
            rectangle1.removeErr(args2);

        }
        catch (Exception exception) {
            e3 = exception;
        }
        assertFalse(e3 instanceof IllegalArgumentException);
        assertFalse(rectangle1.removeErr(args2));

        args2 = new String[5];
        args2[0] = "remove";
        args2[1] = "B";
        args2[2] = "B";
        args2[3] = "B";
        args2[4] = "B";
        Exception e4 = null;
        try {
            rectangle1.removeErr(args2);

        }
        catch (Exception exception) {
            e4 = exception;
        }
        assertTrue(e4 instanceof IllegalArgumentException);

        // false String with coordinate incorrect--------
        String[] args3 = new String[5];
        args3[0] = "remove";
        args3[1] = "1";
        args3[2] = "2";
        args3[3] = "3";
        args3[4] = "4";

        Exception e2 = null;
        try {
            rectangle1.removeErr(args3);
        }
        catch (Exception exception) {
            e2 = exception;
        }
        assertFalse(e2 instanceof IllegalArgumentException);
        assertFalse(rectangle1.removeErr(args3));
        args3[1] = "-4";
        assertTrue(rectangle1.removeErr(args3));
    }


    /**
     * test regional search
     */
    public void testRegionalSearch() {
        // when string length is not equal 5
        String[] args1 = new String[1];
        assertTrue(rectangle1.regionalSearchErr(args1));
        // when string length is 5
        // case 1: is number return false
        // case 2: is not a number throw exception

        // case2:
        args1 = new String[5];
        args1[0] = "regionalsearch";
        args1[1] = "B";
        args1[2] = "A";
        args1[3] = "A";
        args1[4] = "A";
        Exception z = null;
        try {
            rectangle1.regionalSearchErr(args1);

        }
        catch (Exception exception) {
            z = exception;
        }
        assertTrue(z instanceof IllegalArgumentException);

        // case1:
        args1[1] = "1";
        args1[2] = "3";
        args1[3] = "5";
        args1[4] = "7";
        assertFalse(rectangle1.regionalSearchErr(args1));

    }


    /**
     * Test intersection error
     */
    public void testIntersecErr() {
        String[] args1 = new String[2];
        assertTrue(rectangle1.intersecErr(args1));
        args1 = new String[1];
        assertFalse(rectangle1.intersecErr(args1));
    }


    /**
     * test search error
     */
    public void testSearchErr() {
        String[] args1 = new String[3];
        assertTrue(rectangle1.searchErr(args1));
        args1 = new String[2];
        assertFalse(rectangle1.searchErr(args1));
    }


    /**
     * test dump error
     */
    public void testDumpErr() {
        String[] args1 = new String[2];
        assertTrue(rectangle1.dumpErr(args1));
        args1 = new String[1];
        assertFalse(rectangle1.dumpErr(args1));
    }


    /**
     * test rectangle out bound
     */
    public void testRecOutBound() {
        String x = "-1";
        String y = "4";
        String w = "4";
        String h = "4";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "4";
        y = "-1";
        w = "4";
        h = "4";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "4";
        y = "4";
        w = "-1";
        h = "4";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "4";
        y = "4";
        w = "4";
        h = "-1";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "-1";
        y = "-1";
        w = "4";
        h = "-1";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "4";
        y = "4";
        w = "-1";
        h = "-1";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "1024";
        y = "4";
        w = "4";
        h = "4";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        x = "4";
        y = "1024";
        w = "4";
        h = "4";
        assertTrue(rectangle1.recOutBound(x, y, w, h));
        // return false
        x = "4";
        y = "4";
        w = "4";
        h = "4";
        assertFalse(rectangle1.recOutBound(x, y, w, h));
    }


    /**
     * test to see input is number
     */
    public void testIsNumber() {
        assertTrue(rectangle1.isNumber("4"));
        assertFalse(rectangle1.isNumber("B"));

    }


    /**
     * test matching property
     */
    public void testProperityMatches() {
        Rectangle correct = new Rectangle("A", 4, 4, 4, 4);
        assertTrue(rectangle1.properityMatches(correct, 4, 4, 4, 4));
        Rectangle incorrect = new Rectangle("A", 3, 4, 4, 4);
        assertFalse(rectangle1.properityMatches(incorrect, 4, 4, 4, 4));
        incorrect = new Rectangle("A", 4, 3, 4, 4);
        assertFalse(rectangle1.properityMatches(incorrect, 4, 4, 4, 4));
        incorrect = new Rectangle("A", 4, 4, 3, 4);
        assertFalse(rectangle1.properityMatches(incorrect, 4, 4, 4, 4));
        incorrect = new Rectangle("A", 4, 4, 4, 3);
        assertFalse(rectangle1.properityMatches(incorrect, 4, 4, 4, 4));
    }


    /**
     * Testing intersection
     */
    public void testIsIntersect() {
        // same coordinates and width & height
        Rectangle rec1 = new Rectangle("A", 7, 1, 1, 4);
        Rectangle rec2 = new Rectangle("B", 7, 1, 1, 4);
        assertTrue(rectangle1.isIntersect(rec1, rec2));

        // same coordinates but not the same width and height
        rec1 = new Rectangle("A", 7, 1, 1, 4);
        rec2 = new Rectangle("B", 7, 1, 1, 5);
        assertTrue(rectangle1.isIntersect(rec1, rec2));
        rec1 = new Rectangle("A", 7, 1, 5, 4);
        rec2 = new Rectangle("B", 7, 1, 1, 4);
        assertTrue(rectangle1.isIntersect(rec1, rec2));

        // checking if it intersects
        rec1 = new Rectangle("A", 7, 1, 1, 3);
        rec2 = new Rectangle("B", 6, 2, 3, 1);
        assertTrue(rectangle1.isIntersect(rec2, rec1));

        rec1 = new Rectangle("A", 2, 6, 3, 1);
        rec2 = new Rectangle("B", 4, 7, 1, 3);
        assertFalse(rectangle1.isIntersect(rec1, rec2));
        assertFalse(rectangle1.isIntersect(rec2, rec1));

        rec1 = new Rectangle("A", 2, 6, 3, 1);
        rec2 = new Rectangle("B", 6, 2, 3, 1);
        assertFalse(rectangle1.isInRegion(rec1, rec2));
        assertFalse(rectangle1.isInRegion(rec2, rec1));

        // should be false
        rec1 = new Rectangle("A", 6, 3, 3, 1);
        rec2 = new Rectangle("B", 6, 2, 3, 1);
        assertFalse(rectangle1.isIntersect(rec1, rec2));
        assertFalse(rectangle1.isIntersect(rec2, rec1));

        rec1 = new Rectangle("A", 8, 6, 4, 1);
        rec2 = new Rectangle("B", 8, 7, 4, 1);
        assertFalse(rectangle1.isIntersect(rec1, rec2));
        assertFalse(rectangle1.isIntersect(rec2, rec1));

        String[] args4 = new String[6];
        args4[0] = "insert";
        args4[1] = "A";
        args4[2] = "2";
        args4[3] = "1";
        args4[4] = "4";
        args4[5] = "3";
        rectangle1.insertCommand(bst, args4);
        assertTrue(bst.search(new Rectangle("A", 2, 1, 4, 3)));

    }


    /**
     * test remove command
     */
    public void testRemove() {
        // insert an item
        String[] args = new String[6];
        args[0] = "insert";
        args[1] = "A";
        args[2] = "2";
        args[3] = "1";
        args[4] = "4";
        args[5] = "3";
        rectangle1.insertCommand(bst, args);
        assertTrue(bst.search(new Rectangle("A", 2, 1, 4, 3)));

        // remove items by name
        String[] args1 = new String[2];
        args1[0] = "remove";
        args1[1] = "A";
        rectangle1.removeCommand(bst, args1);
        assertFalse(bst.search(new Rectangle("A", 2, 1, 4, 3)));

        // remove non exist items by name
        String[] args4 = new String[2];
        args4[0] = "remove";
        args4[1] = "B";
        rectangle1.removeCommand(bst, args4);
        assertFalse(bst.search(new Rectangle("B", 2, 1, 4, 3)));

        // insert an item
        rectangle1.insertCommand(bst, args);
        assertTrue(bst.search(new Rectangle("A", 2, 1, 4, 3)));

        // remove item by coordinates
        String[] args2 = new String[5];
        args2[0] = "remove";
        args2[1] = "2";
        args2[2] = "1";
        args2[3] = "4";
        args2[4] = "3";
        rectangle1.removeCommand(bst, args2);
        assertTrue(bst.isTreeEmpty());

        // remove a non existing item
        String[] args3 = new String[5];
        args3[0] = "remove";
        args3[1] = "2";
        args3[2] = "1";
        args3[3] = "4";
        args3[4] = "5";
        rectangle1.removeCommand(bst, args2);
        assertTrue(bst.isTreeEmpty());
    }


    /**
     * test intersection command
     */
    public void testIntersection() {
        // insert items to bst
        bst.insert(a);
        bst.insert(a2);
        bst.insert(b);
        bst.insert(b2);
        bst.insert(d);
        bst.insert(e);
        bst.insert(g);
        bst.insert(f);
        bst.insert(p);
        bst.insert(l);

        // test intersections
        String[] args = new String[1];
        args[0] = "intersections";
        rectangle1.intersectionCommand(bst, args);
        assertFalse(bst.isTreeEmpty());
    }


    /**
     * test regional Search
     */
    public void testregionSearch() {
        // insert items to bst
        bst.insert(a);
        bst.insert(a2);
        bst.insert(b);
        bst.insert(b2);
        bst.insert(d);
        bst.insert(e);
        bst.insert(g);
        bst.insert(f);
        bst.insert(p);
        bst.insert(l);

        // test region search
        String[] args = new String[5];
        args[0] = "regionsearch";
        args[1] = "1";
        args[2] = "1";
        args[3] = "1000";
        args[4] = "1000";
        rectangle1.regionSearchCommand(bst, args);
        assertFalse(bst.isTreeEmpty());
    }


    /**
     * test name Search
     */
    public void testNameSearch() {
        bst.insert(a);
        bst.insert(a);
        bst.insert(b);
        bst.insert(b2);

        String[] args = new String[2];
        args[0] = "search";
        args[1] = "a";
        rectangle1.nameSearchCommand(bst, args);

        String[] args1 = new String[2];
        args1[0] = "search";
        args1[1] = "ab";
        rectangle1.nameSearchCommand(bst, args1);
        assertFalse(bst.isTreeEmpty());
    }


    /**
     * test false main
     */
    public void testFalseMain() {
        String[] args = new String[2];
        args[0] = "false";
        Exception z = null;
        try {
            rectangle1.main(args);
        }
        catch (Exception exception) {
            z = exception;
        }
        assertFalse(z instanceof IllegalArgumentException);
    }

}
