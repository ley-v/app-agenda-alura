package alura.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import alura.agenda.model.Aluno;

@Dao
public interface AlunoDAO {
    @Insert
    Long salvar(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> todos();

    @Delete
    void remover(Aluno aluno);

    @Update
    void edita(Aluno aluno);
}
