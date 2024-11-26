package com.maladireta.contato;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

import au.com.bytecode.opencsv.CSVReader;

public class Contatos {

    public List<Contato> recuperandoContatosCSV(String nomeArquivo) {
        List<Contato> contatos = new ArrayList<>();
        CSVReader csvReader = null;
        try {
            URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();
            File arqivoCSV = new File(uri);
            FileReader fileReader = new FileReader(arqivoCSV);
            csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Contato(nextLine[0].trim(), nextLine[1].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro lendo arquivo csv", e);
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
            }
        }
        return contatos;
    }

    @SuppressWarnings("unchecked")
    public List<Contato> recuperarContatosXML(String nomeArquivo) {
        XStream xStream = new XStream();

        xStream.addPermission(NoTypePermission.NONE);

        xStream.addPermission(NoTypePermission.NONE);
        xStream.allowTypesByWildcard(new String[] {
                "com.maladireta.contato.**",
                "java.util.List",
                "java.util.Map",
                "java.util.Set"
        });

        xStream.alias("contatos", List.class);
        xStream.alias("contato", Contato.class);

        URL arquivo = this.getClass().getResource("/" + nomeArquivo);
        return (List<Contato>) xStream.fromXML(arquivo);
    }
}
