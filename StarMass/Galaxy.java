import java.util.*;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return Collections.unmodifiableList(celestialObjects);
    }

    public void addCelestialObject(CelestialObject c) {
        this.celestialObjects.add(c);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> repartition = new HashMap<>();
        repartition.put("Star", 0);
        repartition.put("Planet", 0);
        repartition.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                repartition.put("Star", repartition.get("Star") + obj.getMass());
            } else if (obj instanceof Planet) {
                repartition.put("Planet", repartition.get("Planet") + obj.getMass());
            } else {
                repartition.put("Other", repartition.get("Other") + obj.getMass());
            }
        }

        return repartition;
    }
}