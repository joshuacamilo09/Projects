package org.rest.to_do_list.Controller;

import org.rest.to_do_list.Model.Tarefa;
import org.rest.to_do_list.Service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TarefaController
{
    private TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService)
    {
        this.tarefaService = tarefaService;
    }

    @PostMapping(value = "/createWork")
    public String createTarefa (@RequestBody Tarefa tarefa)
    {
        tarefaService.save(tarefa);
        return "The assignment was created successfully";
    }

    @PutMapping(value = "/editWork/{id}")
    public String editTarefa (@PathVariable Long id , @RequestBody Tarefa tarefa)
    {
        Tarefa updatetarefa = tarefaService.findById(id).get();
        return "The assignment was updated successfully";
    }

    @DeleteMapping("/deleteWork/{id}")
    public ResponseEntity<String> deleteTarefa(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.findById(id);
        if (tarefa.isPresent()) {
            tarefaService.delete(id);
            return ResponseEntity.ok("The assignment was deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assignment not found");
        }
    }

}
