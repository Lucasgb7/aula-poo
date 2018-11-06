package lucas.aula.br.a05controleabastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        setContentView(R.layout.activity_main);
        ArrayList<Abastecimento> abastecimentos =  new ArrayList<Abastecimento>();
        abastecimentos = ListaPostosDAO.getLista(this.getApplicationContext());
        if(abastecimentos.size()>1){
            double autonomia;
            double kmRodados;
            double litrosTotais = 0;

            kmRodados = abastecimentos.get(abastecimentos.size()-1).getKilometros() - abastecimentos.get(0).getKilometros();
            for (int i = 0; i < abastecimentos.size()-1; i++) {
                litrosTotais += abastecimentos.get(i).getLitros();
            }
            autonomia = kmRodados/litrosTotais;
            TextView tvAutonomiaResultado = findViewById(R.id.tvAutonomiaResultado);
            tvAutonomiaResultado.setText(format("%.2f", autonomia));
        }
    }
    public void historico(View view) {
        Intent intent = new Intent(this.getApplicationContext(), ListaPostos.class);
        startActivity(intent);
    }
}