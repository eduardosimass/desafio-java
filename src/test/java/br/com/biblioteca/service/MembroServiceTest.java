package br.com.biblioteca.service;

import br.com.biblioteca.model.Membro;
import br.com.biblioteca.repository.MembroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MembroServiceTest {
    @InjectMocks
    private MembroService membroService;
    @Mock
    private MembroRepository membroRepository;
    private Membro membro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startMembro();
    }

    @Test
    void SalvarDados() {
        Mockito.when(membroRepository.save(Mockito.any(Membro.class))).thenReturn(membro);
        Membro response = membroService.SalvarDados(membro);
        Assertions.assertEquals(membro.getClass(), response.getClass());
    }

    private void startMembro(){
        membro = new Membro("1","1");
    }
}
