package org.rest.to_do_list.Repository;

import org.rest.to_do_list.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepo extends JpaRepository<Tarefa, Long> {}
