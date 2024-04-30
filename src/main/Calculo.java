package main;

import java.text.DecimalFormat;

import classes.Aviao;
import classes.InfoColisao;

public class Calculo {

	//formata o decimal para duas casas depois da virgula
	private static double formatarDecimal (double valor) {
		DecimalFormat df = new DecimalFormat("###.##");
		return Double.parseDouble(df.format(valor).replace(',', '.'));
	}
	
	public static void escalonar(Aviao aviao, double percX, double percY) {
		double auxX = percX / 100;
		double auxY = percY / 100;
		
		aviao.setPontoX(formatarDecimal(aviao.getPontoX() * auxX));
		aviao.setPontoY(formatarDecimal(aviao.getPontoY() * auxY));
	}
	
	//faz com que o avião "voe" para outra posição
	public static void transladar(Aviao aviao, double somaX, double somaY) {
		aviao.setPontoX(formatarDecimal(aviao.getPontoX() + somaX));
		aviao.setPontoY(formatarDecimal(aviao.getPontoY() + somaY));
	}
	
	//faz com que o avião altere sua rotação
	public static void rotacionar(Aviao aviao, double cordX, double cordY, double angulo) {
		
		//caso a cordenada seja maior que 0, altera para negativo, caso contrario, mantem
		double auxX = cordX * -1; 
		double auxY = cordY * -1;
		
		transladar(aviao, auxX, auxY);
		
		//primeiro alterar para radianos e depois calcular cosseno e seno
		double anguloRandianos = Math.toRadians(angulo);
		double cosseno = Math.cos(anguloRandianos);
		double seno = Math.sin(anguloRandianos);
		
		//rotacionar
		double novoX = (aviao.getPontoX() * cosseno) - (aviao.getPontoY() * seno);
		double novoY = (aviao.getPontoY() * cosseno) + (aviao.getPontoX() * seno);
		
		aviao.setPontoX(novoX);
		aviao.setPontoY(novoY);
		
		//voltar a translação
		auxX = auxX * -1;
		auxY = auxY * -1;
		
		transladar(aviao, auxX, auxY);
	}
	
	//calculo de distancia: sqrt faz calculo de raiz
	//logo é feito, x1-x2 * x1-x2 para representar o quadrado
	public static double distancia(double x1, double y1, double x2, double y2) {
		return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
	}
	
	
	//calcula-se o raio que é raiz quadrada de (x ao quadro + y ao quadro)
	//calcula-se a tangente, math.atan faz o calculo da tangente de (y/x)
	public static Aviao cartersianoParaPolar(Aviao a) {
		double raio, angulo;
		
		raio = Math.sqrt((a.getPontoX() * a.getPontoX()) + (a.getPontoY() * a.getPontoY()));
		angulo = Math.toDegrees(Math.atan(a.getPontoY() / a.getPontoX()));
		
		a.setRaio(formatarDecimal(raio));
		a.setAngulo(formatarDecimal(angulo));
		return a;
	}
	
	//altera-se o angulo para radianos
	//depois faz o calculo de x e y, ambos utilizam o raio * cosseno para e seno para y
	public static Aviao polarParaCartesiano(Aviao a) {
		double x, y, anguloRadianos;
		
		anguloRadianos = Math.toRadians(a.getAngulo());
		
		x = a.getRaio() * Math.cos(anguloRadianos);
		y = a.getRaio() * Math.sin(anguloRadianos);
		
		a.setPontoX(formatarDecimal(x));
		a.setPontoY(formatarDecimal(y));
		return a;
	}
	
	public static InfoColisao calcularColisao(Aviao a, Aviao b) {
		InfoColisao info = new InfoColisao();
		info.setAviaoA(a.getCodigo());
		info.setAviaoB(b.getCodigo());
		
		
		//converte a direçãoe em radianos e depois aplica o valor na tangente, achando assim o m 
		double radianoA = Math.toRadians(a.getDirecao());    
		double tangenteA = Math.tan(radianoA);               
		
		double radianoB = Math.toRadians(b.getDirecao());     
		double tangenteB = Math.tan(radianoB);
		
		//calcula a equação do aviao A e B  - (y2 - y1) = m(x2 - x1) -- com o y2 não "existe" podemos deixar com o valor 1
		double y = 1;
		double x = 1;
		
		double ga = tangenteA * x;   //m * x2
		double ha = tangenteA * -a.getPontoX();  //m * -x1
		
		double ia = ha + a.getPontoY();
		
		//-----------
		double gb = tangenteB * x; //m * x2
		double hb = tangenteB * -b.getPontoX(); // m * -x1
		
		double ib = hb + b.getPontoY();
		
		double j = ga - gb;
		double l = ib - ia;
		
		x = l / j;
		y = x + ia;
		
		double distanciaA = distancia(x, y, a.getPontoX(), a.getPontoY());
		double distanciaB = distancia(x, y, b.getPontoX(), b.getPontoY());
		
		double tempoA = converterSegundos(distanciaA / a.getVelocidade());
		double tempoB = converterSegundos(distanciaB / b.getVelocidade());
		
		//caso a velocidade de a for maior que a b, então velocidade de A - velocidade de B
		//se não, velocidade de B - velocidade de A
		double diferencaTempo = (tempoA > tempoB) ? tempoA - tempoB : tempoB - tempoA;
		info.setDiferencaTempo(formatarDecimal(diferencaTempo));
		
		//se velocidade de A for maior que velocidade de B, então velocidade de B
		//se não, velocidade de A
		double tempoColisao = (tempoA > tempoB) ? tempoB : tempoA;
		info.setTempoColisao(formatarDecimal(tempoColisao));
		
		return info;
	}
	
	//converte horas em segundos (usado para calcular a velocidade)
	private static double converterSegundos(double hora) {
		double minutos = hora * 60;
		double segundos = minutos * 60;
		
		return segundos;
	}
}
