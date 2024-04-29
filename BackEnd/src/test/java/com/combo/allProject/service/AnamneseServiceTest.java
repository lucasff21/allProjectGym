    package com.combo.allProject.service;

    import com.combo.allProject.model.Anamnese;
    import com.combo.allProject.repository.AnamneseRepository;

    import org.hibernate.ObjectNotFoundException;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.Mockito;
    import org.mockito.MockitoAnnotations;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.data.rest.webmvc.ResourceNotFoundException;
    import org.springframework.test.context.ActiveProfiles;

    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    import static org.junit.jupiter.api.Assertions.*;
    import static org.mockito.ArgumentMatchers.any;
    import static org.mockito.ArgumentMatchers.anyInt;
    import static org.mockito.Mockito.*;
    import static org.mockito.MockitoAnnotations.openMocks;

    @SpringBootTest
    @ActiveProfiles("test")
    class AnamneseServiceTest {
        @InjectMocks
        private AnamneseService anamneseService;
        @Mock
        private AnamneseRepository anamneseRepository;

        private Anamnese anamnese;
        private Optional<Anamnese> anamneseOptional;

        @BeforeEach
        void setUp() {
            openMocks(this);
            startUser();
        }

        @Test
        void save() {
            when(anamneseRepository.save(any())).thenReturn(anamnese);

            Anamnese anamnese1 = anamneseService.save(anamnese);

            assertNotNull(anamnese1);
            assertEquals(Anamnese.class, anamnese1.getClass());
        }

        //Retornar exceção para o metodo create
        @Test
        void ExceptionCreate() {
            // Mockando o comportamento do anamneseRepository.save para lançar uma exceção IllegalArgumentException
            when(anamneseRepository.save(any())).thenThrow(new IllegalArgumentException("Object cannot be empty"));

            // Verificando se o método save do anamneseService lança a exceção esperada
            IllegalArgumentException exceptionMessage = assertThrows(IllegalArgumentException.class, () -> {
                anamneseService.save(anamnese);
            });

            // Verificando a mensagem da exceção
            String expectedMessage = "Object cannot be empty";
            String actualMessage = exceptionMessage.getMessage();
            assert(expectedMessage.equals(actualMessage));


            //PODE SE REALIZAR DA FORMA ABAIXO OU DA DE CIMA, AMBAS TERÃO O MESMO EFEITO
            assertThrows(IllegalArgumentException.class, () -> {
                anamneseService.save(anamnese);
            }, "Object cannot be empty");
        }

        @Test
        void findById() {
            when(anamneseRepository.findById(anyInt())).thenReturn(anamneseOptional);

            Anamnese response = anamneseService.findById(anamnese.getId());

            assertEquals(Anamnese.class, response.getClass());
        }

        @Test
        void testFindByIdNotFoundException(){
            when(anamneseRepository.findById(anyInt())).thenThrow(new ResourceNotFoundException("Anamnese not found."));
                //Pode ser feito desta maneira
            try{
                anamneseService.findById(anamnese.getId());
            } catch (Exception e) {
                assertEquals(ResourceNotFoundException.class, e.getClass());
                assertEquals("Anamnese not found.", e.getMessage());
            }
                //OU PODE SER FEITO DESTA MANEIRA, AMBAS POSSUEM O MESMO EFEITO
            assertThrows(ResourceNotFoundException.class, () -> {
                anamneseService.findById(anamnese.getId());
            }, "Anamnese not found.");
        }

        @Test
        void findAll() {
            when(anamneseRepository.findAll()).thenReturn(List.of(anamnese));

            List<Anamnese> anamneseList = anamneseService.findAll();
            assertNotNull(anamneseList);
            assertEquals(1, anamneseList.size());
            assertEquals(Anamnese.class, anamneseList.get(0).getClass());
        }

        @Test
        void update() {
            when(anamneseRepository.save(any())).thenReturn(anamnese);

            Anamnese anamneseUpdate = anamneseService.update(anamnese);

            assertNotNull(anamneseUpdate);
            assertEquals(Anamnese.class, anamneseUpdate.getClass());

        }


        @Test
        void delete() {
            doNothing().when(anamneseRepository).delete(any());

            anamneseService.delete(anamnese);
            verify(anamneseRepository, times(1)).delete(anamnese);
        }

        private void startUser(){
            Date data = new Date();
            anamnese = new Anamnese(1, data,
                    1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                    1.0f, 1.0f, 1.0f, 1.0f);

            anamneseOptional = Optional.of(new Anamnese(1, data,
                    1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                    1.0f, 1.0f, 1.0f, 1.0f));
        }
    }