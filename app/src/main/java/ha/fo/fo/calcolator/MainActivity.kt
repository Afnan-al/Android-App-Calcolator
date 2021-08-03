package ha.fo.fo.calcolator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buAC.setOnClickListener ({

            isNewOP=true
            jestOne=true

            textView.text="0"
        })
    }
    var isNewOP=true
    var jestOne=true

    fun buNumberEvent(view: View){
        if (isNewOP){
            textView.text=""
            isNewOP=false
        }
        var tvNumber:String=textView.text.toString()
        val buSeclect=view as Button
        when(buSeclect){
             bu0->{ tvNumber+="0" }
            buDot->{ tvNumber+="." }
            bu1->{ tvNumber+="1"}
            bu2->{ tvNumber+="2" }
            bu3->{ tvNumber+="3" }
            bu4->{ tvNumber+="4" }
            bu5->{ tvNumber+="5" }
            bu6->{ tvNumber+="6" }
            bu7->{ tvNumber+="7" }
            bu8->{ tvNumber+="8" }
            bu9->{ tvNumber+="9" }
            buPlusMinsu->{

                if(jestOne){
                    tvNumber="-"+tvNumber
                    jestOne=false

                }
            }


        }
        textView.setText(tvNumber)

    }
    var op="+"
    var oldNumber=""
    fun buOpEvent(view: View){
        oldNumber=textView.text.toString()
        isNewOP=true
        jestOne=true
      val buselect=view as Button
        when(buselect.id){

            buDiv.id->{op="/"}
            buMulti.id->{op="*"}
            buMinus.id->{op="-"}
            buPuls.id->{op="+"}

        }

    }

    fun buEquelEvent(view: View) {

       var NewNumber:String = textView.text.toString()
        var finalNum: Double? = null
        when (op) {

            "/" -> { finalNum=oldNumber.toDouble() / NewNumber.toDouble() }
            "*" -> {finalNum= oldNumber.toDouble() * NewNumber.toDouble() }
            "-" -> {finalNum= oldNumber.toDouble() - NewNumber.toDouble() }
            "+" -> {finalNum= oldNumber.toDouble() + NewNumber.toDouble() }
    }

        textView.text=finalNum.toString()
        isNewOP=true
        jestOne=true
}
}

