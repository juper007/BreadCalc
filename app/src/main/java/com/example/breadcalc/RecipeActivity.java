package com.example.breadcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {
    double flourRate, waterRate, saltRate, yeastRate, doughRate, butterRate;
    int massPerBread, breadCount;

    int totalMixRateIncludeDough, totalDoughMass, totalFlourIncludeDough,
            totalWaterIncludeDough, totalSaltIncludeDough, totalYeastIncludeDough,
            totalDoughIncludeDough, totalButterIncludeDough;

    int totalMixRateNotIncludeDough, totalFlourNotIncludeDough,
            totalWaterNotIncludeDough, totalSaltNotIncludeDough, totalYeastNotIncludeDough,
            totalDoughNotIncludeDough, totalButterNotIncludeDough;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    public void calculation() {
        EditText flourEdit = findViewById(R.id.flourPercent_editText);
        EditText waterEdit = findViewById(R.id.waterPercent_editText);
        EditText saltEdit = findViewById(R.id.saltPercent_editText);
        EditText yeastEdit = findViewById(R.id.yeastPercent_editText);
        EditText doughEdit = findViewById(R.id.doughPercent_editText);
        EditText butterEdit = findViewById(R.id.butterPercent_editText);
        EditText breadCountEdit = findViewById(R.id.breadCount_editText);
        EditText massPerBreadEdit = findViewById(R.id.massPerBread_editText);

        flourRate = Double.parseDouble(flourEdit.getText().toString());
        waterRate = Double.parseDouble(waterEdit.getText().toString());
        saltRate = Double.parseDouble(saltEdit.getText().toString());
        yeastRate = Double.parseDouble(yeastEdit.getText().toString());
        doughRate = Double.parseDouble(doughEdit.getText().toString());
        butterRate = Double.parseDouble(butterEdit.getText().toString());
        breadCount = Integer.parseInt(breadCountEdit.getText().toString());
        massPerBread = Integer.parseInt(massPerBreadEdit.getText().toString());

        totalDoughMass = breadCount * massPerBread / 100 * 100;

        totalMixRateNotIncludeDough = (int)(flourRate + waterRate);
        totalFlourNotIncludeDough = ((100 * totalDoughMass / totalMixRateNotIncludeDough) + 50) / 100 * 100;
        totalWaterNotIncludeDough = (int)(totalFlourNotIncludeDough * waterRate / 100);
        totalSaltNotIncludeDough  = (int)(totalFlourNotIncludeDough * saltRate / 100);
        totalYeastNotIncludeDough = (int)(totalFlourNotIncludeDough * yeastRate / 100);
        totalDoughNotIncludeDough = (int)(totalFlourNotIncludeDough * doughRate / 100);
        totalButterNotIncludeDough = (int)(totalFlourNotIncludeDough * butterRate / 100);

        totalMixRateIncludeDough = (int)(totalMixRateNotIncludeDough + doughRate);
        totalFlourIncludeDough = ((100 * totalDoughMass / totalMixRateIncludeDough) + 50) / 100 * 100;
        totalWaterIncludeDough = (int)(totalFlourIncludeDough * waterRate / 100);
        totalSaltIncludeDough  = (int)(totalFlourIncludeDough * saltRate / 100);
        totalYeastIncludeDough = (int)(totalFlourIncludeDough * yeastRate / 100);
        totalDoughIncludeDough = (int)(totalFlourIncludeDough * doughRate / 100);
        totalButterIncludeDough = (int)(totalFlourIncludeDough * butterRate / 100);
    }

    public void updateEdit() {
        TextView mixRateIncludeDough = findViewById(R.id.mixRateIncludeDough);
        TextView mixRateNotIncludeDough = findViewById(R.id.mixRateNotIncludeDough);
        TextView massDough = findViewById(R.id.massDough);
        TextView totalFlourMassNotIncludeDough = findViewById(R.id.totalFlourMassNotIncludeDough);
        TextView totalFlourMassIncludeDough = findViewById(R.id.totalFlourMassIncludeDough);
        TextView totalWaterMassNotIncludeDough = findViewById(R.id.totalWaterMassNotIncludeDough);
        TextView totalWaterMassIncludeDough = findViewById(R.id.totalWaterMassIncludeDough);
        TextView totalSaltMassNotIncludeDough = findViewById(R.id.totalSaltMassNotIncludeDough);
        TextView totalSaltMassIncludeDough = findViewById(R.id.totalSaltMassIncludeDough);
        TextView totalYeastMassNotIncludeDough = findViewById(R.id.totalYeastMassNotIncludeDough);
        TextView totalYeastMassIncludeDough = findViewById(R.id.totalYeastMassIncludeDough);
        TextView totalDoughMassNotIncludeDough = findViewById(R.id.totalDoughMassNotIncludeDough);
        TextView totalDoughMassIncludeDough = findViewById(R.id.totalDoughMassIncludeDough);
        TextView totalButterMassNotIncludeDough = findViewById(R.id.totalButterMassNotIncludeDough);
        TextView totalButterMassIncludeDough = findViewById(R.id.totalButterMassIncludeDough);


        massDough.setText(String.format("%dg", totalDoughMass));
        mixRateNotIncludeDough.setText(String.format("%d%%", totalMixRateNotIncludeDough));
        totalFlourMassNotIncludeDough.setText((String.format("%dg", totalFlourNotIncludeDough)));
        totalWaterMassNotIncludeDough.setText((String.format("%dg", totalWaterNotIncludeDough)));
        totalSaltMassNotIncludeDough.setText((String.format("%dg", totalSaltNotIncludeDough)));
        totalYeastMassNotIncludeDough.setText((String.format("%dg", totalYeastNotIncludeDough)));
        totalDoughMassNotIncludeDough.setText((String.format("%dg", totalDoughNotIncludeDough)));
        totalButterMassNotIncludeDough.setText((String.format("%dg", totalButterNotIncludeDough)));

        mixRateIncludeDough.setText(String.format("%d%%", totalMixRateIncludeDough));
        totalFlourMassIncludeDough.setText((String.format("%dg", totalFlourIncludeDough)));
        totalWaterMassIncludeDough.setText((String.format("%dg", totalWaterIncludeDough)));
        totalSaltMassIncludeDough.setText((String.format("%dg", totalSaltIncludeDough)));
        totalYeastMassIncludeDough.setText((String.format("%dg", totalYeastIncludeDough)));
        totalDoughMassIncludeDough.setText((String.format("%dg", totalDoughIncludeDough)));
        totalButterMassIncludeDough.setText((String.format("%dg", totalButterIncludeDough)));

    }

    public void calcButtonClick(View view) {
        calculation();
        updateEdit();
    }
}

