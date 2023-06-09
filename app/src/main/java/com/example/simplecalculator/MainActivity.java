package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//first we grab the various UI elements and store them in variables.
		EditText firstNumInput = findViewById(R.id.math_layout_mathNum1); //first and second numbers
		EditText secondNumInput = findViewById(R.id.math_layout_mathNum2);
		RadioGroup operators = findViewById(R.id.math_layout_operators); //radio button group
		RadioButton addRadio = findViewById(R.id.radioButtonAdd);
		RadioButton minusRadio = findViewById(R.id.radioButtonMinus);
		RadioButton multiplyRadio = findViewById(R.id.radioButtonMultiply);
		RadioButton divideRadio = findViewById(R.id.radioButtonDivide);
		Button equals = findViewById(R.id.equalsButton); //calculate button
		TextView result = findViewById(R.id.main_resultText); //results

		//what happens when the calculate button is tapped
		equals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				/* Edit text gives us a View object, when what we need is an integer.
				And we can't convert directly from View to int, so we go View > String > int */
				int firstNum = Integer.parseInt(firstNumInput.getText().toString());
				int secondNum = Integer.parseInt(secondNumInput.getText().toString());

				/* The RadioGroup view comes with a built-in property that lets us see which of the buttons inside it is checked.
				We'll use that to get the id of the selected operator button */
				int operatorID = operators.getCheckedRadioButtonId();

				Integer answer; //we use the Integer object instead of int because we need to use one of the object's built-in methods (toString) later

				if (operatorID == addRadio.getId()) {
					answer = firstNum + secondNum;
				} else if (operatorID == minusRadio.getId()) {
					answer = firstNum - secondNum;
				} else if (operatorID == multiplyRadio.getId()) {
					answer = firstNum * secondNum;
				} else if (operatorID == divideRadio.getId()) {
					answer = firstNum / secondNum;
				} else {
					answer = 0;
				}
				//for now there's no input validation or try/catch stuff

				result.setText(answer.toString());
			}
		});

	}
}