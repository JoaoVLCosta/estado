package br.edu.fateczl.estado;

import java.util.HashMap;

public class Pessoa {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private HashMap<String, String> map = new HashMap<>();
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        preencher();
    }

    private void preencher() {
        map.put("1", "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins");
        map.put("2", "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima");
        map.put("3", "Ceará, Maranhão e Piauí");
        map.put("4", "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas");
        map.put("5", "Bahia e Sergipe");
        map.put("6", "Minas Gerais");
        map.put("7", "Rio de Janeiro e Espírito Santo");
        map.put("8", "São Paulo");
        map.put("9", "Paraná e Santa Catarina");
        map.put("0", "Rio Grande do Sul");
    }

    public String identificarEstado(){
        return map.get(String.valueOf(cpf.charAt(8)));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
