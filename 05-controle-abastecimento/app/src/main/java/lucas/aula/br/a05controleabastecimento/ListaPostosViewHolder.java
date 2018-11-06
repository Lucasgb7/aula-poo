package lucas.aula.br.a05controleabastecimento;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaPostosViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPosto;
        private TextView tvData;
        private TextView tvKm;
        private TextView tvLitros;

        public ListaPostosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivPosto = itemView.findViewById(R.id.ivPosto);
            this.tvData = itemView.findViewById(R.id.tvData);
            this.tvKm = itemView.findViewById(R.id.tvKm);
            this.tvLitros = itemView.findViewById(R.id.tvLitros);
        }

        public void atualizaGaveta(Abastecimento objeto){
            String km = "KM: " + String.valueOf(objeto.getKilometros());
            String litros = String.valueOf(objeto.getLitros()) + " L";
            String posto = objeto.getPosto();

            this.tvData.setText(objeto.getData());
            this.tvKm.setText(km);
            this.tvLitros.setText(litros);

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