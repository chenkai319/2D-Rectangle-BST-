import student.TestCase;

/**
 * rectangle test cases
 * 
 * @author Chenkai Ren
 * @author Hung Tran
 * @version 1.0
 */
public class RectangleTest extends TestCase {
    private Rectangle default1;
    private Rectangle a;
    private Rectangle a2;
    private Rectangle b;


    /**
     * Se-up for test cases.
     * creating 12 rectangles.
     */
    public void setUp() {
        default1 = new Rectangle();
        a = new Rectangle("a", 1, 1, 1, 3);
        a2 = new Rectangle("a", 10, 1, 4, 1);
        b = new Rectangle("b", 2, 6, 3, 1);
    }


    /**
     * test rectangle constructors
     */
    public void testRectConstructor() {
        Rectangle false2 = new Rectangle("false", 0, 0, 0, 0);
        assertEquals("false", false2.getName());
        Rectangle stringName = new Rectangle("name");
        assertEquals("name", stringName.getName());
    }


    /**
     * test copy constructor
     */
    public void testCopyConstructor() {
        Rectangle aa = new Rectangle("check");
        Rectangle bb = new Rectangle(aa);
        assertEquals("check", bb.getName());
    }


    /**
     * test rectangle's name
     */
    public void testGetName() {
        assertEquals("a", a.getName());
        assertEquals("", default1.getName());
    }


    /**
     * test the x coordinate and y coordinates
     */
    public void testGetXAndGetY() {
        assertEquals(1, a.getX());
        assertEquals(1, a.getY());
        assertEquals(1, a.getW());
        assertEquals(3, a.getH());
    }


    /**
     * test setXY method where x coordinate and y coordinate
     * will change after method is called.
     */
    public void testSetXYWH() {
        a.setXY(4, 3);
        assertTrue(a.setW(33));
        assertTrue(a.setH(33));
        assertFalse(a.setW(0));
        assertFalse(a.setH(0));
        assertEquals(4, a.getX());
        assertEquals(3, a.getY());
        a.setXY(1, 1);
        a.setW(1);
        a.setH(3);
    }


    /**
     * test comparing 2 objects
     */
    public void testRectCompare() {
        Exception z = null;
        try {
            a.compareTo(null);
        }
        catch (Exception exception) {
            z = exception;
        }
        assertTrue(z instanceof IllegalArgumentException);
        assertEquals(0, a.compareTo(a2));
        assertEquals(-1, a.compareTo(b));
    }
}
