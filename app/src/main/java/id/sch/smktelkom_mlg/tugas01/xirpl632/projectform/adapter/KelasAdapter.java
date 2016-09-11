package id.sch.smktelkom_mlg.tugas01.xirpl632.projectform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.tugas01.xirpl632.projectform.R;

/**
 * Created by -asus- on 9/11/2016.
 */
public class KelasAdapter extends ArrayAdapter<String> {

    String mkelas = "";

    public KelasAdapter(Context context, ArrayList<String> listkls) {
        super(context, R.layout.row_spinner_kelas, listkls);
    }

    public void setkelas(String kelas) {
        this.mkelas = kelas;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_kelas, parent, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0, 1));
        TextView tvkls = (TextView) view.findViewById(R.id.textViewkls);
        tvkls.setText(getItem(position));
        TextView tvKelas = (TextView) view.findViewById(R.id.textViewKelas);
        tvKelas.setText(mkelas);

        return view;
    }
}

