package br.com.escola.dominio.aluno;

public class Email {
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
