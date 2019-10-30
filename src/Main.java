import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");
        // 0 is public, 1 is private
        Key [] keys = KeyFactory.createKey(503,563);
        Encoder encoder = new Encoder(keys[0]);
        Decoder decoder = new Decoder(keys[0],keys[1]);

        keys[0].printKey();
        keys[1].printKey();


        String message = "Sel moulu récolté manuellement";
        ArrayList encodedMessage = encoder.simpleEncode(message);
        System.out.println("Message encodé");
        System.out.println(encodedMessage.toString());

        ArrayList cryptedMessage = encoder.RSAEncoding(encodedMessage);
        System.out.println("Message crypté");
        System.out.println(cryptedMessage.toString());


        String decodedMessage = decoder.ASCIISimpleDecode(cryptedMessage,3);
        System.out.println(decodedMessage);

    }
}
