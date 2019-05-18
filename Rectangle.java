/**
 * Rectangle class
 * 
 * @author Hung Tran
 * @author Chenkai Ren
 * @version 1.0
 */
public class Rectangle implements Comparable<Rectangle> {
    private String name;
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;


    /**
     * Default constructor
     */
    public Rectangle() {
        this.name = "";
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.width = 0;
        this.height = 0;
    }


    /**
     * Parameterize constructor
     * width and height have to be bigger than 0
     * 
     * @param name
     *            rectangle name
     * @param x
     *            coordinate x
     * @param y
     *            coordinate y
     * @param w
     *            width
     * @param h
     *            height
     */
    public Rectangle(String name, int x, int y, int w, int h) {
        this.name = name;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.width = w;
        this.height = h;
    }


    /**
     * Parameterize constructor that take in a name
     * 
     * @param name
     *            rectangle name
     */
    public Rectangle(String name) {
        this.name = name;
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.width = 0;
        this.height = 0;
    }


    /**
     * Copy constructor
     * 
     * @param rec
     *            copy item
     */
    public Rectangle(Rectangle rec) {
        this.name = rec.name;
        this.xCoordinate = rec.xCoordinate;
        this.yCoordinate = rec.yCoordinate;
        this.width = rec.width;
        this.height = rec.height;
    }


    /********** GETTER *****************/
    /**
     * get name of rectangle
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * get x coordinate
     * 
     * @return x
     */
    public int getX() {
        return xCoordinate;
    }


    /**
     * get y coordinate
     * 
     * @return y
     */
    public int getY() {
        return yCoordinate;
    }


    /**
     * get height
     * 
     * @return rectangle height
     */
    public int getH() {
        return height;
    }


    /**
     * get width
     * 
     * @return rectangle width
     */
    public int getW() {
        return width;
    }


    /**************** SETTER *********************/
    /**
     * set x and y coordinate
     * 
     * @param x
     *            coordinate x
     * @param y
     *            coordinate y
     */
    public void setXY(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }


    /**
     * set width
     * 
     * @param w
     *            width
     * @return true if valid width
     */
    public boolean setW(int w) {
        if (w <= 0) {
            System.out.println("Width has to greater than 0");
            return false;
        }

        this.width = w;
        return true;
    }


    /**
     * set height
     * 
     * @param h
     *            height
     * @return true if valid height
     */
    public boolean setH(int h) {
        if (h <= 0) {
            System.out.println("Width has to be greater than 0");
            return false;
        }

        this.height = h;
        return true;
    }


    /**
     * Basic compare function
     * 
     * @param rhs
     *            rectangle to compare to
     */
    @Override
    public int compareTo(Rectangle rhs) {
        if (rhs == null) {
            throw new IllegalArgumentException("Cant compare to null");
        }

        return this.name.compareTo(rhs.getName());
    }


    /**
     * print out information of the rectangle
     * 
     * @return a string of rectangle information
     */
    public String toString() {
        return ("(" + this.name + ", " + (int)Math.round(this.xCoordinate)
            + ", " + (int)Math.round(this.yCoordinate) + ", " + (int)Math.round(
                this.width) + ", " + (int)Math.round(this.height) + ")");
    }
}
