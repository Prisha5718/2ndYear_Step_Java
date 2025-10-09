class Artwork {
    protected String title;
    protected String artist;

    public Artwork(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void displayInfo() {
        System.out.println("Artwork: " + title + " by " + artist);
    }
}

class Painting extends Artwork {
    private String brushTechnique;
    private String colorPalette;
    private String frameSpecs;

    public Painting(String title, String artist, String brushTechnique, String colorPalette, String frameSpecs) {
        super(title, artist);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frameSpecs = frameSpecs;
    }

    public void displayDetails() {
        System.out.println("Painting: " + title + ", Brush: " + brushTechnique + ", Colors: " + colorPalette + ", Frame: " + frameSpecs);
    }
}

class Sculpture extends Artwork {
    private String material;
    private String dimensions;
    private String lighting;

    public Sculpture(String title, String artist, String material, String dimensions, String lighting) {
        super(title, artist);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    public void displayDetails() {
        System.out.println("Sculpture: " + title + ", Material: " + material + ", Dimensions: " + dimensions + ", Lighting: " + lighting);
    }
}

class DigitalArt extends Artwork {
    private String resolution;
    private String fileFormat;
    private String interactiveElements;

    public DigitalArt(String title, String artist, String resolution, String fileFormat, String interactiveElements) {
        super(title, artist);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactiveElements = interactiveElements;
    }

    public void displayDetails() {
        System.out.println("Digital Art: " + title + ", Resolution: " + resolution + ", Format: " + fileFormat + ", Interactive: " + interactiveElements);
    }
}

class Photography extends Artwork {
    private String cameraSettings;
    private String editing;
    private String printSpecs;

    public Photography(String title, String artist, String cameraSettings, String editing, String printSpecs) {
        super(title, artist);
        this.cameraSettings = cameraSettings;
        this.editing = editing;
        this.printSpecs = printSpecs;
    }

    public void displayDetails() {
        System.out.println("Photography: " + title + ", Camera: " + cameraSettings + ", Editing: " + editing + ", Print: " + printSpecs);
    }
}

public class GalleryDemo {
    public static void main(String[] args) {
        Artwork[] gallery = {
            new Painting("Sunset", "Alice", "Oil", "Warm Tones", "Wooden Frame"),
            new Sculpture("The Thinker", "Bob", "Bronze", "2m x 1m", "Spotlight"),
            new DigitalArt("Virtual Dream", "Charlie", "4K", "MP4", "Interactive"),
            new Photography("Nature Shot", "Diana", "f/1.8, 1/200s", "Photoshop Edited", "A3 Print")
        };

        for (Artwork a : gallery) {
            a.displayInfo();

            if (a instanceof Painting p) {
                p.displayDetails();
            } else if (a instanceof Sculpture s) {
                s.displayDetails();
            } else if (a instanceof DigitalArt d) {
                d.displayDetails();
            } else if (a instanceof Photography ph) {
                ph.displayDetails();
            }

            System.out.println();
        }
    }
}
