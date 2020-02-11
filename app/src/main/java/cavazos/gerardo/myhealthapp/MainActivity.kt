package cavazos.gerardo.myhealthapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.weight) as EditText
        val altura: EditText = findViewById(R.id.height) as EditText
        val calcular: Button = findViewById(R.id.calculate) as Button
        val imc: TextView = findViewById(R.id.imc) as TextView
        val rango: TextView = findViewById(R.id.range) as TextView



        calcular.setOnClickListener{
            var p: Float = peso.text.toString().toFloat()
            var a: Float = altura.text.toString().toFloat()
            var imc2: Float = p/(a.pow(2))

            imc.setText(""+imc2)

            if (imc2<18.5){
                rango.setBackgroundResource(R.color.greenish)
                rango.setText("Por debajo del peso ideal")
            } else if (imc2>=18.5 && imc2<=24.9){
                rango.setBackgroundResource(R.color.green)
                rango.setText("Saludable")
            } else if (imc2>=25 && imc2<=29.9){
                rango.setBackgroundResource(R.color.yellow)
                rango.setText("Sobrepeso")
            }else if (imc2>=30 && imc2<=39.9){
                rango.setBackgroundResource(R.color.orange)
                rango.setText("Obesidad")
            }else if (imc2>=40){
                rango.setBackgroundResource(R.color.red)
                rango.setText("Obesidad Mórbida")
            }

        }



    }
}
