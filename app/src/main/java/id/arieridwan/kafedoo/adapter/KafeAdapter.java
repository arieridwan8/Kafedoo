package id.arieridwan.kafedoo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.arieridwan.kafedoo.DetailActivity;
import id.arieridwan.kafedoo.R;
import id.arieridwan.kafedoo.model.DATum;

public  class KafeAdapter extends RecyclerView.Adapter<KafeAdapter.ViewHolder> {
    private List<DATum> mKafeList;
    private LayoutInflater mInflater;
    private Context mContext;

    public KafeAdapter(Context context , List<DATum> dataList) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mKafeList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = mInflater.inflate(R.layout.item_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_KAFE, mKafeList.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DATum kafe = mKafeList.get(position);
        Picasso.with(mContext)
                .load(kafe.getUrl_foto())
                .centerCrop()
                .resize(600, 400)
                .into(holder.foto);
        holder.nama.setText(kafe.getNama());
        holder.alamat.setText(kafe.getAlamat());
    }

    @Override
    public int getItemCount() {
        return (mKafeList == null) ? 0 : mKafeList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView foto;
        public TextView nama,alamat;
        public ViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nama = (TextView)itemView.findViewById(R.id.nama);
            alamat = (TextView)itemView.findViewById(R.id.alamat);
        }
    }
}