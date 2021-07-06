package alura.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import alura.agenda.database.dao.TelefoneDAO;
import alura.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneDoAluoTask extends AsyncTask<Void, Void, Telefone> {
    private TelefoneDAO dao;
    private PrimeiroTelefoneEncontradoListener listener;
    private int alunoId;

    public BuscaPrimeiroTelefoneDoAluoTask(TelefoneDAO dao, int alunoId, PrimeiroTelefoneEncontradoListener listener) {
        this.dao = dao;
        this.alunoId = alunoId;
        this.listener = listener;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return dao.buscaPrimeiroTelefoneDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        listener.quandoEncontrado(primeiroTelefone);


    }

    public interface PrimeiroTelefoneEncontradoListener{
        void quandoEncontrado(Telefone telefoneEncontrado);
    }
}
