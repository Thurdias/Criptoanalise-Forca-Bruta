
public class PrincipalQuebraSenha {
	public static void main(String[] args) {
		new QuebraSenha(0, 100000).start();
		new QuebraSenha(100000, 200000).start();
		new QuebraSenha(200000, 300000).start();
		new QuebraSenha(300000, 400000).start();
		new QuebraSenha(400000, 500000).start();
		new QuebraSenha(500000, 600000).start();
		new QuebraSenha(600000, 700000).start();
		new QuebraSenha(700000, 800000).start();
		new QuebraSenha(800000, 900000).start();
		new QuebraSenha(900000, 1000000).start();
	}
}