package lucas.aula.br.a03_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.format;

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
            for (i = 1; i <= convidados; i++){
                if (i % 10 == 0){
                    if (convidados>10) {
                        qtdGuardanapos++;
                        qtdCopos++;
                    }
                }
            }
            for (i = 1; i <= qtdTotalCarnes; i++){
                if (i % 5 == 0){
                    if(qtdTotalCarnes>5) {
                        qtdCarvao++;
                    }
                }
            }
            frango.setText( format("Frango: %.2f kg", qtdFrango));
            suino.setText( format("Suino: %.2f kg", qtdSuino));
            bovino.setText( format("Bovino: %.2f kg", qtdBovino));
            linguicas.setText( format("Linguiça: %.2f kg", qtdLinguicas));
            totalCarnes.setText( format("TOTAL: %.2f KG", qtdTotalCarnes));
            cerveja.setText( format("Cerveja: %.2f Litro(s)", qtdCerveja));
            refrigerante.setText( format("Refrigerante: %.2f Litro(s)", qtdRefrigerante));
            paes.setText( format("Pães: %.2f Unidade(s)", qtdPaes));
            guardanapos.setText( format("Guardanapos: %.2f pacote(s) com 50 unidades", qtdGuardanapos));
            copos.setText( format("Copos: %.2f pacote(s) com 50 unidades", qtdCopos));
            carvao.setText( format("Carvão: %.2f pacote(s) de 5kg", qtdCarvao));

            result.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Preencha os convidados", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }
}
