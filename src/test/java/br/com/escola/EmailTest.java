package br.com.escola;

import br.com.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    void emailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email("email@email"));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }
}
