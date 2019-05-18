import java.io.*;

/**
 * Main file
 * 
 * @author Hung Tran
 * @author Chenkai Ren
 * @version 1.0
 */
public class Rectangle1 {
    /**
     * main function
     * 
     * @param args
     *            user parameter
     * @throws Exception
     *             any parsing error
     */
    public static void main(String[] args) throws Exception {
        BufferedReader inputFile = new BufferedReader(new FileReader(args[0]));
        try {
            String text = inputFile.readLine();
            String[] words;

            BinarySearchTree<Rectangle, String> bst =
                new BinarySearchTree<Rectangle, String>();
            while (text != null) {
                // Take off all the space then store them inside an array
                String s = text.replaceAll("^\\s+", "");
                words = s.split("\\s+");

                // if the command is insert
                if (words[0].compareTo("insert") == 0) {
                    if (!insertErr(words)) {
                        insertCommand(bst, words);
                    }
                }

                // Remove section
                else if (words[0].compareTo("remove") == 0) {
                    if (!removeErr(words)) {
                        removeCommand(bst, words);
                    }
                }

                // Region search
                else if (words[0].compareTo("regionsearch") == 0) {
                    if (!regionalSearchErr(words)) {
                        regionSearchCommand(bst, words);
                    }
                }

                // Intersections
                else if (words[0].compareTo("intersections") == 0) {
                    if (!intersecErr(words)) {
                        intersectionCommand(bst, words);
                    }
                }

                // Name search
                else if (words[0].compareTo("search") == 0) {
                    if (!searchErr(words)) {
                        nameSearchCommand(bst, words);
                    }
                }

                // Dump
                else if (words[0].compareTo("dump") == 0) {
                    if (!dumpErr(words)) {
                        System.out.println("bst dump:");
                        bst.dump();
                    }
                }
                text = inputFile.readLine();
            }
        }
        catch (Error z) {
            System.out.println("Invalid Syntax in command file");
        }

        finally {
            inputFile.close();
        }

    }


    /************* Checking command functions ********************/
    /**
     * Intersection command
     * 
     * @param bst
     *            the binary tree
     * @param words
     *            the input command
     */
    public static void insertCommand(
        BinarySearchTree<Rectangle, String> bst,
        String[] words) {
        bst.insert(new Rectangle(words[1], Integer.valueOf(words[2]), Integer
            .valueOf(words[3]), Integer.valueOf(words[4]), Integer.valueOf(
                words[5])));
        System.out.println("Rectangle accepted: (" + words[1] + ", " + words[2]
            + ", " + words[3] + ", " + words[4] + ", " + words[5] + ")");
    }


    /**
     * remove command
     * 
     * @param bst
     *            the binary tree
     * @param words
     *            the input command
     */
    public static void removeCommand(
        BinarySearchTree<Rectangle, String> bst,
        String[] words) {
        // Remove by name
        if (words.length == 2) {
            Rectangle target = new Rectangle(words[1]);
            if (!bst.remove(target, false)) {
                System.out.println("Rectangle rejected: " + words[1]);
            }
        }
        // Remove by coordinate
        else {
            // get all the coordinates
            int xTarget = Integer.valueOf(words[1]);
            int yTarget = Integer.valueOf(words[2]);
            int wTarget = Integer.valueOf(words[3]);
            int hTarget = Integer.valueOf(words[4]);
            boolean found = false;
            for (Node<Rectangle, String> item : bst) {
                if (properityMatches(item.getData(), xTarget, yTarget, wTarget,
                    hTarget)) {
                    item.activateDelete();
                    found = bst.remove(item.getData(), true);
                    break;
                }
            }
            if (!found) {
                System.out.println("Rectangle rejected: " + "(" + words[1]
                    + ", " + words[2] + ", " + words[3] + ", " + words[4]
                    + ")");
            }
        }
    }


    /**
     * regional search command
     * 
     * @param bst
     *            the binary tree
     * @param words
     *            the input command
     */
    public static void regionSearchCommand(
        BinarySearchTree<Rectangle, String> bst,
        String[] words) {
        System.out.println("Rectangles intersecting region (" + words[1] + ", "
            + words[2] + ", " + words[3] + ", " + words[4] + "):");

        Rectangle targetRec = new Rectangle("Target", Integer.valueOf(words[1]),
            Integer.valueOf(words[2]), Integer.valueOf(words[3]), Integer
                .valueOf(words[4]));

        for (Node<Rectangle, String> eachRecNode : bst) {
            if (isInRegion(targetRec, eachRecNode.getData())) {
                System.out.println(eachRecNode.getData().toString());
            }
        }
    }


    /**
     * intersection command
     * 
     * @param bst
     *            the binary tree
     * @param words
     *            the input command
     */
    public static void intersectionCommand(
        BinarySearchTree<Rectangle, String> bst,
        String[] words) {
        System.out.println("Intersection pairs:");
        int outLoopIndex = 0;
        int inLoopIndex = 0;
        for (Node<Rectangle, String> outLoopNode : bst) {
            for (Node<Rectangle, String> inLoopNode : bst) {
                if (inLoopIndex > outLoopIndex) {
                    if (isIntersect(inLoopNode.getData(), outLoopNode
                        .getData())) {
                        System.out.println(outLoopNode.getData().toString()
                            + ":" + inLoopNode.getData().toString());
                    }
                }
                inLoopIndex++;
            }
            inLoopIndex = 0;
            outLoopIndex++;
        }
    }


    /**
     * name search command
     * 
     * @param bst
     *            the binary tree
     * @param words
     *            the input command
     */
    public static void nameSearchCommand(
        BinarySearchTree<Rectangle, String> bst,
        String[] words) {
        boolean found = false;
        for (Node<Rectangle, String> item : bst) {
            if (item.getData().getName().compareTo(words[1]) == 0) {
                System.out.println("Rectangle found: " + item.getData()
                    .toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Rectangle not found: " + words[1]);
        }
    }


    /************* Checking Error functions ********************/
    /**
     * Error checking for insert
     * 
     * @param words
     *            user input
     * @return true if there is error
     */
    public static boolean insertErr(String[] words) {
        if (words.length != 6) {
            throw new IllegalArgumentException(
                "Uncorrect number of arguments in insert");
        }
        for (int i = 2; i <= 5; i++) {
            if (!isNumber(words[i])) {
                throw new IllegalArgumentException(
                    "at least 1 coordinate is not number");
            }
        }

        if (recOutBound(words[2], words[3], words[4], words[5])) {
            System.out.println("Rectangle rejected: (" + words[1] + ", "
                + words[2] + ", " + words[3] + ", " + words[4] + ", " + words[5]
                + ")");
            return true;
        }

        if (!words[1].matches("[a-zA-Z][a-zA-Z0-9_]*")) {
            System.out.println("Rectangle rejected: (" + words[1] + ", "
                + words[2] + ", " + words[3] + ", " + words[4] + ", " + words[5]
                + ")");
            return true;
        }
        return false;
    }


    /**
     * Error checking for remove
     * 
     * @param words
     *            user input
     * @return true if there is error
     */
    public static boolean removeErr(String[] words) {
        if (!(words.length == 2 || words.length == 5)) {
            throw new IllegalArgumentException(
                "Uncorrect number of arguments in remove");
        }
        if (words.length == 5) {
            for (int i = 1; i <= 4; i++) {
                if (!isNumber(words[i])) {
                    throw new IllegalArgumentException(
                        "at least 1 value is not number");
                }
            }
            if (recOutBound(words[1], words[2], words[3], words[4])) {
                System.out.println("Rectangle rejected: (" + words[1] + ", "
                    + words[2] + ", " + words[3] + ", " + words[4] + ")");
                return true;
            }

            if (Integer.valueOf(words[3]) <= 0 || Integer.valueOf(
                words[4]) <= 0) {
                System.out.println("Rectangle rejected: (" + words[1] + ", "
                    + words[2] + ", " + words[3] + ", " + words[4] + ")");
                return true;
            }
        }
        return false;
    }


    /**
     * check regional search error
     * 
     * @param words
     *            user input
     * @return true if there is an error
     */
    public static boolean regionalSearchErr(String[] words) {
        if (words.length != 5) {
            return true;
        }
        for (int i = 1; i <= 4; i++) {
            if (!isNumber(words[i])) {
                throw new IllegalArgumentException(
                    "at least 1 value is not number");
            }
        }
        if (Integer.valueOf(words[3]) <= 0 || Integer.valueOf(words[4]) <= 0) {
            System.out.println("Rectangle rejected: (" + words[1] + ", "
                + words[2] + ", " + words[3] + ", " + words[4] + ")");
            return true;
        }
        return false;
    }


    /**
     * Check for intersection error
     * 
     * @param line
     *            use input
     * @return true if there is error
     */
    public static boolean intersecErr(String[] line) {
        return (line.length != 1);
    }


    /**
     * check for search error
     * 
     * @param line
     *            use input
     * @return true if there is error
     */
    public static boolean searchErr(String[] line) {
        return (line.length != 2);
    }


    /**
     * check for dump error
     * 
     * @param line
     *            user input
     * @return true if there is error
     */
    public static boolean dumpErr(String[] line) {
        return (line.length != 1);
    }


    /**
     * check if the rectangle is out bound
     * 
     * @param xCoor
     *            coordinate x
     * @param yCoor
     *            coordinate y
     * @param width
     *            the width
     * @param height
     *            the height
     * @return true if there is error
     */
    public static boolean recOutBound(
        String xCoor,
        String yCoor,
        String width,
        String height) {
        int x = Integer.valueOf(xCoor);
        int y = Integer.valueOf(yCoor);
        int w = Integer.valueOf(width);
        int h = Integer.valueOf(height);

        return (x < 0 || y < 0 || w <= 0 || h <= 0 || x + w > 1024 || y
            + h > 1024);
    }


    /************************* Tools ********************/
    /**
     * check to see if all input is number
     * 
     * @param target
     *            user input
     * @return true if everything is number
     */
    public static boolean isNumber(String target) {
        return target.matches("-?\\d+(\\.\\d+)?");
    }


    /**
     * check to see if all the properties are the same
     * 
     * @param item
     *            rectangle
     * @param x
     *            coordinate x
     * @param y
     *            coordinate y
     * @param w
     *            width
     * @param h
     *            height
     * @return true if properties are the same
     */
    public static boolean properityMatches(
        Rectangle item,
        int x,
        int y,
        int w,
        int h) {
        return (item.getX() == x && item.getY() == y && item.getW() == w && item
            .getH() == h);
    }


    /**
     * check to see if the rectangle is in region
     * 
     * @param leftRec
     *            region
     * @param rightRec
     *            rectangle
     * @return true if that rectangle is in region
     */
    public static boolean isInRegion(Rectangle leftRec, Rectangle rightRec) {
        // target rectangle
        int tx = leftRec.getX();
        int tx2 = leftRec.getX() + leftRec.getW();
        int ty = leftRec.getY();
        int ty2 = leftRec.getY() + leftRec.getH();

        // this rectangle added
        int rx = rightRec.getX();
        int rx2 = rightRec.getX() + rightRec.getW();
        int ry = rightRec.getY();
        int ry2 = rightRec.getY() + rightRec.getH();

        while (rx <= rx2) {
            if ((tx < rx) && (rx < tx2)) {
                int tempRy = ry;
                while (tempRy <= ry2) {
                    if ((ty < tempRy) && (tempRy < ty2)) {
                        return true;
                    }
                    tempRy++;
                }

            }
            rx++;
        }
        return false;
    }


    /**
     * check to see if 2 rectangles are intersect
     * 
     * @param a
     *            left rectangle
     * @param b
     *            right rectangle
     * @return true if they are intersect
     */
    public static boolean isIntersect(Rectangle a, Rectangle b) {
        // target rectangle
        int ax1 = a.getX();
        int ax2 = ax1 + a.getW();
        int ay1 = a.getY();
        int ay2 = ay1 + a.getH();

        // this rectangle added
        int bx1 = b.getX();
        int bx2 = bx1 + b.getW();
        int by1 = b.getY();
        int by2 = by1 + b.getH();

        // check up and down
        return (!(by1 >= ay2 || ay1 >= by2 || ax1 >= bx2 || ax2 <= bx1));
    }
}
