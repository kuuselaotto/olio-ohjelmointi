package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class UserAddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText firstNameText, lastNameText, email;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spinner;
    private String imgIndex;
    private Animation scaleUp, scaleDown;
    UserStorage userStorage = UserStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);

        firstNameText = findViewById(R.id.firstNameText);
        lastNameText = findViewById(R.id.lastNameText);
        email = findViewById(R.id.emailText);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.imgSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Images, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

    }

    public void addUserButton(View view) {

        view.startAnimation(scaleUp);
        view.startAnimation(scaleDown);

        if (firstNameText.getText().toString().equals("") || lastNameText.getText().toString().equals("") || email.getText().toString().equals("") || getDegreeProgram(view).equals("")) {

            Toast toast = Toast.makeText(this, "Täytä tiedot!", Toast.LENGTH_SHORT);
            toast.show();

        } else {
            User user = new User(firstNameText.getText().toString(), lastNameText.getText().toString(), email.getText().toString(), getDegreeProgram(view), imgIndex);
            userStorage.addUser(user);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        imgIndex = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}