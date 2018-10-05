package test.br.com.caelum.leilao.teste;

import main.br.com.caelum.leilao.dominio.Lance;
import main.br.com.caelum.leilao.dominio.Leilao;
import main.br.com.caelum.leilao.dominio.Usuario;
import main.br.com.caelum.leilao.servico.Avaliador;

import org.junit.Assert;
import org.junit.Test;



public class AvaliadorTest {
	
	//public static void main(String[] args) {
	@Test	
	public void deveEntenderLancesEmOrdemCrescente() {
		
		//parte 1: cenário
		Usuario diogo = new Usuario("Diogo");
		Usuario teste1 = new Usuario("Teste1");
		Usuario teste2 = new Usuario("Teste2");
		
		Leilao leilao = new Leilao("Video Game");
		
		leilao.propoe(new Lance(diogo, 250.0));
		leilao.propoe(new Lance(teste1, 280.0));
		leilao.propoe(new Lance(teste2, 300.0));
		
		//parte 2: ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//parte 3: validação
		double maiorEsperado = 300.0;
		double menorEsperado = 250.0;
		
		System.out.println(maiorEsperado);
		System.out.println(leiloeiro.getMaiorLance());		
		System.out.println(menorEsperado);
		System.out.println(leiloeiro.getMenorLance());
		System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		System.out.println(menorEsperado == leiloeiro.getMenorLance());

		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
}
