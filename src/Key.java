

public class Key {

    private int common;

    private int specific;

    public Key(int common,int specific) {
        this.common = common;
        this.specific = specific;
    }

    public void printKey() {
        System.out.println("common part :" + Integer.toString(common));
        System.out.println("specific part" + Integer.toString(specific));
    }

    public int getCommonPart(){
        return common;
    }

    public int getSpecificPart(){
        return specific;
    }

    public String toString() {
        return String.valueOf(this.common)+ ',' + String.valueOf(this.specific);
    }
}
