public  class CelestialObject{
     double x, y, z;
     String name;
    public  static double KM_IN_ONE_AU =  150000000; 
    public static  double getDistanceBetween(CelestialObject obj1, CelestialObject obj2){
        double x = obj1.getX() - obj2.getX();
        double y = obj1.getY() - obj2.getY();
        double z = obj1.getZ() - obj2.getZ();
        Double distance = Math.sqrt(x*x+y*y+z*z);
        return distance;
    }
    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2){
        double distance =  CelestialObject.getDistanceBetween(obj1, obj2);
        return distance * CelestialObject.KM_IN_ONE_AU;
    }
     public CelestialObject(){
        this.x = 0.0;
        this.y =0.0;
        this.z =0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double  y, double z){
        this.x = x;
        this.y =y;
        this.z =z;
        this.name = name;
    }
    public double  getX(){
        return this.x;
    }
     public double  getY(){
        return this.y;
    }
    public double  getZ(){
        return this.z;
    }
    public String  getName(){
        return this.name;
    }
    public void  setX(double x){
        this.x = x;
    }
    public void  setY(double y){
        this.y = y;
    }
    public void  setZ(double z){
        this.z = z;
    }
    public void  setName(String name){
        this.name = name;
    }

    public  String toString(){
        String res = String.format("%s is positioned at (%.3f, %.3f, %.3f)", this.name, x,y,z);
        return res;
    }
    public boolean equals(CelestialObject obj){
        if (this == null || obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        if (this.name == obj.name && this.x == obj.x && this.y == obj.y && this.z == obj.z){
            return  true;
        }
        return false;
    }
    public int hashCode(){
        return java.util.Objects.hash(name,x,y,z);
    }
}