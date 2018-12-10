package lucas.aula.br.a05controleabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdicionarAbastecimento extends AppCompatActivity {

    private String postos[] = new String[]{"Outro", "Petrobras", "Ipiranga", "Shell", "Texaco"};
    private Spinner sPostos;
    private EditText etKmAtual;
    private EditText etLitrosAbastecidos;
    private EditText etData;
    private double kmRodados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, postos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.kmRodados = this.getIntent().getDoubleExtra("kmRodados", -1);
        sPostos = (Spinner) findViewById(R.id.sPostos);
        sPostos.setAdapter(adapter);
        etKmAtual = findViewById(R.id.etKmAtual);
        etLitrosAbastecidos = findViewById(R.id.etLitros);
        etData = findViewById(R.id.etData);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        etData.setText(formatter.format(date));
    }

    public void salvarAbastecimento(View view) {
        Abastecimento abastecimento = new Abastecimento();

        if (etKmAtual.getText().toString().equals("")) {
            this.etKmAtual.setError("Campo obrigatório");
            return;
        }
        if (etLitrosAbastecidos.getText().toString().equals("")) {
            this.etLitrosAbastecidos.setError("Campo obrigatório");
            return;
        }
        if (etData.getText().toString().equals("")) {
            this.etData.setError("Campo obrigatório");
            return;
        }
        if (Double.parseDouble(etKmAtual.getText().toString()) <= this.kmRodados) {
            this.etKmAtual.setError("KM atual deve ser maior que os KM rodados");
            return;
        }

        abastecimento.setKilometros(Double.parseDouble(etKmAtual.getText().toString()));
        abastecimento.setLitros(Double.parseDouble(etLitrosAbastecidos.getText().toString()));
        abastecimento.setData(etData.getText().toString());
        abastecimento.setPosto(sPostos.getSelectedItem().toString());
        boolean abastecimentoSalvo = ListaPostosDAO.salvar(this.getApplicationContext(), abastecimento);

        if (abastecimentoSalvo) {
            setResult(1);
            finish();
        } else {
            Toast.makeText(this.getApplicationContext(), "Não foi possível salvar", Toast.LENGTH_SHORT).show();
        }
    }
}
