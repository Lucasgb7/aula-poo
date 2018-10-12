package lucas.aula.br.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class retanguloPasso1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo_passo1);
    }
    public void onClickAvancar(View v){
        EditText etAlturaRetangulo = findViewById(R.id.etAlturaRetangulo);
        EditText etBaseRetangulo = findViewById(R.id.etBaseRetangulo);

        double alturaRetangulo = Double.parseDouble(etAlturaRetangulo.getText().toString());
        double baseRetangulo = Double.parseDouble(etBaseRetangulo.getText().toString());

        Intent intencaoAbrirCirculoResultado = new Intent(this.getApplicationContext(), retanguloResultado.class);

        intencaoAbrirCirculoResultado.putExtra("alturaRetangulo", alturaRetangulo);
        intencaoAbrirCirculoResultado.putExtra("baseRetangulo", baseRetangulo);

        this.startActivity(intencaoAbrirCirculoResultado);
    }
}
