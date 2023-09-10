package br.com.escola;

import br.com.escola.aplicacao.aluno.MatricularAluno;
import br.com.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class CommandLine {
    public static void main(String[] args) {
        String nome = "Nome do Aluno";
        String cpf = "999.999.999-99";
        String email = "fulano@mail.com";

        MatricularAluno matricula = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricula.matricular(new MatricularAlunoDto(nome, cpf, email));
    }
}