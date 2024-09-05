package india.learn.lifeline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import india.learn.lifeline.ui.theme.LifeLineTheme

class AppointmentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeLineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var patientName by remember { mutableStateOf("John Doe") }
                    var phoneNumber by remember { mutableStateOf("123-456-7890") }
                    var age by remember { mutableStateOf("30") }
                    var symptoms by remember { mutableStateOf("Fever, Cough, Shortness of Breath") }

                    PatientDetailsPage(
                        patientName = patientName,
                        onNameChange = { patientName = it },
                        phoneNumber = phoneNumber,
                        onPhoneNumberChange = { phoneNumber = it },
                        age = age,
                        onAgeChange = { age = it },
                        symptoms = symptoms,
                        onSymptomsChange = { symptoms = it },
                        onBookAppointmentClick = {
                            // Handle button click
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PatientDetailsPage(
    patientName: String,
    onNameChange: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    age: String,
    onAgeChange: (String) -> Unit,
    symptoms: String,
    onSymptomsChange: (String) -> Unit,
    onBookAppointmentClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Patient Image
        Image(
            painter = painterResource(id = R.drawable.opd),
            contentDescription = "Patient Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        // Editable Patient Name
        TextField(
            value = patientName,
            onValueChange = onNameChange,
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Editable Phone Number
        TextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        // Editable Age
        TextField(
            value = age,
            onValueChange = onAgeChange,
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Editable Symptoms
        TextField(
            value = symptoms,
            onValueChange = onSymptomsChange,
            label = { Text("Symptoms") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Book an Appointment Button
        Button(
            onClick = onBookAppointmentClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Book an Appointment")
        }
    }
}
