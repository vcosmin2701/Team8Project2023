package com.lbbsystem.lbbsystem.utilities;

import jakarta.ejb.Stateless;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Stateless
public class EncryptionUtil {
  private static final String ALGORITHM = "AES";
  private static final byte[] KEY = "MySuperSecretKey".getBytes();
  public  static String encrypt(String valueToEnc) throws Exception {
    Key key = new SecretKeySpec(KEY, ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encryptedValue = cipher.doFinal(valueToEnc.getBytes());
    return Base64.getEncoder().encodeToString(encryptedValue);
  }

  public static String decrypt(String encryptedValue) throws Exception {
    Key key = new SecretKeySpec(KEY, ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decodedValue = Base64.getDecoder().decode(encryptedValue);
    byte[] decryptedValue = cipher.doFinal(decodedValue);
    return new String(decryptedValue);
  }
}
