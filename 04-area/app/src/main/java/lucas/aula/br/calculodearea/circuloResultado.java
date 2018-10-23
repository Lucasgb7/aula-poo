package lucas.aula.br.calculodearea;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circuloResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_resultado);

        double diametro = this.getIntent().getDoubleExtra("diametro", -1);
        double areaCirculo = (Math.PI) * ((diametro/2) * (diametro/2));

        TextView tvAreaCirculo = findViewById(R.id.tvAreaCirculo);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvAreaCirculo.setText(nf.format(areaCirculo) + " cm²");
    }

    public void onClickVoltar(View v) {
        Intent intencaoAbrirInicio = new Intent(this.getApplicationContext(), MainActivity.class);
        intencaoAbrirInicio.addFlags(intencaoAbrirInicio.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intencaoAbrirInicio);
    }
}
