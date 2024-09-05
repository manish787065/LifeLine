package india.learn.lifeline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import india.learn.lifeline.ui.theme.LifeLineTheme


class EmergencyHelpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeLineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val checkboxes = remember {
                        mutableStateListOf(
                            "Heart attack" to false,
                            "Accident" to false,
                            "Burn" to false,
                            "Animal attack" to false,
                            "Others" to false
                        )
                    }

                    CheckboxPage(
                        checkboxes = checkboxes,
                        onCheckboxChange = { index, isChecked ->
                            checkboxes[index] = checkboxes[index].copy(second = isChecked)
                        },
                        onSubmitClick = {

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CheckboxPage(
    checkboxes: List<Pair<String, Boolean>>, // List of pairs where each pair is a label and its checked state
    onCheckboxChange: (Int, Boolean) -> Unit, // Callback for checkbox changes
    onSubmitClick: () -> Unit // Callback for submit button click
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 120 dp Image
        Image(
            painter = painterResource(id = R.drawable.opd), // Replace with your image resource
            contentDescription = "Sample Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        checkboxes.forEachIndexed { index, (label, isChecked) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = label, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                Checkbox(modifier = Modifier,
                    checked = isChecked,
                    onCheckedChange = { newValue -> onCheckboxChange(index, newValue) }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Submit Button
        Button(
            onClick = onSubmitClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Submit")
        }
    }
}
