package com.example.dell.calculator.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.dell.calculator.R
import kotlinx.android.synthetic.main.calculator_output.view.*


class calculatorOutputView(context: Context,attributeSet: AttributeSet?) : LinearLayout(context,attributeSet),calculatorOutputInterfaceView{

    override fun setEquation(equation: String) {
        calculator_input_equation.text = equation

    }

    override fun setOutcome(outcome: String) {
        calculator_input_outcome.text = outcome
    }

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        LayoutInflater.from(context).inflate(R.layout.calculator_output,this,true)
    }

    fun addItem(item : String)
    {
        calculatorOutputPresenter.add(item)
    }

    fun removeItem(){
        calculatorOutputPresenter.remove()
    }

    fun solve(){
        calculatorOutputPresenter.solve()
    }

    fun clear(){
        calculatorOutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        calculatorOutputPresenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        calculatorOutputPresenter.detach()
    }
}

