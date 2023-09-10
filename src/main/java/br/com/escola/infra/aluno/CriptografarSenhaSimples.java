package br.com.escola.infra.aluno;

import br.com.escola.dominio.CriptografarSenha;

import java.security.MessageDigest;

public class CriptografarSenhaSimples implements CriptografarSenha {
    private static final String prefixo = "prefixo_";

    @Override
    public String criptografar(String senha) {
        return prefixo + senha;
    }

    @Override
    public boolean validarSenha(String senhaCriptografada, String senha) {
        return senhaCriptografada.equals(prefixo + senha);
    }
}
