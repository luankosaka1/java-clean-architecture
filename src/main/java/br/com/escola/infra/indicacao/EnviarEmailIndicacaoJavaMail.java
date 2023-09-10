package br.com.escola.infra.indicacao;

import br.com.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.escola.dominio.aluno.Aluno;

import java.util.Properties;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        // enviar email
    }
}
