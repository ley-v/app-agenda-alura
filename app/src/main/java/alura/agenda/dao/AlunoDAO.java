package alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import alura.agenda.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontado = null;
        for (Aluno a :
                alunos) {
            if (a.getId() == aluno.getId()) alunoEncontado = a;
        }
        if (alunoEncontado != null) {
            int posicao = alunos.indexOf(alunoEncontado);
            alunos.set(posicao, aluno);
        }
    }
}
