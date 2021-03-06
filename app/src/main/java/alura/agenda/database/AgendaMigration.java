package alura.agenda.database;

import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import alura.agenda.model.TipoTelefone;

class AgendaMigration {

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Aluno ADD COLUMN sobrenome TEXT");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // criar nova tabela com as informações desejadas
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`nome` TEXT, `telefone` TEXT, `email` TEXT)");
            //copiar dados d atabela antiga para a nova
            database.execSQL("INSERT INTO Aluno_novo (id, nome, telefone, email)" +
                    "SELECT id, nome || ' ' || sobrenome, telefone, email FROM Aluno");
            //remover tabela antiga
            database.execSQL("DROP TABLE Aluno");
            //renomear a tabela nova com o nome da tabela antiga
            database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Aluno ADD COLUMN momentoDeCadastro INTEGER");
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`nome` TEXT, " +
                    "`telefoneFixo` TEXT, " +
                    "`telefoneCelular` TEXT, " +
                    "`email` TEXT, " +
                    "`momentoDeCadastro` INTEGER)");
            database.execSQL("INSERT INTO Aluno_novo (id, nome, telefoneFixo, email, momentoDeCadastro)" +
                    "SELECT id, nome, telefone, email, momentoDeCadastro FROM Aluno");
            database.execSQL("DROP TABLE Aluno");
            database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
        }
    };

    private static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_novo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`nome` TEXT, `email` TEXT, `momentoDeCadastro` INTEGER)");
            database.execSQL("INSERT INTO Aluno_novo (id, nome, email, momentoDeCadastro)" +
                    "SELECT id, nome, email, momentoDeCadastro FROM Aluno");

            database.execSQL("CREATE TABLE IF NOT EXISTS `Telefone` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`numero` TEXT, `tipo` TEXT, `alunoId` INTEGER NOT NULL)");
            database.execSQL("INSERT INTO Telefone (numero, alunoId)" +
                    "SELECT telefoneFixo, id FROM Aluno");

            database.execSQL("UPDATE Telefone SET tipo = ?", new TipoTelefone[]{TipoTelefone.FIXO});

            // migrando telefoneFixo e telefoneCelular
//            Cursor cursor = database.query("SELECT id, telefoneFixo, telefoneCelular FROM Aluno");
//            if (cursor != null) {
//                if (cursor.moveToFirst()) {
//                    do {
//                        String idAluno = cursor.getString(cursor.getColumnIndex("id"));
//                        String telefoneFixo = cursor.getString(cursor.getColumnIndex("telefoneFixo"));
//                        String telefoneCelular = cursor.getString(cursor.getColumnIndex("telefoneCelular"));
//                        if (telefoneFixo != null) {
//                            // Insere Telefone Fixo
//                            database.execSQL("INSERT INTO Telefone (numero, tipo, alunoId) " +
//                                    "VALUES ('" + telefoneFixo + "', '" + String.valueOf(TipoTelefone.FIXO) + "', " + idAluno + ")");
//                        }
//                        if (telefoneCelular != null) {
//                            // Insere Telefone Celular
//                            database.execSQL("INSERT INTO Telefone (numero, tipo, alunoId) " +
//                                    "VALUES ('" + telefoneCelular + "', '" + String.valueOf(TipoTelefone.CELULAR) + "', " + idAluno + ")");
//                        }
//                    } while (cursor.moveToNext());
//                }
//            }

            database.execSQL("DROP TABLE Aluno");
            database.execSQL("ALTER TABLE Aluno_novo RENAME TO Aluno");
        }
    };
    static final Migration[] TODAS_MIGRATIONS = {MIGRATION_1_2,
            MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6};
}
