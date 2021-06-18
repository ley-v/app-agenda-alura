package alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import alura.agenda.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
    return new ArrayList<>(alunos);
    }
}
