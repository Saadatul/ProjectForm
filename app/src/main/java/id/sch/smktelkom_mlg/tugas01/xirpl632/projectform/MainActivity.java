package id.sch.smktelkom_mlg.tugas01.xirpl632.projectform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkom_mlg.tugas01.xirpl632.projectform.adapter.KelasAdapter;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Spinner spkelas, spkls;
    RadioButton rbM, rbO, rbP, rbC;
    CheckBox cbMe, cbMa, cbPa, cbBd, cbCo, cbMt;
    Button bOK;
    TextView tvHasil;
    TextView tvKelas;
    TextView tvOr;
    TextView tvSub;

    String[][] arkls = {{"X TKJ 1", "X TKJ 2", "X TKJ 3", "X TKJ 4", "X TKJ 5", "X TKJ 6"},
            {"X RPL 1", "X RPL 2", "X RPL 3", "X RPL 3", "X RPL 4", "X RPL 5", "X RPL 6"}};
    ArrayList<String> listkls = new ArrayList<>();
    KelasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        spkelas = (Spinner) findViewById(R.id.spinnerkelas);
        spkls = (Spinner) findViewById(R.id.spinnerkls);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvKelas = (TextView) findViewById(R.id.textViewKelas);

        rbM = (RadioButton) findViewById(R.id.radioButtonM);
        rbO = (RadioButton) findViewById(R.id.radioButtonO);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rbC = (RadioButton) findViewById(R.id.radioButtonC);
        tvOr = (TextView) findViewById(R.id.textViewOr);

        cbMe = (CheckBox) findViewById(R.id.checkBoxMe);
        cbMa = (CheckBox) findViewById(R.id.checkBoxMa);
        cbPa = (CheckBox) findViewById(R.id.checkBoxPa);
        cbBd = (CheckBox) findViewById(R.id.checkBoxBd);
        cbCo = (CheckBox) findViewById(R.id.checkBoxCo);
        cbMt = (CheckBox) findViewById(R.id.checkBoxMt);
        tvSub = (TextView) findViewById(R.id.textViewSub);

        adapter = new KelasAdapter(this, listkls);
        spkls.setAdapter(adapter);

        spkelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listkls.clear();
                listkls.addAll(Arrays.asList(arkls[pos]));
                adapter.setkelas((String) spkelas.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                spkls.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                tvKelas.setText("Anda dari kelas " + spkls.getSelectedItem().toString());
                String Or = null;

                if (rbM.isChecked()) {
                    Or = rbM.getText().toString();
                } else if (rbM.isChecked()) {
                    Or = rbM.getText().toString();
                } else if (rbO.isChecked()) {
                    Or = rbO.getText().toString();
                } else if (rbP.isChecked()) {
                    Or = rbP.getText().toString();
                } else if (rbC.isChecked()) {
                    Or = rbC.getText().toString();
                }
                if (Or == null) {
                    tvOr.setText("Anda belum memilih Organisasi");
                } else {
                    tvOr.setText("Anda mendaftar Organisasi " + Or);
                }

                String Sub = "Anda mendaftar Sub-Organisasi :\n";
                int startlen = Sub.length();
                if (cbMe.isChecked()) Sub += cbMe.getText() + "\n";
                if (cbMa.isChecked()) Sub += cbMa.getText() + "\n";
                if (cbPa.isChecked()) Sub += cbPa.getText() + "\n";
                if (cbCo.isChecked()) Sub += cbCo.getText() + "\n";
                if (cbMt.isChecked()) Sub += cbMt.getText() + "\n";

                if (Sub.length() == startlen) Sub += "Anda belum memilih Sub-Organisasi";
                tvSub.setText(Sub);

            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("Selamat bergabung " + nama);
        }
    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }
}

