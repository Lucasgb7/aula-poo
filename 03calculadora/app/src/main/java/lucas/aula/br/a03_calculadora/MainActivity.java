package lucas.aula.br.a03_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calcular(View elementoClicado){
        EditText men = findViewById(R.id.etMen);
        EditText women = findViewById(R.id.etWomen);
        EditText children = findViewById(R.id.etChildren);
        LinearLayout result = findViewById(R.id.llResult);

        String numberMen = men.getText().toString();
        String numberWomen = women.getText().toString();
        String numberChildren = children.getText().toString();

        if(numberMen.equals("") || numberWomen.equals("") || numberChildren.equals("")){
            men.setError("Informe a quantidade de homens");
            women.setError("Informe a quantidade de mulheres");
            children.setError("Informe a quantidade de criancas");
            return;
        }
        TextView frango = findViewById(R.id.tvFrango);
        TextView suino = findViewById(R.id.tvSuino);
        TextView bovino = findViewById(R.id.tvBovino);
        TextView linguicas = findViewById(R.id.tvLinguicas);
        TextView totalCarnes = findViewById(R.id.tvTotalCarnes);
        TextView cerveja = findViewById(R.id.tvCerveja);
        TextView refrigerante = findViewById(R.id.tvRefrigerante);
        TextView paes = findViewById(R.id.tvPaes);
        TextView guardanapos = findViewById(R.id.tvGuardanapos);
        TextView copos = findViewById(R.id.tvCopos);
        TextView carvao = findViewById(R.id.tvCarvao);
        try{
            double nMen = Double.parseDouble(numberMen);
            double nWomen = Double.parseDouble(numberWomen);
            double nChildren = Double.parseDouble(numberChildren);

            double convidados = nMen + nWomen + nChildren;
            double qtdCarne = (nMen*0.5) + (nWomen*0.3) + (nChildren*0.2);

            double qtdFrango = 0;
            double qtdSuino = 0;
            double qtdBovino = 0;
            double qtdLinguicas = 0;
            double qtdTotalCarnes = 0;
            double qtdCerveja = 0;
            double qtdRefrigerante = 0;
            double qtdPaes = 0;
            double qtdGuardanapos = 1;
            double qtdCopos = 1;
            double qtdCarvao = 1;

            int i;
            for (i = 0; i < nMen; i++){
                qtdFrango += 0.05;
                qtdSuino += 0.05;
                qtdBovino += 0.25;
                qtdLinguicas += 0.15;
                qtdTotalCarnes += 0.5;
                qtdCerveja += 0.5;
                qtdRefrigerante += .75;
                qtdPaes += 2;
            }
            for (i = 0; i < nWomen; i++){
                qtdFrango += 0.03;
                qtdSuino += 0.03;
                qtdBovino += 0.15;
                qtdLinguicas += 0.09;
                qtdTotalCarnes += 0.3;
                qtdCerveja += 0.35;
                qtdRefrigerante += 0.5;
                qtdPaes += 1.5;
            }
            for (i = 0; i < nChildren; i++){
                qtdFrango += 0.02;
                qtdSuino += 0.02;
                qtdBovino += 0.1;
                qtdLinguicas += 0.06;
                qtdTotalCarnes += 0.2;
                qtdCerveja += 0.0;
                qtdRefrigerante += 1;
                qtdPaes += 1;
            }
            for (i = 0; i < convidados; i++){
                if (convidados % 10 == 0){
                    qtdGuardanapos++;
                    qtdCopos++;
                }
            }
            for (i = 0; i < qtdTotalCarnes; i++){
                if (qtdTotalCarnes % 5 == 0){
                    qtdCarvao++;
                }
            }
            frango.setText( "Frango: " + qtdFrango + " kg");
            suino.setText( "Suíno: " + qtdSuino + " kg");
            bovino.setText( "Bovino: " + qtdBovino + " kg");
            linguicas.setText( "Linguiças: " + qtdLinguicas + " kg");
            totalCarnes.setText( "Total: " + qtdTotalCarnes + " KG");
            cerveja.setText( "Cerveja: " + qtdCerveja + " Litro(s)");
            refrigerante.setText( "Refrigerante: " + qtdRefrigerante + " Litro(s)");
            paes.setText( "Pães: " + qtdPaes + " Unidade(s)");
            guardanapos.setText( "Guardanapos: " + qtdGuardanapos + " pacote(s) com 50 guardanapos");
            copos.setText( "Copos Descartáveis: " + qtdCopos + " pacote(s) com 50 copos");
            carvao.setText( "Carvão: " + qtdCarvao + " pacote(s) de 5kg");

            result.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Preencha os convidados", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }
}
