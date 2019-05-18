# 2D-Rectangle-BST-
Background: Any applications areas such as computer graphics, geographic information systems, and VLSI design require the ability to store and query a collection of rectangles. In 2D, typical queries include the ability to find all rectangles that cover a query point or query rectangle and to report all intersections from among the set of rectangles. Adding and removing rectangles from the collection are also fundamental operations.  

Purpose: For this project, you will create a simple spatial database for handling inserting, deleting, and performing queries on a collection of rectangles. The data structure used to store the collection will be the Binary Search Tree

The name of the program is Rectangle1 (this is the name where Web-CAT expects the main class
to be). There is a single command line parameter that specifies the name of the command file. So,
the program would be invoked from the command-line as:

                  java Rectangle1 {command-file}
                  
My program will read a series of commands from the command file, with one command per line.
No command line will require more than 80 characters. Each command requires certain outputs,
whose details will be described by sample test file outputs that we will post. The formats for the
commands are as follows. The commands are free-format in that any number of spaces may come
before, between, or after the command name and its parameters. All coordinates will be signed
values small enough to fit in a 32-bit int variable.

-----------------------Methods--------------
insert name x y w h
remove name
remove x y w h
regionsearch x y w h
intersections
search name
dump

-----------------------Descriptions-----------------
insert name x y w h

Insert a rectangle named name with upper left corner (x, y), width w and height h. It is
permissible for two or more rectangles to have the same name, and it is permissible for two or
more rectangles to have the same spatial dimensions and position. The name must begin with a
letter, and may contain letters, digits, and underscore characters. Names are case sensitive. A
rectangle should be rejected for insertion if its height or width are not greater than 0. All
rectangles must fit within the “world box" that is 1024 by 1024 units in size and has upper left
corner at (0, 0). If a rectangle is all or partly out of this box, it should be rejected for insertion.

remove name

Remove the rectangle with name name. If two or more rectangles have the same name, then any
one such rectangle may be removed. If no rectangle exists with this name, it should be so reported.

remove x y w h

Remove the rectangle with the specified dimensions. If two or more rectangles have the same
dimensions, then any one such rectangle may be removed. If no rectangle exists with these
dimensions, it should be so reported.

regionsearch x y w h

Report all rectangles currently in the database that intersect the query rectangle specified by the 
regionsearch parameters. For each such rectangle, list out its name and coordinates. A
regionsearch command should be rejected if the height or width is not greater than 0. However, it
is (syntactically) acceptable for the regionsearch rectangle to be all or partly outside of the 1024
by 1024 world box.

intersections

Report all pairs of rectangles within the database that intersect.

search name

Return the information about the rectangle(s), if any, that have name name. If there are more than
one rectangle with the same name, you should return the info for all of them. 
