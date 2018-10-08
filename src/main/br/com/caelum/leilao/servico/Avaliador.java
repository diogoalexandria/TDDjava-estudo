package main.br.com.caelum.leilao.servico;

import main.br.com.caelum.leilao.dominio.Lance;
import main.br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double media = 0;
	

	public void avalia(Leilao leilao) {
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos  = lance.getValor();
			}
			if(lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
	}
	
	public void media(Leilao leilao) {		
		double soma = 0;
		for(Lance lance : leilao.getLances()) {
			soma += lance.getValor();			
		}
		media = soma/leilao.getLances().size();
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public double getMenorLance() {
		return menorDeTodos;
	}
	public double getMedia() {
		return media;
	}

}
