package br.com.escola.aplicacao.aluno;

import br.com.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.escola.dominio.aluno.Aluno;
import br.com.escola.dominio.aluno.RepositorioDeAluno;

public class MatricularAluno {
    private final RepositorioDeAluno repositorio;

    public MatricularAluno(RepositorioDeAluno repositorio) {
        this.repositorio = repositorio;
    }

    public void matricular(MatricularAlunoDto dados) {
        repositorio.matricular(dados.criarAluno());
    }
}
