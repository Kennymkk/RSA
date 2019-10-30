public class KeyFactory {

    /**
     * first key is public second one is private
     * @param p
     * @param q
     * @return
     * @throws Exception
     */
    public static Key [] createKey(int p, int q) throws Exception {

        int n = p*q;
        int phi = (p-1)*(q-1);

        int e = KeyFactory.find_e(p,q,phi,0);
        int d = KeyFactory.find_d(p,q,phi,e,0);

        Key [] keys = new Key[2];
        keys[0] = new Key(n,e); // public
        keys[1] = new Key(n,d); // private

        return keys;
    }

    private static int find_e(int p, int q,int phi,int seed) throws Exception {

        int e;
        if(p > q) {
            e = p;
        }
        else {
            e = q;
        }

        if(e >= phi) {
            throw new Exception("Fatal error! e generation went wrong");
        }

        int currentSeed = 0;
        boolean finished =false;
        while(!finished) {

            do{
                e++;
            }
            while(Maths.PGCD(e,phi) != 1);


            if(seed == currentSeed) {
                finished = true;
            }

            currentSeed++;
        }

        return e;
    }

    private static int find_d(int p, int q, int phi, int e, int seed) throws Exception {
        int d;
        if (p > q) {
            d = p;
        }
        else{
            d = q;
        }

        if(d >= phi) {
            throw new Exception("Fatal error! d generation went wrong");
        }
        int currentSeed = 0;
        boolean finished = false;
        while(!finished) {
            while(e*d%phi !=1){
                d++;
            }
            if( seed == currentSeed) {
                finished = true;
            }
            currentSeed++;
        }

        return d;
    }
}
