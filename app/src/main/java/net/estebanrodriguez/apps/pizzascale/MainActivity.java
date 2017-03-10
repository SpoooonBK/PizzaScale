package net.estebanrodriguez.apps.pizzascale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.input);
        Button button = (Button) findViewById(R.id.pizza_scale_button);
        final TextView sliceAmount = (TextView) findViewById(R.id.text_view_num_of_slices);
        final TextView pizzaAmount = (TextView) findViewById(R.id.text_view_num_of_pizzas);
        final TextView remainingSlices = (TextView) findViewById(R.id.text_view_num_of_remaining);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();

                if (checkIfNumber(input)) {
                    Double weight = convertToDouble(input);
                    Double slices = PizzaConverter.ConvertToPizzaSlice(weight);
                    Double pizzas = PizzaConverter.ConvertToWholePizzas(weight);

                    sliceAmount.setText(slices + " slices.");
                    pizzaAmount.setText(pizzas + " whole pizzas");
                    if(PizzaConverter.getTheRemainingSlices(weight)>0){
                        remainingSlices.setText("and " + PizzaConverter.getTheRemainingSlices(weight) + " slices.");
                    }
                }
            }
        });

    }

    private boolean checkIfNumber(String input) {

        try{
            Double.parseDouble(input);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private double convertToDouble(String input){

        CheckBox checkBox = (CheckBox) findViewById(R.id.unit_check_box);

        double weight = Double.parseDouble(input);

        if(checkBox.isChecked()){
            return PizzaConverter.KgsToLbs(weight);
        }else return weight;
    }




}
