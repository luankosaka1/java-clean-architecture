package br.com.escola.dominio.aluno;

public class FabricaDeAluno {
    private Aluno aluno;

    public FabricaDeAluno addNomeCpfEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(
                new CPF(cpf),
                nome,
                new Email(email)
        );

        return this;
    }

    public FabricaDeAluno addTelefone(String ddd, String numero) {
        if (this.aluno == null) {
            throw new IllegalArgumentException("Aluno não instanciado");
        }

        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }
}
