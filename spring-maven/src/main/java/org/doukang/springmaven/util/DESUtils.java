package org.doukang.springmaven.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESUtils
{
    private static Key key;

    private static String KEY_STR = "public_key";

    static
    {
        try
        {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String getEncryptString(String msg)
    {
        BASE64Encoder base64en = new BASE64Encoder();
        try
        {
            byte[] msgBytes = msg.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptMsgBytes = cipher.doFinal(msgBytes);
            return base64en.encode(encryptMsgBytes);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String getDecryptString(String msg)
    {
        BASE64Decoder base64de = new BASE64Decoder();
        try
        {
            byte[] msgBytes = base64de.decodeBuffer(msg);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptMsgBytes = cipher.doFinal(msgBytes);
            return new String(decryptMsgBytes, "UTF-8");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
