package pagamento;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.pagamento_abstract_factory.AlertaDeRiscoException;
import com.pagamento_abstract_factory.operadora.CapturaNaoAutorizadaException;
import com.pagamento_abstract_factory.pagamento.ModuloPagamentoFactory;
import com.pagamento_abstract_factory.pagamento.Pagamento;
import com.pagamento_abstract_factory.pagamento.pagseguro.PagSeguroModuloPagamentoFactory;

public class PagamentoViaPagSeguroTest {

	private Pagamento pagamento;
	
	@Before
	public void init() {
		ModuloPagamentoFactory moduloPagamentoFactory = new PagSeguroModuloPagamentoFactory();
		pagamento = new Pagamento(moduloPagamentoFactory);
	}
	
	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
		assertNotNull(codigoAutorizacao);
	}
	
	@Test(expected=CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_cartaoInvalido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("5555.2222", new BigDecimal("2000"));
	}
	
	@Test(expected=AlertaDeRiscoException.class)
	public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("7777.2222", new BigDecimal("5500"));
	}
	
}