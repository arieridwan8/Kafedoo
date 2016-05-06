package id.arieridwan.kafedoo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.arieridwan.kafedoo.R;
import id.arieridwan.kafedoo.model.DetailFasilitas;


public class FasilitasAdapter extends ArrayAdapter<DetailFasilitas> {

    private Context context;
    private ArrayList<DetailFasilitas> flowerList;
    public FasilitasAdapter(Context context, int resource, ArrayList<DetailFasilitas> objects) {
        super(context, resource, objects);
        this.context = context;
        this.flowerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fasilitas,parent,false);
        final DetailFasilitas flower = flowerList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.tvFasilitas);
        tv.setText(flower.getNama());
        return view;
    }
}

