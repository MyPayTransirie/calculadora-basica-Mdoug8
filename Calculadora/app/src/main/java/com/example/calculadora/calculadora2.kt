package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculadora2.*
import kotlinx.android.synthetic.main.activity_tela_calculadora.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class calculadora2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_calculadora)

        // Numbers
        btn_um.setOnClickListener { appendOnExpression("1",true) }
        btn_dois.setOnClickListener { appendOnExpression("2",true) }
        btn_tres.setOnClickListener { appendOnExpression("3",true) }
        btn_quatro.setOnClickListener { appendOnExpression("4",true) }
        btn_cinco.setOnClickListener { appendOnExpression("5",true) }
        btn_seis.setOnClickListener { appendOnExpression("6",true) }
        btn_sete.setOnClickListener { appendOnExpression("7",true) }
        btn_oito.setOnClickListener { appendOnExpression("8",true) }
        btn_nove.setOnClickListener { appendOnExpression("9",true) }
        btn_zero.setOnClickListener { appendOnExpression("0",true) }
        btn_ponto.setOnClickListener { appendOnExpression(".",true) }

        //operators
        btn_soma.setOnClickListener { appendOnExpression("+",false) }
        btn_subtracao.setOnClickListener { appendOnExpression("-",false) }
        btn_multiplicacao.setOnClickListener { appendOnExpression("*",false) }
        btn_divide.setOnClickListener { appendOnExpression("/",false) }

        btn_delete.setOnClickListener {
            if(!btn_delete.isLongClickable()){
                val string = inputValor.text.toString()
                if(string.isNotEmpty()){
                    inputValor.text=string.substring(0,string.length-1)
                }
            }
            else{
                inputValor.text=""
                mostraValor.text=""
            }
        }

        btn_calcular.setOnClickListener{
            try {
                val expression = ExpressionBuilder(inputValor.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result==longResult.toDouble())
                    mostraValor.text = longResult.toString()
                else
                    mostraValor.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception","message :"+e.message)

            }
        }


    }
    fun appendOnExpression(string : String, canClear:Boolean){
        if(mostraValor.text.isNotEmpty())
        {
            inputValor.text= ""
        }

        if(canClear){
            mostraValor.text = ""
            inputValor.append(string)
        }else{
            inputValor.append(mostraValor.text)
            inputValor.append(string)
            mostraValor.text = ""


        }
    }
}