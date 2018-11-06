
package lucas.aula.br.a05controleabastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class ListaPostos extends AppCompatActivity {
    private final int ABASTECER = 1234;
    private ListaPostosAdapter adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postos);

        RecyclerView rvListaAbastecimento = findViewById(R.id.rvListaPostos);

        this.adapater = new ListaPostosAdapter();
        this.adapater.listaPostos = ListaPostosDAO.getLista(this.getApplicationContext());

        rvListaAbastecimento.setAdapter(this.adapater);
        rvListaAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB(View view) {
        Intent intent =  new Intent(this.getApplicationContext(), AdicionarAbastecimento.class);
        if(this.adapater.listaPostos.size()>0) {
            intent.putExtra("kmRodados", this.adapater.listaPostos.get(this.adapater.listaPostos.size() - 1).getKilometros());
        }
        startActivityForResult(intent, ABASTECER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ABASTECER) {
            if (resultCode == 1) {
                //Toast.makeText(this.getApplicationContext(), "AÇÃO 1!!!!!", Toast.LENGTH_LONG).show();
                this.adapater.notifyDataSetChanged();
            } else {
                Toast.makeText(this.getApplicationContext(), "Erro 1", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this.getApplicationContext(), "Erro 2", Toast.LENGTH_SHORT).show();
        }
    }
}
