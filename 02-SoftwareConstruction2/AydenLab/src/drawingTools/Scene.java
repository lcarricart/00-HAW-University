package drawingTools;
import java.util.ArrayList; // Importing the ArrayList class from the java.util package
import java.awt.Color; //Importing the Color class from the AWT package
import java.util.ListIterator;

import decorators.BowTieDecorator;
import decorators.CornHatDecorator;
import decorators.EyeColorDecorator;
import decorators.FaceColorDecorator;
import kangaroo.BoxingKangaroo;
import kangaroo.Kangaroo;

public class Scene {

    private ArrayList<LocatedRectangle> kangaroos = null;   // aggregate, The reason why we use ArrayList<Kangaroo> is because we want to store multiple Kangaroo objects in the Scene class.
//    private ArrayList<LocatedRectangle> locatedRectangles = null;
    private Color color = Color.WHITE;              // Default color for the background, initialized to black
    private boolean kangaroosHaveGloves = false;    // State for Kangaroos with gloves
    private int kangarooSize = 100; // Default size for kangaroos

    public Scene() {
        generateKangaroos();
    }

    public void generateKangaroos() {
        kangaroos = new ArrayList<>();
//        locatedRectangles = new ArrayList<>();
        for (int i = 0; i < 500; i++) { // Check if the kangaroo is not null before adding it to the list
            int width = RandomNumber.between(90,100);
            int height = RandomNumber.between(130,140);
            int x = RandomNumber.between(0, 1200 - width);
            int y = RandomNumber.between(0, 800 - height);
            Kangaroo newKangaroo = new Kangaroo(width, height, x, y);
            if (kangaroosHaveGloves) {
                newKangaroo = new BoxingKangaroo(width, height, x, y);
            } else {
                newKangaroo = new Kangaroo(width, height, x, y);
            }
            addNewKangaroo(newKangaroo);
        }
    }

    public void addNewKangaroo(Kangaroo newKangaroo) {
        boolean intersection = false;

        for (LocatedRectangle kangaroo : kangaroos) {
            intersection = intersection || kangaroo.intersects(newKangaroo);
        }
        if (!intersection) {
            kangaroos.add(newKangaroo);
//            locatedRectangles.add(newKangaroo);
        }
    }
    
    public int addNewKangarooInt(Kangaroo newKangaroo) {
        boolean intersection = false;

        for (LocatedRectangle kangaroo : kangaroos) {
            intersection = intersection || kangaroo.intersects(newKangaroo);
        }
        if (!intersection) {
            kangaroos.add(newKangaroo);
//            locatedRectangles.add(newKangaroo);
            return 1;
        }
        return 0;
    }

    public void draw() {
        //generateKangaroos();
        for (LocatedRectangle kangaroo : kangaroos) {
            kangaroo.draw();
            if (kangaroosHaveGloves && kangaroo instanceof BoxingKangaroo) {
                ((BoxingKangaroo) kangaroo).drawGloves();
            }
        }
    }

//    public void drawAt(int numOfKangaroos) {
//        for (Kangaroo kangaroo : kangaroos) {       //for (Kangaroo kangaroo : kangaroos) means: for each Kangaroo in the kangaroos list, assign it to the variable kangaroo and execute the loop body.
//            kangaroo.drawAt(kangaroo.width(), kangaroo.height());       //kangaroo.drawAt(kangaroo.width(), kangaroo.height()); calls the drawAt method for the current kangaroo, passing its width and height.
//            if (kangaroo.equals(kangaroos.get(numOfKangaroos))) {   //if the current kangaroo is equal to the one at index numOfKangaroos in the list. If so, the loop stops (break).
//                break;
//            }
//        }
//    }

    public void drawAt(int numOfKangaroos) {
        for (LocatedRectangle rect : kangaroos) {
            if (rect instanceof Kangaroo) {
                ((Kangaroo) rect).drawAt(rect.width(), rect.height());
            } else {
                rect.draw(); // fallback if not a Kangaroo
            }
            if (rect.equals(kangaroos.get(numOfKangaroos))) {
                break;
            }
        }
    }

    public void setColor(Color color) {
        this.color = color; // Adds the specified color to the list of colors for the background
    }

    public Color getColor() {
        return color; // Returns the list of colors for the background
    }

    public void setKangaroosHaveGloves(boolean hasGloves) {
        for (LocatedRectangle kangaroo : kangaroos) {
            this.kangaroosHaveGloves = hasGloves; // Sets the kangaroosHaveGloves variable to true or false based on the input parameter
            generateKangaroos(); // Regenerate kangaroos with/without gloves

        }
    }
    public boolean getKangaroosHaveGloves() {
        return kangaroosHaveGloves;
    }

    public void setKangarooSize(int size) {
        this.kangarooSize = size;
    }

    public int getKangarooSize() {
        return kangarooSize;
    }

    public void adjustKangarooSizes(int newSize) {
        this.kangarooSize = newSize;
        for (LocatedRectangle rect : kangaroos) {
            if (rect instanceof Kangaroo) {
                ((Kangaroo) rect).setWidth(newSize);
                ((Kangaroo) rect).setHeight(newSize);
            }
//            kangaroo.setWidth(newSize);
//            kangaroo.setHeight(newSize);
        }
    }
    // Lab4 task : Change the eye color
    //Scene → Kangaroo → KangarooHead → Face and Eye class stores the data for the eye color.
//    public void setEyecolor(Color color) {
//        for (LocatedRectangle kangaroo : kangaroos) {
//            int colorR = RandomNumber.between(0, 255);
//            int colorG = RandomNumber.between(0, 255);
//            int colorB = RandomNumber.between(0, 255);
//            kangaroo.setEyeColor(new Color(colorR, colorG, colorB)); // Sets the eye color of each kangaroo to a random color
////          //kangaroo.setColor(Color.BLACK)
//        }
//    }
    public void setEyecolor(Color color) {
        for (LocatedRectangle kangaroo : kangaroos) {
            if (kangaroo instanceof Kangaroo) {
                int colorR = RandomNumber.between(0, 255);
                int colorG = RandomNumber.between(0, 255);
                int colorB = RandomNumber.between(0, 255);
                ((Kangaroo) kangaroo).setEyeColor(new Color(colorR, colorG, colorB));
            }
        }
    }

    // decorator methods (decorateKangaroosWithRandomEyeColor, decorateKangaroosWithRandomfaceColor, decorationPatternAddCOrnHatButton, and decorateionPatternAddBowtieButton) wrap each Kangaroo in a decorator object.
    // Lab4 task : Change the eye color using decorator pattern
    public void decorateKangaroosWithRandomEyeColor() {
        ListIterator<LocatedRectangle> iterator = kangaroos.listIterator();
        while (iterator.hasNext()) {
            LocatedRectangle kangaroo = iterator.next();
            int colorR = RandomNumber.between(0, 255);
            int colorG = RandomNumber.between(0, 255);
            int colorB = RandomNumber.between(0, 255);
            LocatedRectangle decorated = new EyeColorDecorator(kangaroo, new Color(colorR, colorG, colorB));
            iterator.set(decorated);
        }
    }

    // Lab4 task : Change the face color using decorator pattern
    public void decorateKangaroosWithRandomfaceColor() {
        ListIterator<LocatedRectangle> iterator = kangaroos.listIterator();
        while (iterator.hasNext()) {
            LocatedRectangle kangaroo = iterator.next();
            int colorR = RandomNumber.between(0, 255);
            int colorG = RandomNumber.between(0, 255);
            int colorB = RandomNumber.between(0, 255);
            LocatedRectangle decorated = new FaceColorDecorator(kangaroo, new Color(colorR, colorG, colorB));
            iterator.set(decorated);
        }
    }

    // Lab4 task : Add a corn hat to each kangaroo using decorator pattern
    public void decorationPatternAddCOrnHatButton() {
        ListIterator<LocatedRectangle> iterator = kangaroos.listIterator();
        while (iterator.hasNext()) {
            LocatedRectangle kangaroo = iterator.next();
            LocatedRectangle decorated = new CornHatDecorator(kangaroo);
            iterator.set(decorated);
        }
    }

    // Lab4 task : Add a bowtie to each kangaroo using decorator pattern
    public void decorateionPatternAddBowtieButton() {
        ListIterator<LocatedRectangle> iterator = kangaroos.listIterator();
        while (iterator.hasNext()) {
            LocatedRectangle kangaroo = iterator.next();
            LocatedRectangle decorated = new BowTieDecorator(kangaroo);
            iterator.set(decorated);
//            if (kangaroo instanceof Kangaroo) {
//                LocatedRectangle decorated = new BowTieDecorator((Kangaroo) locatedRectangle);
//                iterator.set(decorated);

        }
    }

    public void setNumberOfKangaroos (int count) {
        int successfulKangaroosCounter = 0;
    	kangaroos = new ArrayList<>();
        
        while (successfulKangaroosCounter < count) {
            int width = RandomNumber.between(90, 100);
            int height = RandomNumber.between(130, 140);
            int x = RandomNumber.between(0, 1200 - width);
            int y = RandomNumber.between(0, 800 - height);
            Kangaroo newKangaroo = kangaroosHaveGloves
            //'?' : If kangaroosHaveGloves is true, it creates a BoxingKangaroo.
            //':' : If kangaroosHaveGloves is false, it creates a regular Kangaroo.
                ? new BoxingKangaroo(width, height, x, y)       //condition ? valueIfTrue : valueIfFalse, if-else statement
                : new Kangaroo(width, height, x, y);
            successfulKangaroosCounter += addNewKangarooInt(newKangaroo);
        }
    }

//    self-directed study for java syntax :
//    Kangaroo newKangaroo = kangaroosHaveGloves
//            //If kangaroosHaveGloves is true, it creates a BoxingKangaroo.
//            //If kangaroosHaveGloves is false, it creates a regular Kangaroo.
//            ? new BoxingKangaroo(width, height, x, y)       //condition ? valueIfTrue : valueIfFalse, if-else statement
//            : new Kangaroo(width, height, x, y);

//    instead of using the above syntax, we can use the following code to create a new Kangaroo object based on the kangaroosHaveGloves condition:
//    Kangaroo newKangaroo;
//        if (kangaroosHaveGloves) {
//        newKangaroo = new BoxingKangaroo(width, height, x, y);
//    } else {
//        newKangaroo = new Kangaroo(width, height, x, y);
//    }
}
