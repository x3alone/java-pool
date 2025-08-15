import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return this.centerStar;
    }

    public void setCenterStar(Star s) {
        this.centerStar = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Planet))
            return false;
        Planet oth = (Planet) obj;
        return super.equals(oth) && this.centerStar.equals(oth.centerStar);
    }

    @Override
    public String toString() {
        return String.format("%s circles around %s at the %.3f AU", name, centerStar.name,
                this.distanceBetween(this, this.centerStar));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, centerStar);
    }

    public double distanceBetween(Object obj, Object obj1) {
        Planet e = (Planet) obj;
        Star d = (Star) obj1;
        return Math.sqrt(Math.pow(e.x - d.x, 2) + Math.pow(e.y - d.y, 2) + Math.pow(e.z - d.z, 2));
    }
}