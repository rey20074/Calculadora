package com.example.taller1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class Calculadora : AppCompatActivity() {

    lateinit var Res:TextView
    lateinit var btn0:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button
    lateinit var mas:Button
    lateinit var menos:Button
    lateinit var por:Button
    lateinit var div:Button
    lateinit var borrar:Button
    lateinit var igual:Button
    lateinit var prueba1:Button
    lateinit var prueba2:Button
    lateinit var punto:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        var ResOper:Double
        var Operand1:Double
        var Operand2:Double
        var operando:String
        var guardado:String

        ResOper=0.0
        Operand1=0.0
        Operand2=0.0
        operando=""
        guardado=""

        Res=findViewById(R.id.Resultado)
        btn0=findViewById(R.id.btn0)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)
        mas=findViewById(R.id.mas)
        menos=findViewById(R.id.menos)
        por=findViewById(R.id.por)
        div=findViewById(R.id.div)
        borrar=findViewById(R.id.borrar)
        igual=findViewById(R.id.igual)
        prueba1=findViewById(R.id.prueba1)
        prueba2=findViewById(R.id.prueba2)
        punto=findViewById(R.id.punto)

        borrar.setOnClickListener(){
            guardado=""
            operando=""
            Res.text="0"
        }
        btn0.setOnClickListener(){
            guardado+="0"
            Res.text=guardado
        }
        btn1.setOnClickListener(){
            guardado+="1"
            Res.text=guardado
        }
        btn2.setOnClickListener(){
            guardado+="2"
            Res.text=guardado
        }
        btn3.setOnClickListener(){
            guardado+="3"
            Res.text=guardado
        }
        btn4.setOnClickListener(){
            guardado+="4"
            Res.text=guardado
        }
        btn5.setOnClickListener(){
            guardado+="5"
            Res.text=guardado
        }
        btn6.setOnClickListener(){
            guardado+="6"
            Res.text=guardado
        }
        btn7.setOnClickListener(){
            guardado+="7"
            Res.text=guardado
        }
        btn8.setOnClickListener(){
            guardado+="8"
            Res.text=guardado
        }
        btn9.setOnClickListener(){
            guardado+="9"
            Res.text=guardado
        }
        punto.setOnClickListener(){
            guardado+="."
            Res.text=guardado
        }

        mas.setOnClickListener(){

            if(operando.equals("")||operando.equals("-")){
                guardado+="+"
                operando="+"
            }

            Res.text=guardado
        }
        menos.setOnClickListener(){

            if(operando.equals("")||operando.equals("-")){
                guardado+="-"
                operando="-"
            }
            Res.text=guardado
        }
        div.setOnClickListener(){

            if(operando.equals("")||operando.equals("-")){
                guardado+="/"
                operando="/"
            }
            Res.text=guardado
        }
        por.setOnClickListener(){

            if(operando.equals("")||operando.equals("-")){
                guardado+="x"
                operando="x"
            }
            Res.text=guardado
        }


        igual.setOnClickListener(){

            val formato = DecimalFormat("#.00")

            var lista = guardado.split("+", "-", "x", "/").toMutableList()

            //negativos
            if(lista[0].equals("-")) {
                lista[0]=lista[0]+lista[1]
                lista[1]=lista[2]
                lista[2]=lista[3]
            }

            
            Operand1=(lista[0].toDouble())
            Operand2=(lista[1].toDouble())
            formato.format(Operand1)
            formato.format(Operand2)

            prueba1.text=Operand1.toString()
            prueba2.text=Operand2.toString()

            if(operando.equals("+")){
                ResOper=Operand1+Operand2
                formato.format(ResOper)
                guardado= ResOper.toString()
                Res.text= ResOper.toString()
                operando=""
            }
            else if (operando.equals("-")){
                ResOper=Operand1-Operand2
                formato.format(ResOper)
                guardado= ResOper.toString()
                Res.text=ResOper.toString()
                operando=""
            }
            else if (operando.equals("x")){
                ResOper=Operand1*Operand2
                formato.format(ResOper)
                guardado= ResOper.toString()
                Res.text=ResOper.toString()
                operando=""
            }
            else if (operando.equals("/")){
                try{
                    ResOper=Operand1/Operand2
                    formato.format(ResOper)
                    guardado= ResOper.toString()
                    Res.text=ResOper.toString()
                    operando=""
                }
                catch (e: Exception){
                    Res.text="No se puede la div por 0"
                    guardado= ""
                    operando=""
                }
            }
        }
    }
}