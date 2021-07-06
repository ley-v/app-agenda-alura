package alura.agenda.asynctask;

import android.os.AsyncTask;

import java.util.List;

import alura.agenda.database.dao.TelefoneDAO;
import alura.agenda.model.Aluno;
import alura.agenda.model.Telefone;

public class BuscaTodosOsTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {
    private TelefoneDAO telefoneDAO;
    private Aluno aluno;
    private TelefonesDoAlunoEncontradoListener listener;

    public BuscaTodosOsTelefonesDoAlunoTask(TelefoneDAO telefoneDAO, Aluno aluno,
                                            TelefonesDoAlunoEncontradoListener listener) {
        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {
        return telefoneDAO.buscaTodosOsTelefonesDoAluno(aluno.getId());
    }

    @Override
    protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        listener.quandoEncontrados(telefones);
    }

    public interface TelefonesDoAlunoEncontradoListener{
        void quandoEncontrados(List<Telefone> telefones);
    }
}
