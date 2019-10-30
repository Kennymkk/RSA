import java.math.BigInteger;

public class Encoder {


    private Key publicKey;

    public Encoder(Key publicKey){
        this.publicKey = publicKey;
    }

    public String simpleEncode(String content) throws Exception{

        String encodedContent = "";
        byte [] encodedBytes;
        encodedBytes = content.getBytes();
        for(char c : content.toCharArray()) {
            // We first cast our character in int,then store it in String
            System.out.println((int) c);
            String numericChar = String.valueOf((int) c);
            if(numericChar.length() < 3) {
                numericChar = "0" + numericChar;
            }
            if(numericChar.length() != 3){
                throw new Exception("Unexepected length for encoded value of character");
            }

            encodedContent+= numericChar;
        }

        return encodedContent;
    }
    public String RSAEncoding(String content, int intSize) {
        String cryptedContent = "";
        for(int i = 0; i < content.length()/intSize ; i++ ){
            int currentNumber = Integer.valueOf(content.substring(i*intSize,i*intSize+(intSize)));
            System.out.println(currentNumber);
            int cryptedNumber = this.RSAEncoding(currentNumber);
            System.out.println(cryptedNumber);
            cryptedContent += cryptedNumber;
            System.out.println(cryptedContent+"\n");
        }

        return cryptedContent;
    }

    public int RSAEncoding(int content){
        BigInteger bigContent = new BigInteger(String.valueOf(content));
        BigInteger modValue = new BigInteger(String.valueOf(this.publicKey.getCommonPart()));
        BigInteger powValue = new BigInteger(String.valueOf(this.publicKey.getSpecificPart()));

        BigInteger result = bigContent.modPow(powValue,modValue);

        System.out.println(result);

        return result.intValue();
    }




}
