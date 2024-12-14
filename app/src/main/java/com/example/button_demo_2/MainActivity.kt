package com.example.button_demo_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.*
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.button_demo_2.ui.theme.Button_demo_2Theme
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // References to UI elements from XML
        val editTextName: EditText = findViewById(R.id.editTextName)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val checkBoxReading: CheckBox = findViewById(R.id.checkBoxReading)
        val checkBoxTraveling: CheckBox = findViewById(R.id.checkBoxTraveling)
        val checkBoxGaming: CheckBox = findViewById(R.id.checkBoxGaming)
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        val imageButton: ImageButton = findViewById(R.id.imageButton)
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        // AutoCompleteTextView setup (for countries)
        val countries = arrayOf("USA", "India", "Canada", "UK", "Australia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, countries)
        autoCompleteTextView.setAdapter(adapter)

        // Button click listener to show result
        btnSubmit.setOnClickListener {
            // Get the name from EditText
            val name = editTextName.text.toString()

            // Get the selected gender from RadioGroup
            val genderId = radioGroupGender.checkedRadioButtonId
            val gender = if (genderId != -1) findViewById<RadioButton>(genderId)?.text else "Not selected"

            // Collect hobbies from Checkboxes
            val hobbies = mutableListOf<String>()
            if (checkBoxReading.isChecked) hobbies.add("Reading")
            if (checkBoxTraveling.isChecked) hobbies.add("Traveling")
            if (checkBoxGaming.isChecked) hobbies.add("Gaming")

            // Get selected country from AutoCompleteTextView
            val country = autoCompleteTextView.text.toString()

            // Get the ToggleButton state
            val toggleState = if (toggleButton.isChecked) "ON" else "OFF"

            // Display the result in TextView
            textViewResult.text = """
                Name: $name
                Gender: $gender
                Hobbies: ${hobbies.joinToString(", ")}
                Country: $country
                Toggle: $toggleState
            """.trimIndent()
        }

        // ImageButton click listener (just to show a toast message)
        imageButton.setOnClickListener {
            Toast.makeText(this, "ImageButton clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}

