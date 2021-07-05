package alura.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import alura.agenda.database.dao.TelefoneDAO;
import alura.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneDoAluoTask extends AsyncTask<Void, Void, Telefone> {
    private TelefoneDAO dao;
    private TextView campoTelefone;
    private int alunoId;

    public BuscaPrimeiroTelefoneDoAluoTask(TelefoneDAO dao,TextView telefone, int alunoId) {
        this.dao = dao;
        this.alunoId = alunoId;
        this.campoTelefone = telefone;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return dao.buscaPrimeiroTelefoneDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        if (primeiroTelefone != null) campoTelefone.setText(primeiroTelefone.getNumero());

    }
}
