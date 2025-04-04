package thebao.edu.phanthebao_64130132;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> listDataLand;

    public LandScapeAdapter(Context context, ArrayList<LandScape> listDataLand) {
        this.context = context;
        this.listDataLand = listDataLand;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewHolderCre = new ItemLandHolder(view);
        return viewHolderCre;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lấy đối tượng hiển thị
        LandScape landScapeHienThi = listDataLand.get(position);

        // Đặt nội dung cho caption
        holder.textCaption.setText(landScapeHienThi.getLandCation());

        // Đặt ảnh trực tiếp, KHÔNG CẦN getIdentifier()
        holder.imageViewLand.setImageResource(landScapeHienThi.getLandImageFileName());


        holder.info.setText(landScapeHienThi.getThongtin());
    }

    @Override
    public int getItemCount() {
        return listDataLand.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textCaption, info;
        ImageView imageViewLand;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            textCaption = itemView.findViewById(R.id.textViewCaption);
            imageViewLand = itemView.findViewById(R.id.imageViewLand);
            info = itemView.findViewById(R.id.textViewThongtin);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int viTriduocChon = getAdapterPosition();
            LandScape phanTuduocChon = listDataLand.get(viTriduocChon);
            String ten  = phanTuduocChon.getLandCation();
            int tenFile = phanTuduocChon.getLandImageFileName();
            String chuoiThongbao = "Bạn vừa chọn: " + ten;
            Toast.makeText(v.getContext(),chuoiThongbao,Toast.LENGTH_LONG).show();
        }
    }
}


