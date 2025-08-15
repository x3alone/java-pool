public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;
    
    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }
    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static final double KM_IN_ONE_AU = 150000000;

    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
    double dx = a.getX() - b.getX();
    double dy = a.getY() - b.getY();
    double dz = a.getZ() - b.getZ();
    return Math.sqrt(dx * dx + dy * dy + dz * dz);
}

public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
    return getDistanceBetween(a, b) * KM_IN_ONE_AU;
}
    @Override
 public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }
@Override
public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; 
        CelestialObject other = (CelestialObject) obj;
        return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0 && Double.compare(z, other.z) == 0 && Objects.equals(name, other.name);
}
    @Override
public int hashCode() {
        return Objects.hash(name, x, y, z);
}

}
