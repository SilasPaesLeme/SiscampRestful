package br.com.siscamp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	public String Criptografar(String senhaNormal) {
		String senhaSegura;
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte messageDigestSenhaAdmin[] = null;
		try {
			messageDigestSenhaAdmin = algorithm.digest(senhaNormal.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		StringBuilder hexStringSenhaAdmin = new StringBuilder();
		for (byte b : messageDigestSenhaAdmin) {
			hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
		}
		senhaSegura = hexStringSenhaAdmin.toString();

		return senhaSegura;

	}

}