package sg.edu.rp.c346.myprofile;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
    }


    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float GPA = Float.parseFloat(strGPA);
        int intGender = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.putFloat("score",GPA);
        prefEdit.putInt("gender",intGender);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String savename = prefs.getString("name","");
        float saveGPA = prefs.getFloat("score",'0');
        int saveGender = prefs.getInt("gender",1);
        etName.setText(savename);
        etGPA.setText(Float.toString(saveGPA));
        rgGender.check(saveGender);
    }
}
