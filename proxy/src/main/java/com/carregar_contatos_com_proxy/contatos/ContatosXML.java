package com.carregar_contatos_com_proxy.contatos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.carregar_contatos_com_proxy.model.Contato;
import com.carregar_contatos_com_proxy.repository.Contatos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

public class ContatosXML implements Contatos {

    private Map<String, String> contatosEmCache = new HashMap<>();

    @SuppressWarnings("unchecked")
    public ContatosXML(String... nomesArquivos) {
        XStream xstream = new XStream();
        xstream.addPermission(NoTypePermission.NONE);
        xstream.allowTypesByWildcard(new String[] {
                "com.carregar_contatos_com_proxy.model.**",
                "java.util.List",
                "java.util.Map",
                "java.util.Set"
        });

        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        for (String nomeArquivo : nomesArquivos) {
            System.out.println("Carregando arquivo: " + nomeArquivo);
            List<Contato> contatosCarregados = (List<Contato>) xstream
                    .fromXML(this.getClass().getResource("/" + nomeArquivo));
            for (Contato contato : contatosCarregados) {
                contatosEmCache.put(contato.getEmail(), contato.getNome());
            }
        }
    }

    @Override
    public String buscarPor(String email) {
        return contatosEmCache.get(email);
    }

}
