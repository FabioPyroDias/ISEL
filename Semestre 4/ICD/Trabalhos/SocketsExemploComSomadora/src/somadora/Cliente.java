package somadora;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	private String nome;
	private Socket sock;
	private PrintWriter pw;
	private BufferedReader br;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Socket getSock() {
		return sock;
	}
	public void setSock(Socket sock) {
		this.sock = sock;
	}
	public PrintWriter getPw() {
		return pw;
	}
	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	

}
