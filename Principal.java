import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
	public static void main(String[] args) {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader(
								new InputStreamReader(
								System.in));
		String texto = "";
		String senha = "";
		String criptograma = "";
		
		try {
			// Entrada de dados para encriptar
			System.out.print("Digite o texto: ");
			texto = leitor.readLine();
			
			System.out.print("Digite a senha: ");
			senha = leitor.readLine();
			
			// Processamento para encriptar
			CriptografiaAES objCripto = new CriptografiaAES(senha);
			criptograma = objCripto.encriptar(texto);
			
			// Saída de dados para encriptar
			System.out.println(criptograma);
			
			// Entrada de dados para decriptar
			System.out.print("Digite o criptograma: ");
			criptograma = leitor.readLine();
			
			System.out.print("Digite a senha: ");
			senha = leitor.readLine();
			
			// Processamento para decriptar
			objCripto = new CriptografiaAES(senha);
			texto = objCripto.decriptar(criptograma);
			
			// Saída de dados para decriptar
			System.out.println(texto);
		} catch (Exception erro) {
			System.out.println("Senha incorreta !");
		}
	}
}