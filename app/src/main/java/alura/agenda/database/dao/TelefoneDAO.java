package alura.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import alura.agenda.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT t.* FROM Telefone t " +
            "INNER JOIN Aluno a ON t.alunoId = a.id " +
            "WHERE t.alunoId = :alunoId " +
            "LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);
}
