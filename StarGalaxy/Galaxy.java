import java.util.ArrayList;
import java.util.List;

public class Galaxy{
    private List<CelestialObject> celestialObjects;
    public Galaxy(){
        super();
        this.celestialObjects = new ArrayList<>();
    }
    public List<CelestialObject> getCelestialObjects(){
        return this.celestialObjects;
    }
    public void addCelestialObject(CelestialObject c){
        this.celestialObjects.add(c);
    }
}