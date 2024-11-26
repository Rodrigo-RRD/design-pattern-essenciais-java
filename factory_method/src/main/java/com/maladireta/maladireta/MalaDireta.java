package com.maladireta.maladireta;

import java.util.List;

import com.maladireta.contato.Contato;
import com.maladireta.contato.Contatos;

public class MalaDireta {
   public boolean enviarEmail(String nomeArquivo, String mensagem) {
		Contatos contatosRepositorio = new Contatos();
		List<Contato> contatos = contatosRepositorio.recuperarContatosXML(nomeArquivo);
		
		System.out.println("Conectando no servidor SMTP...");
		System.out.println("Mensagem a ser enviada: " + mensagem);
		System.out.println();
		
		for (Contato contato : contatos) {
			System.out.println("From: <rodrigo@gmail.com>");
			System.out.printf("To: [%s] <%s>\n", contato.getNome(), contato.getEmail());
			System.out.println(mensagem);
			System.out.println();
		}
		
		return true;
	}
}
