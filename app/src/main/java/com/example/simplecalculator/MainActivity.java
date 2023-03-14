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

		EditText firstNumInput = findViewById(R.id.math_layout_mathNum1);
		EditText secondNumInput = findViewById(R.id.math_layout_mathNum2);
		RadioGroup operators = findViewById(R.id.math_layout_operators);
		RadioButton addRadio = findViewById(R.id.radioButtonAdd);
		RadioButton minusRadio = findViewById(R.id.radioButtonMinus);
		RadioButton multiplyRadio = findViewById(R.id.radioButtonMultiply);
		RadioButton divideRadio = findViewById(R.id.radioButtonDivide);
		Button equals = findViewById(R.id.equalsButton);
		TextView result = findViewById(R.id.main_resultText);
		equals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int firstNum = Integer.parseInt(firstNumInput.getText().toString());
				int secondNum = Integer.parseInt(secondNumInput.getText().toString());

				int operatorID = operators.getCheckedRadioButtonId();

				Integer answer;


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