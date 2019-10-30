import java.math.BigInteger;
import java.util.ArrayList;

public class Encoder {


    private Key publicKey;

    public Encoder(Key publicKey){
        this.publicKey = publicKey;
    }

    public ArrayList simpleEncode(String content) throws Exception{

        ArrayList<Integer> encodedContent = new ArrayList<Integer>();
        for(char c : content.toCharArray()) {
            // We first cast our character in int,then store it in String
            String numericChar = String.valueOf((int) c);
            if(numericChar.length() < 3) {
                numericChar = "0" + numericChar;
            }
            if(numericChar.length() != 3){
                throw new Exception("Unexepected length for encoded value of character");
            }

            encodedContent.add(Integer.valueOf(numericChar));
        }

        return encodedContent;
    }
    public ArrayList<Integer> RSAEncoding(ArrayList<Integer> content) {
        ArrayList<Integer> cryptedContent = new ArrayList<Integer>();
        for(int currentNumber : content ){
            int cryptedNumber = this.RSAEncoding(currentNumber);
            cryptedContent.add(cryptedNumber);
        }

        return cryptedContent;
    }

    public int RSAEncoding(int content){
        BigInteger bigContent = new BigInteger(String.valueOf(content));
        BigInteger modValue = new BigInteger(String.valueOf(this.publicKey.getCommonPart()));
        BigInteger powValue = new BigInteger(String.valueOf(this.publicKey.getSpecificPart()));

        BigInteger result = bigContent.modPow(powValue,modValue);

        return result.intValue();
    }




}
