package br.com.flores.marcio.loccarr.Modelos;

import java.util.Date;

/**
 * Created by marci on 24/11/2017.
 */

public class Motorista {
    public String nome, matricula, cnh, dataIngresso;

    public Motorista(String nome, String matricula, String cnh, String dataIngresso) {
        this.nome = nome;
        this.matricula = matricula;
        this.cnh = cnh;
        this.dataIngresso = dataIngresso;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCnh() {
        return cnh;
    }

    public String getDataIngresso() {
        return dataIngresso;
    }
}
