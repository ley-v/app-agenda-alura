package alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alura.agenda.R;
import alura.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {
    final List<Aluno> alunos = new ArrayList<>();
    private final Context contexto;

    public ListaAlunosAdapter(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = criaView(parent);
        Aluno alunoDevolvido = alunos.get(position);
        vincula(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vincula(View viewCriada, Aluno alunoDevolvido) {
        TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
        nome.setText(alunoDevolvido.getNomeCompleto());
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
        telefone.setText(alunoDevolvido.getTelefone());
    }

    private View criaView(ViewGroup parent) {
        return LayoutInflater.from(contexto).inflate(R.layout.item_aluno, parent, false);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }

    public void atualiza(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }
}
