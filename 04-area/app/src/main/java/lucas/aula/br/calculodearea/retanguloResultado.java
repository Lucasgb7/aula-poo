package lucas.aula.br.calculodearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class retanguloResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo_resultado);

        double alturaRetangulo = this.getIntent().getDoubleExtra("alturaRetangulo", -1);
        double baseRetangulo = this.getIntent().getDoubleExtra("baseRetangulo", -1);
        double areaRetangulo = (baseRetangulo * alturaRetangulo);

        TextView tvAreaRetangulo = findViewById(R.id.tvAreaRetangulo);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvAreaRetangulo.setText(nf.format(areaRetangulo) + " cm²");
    }
    public void onClickVoltar(View v) {
        Intent intencaoAbrirInicio = new Intent(this.getApplicationContext(), MainActivity.class);
        intencaoAbrirInicio.addFlags(intencaoAbrirInicio.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intencaoAbrirInicio);
    }
}
