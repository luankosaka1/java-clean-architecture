package br.com.escola.dominio;

public interface CriptografarSenha {
    String criptografar(String senha);
    boolean validarSenha(String senhaCriptografada, String senha);
}
