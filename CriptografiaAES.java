import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaAES {
	// Propriedades da classe
	private SecretKeySpec chave = null;
	private IvParameterSpec iv = null;
	private Cipher cifra = null;
	
	// Método construtor da classe
	public CriptografiaAES(String senha) throws Exception {
		MessageDigest hash = MessageDigest.getInstance("SHA-256");
		hash.reset();
		hash.update(senha.getBytes("UTF-8"));
		byte[] resultado = hash.digest();
		
		chave = new SecretKeySpec(resultado, "AES");
		iv = new IvParameterSpec("JuniorEhBonitao!".getBytes("UTF-8"));
		cifra = Cipher.getInstance("AES/CBC/PKCS5Padding");
	}
	
	// Métodos da classe
	public String encriptar(String texto) throws Exception {
		cifra.init(Cipher.ENCRYPT_MODE, chave, iv);
		byte[] retorno = cifra.doFinal(texto.getBytes("UTF-8"));
		
		return Base64.getEncoder().encodeToString(retorno); 
	}
	
	public String decriptar(String criptograma) throws Exception {
		cifra.init(Cipher.DECRYPT_MODE, chave, iv);
		byte[] retorno = cifra.doFinal(Base64.getDecoder().decode(criptograma));
		
		return new String(retorno, "UTF-8");
	}
}