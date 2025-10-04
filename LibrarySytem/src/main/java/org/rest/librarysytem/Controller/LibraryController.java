package org.rest.librarysytem.Controller;


import org.rest.librarysytem.Model.Library;
import org.rest.librarysytem.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibraryController
{
    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/ALlBooks")
    public String addBooks()
    {
        List<Library> books = Arrays.asList
                (
                new Library(1L, 42982, "A Lenda", "Francisco Machado"),
                new Library(2L, 42983, "Segredos do Tempo", "Ana Ribeiro"),
                new Library(3L, 42984, "Sombras do Passado", "Carlos Almeida"),
                new Library(4L, 42985, "O Último Guardião", "Beatriz Lopes"),
                new Library(5L, 42986, "Caminhos da Noite", "João Ferreira"),
                new Library(6L, 42987, "Ecos Distantes", "Marta Sousa"),
                new Library(7L, 42988, "Horizontes Perdidos", "Pedro Carvalho"),
                new Library(8L, 42989, "Além do Infinito", "Sofia Martins"),
                new Library(9L, 42990, "Chamas do Destino", "Ricardo Gomes"),
                new Library(10L, 42991, "Som do Silêncio", "Isabel Costa")
        );

        libraryService.saveAll(books);

        return "Livros inseridos dentro do banco de dados com sucesso";
    }
}
