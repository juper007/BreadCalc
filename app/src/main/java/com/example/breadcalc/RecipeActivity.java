package com.example.breadcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class RecipeActivity extends AppCompatActivity {
    double flourRate, waterRate, saltRate, yeastRate, doughRate, butterRate;
    int massPerBread, breadCount;

    int totalMixRateIncludeDough, totalDoughMass, totalFlourIncludeDough,
            totalWaterIncludeDough, totalSaltIncludeDough, totalYeastIncludeDough,
            totalDoughIncludeDough, totalButterIncludeDough;

    int totalMixRateNotIncludeDough, totalFlourNotIncludeDough,
            totalWaterNotIncludeDough, totalSaltNotIncludeDough, totalYeastNotIncludeDough,
            totalDoughNotIncludeDough, totalButterNotIncludeDough;

    private final String UNIT_GRAM = "g";
    private final String UNIT_PERCENT = "%%";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    private void updateTextViewValue(int id, String value) {
        TextView target = findViewById(id);
        target.setText(value);
    }

    @NotNull
    private static String getValueWithUnitString (int value, String unit) {
        return String.format("%d" + unit, value);
    }

    @NotNull
    private static String getValueWithUnitString (double value, String unit) {
        return String.format("%.0f" + unit, value);
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

        totalMixRateNotIncludeDough = (int) (flourRate + waterRate);
        totalFlourNotIncludeDough = ((100 * totalDoughMass / totalMixRateNotIncludeDough) + 50) / 100 * 100;
        totalWaterNotIncludeDough = (int) (totalFlourNotIncludeDough * waterRate / 100);
        totalSaltNotIncludeDough = (int) (totalFlourNotIncludeDough * saltRate / 100);
        totalYeastNotIncludeDough = (int) (totalFlourNotIncludeDough * yeastRate / 100);
        totalDoughNotIncludeDough = (int) (totalFlourNotIncludeDough * doughRate / 100);
        totalButterNotIncludeDough = (int) (totalFlourNotIncludeDough * butterRate / 100);

        totalMixRateIncludeDough = (int) (totalMixRateNotIncludeDough + doughRate);
        totalFlourIncludeDough = ((100 * totalDoughMass / totalMixRateIncludeDough) + 50) / 100 * 100;
        totalWaterIncludeDough = (int) (totalFlourIncludeDough * waterRate / 100);
        totalSaltIncludeDough = (int) (totalFlourIncludeDough * saltRate / 100);
        totalYeastIncludeDough = (int) (totalFlourIncludeDough * yeastRate / 100);
        totalDoughIncludeDough = (int) (totalFlourIncludeDough * doughRate / 100);
        totalButterIncludeDough = (int) (totalFlourIncludeDough * butterRate / 100);
    }

    public void updateEdit() {
        updateTextViewValue(R.id.massDough, getValueWithUnitString(totalDoughMass, UNIT_GRAM));
        updateTextViewValue(R.id.mixRateNotIncludeDough, getValueWithUnitString(totalMixRateNotIncludeDough, UNIT_PERCENT));
        updateTextViewValue(R.id.mixRateIncludeDough, getValueWithUnitString(totalMixRateIncludeDough, UNIT_PERCENT));
        updateTextViewValue(R.id.totalFlourMassNotIncludeDough, getValueWithUnitString(totalFlourNotIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalFlourMassIncludeDough, getValueWithUnitString(totalFlourIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalWaterMassNotIncludeDough, getValueWithUnitString(totalWaterNotIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalWaterMassIncludeDough, getValueWithUnitString(totalWaterIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalSaltMassNotIncludeDough, getValueWithUnitString(totalSaltNotIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalSaltMassIncludeDough, getValueWithUnitString(totalSaltIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalYeastMassNotIncludeDough, getValueWithUnitString(totalYeastNotIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalYeastMassIncludeDough, getValueWithUnitString(totalYeastIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalDoughMassNotIncludeDough, getValueWithUnitString(totalDoughNotIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalDoughMassIncludeDough, getValueWithUnitString(totalDoughIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalButterMassNotIncludeDough, getValueWithUnitString(totalButterNotIncludeDough, UNIT_GRAM));
        updateTextViewValue(R.id.totalButterMassIncludeDough, getValueWithUnitString(totalButterIncludeDough, UNIT_GRAM));
    }

    public void calcButtonClick(View view) {
        calculation();
        updateEdit();
    }
}

