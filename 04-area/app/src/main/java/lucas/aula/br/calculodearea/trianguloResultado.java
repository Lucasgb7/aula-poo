package lucas.aula.br.calculodearea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class trianguloResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_resultado);

        double alturaTriangulo = this.getIntent().getDoubleExtra("alturaTriangulo", -1);
        double baseTriangulo = this.getIntent().getDoubleExtra("baseTriangulo", -1);
        double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2 ;

        TextView tvAreaTriangulo = findViewById(R.id.tvAreaTriangulo);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvAreaTriangulo.setText(nf.format(areaTriangulo));
    }
}
