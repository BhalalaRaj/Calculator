package com.example.dell.calculator


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.calculator_input.view.*

class calculatorInputView(context: Context,attributeSet: AttributeSet): RelativeLayout(context,attributeSet)
{
    init {
        //inflate layout
        LayoutInflater.from(context).inflate(R.layout.calculator_input,this,true)

        //read attribute set
        attributeSet?.run {
            val typedArray = context.obtainStyledAttributes(attributeSet,R.styleable.calculatorInputView)

            val textResource = typedArray.getString(R.styleable.calculatorInputView_item_text)
            val iconResource = typedArray.getResourceId(R.styleable.calculatorInputView_item_icon,-1)

            when
            {
                iconResource != -1-> {
                    input_element_text.visibility = View.GONE
                    input_element_image.apply {
                        visibility = View.VISIBLE
                        setImageResource(iconResource)

                    }
                }
                !textResource.isNullOrEmpty() -> {
                    input_element_image.visibility = View.GONE
                    input_element_text.apply {
                        visibility = View.VISIBLE
                        text = textResource
                    }
                }
                else ->
                {
                    input_element_text.visibility = View.GONE
                    input_element_image.visibility = View.GONE
                }
            }

            typedArray.recycle()
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        input_element_click.setOnClickListener(l)
    }
}