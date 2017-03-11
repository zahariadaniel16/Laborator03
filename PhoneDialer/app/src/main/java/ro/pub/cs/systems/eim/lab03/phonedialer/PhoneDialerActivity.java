package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;

public class PhoneDialerActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private ImageButton backspaceImageButton, callImageButton, hangupImageButton;
    private Button genericButton;

    final private static int[] buttonIds = {
            R.id.number_1_button,
            R.id.number_2_button,
            R.id.number_3_button,
            R.id.number_4_button,
            R.id.number_5_button,
            R.id.number_6_button,
            R.id.number_7_button,
            R.id.number_8_button,
            R.id.number_9_button,
            R.id.number_0_button,
            R.id.number_star_button,
            R.id.number_pound_button
    };

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            phoneNumberEditText.setText(phoneNumberEditText.getText().toString() +
                    ((Button) view).getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        phoneNumberEditText = (EditText) findViewById(R.id.phone_number_edit_text);
        backspaceImageButton = (ImageButton) findViewById(R.id.backspace_image_button);
        callImageButton = (ImageButton) findViewById(R.id.call_image_button);
        hangupImageButton = (ImageButton) findViewById(R.id.hangup_image_button);

        for (int index = 0; index < buttonIds.length; index++) {
            genericButton = (Button) findViewById(buttonIds[index]);
            genericButton.setOnClickListener(genericButtonClickListener);
        }
    }
}
