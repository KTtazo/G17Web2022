package utiles;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Contiene los metodos requeridos para hashear y validar contrasenas usando el algoritmo de encriptado PBKDF2WithHmacSHA1
 * @author Daniel Pastor Miguel
 */

public class HashPasswordUtil {

    /** 
     * Genera una hash con un algoritmo de encriptado PBKDF2WithHmacSHA1 de 166 caracteres
     * @param password. Contraseña sobre la que se quiere crear una hash
     * @return El hash generado
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public static String generarPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    /**
     * Crea 16 caracteres aleatorios usando el algoritmo SHA1PRNG
     * @return Los caracteres aleatorios
     * @throws NoSuchAlgorithmException 
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    /**
     * Convierte un array de bytes en formato decimal a formato hexadecimal
     * @param array
     * @return Cadena de texto en formato hexadecimal
     * @throws NoSuchAlgorithmException 
     */
    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    /**
     * Compara si una cadena de texto simple y otra hasheada con el algortimo PBKDF2WithHmacSHA1 son iguales 
     * @param decodedPassword
     * @param hashedPassword
     * @return Si son iguales o no
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NumberFormatException. Si se introduce una cadena que no este hasheada como argumento de hashedPassword
     */
    public static boolean validarPassword(String decodedPassword, String hashedPassword)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NumberFormatException {
        String[] parts = hashedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);

        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(decodedPassword.toCharArray(),
                salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    /**
     * Convierte una cadena de texto hexadecimal en un array de bytes en formato decimal
     * @param hex
     * @return Array de bytes en formato decimal
     * @throws NoSuchAlgorithmException 
     */
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
