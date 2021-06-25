package alura.agenda;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import alura.agenda.dao.AlunoDAO;
import alura.agenda.database.AgendaDatabase;
import alura.agenda.database.dao.RoomAlunoDAO;
import alura.agenda.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AgendaDatabase database = Room.databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .allowMainThreadQueries()
                .build();
        RoomAlunoDAO dao = database.getRoomAlunoDAO();

        dao.salvar(new Aluno("Milly", "111", "milly@gmail.com"));
        dao.salvar(new Aluno("Britt", "222", "britt@gmail.com"));

    }
}
