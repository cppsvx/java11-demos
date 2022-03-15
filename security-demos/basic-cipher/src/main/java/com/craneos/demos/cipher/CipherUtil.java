package com.craneos.demos.cipher;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;

public class CipherUtil {

    public static byte[] encryptAES(String key, String instance, String message){
        byte[] encryptedMessageBytes = null;
        try {
            byte[] encryptionKeyBytes = key.getBytes();
            Cipher cipher = Cipher.getInstance(instance);
            SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedMessageBytes = cipher.doFinal(message.getBytes());
        } catch(Exception e){
            e.printStackTrace();
        }
        return encryptedMessageBytes;
    }

    public static byte[] decryptAES(String key, String instance, byte[] message){
        byte[] decryptedMessageBytes = null;
        try {
            byte[] encryptionKeyBytes = key.getBytes();
            Cipher cipher = Cipher.getInstance(instance);
            SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptedMessageBytes = cipher.doFinal(message);
        } catch(Exception e){
            e.printStackTrace();
        }
        return decryptedMessageBytes;
    }

    public static KeyPair generateKey(){
        KeyPair keyPair = null;
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            //kpg.initialize(1024); // speedy generation, but not secure anymore
            kpg.initialize(4096);
            keyPair = kpg.generateKeyPair();
        } catch (Exception e){
            e.printStackTrace();
        }
        return keyPair;
    }

    public static byte[] encryptRSA(RSAPublicKey rsaPublicKey, String instance, String message){
        byte[] encryptedMessageBytes = null;
        try {
            Cipher oaepFromAlgo = Cipher.getInstance(instance);
            oaepFromAlgo.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            encryptedMessageBytes = oaepFromAlgo.doFinal(message.getBytes(StandardCharsets.UTF_8));
        } catch(Exception e){
            e.printStackTrace();
        }
        return encryptedMessageBytes;
    }

    public static byte[] decryptRSA(RSAPrivateKey rsaPrivateKey, String instance, byte[] message){
        byte[] decryptedMessageBytes = null;
        try {
            Cipher oaepFromInit = Cipher.getInstance(instance);
            OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT);
            oaepFromInit.init(Cipher.DECRYPT_MODE, rsaPrivateKey, oaepParams);
            decryptedMessageBytes = oaepFromInit.doFinal(message);
        } catch(Exception e){
            e.printStackTrace();
        }
        return decryptedMessageBytes;
    }

}