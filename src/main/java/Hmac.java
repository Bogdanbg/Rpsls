import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hmac {

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static String hmacSha(String KEY, String VALUE) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            sha256_HMAC.init(new SecretKeySpec(KEY.getBytes(), "HmacSHA256"));
            byte[] result = sha256_HMAC.doFinal(VALUE.getBytes());
            return byteArrayToHex(result).toUpperCase();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static String GenerateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(secureRandom);

        SecretKey secretKey = keyGenerator.generateKey();
        String s = new BigInteger(1, secretKey.getEncoded()).toString(16);
        return s.toUpperCase();
    }
}