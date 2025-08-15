
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
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getName(), getX(), getY(), getZ(), getCenterStar());
    }

    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (!(obj instanceof Planet)) return false;
    //     Planet other = (Planet) obj;
    //     if (centerStar == null) {
    //         return other.centerStar == null;
    //     }
    //     return centerStar.equals(other.centerStar);
    // }
    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Planet other = (Planet) obj;

        if (this.getName().equals(other.getName())
                && Double.compare(this.getX(), other.getX()) == 0
                && Double.compare(this.getY(), other.getY()) == 0
                && Double.compare(this.getZ(), other.getZ()) == 0
                && this.getCenterStar().equals(other.getCenterStar())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        double distanceWithCenterStar = getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU",
                getName(),
                centerStar.getName(),
                distanceWithCenterStar);
    }
}
