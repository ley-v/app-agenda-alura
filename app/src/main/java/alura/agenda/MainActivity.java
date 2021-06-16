package alura.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int activity_main = R.layout.activity_main;
        Toast.makeText(this, String.valueOf(activity_main), Toast.LENGTH_LONG).show();
        setContentView(activity_main);

        List<String> alunos = new LinkedList<>(Arrays.asList("Milly", "Joabson", "Hazel", "brit"));

        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }

}
