package pl.put.poznan.buildings.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class Buildings {

    private final String[] transforms;

    public Buildings(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        // of course normally it would to something based on transforms
        return text.toUpperCase();
    }
}
