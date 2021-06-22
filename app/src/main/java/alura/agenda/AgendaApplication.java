package alura.agenda;

import android.app.Application;

import alura.agenda.dao.AlunoDAO;
import alura.agenda.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(new Aluno("Milly", "111", "milly@gmail.com"));
        dao.salvar(new Aluno("Britt", "222", "britt@gmail.com"));

    }
}
