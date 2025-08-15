public  class Star extends CelestialObject{
    private double magnitude ;

    public Star(){
        super();
    }
    public Star(String name, double x, double  y, double z, double magnitude ){
        super(name,x,y,z);
        this.magnitude = magnitude;
    }
    public double  getMagnitude(){
        return magnitude;
    }
    public void setMagnitude(double magnitude){
        this.magnitude = magnitude;
    }

    public  String toString(){
        String res = String.format("%s shines at the %.3f magnitude", this.name, magnitude);
        return res;
    }
    public boolean equals(Star obj){
        if (this == null || obj == null) return false;
        
        if (getClass() != obj.getClass()) return false;

        if (this.name == obj.name && this.x == obj.x && this.y == obj.y && this.z == obj.z && this.magnitude == obj.magnitude){
            return  true;
        }
        return false;
    }
     public int hashCode(){
        return java.util.Objects.hash(name,x,y,z,magnitude);
    }
}