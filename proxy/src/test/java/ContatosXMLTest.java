import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.carregar_contatos_com_proxy.repository.Contatos;

public class ContatosXMLTest {

    @Test
    public void deveRetornarContato() {
        Contatos contatos = new ContatosXMLProxy("contatos1.xml", "contatos2.xml");
        String nome = contatos.buscarPor("jose@email.com");
        assertEquals("José Santos", nome);
    }

}
