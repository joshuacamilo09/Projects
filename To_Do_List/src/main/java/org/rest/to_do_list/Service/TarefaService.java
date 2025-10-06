package org.rest.to_do_list.Service;

import jakarta.transaction.Transactional;
import org.rest.to_do_list.Model.Tarefa;
import org.rest.to_do_list.Repository.TarefaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TarefaService
{
    @Autowired
    private TarefaRepo tarefaRepo;

    public void save(Tarefa tarefa)
    {
        tarefaRepo.save(tarefa);
    }

    public Optional<Tarefa> findById(Long id)
    {
        return Optional.ofNullable(tarefaRepo.findById(id).orElse(null));
    }

    public void delete(Long id)
    {
        tarefaRepo.deleteById(id);
    }

    @Transactional
    public Tarefa tarefa (Long tarefaId,Tarefa novatarefa)
    {
        Tarefa tarefa =  tarefaRepo.findById(tarefaId)
            .orElseThrow(() -> new RuntimeException("Assignment not found") );

        tarefa.setTrabalho(novatarefa.getTrabalho());
        tarefa.setLazer(novatarefa.getLazer());
        tarefa.setEstudo(novatarefa.getEstudo());

        tarefa.setPrazo(LocalDate.of(2025, 12, 30));

        if (LocalDate.now().isBefore(tarefa.getPrazo()))
        {
            tarefa.setStatus("Pendente");
        } else
        {
            tarefa.setStatus("Concluído");
        }

        return tarefaRepo.save(tarefa);
    }
}
