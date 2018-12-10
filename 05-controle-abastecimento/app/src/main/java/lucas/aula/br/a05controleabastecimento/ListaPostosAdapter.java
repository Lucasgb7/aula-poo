package lucas.aula.br.a05controleabastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaPostosAdapter extends RecyclerView.Adapter {
    public ArrayList<Abastecimento> listaPostos;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        // Inflando o XML
        View elementoPaiXML = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        ListaPostosViewHolder minhaGaveta = new ListaPostosViewHolder(elementoPaiXML);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // Vestindo uma gaveta
        ListaPostosViewHolder minhaGaveta = (ListaPostosViewHolder) viewHolder;
        Abastecimento daVez = listaPostos.get(i);
        minhaGaveta.atualizaGaveta(daVez);
    }

    @Override
    public int getItemCount() {
        // Total de itens da lista
        return listaPostos.size();
    }
}