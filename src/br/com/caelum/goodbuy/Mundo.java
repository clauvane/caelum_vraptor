package br.com.caelum.goodbuy;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {
	public String boasVindas(){
		return "Ola Mundo";
	}
	
	public List<String> getPaises(){
		List<String> listaDePaises = new ArrayList<String>();
		listaDePaises.add("Brasil");
		listaDePaises.add("Argentina");
		listaDePaises.add("Chile");
		listaDePaises.add("Venezuela");
		
		return listaDePaises;
	}
}