package lucas.aula.br.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class circuloPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_passo1);
    }
    public void onClickAvancar(View v){
        EditText etDiametro = findViewById(R.id.etDiametro);
        double diametro = Double.parseDouble(etDiametro.getText().toString());

        Intent intencaoAbrirCirculoResultado = new Intent(this.getApplicationContext(), circuloResultado.class);

        intencaoAbrirCirculoResultado.putExtra("diametro", diametro);
        this.startActivity(intencaoAbrirCirculoResultado);
    }
}
