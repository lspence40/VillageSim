package net.villageSim;

import java.util.List;

public class World {

    //public List<Village> villages;
    public Village theShire;
    private static World instance = null;

    private World() {}

    public synchronized static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

}
