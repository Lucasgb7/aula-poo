package lucas.aula.br.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class trianguloPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_passo1);
    }
    public void onClickAvancar(View v){
        EditText etAlturaTriangulo = findViewById(R.id.etAlturaTriangulo);
        EditText etBaseTriangulo = findViewById(R.id.etBaseTriangulo);

        double alturaTriangulo = Double.parseDouble(etAlturaTriangulo.getText().toString());
        double baseTriangulo = Double.parseDouble(etBaseTriangulo.getText().toString());

        Intent intencaoAbrirCirculoResultado = new Intent(this.getApplicationContext(), trianguloResultado.class);

        intencaoAbrirCirculoResultado.putExtra("alturaTriangulo", alturaTriangulo);
        intencaoAbrirCirculoResultado.putExtra("baseTriangulo", baseTriangulo);

        this.startActivity(intencaoAbrirCirculoResultado);
    }
}
