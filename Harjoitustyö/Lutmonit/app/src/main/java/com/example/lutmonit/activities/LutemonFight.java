package com.example.lutmonit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutmonit.R;
import com.example.lutmonit.classes.Lutemon;
import com.example.lutmonit.classes.Storage;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class LutemonFight extends AppCompatActivity {

    private Button btnFight;
    private ArrayList<Lutemon> lutemonsBattle;
    private Storage storage;
    private RadioGroup radioGroup;
    private Lutemon A, B;
    private TextView txtBattleLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_fight);

        storage = Storage.getInstance();
        btnFight = findViewById(R.id.btnFigth);
        radioGroup = findViewById(R.id.radioGroup);
        txtBattleLog = findViewById(R.id.txtBattleLog);
        lutemonsBattle = storage.getLutemonsBattle();

        setLutemonsToRadioButtons();


        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (A != null && B != null) {

                    String battleLog = "";

                    while (A.getHealth() > 0 || B.getHealth() > 0) {

                        battleLog += A.getName() + " (" + A.getColor() + ") att: " + A.getAttack() + "; def: " + A.getDefense() + "; exp: " + A.getExperience() + "; health: " + A.getHealth() + "/" + A.getMaxHealth() + "\n";
                        battleLog += B.getName() + " (" + B.getColor() + ") att: " + B.getAttack() + "; def: " + B.getDefense() + "; exp: " + B.getExperience() + "; health: " + B.getHealth() + "/" + B.getMaxHealth() + "\n";

                        B.defense(A, A.getExperience());
                        battleLog += A.getName() + " (" + A.getColor() + ") hyökkäsi " + B.getName() + " (" + B.getColor() + ")\n";

                        if (B.getHealth() > 0) {
                            battleLog += B.getName() + "(" + B.getColor() + ") Selvisi hengissä.\n";
                            Lutemon temp = A;
                            A = B;
                            B = temp;
                        } else {
                            battleLog += B.getName() + " (" + B.getColor() + ") Kuoli.\n";
                            A.giveExperience();
                            break;
                        }
                        txtBattleLog.setText(battleLog);
                    }

                    battleLog += "Taistelu on ohi";
                    txtBattleLog.setText(battleLog);

                    radioGroup.removeAllViews();
                    setLutemonsToRadioButtons();

                    A = null;
                    B = null;

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Valitse taistelevat lutemonit!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Lutemon lutemon;
                int radioID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(radioID);
                lutemon = storage.getLutemonByName(radioButton.getText().toString(), lutemonsBattle);

                if (lutemon.getHealth() > 0) {
                    if (A == null) {
                        A = lutemon;
                        radioButton.setText(A.getName() + " (Taistelussa)");
                        radioButton.setChecked(false);

                    } else if (B == null) {
                        B = lutemon;
                        radioButton.setText(B.getName() + " (Taistelussa)");
                        radioButton.setChecked(false);
                    } else {
                        radioButton.setChecked(false);
                        Toast toast = Toast.makeText(getApplicationContext(), "Olet valinnut jo kaksi taistelevaa lutemonia!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    radioButton.setChecked(false);
                    Toast toast = Toast.makeText(getApplicationContext(), "Lutemon on kuollut, valitse toinen!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        storage.saveLutemons(this);
        super.onDestroy();
    }

    public void setLutemonsToRadioButtons() {

        lutemonsBattle.forEach(lutemon -> {

            if (lutemon.getHealth() <= 0) {
                RadioButton rb = new RadioButton(this);
                rb.setText(lutemon.getName() + " (Kuollut)");
                rb.setTextSize(20);
                radioGroup.addView(rb);
            } else {
                RadioButton rb = new RadioButton(this);
                rb.setText(lutemon.getName());
                rb.setTextSize(20);
                radioGroup.addView(rb);
            }
        });
    }
}