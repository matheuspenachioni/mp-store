package br.com.matheus.mpstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.matheus.mpstore.controller.AcessoController;
import br.com.matheus.mpstore.model.Acesso;

@SpringBootTest(classes = MpStoreApplication.class)
class MpStoreApplicationTests {
	
	@Autowired
	private AcessoController acessoController;
	
	@Test
	void testeCadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		
		acessoController.saveAcesso(acesso);
	}

}
