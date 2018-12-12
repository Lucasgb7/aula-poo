package lucas.aula.br.a05controleabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PostoDetalhes extends AppCompatActivity {
    private Abastecimento abastecimento;
    private ImageView ivPosto;
    private TextView tvData;
    private TextView tvKm;
    private TextView tvLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Cheguei aqui");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posto_detalhes);

        ivPosto = findViewById(R.id.ivPosto);
        tvKm = findViewById(R.id.tvKMAbastecimento);
        tvLitros = findViewById(R.id.tvLitrosAbastecidos);
        tvData = findViewById(R.id.tvDataAbastecimento);

        this.abastecimento = (Abastecimento) getIntent().getSerializableExtra("abastecimento");
        String posto = abastecimento.getPosto();
        String km = String.valueOf(abastecimento.getKilometros()) + " km";
        String litros = String.valueOf(abastecimento.getLitros()) + " L";

        tvData.setText(abastecimento.getData());
        tvKm.setText(km);
        tvLitros.setText(litros);
        if(posto.equals("Outro")) {
            ivPosto.setImageResource(R.drawable.gas_station);
        }else if(posto.equals("Ipiranga")){
            ivPosto.setImageResource(R.drawable.ipiranga);
        }else if(posto.equals("Petrobras")){
            ivPosto.setImageResource(R.drawable.petrobras);
        }else if(posto.equals("Shell")){
            ivPosto.setImageResource(R.drawable.shell);
        }else{
            ivPosto.setImageResource(R.drawable.texaco);
        }
    }
}
