
public class QuebraSenha extends Thread {
	// Propriedades da classe
	private int inicio = 0;
	private int fim = 0;
	
	// Método construtor da classe
	public QuebraSenha(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	// Método de execução paralela da classe
	public void run() {
		for (int i = inicio ; i < fim ; i++) {
			try {
				CriptografiaAES objCripto = new CriptografiaAES("" + i);
				String texto = objCripto.decriptar("uUhUdIk0jC2hB+k0XhaUZw==");
				byte[] array = texto.getBytes("UTF-8");
				boolean valido = true;
				
				for (int j = 0 ; j < 16 ; j++) {
					if (array[j] < 30) {
						valido = false;
					}
				}
				if (valido) {
					System.out.println("ACHEI A SENHA !!!! SOU FODA !!!!");
					System.out.println("Senha: " + i);
					System.out.println("Texto: " + texto);
				}
			} catch (Exception erro) {
			}
		}
	}
}