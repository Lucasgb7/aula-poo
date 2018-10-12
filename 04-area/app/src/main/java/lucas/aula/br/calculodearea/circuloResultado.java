package lucas.aula.br.calculodearea;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class circuloResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_resultado);

        double diametro = this.getIntent().getDoubleExtra("diametro", -1);
        double areaCirculo = (3.141592653589793) / ((diametro/2) * (diametro/2));

        TextView tvAreaCirculo = findViewById(R.id.tvAreaCirculo);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvAreaCirculo.setText(nf.format(areaCirculo));
    }
}
