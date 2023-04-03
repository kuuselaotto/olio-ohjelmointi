package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class UserAddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText firstNameText, lastNameText, email;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spinner;
    private String imgIndex;
    private Animation scaleUp, scaleDown;
    private CheckBox checkBoxKandidaatti, checkBoxDI, checkBoxTohtori, checkBoxUima;
    UserStorage userStorage = UserStorage.getInstance();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);

        firstNameText = findViewById(R.id.firstNameText);
        lastNameText = findViewById(R.id.lastNameText);
        email = findViewById(R.id.emailText);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.imgSpinner);

        checkBoxKandidaatti = findViewById(R.id.kandidaattiCheck);
        checkBoxDI = findViewById(R.id.DICheck);
        checkBoxTohtori = findViewById(R.id.tohtoriCheck);
        checkBoxUima = findViewById(R.id.uimaCheck);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Images, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        context = this;

    }

    public void addUserButton(View view) {

        view.startAnimation(scaleUp);
        view.startAnimation(scaleDown);

        if (firstNameText.getText().toString().equals("") || lastNameText.getText().toString().equals("") || email.getText().toString().equals("") || getDegreeProgram(view).equals("")) {

            Toast toast = Toast.makeText(this, "Täytä tiedot!", Toast.LENGTH_SHORT);
            toast.show();

        } else {
            User user = new User(firstNameText.getText().toString(), lastNameText.getText().toString(), email.getText().toString(), getDegreeProgram(view), imgIndex, getDegrees(view));
            userStorage.addUser(user);
            userStorage.saveUsers(this);

            firstNameText.setText("");
            lastNameText.setText("");
            email.setText("");
            radioGroup.clearCheck();
        }
    }

    public String getDegreeProgram(View view) {
        String degree;

        int radioID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);
        degree = radioButton.getText().toString();

        return degree;
    }

    public StringBuilder getDegrees(View view) {

        StringBuilder degrees = new StringBuilder();

        if (checkBoxKandidaatti.isChecked()) {
            degrees.append(checkBoxKandidaatti.getText().toString() + "\n");
        }
        if (checkBoxDI.isChecked()) {
            degrees.append(checkBoxDI.getText().toString() + "\n");
        }
        if (checkBoxTohtori.isChecked()) {
            degrees.append(checkBoxTohtori.getText().toString() + "\n");
        }
        if (checkBoxUima.isChecked()) {
            degrees.append(checkBoxUima.getText().toString() + "\n");
        }

        return degrees;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        imgIndex = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}