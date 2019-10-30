import java.math.BigInteger;

public class Decoder {

    public Key privateKey;

    public Key publicKey;

    public Decoder(Key publicKey, Key privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    private int RSADecode(int content) {
        BigInteger pow = new BigInteger(String.valueOf(this.privateKey.getSpecificPart()));
        BigInteger mod = new BigInteger(String.valueOf(this.privateKey.getCommonPart()));
        BigInteger bigContent = new BigInteger(String.valueOf(content));


        BigInteger result = bigContent.modPow(pow,mod);


        return result.intValue();
    }

    public String ASCIISimpleDecode(String content,int intSize) {
        //TODO check si la longueur est bien divisible par 3

        System.out.println("\n \n");
        String decodedMessage = "";
        for(int i = 0;i < content.length()/intSize  ; i++){
            // Cropping by size of hashing : ABCDEF => ABC DEF
            int cryptedChar = Integer.valueOf(content.substring(i*intSize,i*intSize+intSize));
            System.out.println(cryptedChar);
            int encodeddChar = this.RSADecode(cryptedChar);
            System.out.println(encodeddChar );
            decodedMessage +=  Character.toString((char) this.RSADecode(cryptedChar));
            System.out.println(decodedMessage+"\n");
        }

        return decodedMessage;
    }

}
