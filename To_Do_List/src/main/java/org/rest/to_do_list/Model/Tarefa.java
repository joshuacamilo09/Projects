package org.rest.to_do_list.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tarefa
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String estudo;

    @Column
    private String Trabalho;

    @Column
    private String Lazer;

    @Column
    private String Status;

    @Column
    private LocalDate prazo;

    @PrePersist
    public void prePersist()
    {
        if (prazo == null) prazo = LocalDate.of(2025, 12, 30);
        if (Status == null) Status = LocalDate.now().isBefore(prazo) ? "Pendente" : "Concluído";
    }

    public void setStatus(String status) {this.Status = status;}

    public LocalDate getPrazo()
    {
        return prazo;
    }
    public void setPrazo(LocalDate prazo)
    {
        this.prazo = prazo;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getEstudo() {
        return estudo;
    }
    public void setEstudo(String estudo) {
        this.estudo = estudo;
    }


    public String getTrabalho() {
        return Trabalho;
    }
    public void setTrabalho (String Trabalho){
        this.Trabalho = Trabalho;
    }


    public String getLazer() {
        return Lazer;
    }
    public void setLazer(String Lazer){
        this.Lazer = Lazer;
    }
}
