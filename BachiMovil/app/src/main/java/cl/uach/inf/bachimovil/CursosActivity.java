package cl.uach.inf.bachimovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CursosActivity extends AppCompatActivity {
    String valorRecibido;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        textView = findViewById(R.id.txtCurso);

        Bundle bundle = getIntent().getExtras();
        valorRecibido= getIntent().getStringExtra("key1");

        textView.setText(valorRecibido);


    }
}
