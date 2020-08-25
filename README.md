# AnimGameJava
This project includes experimentation for and a general outline of a basic, interactive game.

# AnimGameJava2
As a beginner to Java, the goal of this project was to familiarize myself with GUI by creating an interactive, animated user experience. Ultimately, the objective was to create a virtual “museum,” where users could control a cursor to interact with different paintings.
This code was written using Visual Studio Code with Java 11.0.5.

# Steps
The process of developing this program was broken down into four steps:
1. Animation
2. Blueprint
3. Interaction
4. Aesthetics

## Step 1: Animation
**Creating a JFrame with user-controlled animation**

* Generating a cursor that can be controlled with arrow keys using the *paintComponent*, *keyPressed*, and *keyReleased* methods
* Experimenting with *actionPerformed* and *keyPressed* (eg. interval time, velocity and distance, etc.)

## Step 2: Blueprint
**Designing a blueprint for the game using a sketch layer, grid, and background**

* Created a class *JPanelGrid* (visibility set to false in final product) to keep track of object sizes and cursor movement
* Wrote a class *JPanelSketch* to outline the “museum,” including the general area covered, as well as the locations of labels and pictures
* Wrote a class *JPanelWithBackground* that takes a filename as input, and creates a layer with that image as the designated background
* JLabels were made in the main method, as they are feature of the javax.swing plugin and did not have to be introduced as objects of a new class

![Image 1] (ReadMe_img1.png)

## Step 3: Interaction
**Programming areas and objects to respond to cursor detection**
* Created a new class, *LabelArea*, to detect whether the cursor would fall into the area covered by that object
  * Objects of *LabelArea* were stored in array, taking each corresponding label’s coordinates as input for the constructor class
  * When called to detect cursor, the method *inArea* took the coordinates (x, y) of the cursor as input
* Created a class, *JPanelPictures*, to generate images that could be stored in objects of the class by providing the image filename as input

## Step 4: Aesthetics
**Finalizing the overall look and experience of the project**
* Using the drawing application Procreate on a 9.7-inch iPad, drew the “museum” setting. This image replaced the background image used in earlier steps
* Still using Procreate on the iPad, a 40x40-pixel PNG image was drawn to replace the earlier cursor
* Another *JLabel*, alongside one more object of *JPanelPictures*, was added to display a “map” when touched with the cursor.
* Created a class, *JPanelScreen*, to darken the screen temporarily whenever a picture was displayed, in order to make the image stand out

![Image 2.1] (https://octodex.github.com/images/yaktocat.png)
![Image 2.2] (https://octodex.github.com/images/yaktocat.png)

# What I Learned
* I learned a lot about coding with javax.swing, and creating visual and user-controlled features in a JFrame.
* Hard-coded numbers should be avoided if possible.
  * At some points, hard-coded numbers were necessary in order to specify desired coordinates. In these cases, I made an effort to keep these hard-coded numbers towards the beginning of the class or main method (so that they could be easily found and understood).
  * If possible, and if the same number was used multiple times, it was stored in a variable so that it could be easily accessed and changed, if necessary.
* If there are multiple objects of a single class that will be used in a similar manner, they can be stored in an object array. This allowed me to optimize and shorten the code. For example, instead of setting each object of *JPanelPicture* to be invisible by default, I could create a loop that set each object to be invisible for the length of the *pictures* array.
* Variable types and initialization depends on where it is used. For example, variables that are used in the main must be static, and variables whose values do not change can be final. Some variables must be initialized at the beginning of a class, or they will not be accessible to all methods.
