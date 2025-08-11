public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if ( array == null) return null;
        int[] res = new int[array.length];
        for (int i =0 ; i < array.length; i++){
            int val =array[i];
            int mod = val %3; 
            if (mod== 0){
                res[i] = val * 5;
            }else if (mod == 1){
                res[i] =val +7;
            }else {
                res[i] = val;
            }
        }
        return res;
    }
}