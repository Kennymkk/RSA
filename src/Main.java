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
        String encodedMessage = encoder.simpleEncode(message);
        System.out.println("Message encodé");
        System.out.println(encodedMessage);

        String cryptedMessage = encoder.RSAEncoding(encodedMessage,3);
        System.out.println("Message crypté");
        System.out.println(cryptedMessage);


        String decodedMessage = decoder.ASCIISimpleDecode(cryptedMessage,3);
        System.out.println(decodedMessage);

    }
}
