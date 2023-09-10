package br.com.escola.infra.aluno;

import br.com.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunoJDBC implements RepositorioDeAluno {
    private final Connection connection;

    public RepositorioDeAlunoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "insert into aluno values(?,?,?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEMail());
            ps.execute();

            sql = "insert into telefone values(?,?)";
            connection.prepareStatement(sql);
            for (Telefone telefone: aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            String sql = "select id, nome, email from aluno where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();

            if (!encontrou) {
                throw new IllegalArgumentException("Aluno não encontrado");
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "select ddd, numero from telefone where aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                encontrado.adicionarTelefone(
                        rs.getString("ddd"),
                        rs.getString("numero")
                );
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        List alunos = new ArrayList<>();

        try {
            String sql = "select id, nome, email from aluno";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        new CPF(rs.getString("cpf")),
                        rs.getString("nome"),
                        new Email(rs.getString("email"))
                );

                sql = "select ddd, numero from telefone where aluno_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, rs.getLong("id"));
                rs = ps.executeQuery();

                while (rs.next()) {
                    aluno.adicionarTelefone(
                            rs.getString("ddd"),
                            rs.getString("numero")
                    );
                }

                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
