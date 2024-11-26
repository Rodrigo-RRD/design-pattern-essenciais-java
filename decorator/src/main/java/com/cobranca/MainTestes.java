package com.cobranca;

import java.time.YearMonth;
import java.util.Scanner;

import com.cobranca.model.CartaoCredito;
import com.cobranca.model.Cliente;
import com.cobranca.service.AnalisadorDeRiscoClearSale;
import com.cobranca.service.AutorizadorCartaoCredito;
import com.cobranca.service.AutorizadorCielo;

public class MainTestes {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.printf("Cliente: ");
            String nomeCliente = entrada.nextLine();

            System.out.printf("CPF: ");
            String cpf = entrada.nextLine();

            System.out.println();
            System.out.printf("Valor da compra: R$");
            double valor = entrada.nextDouble();
            entrada.nextLine();

            System.out.println();
            System.out.println("Informações de pagamento");
            System.out.printf("Número do cartão: ");
            String cartao = entrada.nextLine();
            System.out.printf("Nome do cartão: ");
            String nomeCartao = entrada.nextLine();
            System.out.printf("Ano vencimento: ");
            int anoVencimento = entrada.nextInt();
            System.out.printf("Mês vencimento: ");
            int mesVencimento = entrada.nextInt();
            System.out.printf("Código segurança: ");
            int codigoSeguranca = entrada.nextInt();

            // Novo cliente
            Cliente cliente = new Cliente(nomeCliente, cpf);
            // Passar as informacoes do numero do cartao, nome do cartao
            CartaoCredito cartaoCredito = new CartaoCredito(cartao, nomeCartao,
                    // YearMonth formato "MM/AAAA", sem incluir o dia.
                    YearMonth.of(anoVencimento, mesVencimento), codigoSeguranca);
            
            // Decorou o codigo abaixo
            AutorizadorCartaoCredito autorizador = new AnalisadorDeRiscoClearSale(new AutorizadorCielo());
            autorizador.autorizar(cliente, cartaoCredito, valor);

        }
    }
}