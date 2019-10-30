public final class Maths {

    public static int PGCD (int a, int b) {

        int old_r = -1;
        while(true){
            int r = a % b;

            if(r == 0){
                return old_r;
            }

            a = b;
            b = r;
            old_r = r;
        }
    }


}
