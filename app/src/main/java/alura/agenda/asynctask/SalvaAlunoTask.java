package alura.agenda.asynctask;

import alura.agenda.database.dao.AlunoDAO;
import alura.agenda.database.dao.TelefoneDAO;
import alura.agenda.model.Aluno;
import alura.agenda.model.Telefone;

public class SalvaAlunoTask extends BaseAlunoComTelefoneTask {
    private AlunoDAO alunoDAO;
    private TelefoneDAO telefoneDAO;
    private Telefone telefoneFixo;
    private Telefone telefoneCelular;
    private Aluno aluno;

    public SalvaAlunoTask(AlunoDAO alunoDAO,
                          TelefoneDAO telefoneDAO,
                          Telefone telefoneFixo,
                          Telefone telefoneCelular,
                          Aluno aluno,
                          FinalizadaListener listener) {
        super(listener);
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.aluno = aluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        int alunoId = alunoDAO.salvar(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDAO.salvar(telefoneFixo, telefoneCelular);
        return null;
    }

}
