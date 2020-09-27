package com.pucmm.interfazsimple_androidstudio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String detailed_info = "";

    LinearLayout layout_lenguaje, layout_checkboxesLanguage;
    EditText txtField_name, txtField_surname;
    DatePicker date_birth;
    Spinner spn_genre;
    RadioGroup radioGroup_lenguajes;
    RadioButton radioButton_yes, radioButton_no;
    CheckBox checkBox_java, checkBox_js, checkBox_ccpp, checkBox_python, checkBox_goland, checkBox_cshp;
    Button btn_send, btn_reset;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_lenguaje = findViewById(R.id.layout_lenguaje);
        layout_checkboxesLanguage = findViewById(R.id.layout_checkboxesLanguage);

        txtField_name = findViewById(R.id.txtField_name);
        txtField_surname = findViewById(R.id.txtField_surname);
        date_birth = findViewById(R.id.date_birth);
        spn_genre = findViewById(R.id.spn_genre);

        radioGroup_lenguajes = findViewById(R.id.radioGroup_lenguajes);
        radioButton_yes = findViewById(R.id.radioButton_yes);
        radioButton_no = findViewById(R.id.radioButton_no);

        checkBox_java = findViewById(R.id.checkBox_java);
        checkBox_js = findViewById(R.id.checkBox_js);
        checkBox_ccpp = findViewById(R.id.checkBox_ccpp);
        checkBox_python = findViewById(R.id.checkBox_python);
        checkBox_goland = findViewById(R.id.checkBox_goland);
        checkBox_cshp = findViewById(R.id.checkBox_cshp);

        btn_send = findViewById(R.id.btn_send);
        btn_reset = findViewById(R.id.btn_reset);

        date_birth.updateDate(2020, 9, 25);

        radioGroup_lenguajes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId){
                if(radioButton_yes.isChecked()){
                    layout_lenguaje.setVisibility(View.VISIBLE);

                    checkBox_java.setChecked(false);
                    checkBox_js.setChecked(false);
                    checkBox_ccpp.setChecked(false);
                    checkBox_python.setChecked(false);
                    checkBox_goland.setChecked(false);
                    checkBox_cshp.setChecked(false);

                }
                else if(radioButton_no.isChecked()){
                    layout_lenguaje.setVisibility(View.GONE);

                    checkBox_java.setChecked(false);
                    checkBox_js.setChecked(false);
                    checkBox_ccpp.setChecked(false);
                    checkBox_python.setChecked(false);
                    checkBox_goland.setChecked(false);
                    checkBox_cshp.setChecked(false);
                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                txtField_name.getText().clear();
                txtField_surname.getText().clear();
                date_birth.updateDate(2020, 9, 25);
                spn_genre.setSelection(0);
                radioButton_yes.setChecked(true);
                radioButton_no.setChecked(false);
                checkBox_java.setChecked(false);
                checkBox_js.setChecked(false);
                checkBox_ccpp.setChecked(false);
                checkBox_python.setChecked(false);
                checkBox_goland.setChecked(false);
                checkBox_cshp.setChecked(false);
            }
        });


    }


    public void sendInfo(View view){
        Intent intent = new Intent(this, SecondActivity.class);

        String name = txtField_name.getText().toString().trim();
        String surname = txtField_surname.getText().toString().trim();
        String genre = spn_genre.getSelectedItem().toString();
        int birth_month = date_birth.getMonth() + 1;
        int birth_day = date_birth.getDayOfMonth();
        int birth_year = date_birth.getYear();
        String java = checkBox_java.getText().toString();
        String js = checkBox_js.getText().toString();
        String ccpp = checkBox_ccpp.getText().toString();
        String python = checkBox_python.getText().toString();
        String goland = checkBox_goland.getText().toString();
        String cshp = checkBox_cshp.getText().toString();


        String info = "¡Hola!, mi nombre es " + name + " " + surname + "." +
                "\n Soy " + genre + ", y nací en la fecha " + birth_month + "/" + birth_day + "/" + birth_year + ".";


        if(!name.isEmpty() && !surname.isEmpty()){
            if(radioButton_no.isChecked()){
                String info_no = "\n No me gusta programar.";
                String info_form = info.concat(info_no);
                intent.putExtra(detailed_info, info_form);
                startActivity(intent);
            }

            else if(radioButton_yes.isChecked()){
                if(checkBox_java.isChecked() || checkBox_js.isChecked() || checkBox_ccpp.isChecked() || checkBox_python.isChecked() ||
                        checkBox_goland.isChecked() || checkBox_cshp.isChecked()){
                    ArrayList<String> selectedLanguages = new ArrayList<String>();

                    String info_yes = info.concat("\n Me gusta programar. Mis lenguajes favoritos son: ");
                    if(checkBox_java.isChecked()){ info_yes += (java + ", "); }
                    if(checkBox_js.isChecked()){ info_yes += (js + ", "); }
                    if(checkBox_ccpp.isChecked()){ info_yes += (ccpp + ", "); }
                    if(checkBox_python.isChecked()){ info_yes += (python + ", "); }
                    if(checkBox_goland.isChecked()){ info_yes += (goland + ", "); }
                    if(checkBox_cshp.isChecked()){ info_yes += (cshp + ", "); }

                      String  info_form = info_yes+ ".";
                    intent.putExtra(detailed_info, info_form);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }

        } else{
            Toast.makeText(MainActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}