package classes;

public class Aviao {

	private int codigo;
	private double pontoX;
	private double pontoY;
	private double raio;
	private double angulo;
	private double velocidade;
	private double direcao;
	
	public Aviao() {}
	
	public Aviao(int codigo, double pontoX, double pontoY, double raio, double angulo, double velocidade, double direcao) {
		super();
		this.codigo = codigo;
		this.pontoX = pontoX;
		this.pontoY = pontoY;
		this.raio = raio;
		this.angulo = angulo;
		this.velocidade = velocidade;
		this.direcao = direcao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPontoX() {
		return pontoX;
	}
	public void setPontoX(double pontoX) {
		this.pontoX = pontoX;
	}
	public double getPontoY() {
		return pontoY;
	}
	public void setPontoY(double pontoY) {
		this.pontoY = pontoY;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	public double getAngulo() {
		return angulo;
	}
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	public double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
	public double getDirecao() {
		return direcao;
	}
	public void setDirecao(double direcao) {
		this.direcao = direcao;
	}
	
	public String toString() {
		return "Aviao [codigo=" + codigo + ", pontoX=" + pontoX + ", pontoY=" + pontoY + ", raio=" + raio + ", angulo="
				+ angulo + ", velocidade=" + velocidade + ", direcao=" + direcao + "]";
	}
	
}
