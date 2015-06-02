package com.mercury.util;

import java.security.*;
import javax.crypto.*;

public class AES {
  
    private KeyGenerator keygen;    
    private SecretKey deskey;    
    private Cipher c;  
    private byte[] cipherByte;
    
    public AES() throws NoSuchAlgorithmException, NoSuchPaddingException{
    	Security.addProvider(new com.sun.crypto.provider.SunJCE());  
        keygen = KeyGenerator.getInstance("AES");  
        deskey = keygen.generateKey();   
        c = Cipher.getInstance("AES"); 
    }
    /** 
     * Encryption 
     *  
     * @param str 
     * @return 
     * @throws InvalidKeyException 
     * @throws IllegalBlockSizeException 
     * @throws BadPaddingException 
     */  
    public byte[] Encrytor(String str) throws InvalidKeyException,  
    	IllegalBlockSizeException, BadPaddingException {    
    	c.init(Cipher.ENCRYPT_MODE, deskey);  
    	byte[] src = str.getBytes();    
    	cipherByte = c.doFinal(src);  
    	return cipherByte;  
    } 
    /** 
     * Decryption
     *  
     * @param buff 
     * @return 
     * @throws InvalidKeyException 
     * @throws IllegalBlockSizeException 
     * @throws BadPaddingException 
     */ 
    public byte[] Decryptor(byte[] buff) throws InvalidKeyException,  
    	IllegalBlockSizeException, BadPaddingException {  
    	c.init(Cipher.DECRYPT_MODE, deskey);  
    	cipherByte = c.doFinal(buff);  
    	return cipherByte;  
    } 
    /** 
     * @param args 
     * @throws NoSuchPaddingException  
     * @throws NoSuchAlgorithmException  
     * @throws BadPaddingException  
     * @throws IllegalBlockSizeException  
     * @throws InvalidKeyException  
     */  
    public static void main(String[] args) throws Exception {  
    	AES aes = new AES();  
        String msg ="www.suning.com/index.jsp";  
        byte[] encontent = aes.Encrytor(msg);  
        byte[] decontent = aes.Decryptor(encontent);  
        System.out.println("Plaintext:" + msg);  
        System.out.println("Encryted:" + new String(encontent));  
        System.out.println("Decrypted:" + new String(decontent));  
    }
}
