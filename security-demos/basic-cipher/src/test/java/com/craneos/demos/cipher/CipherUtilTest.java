package com.craneos.demos.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class CipherUtilTest {

    private static final String MESSAGE_TO_ENCRYPT = "hi, i am testing the cipher class.";
    private static final String KEY_16_BYTES = "AA2143F2fFAS32aa";
    private static final String CIPHER_INSTANCES_PKCS5Padding = "AES/ECB/PKCS5Padding";
    private static final String CIPHER_INSTANCES_OAEPWithSHA = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String CIPHER_INSTANCES_OAEPPadding = "RSA/ECB/OAEPPadding";

    @Test
    public void testAES(){
        // KEY Must have 16 bytes
        byte[] encryptedMessage = CipherUtil.encryptAES(KEY_16_BYTES, CIPHER_INSTANCES_PKCS5Padding, MESSAGE_TO_ENCRYPT);
        byte[] decryptedMessage = CipherUtil.decryptAES(KEY_16_BYTES, CIPHER_INSTANCES_PKCS5Padding, encryptedMessage);
        Assertions.assertEquals(MESSAGE_TO_ENCRYPT, new String(decryptedMessage));

        // out
        System.out.println("Message -----------------------> "+MESSAGE_TO_ENCRYPT);
        System.out.println("Message encrypted -------------> "+new String(encryptedMessage));
        System.out.println("Message decrypted -------------> "+new String(decryptedMessage));
    }

    /**
     * https://stackoverflow.com/questions/32161720/breaking-down-rsa-ecb-oaepwithsha-256andmgf1padding
     */
    @Test
    public void testRSA_different_instance(){
        KeyPair keyPair = CipherUtil.generateKey();
        RSAPublicKey pubkey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privkey = (RSAPrivateKey) keyPair.getPrivate();

        byte[] encryptedMessage = CipherUtil.encryptRSA(pubkey, CIPHER_INSTANCES_OAEPWithSHA, MESSAGE_TO_ENCRYPT);
        byte[] decryptedMessage = CipherUtil.decryptRSA(privkey, CIPHER_INSTANCES_OAEPPadding, encryptedMessage);

        // out
        System.out.println("Message -----------------------> "+MESSAGE_TO_ENCRYPT);
        System.out.println("Message encrypted -------------> "+new String(encryptedMessage));
        System.out.println("Message decrypted -------------> "+new String(decryptedMessage));
        System.out.println(" ----------------Private key -------------------\n"+privkey);
        System.out.println(" ----------------Public key key -------------------\n"+pubkey);
    }

    /**
     * https://stackoverflow.com/questions/32161720/breaking-down-rsa-ecb-oaepwithsha-256andmgf1padding
     */
    @Test
    public void testRSA_same_instance(){
        KeyPair keyPair = CipherUtil.generateKey();
        RSAPublicKey pubkey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privkey = (RSAPrivateKey) keyPair.getPrivate();

        byte[] encryptedMessage = CipherUtil.encryptRSA(pubkey, CIPHER_INSTANCES_OAEPWithSHA, MESSAGE_TO_ENCRYPT);
        byte[] decryptedMessage = CipherUtil.decryptRSA(privkey, CIPHER_INSTANCES_OAEPWithSHA, encryptedMessage);

        // out
        System.out.println("Message -----------------------> "+MESSAGE_TO_ENCRYPT);
        System.out.println("Message encrypted -------------> "+new String(encryptedMessage));
        System.out.println("Message decrypted -------------> "+new String(decryptedMessage));
        System.out.println(" ----------------Private key -------------------\n"+privkey);
        System.out.println(" ----------------Public key key -------------------\n"+pubkey);
    }
}
