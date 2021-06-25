package alura.agenda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import alura.agenda.database.dao.RoomAlunoDAO;
import alura.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {
    public abstract RoomAlunoDAO getRoomAlunoDAO();

}
