package alura.agenda.asynctask;

import android.os.AsyncTask;

import alura.agenda.database.dao.AlunoDAO;
import alura.agenda.model.Aluno;
import alura.agenda.ui.ListaAlunosView;
import alura.agenda.ui.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask<Void, Void, Void> {
    private AlunoDAO dao;
    private Aluno aluno;
    private ListaAlunosAdapter adapter;

    public RemoveAlunoTask(AlunoDAO dao, Aluno aluno, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.aluno = aluno;
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remover(aluno);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        adapter.remove(aluno);

    }
}
