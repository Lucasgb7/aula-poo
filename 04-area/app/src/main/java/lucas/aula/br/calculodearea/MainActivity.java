package lucas.aula.br.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAvancar(View v){
        RadioGroup rgFigura = findViewById(R.id.rgFigura);

        try{
            if (rgFigura.getCheckedRadioButtonId() == R.id.rdCirculo){
                Intent intencaoAbrirTelaCirculo = new Intent(this.getApplicationContext(), circuloPasso1.class);
                this.startActivity(intencaoAbrirTelaCirculo);
            }
            if (rgFigura.getCheckedRadioButtonId() == R.id.rdRetangulo){
                Intent intencaoAbrirTelaRetangulo = new Intent(this.getApplicationContext(), retanguloPasso1.class);
                this.startActivity(intencaoAbrirTelaRetangulo);
            }
            if (rgFigura.getCheckedRadioButtonId() == R.id.rdTriangulo) {
                Intent intencaoAbrirTelaTriangulo = new Intent(this.getApplicationContext(), trianguloPasso1.class);
                this.startActivity(intencaoAbrirTelaTriangulo);
            }
        }catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
        }
    }
}
