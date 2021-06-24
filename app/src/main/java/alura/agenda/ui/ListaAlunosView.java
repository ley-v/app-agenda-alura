package alura.agenda.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import alura.agenda.dao.AlunoDAO;
import alura.agenda.model.Aluno;
import alura.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {
    private final Context context;
    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(this.context);
        dao = new AlunoDAO();
    }


    public void confirmaRemocao(MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Remoção de aluno")
                .setMessage("Confirma a remoção do aluno?")
                .setNegativeButton("não", null)
                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                        remove(alunoEscolhido);
                    }
                })
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    public void remove(Aluno aluno) {
        dao.remover(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
