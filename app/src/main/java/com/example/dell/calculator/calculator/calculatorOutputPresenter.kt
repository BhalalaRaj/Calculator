package com.example.dell.calculator.calculator

import bsh.Interpreter

object calculatorOutputPresenter{

    //current attached view
    private var mnView: calculatorOutputInterfaceView?=null

    //current equation
    private var mnCurrentEquation:String = ""

    //current outcome
    private var mnCurrentOutcome: String = ""

    //interpreter
    private val mnInterpreter= Interpreter()
    fun attach(view: calculatorOutputInterfaceView)
    {
        mnView=view
        updateEquation()
        updateOutcome()
    }

    fun detach(){
        mnView = null
    }

    fun add(item : String){
        mnCurrentEquation = mnCurrentEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun remove(){
        mnCurrentEquation = if(mnCurrentEquation.length>1)
        {
            mnCurrentEquation.substring(0, mnCurrentEquation.length-1)
        }
        else
        {
            ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()

    }

    fun solve(){
        if(mnCurrentOutcome.isNotEmpty())
        {
            mnCurrentEquation= mnCurrentOutcome
            mnCurrentOutcome=""
        }
        updateEquation()
        updateOutcome()
    }

    fun clear(){
        mnCurrentEquation=""
        mnCurrentOutcome=""
        updateEquation()
        updateOutcome()

    }

    private fun calculateOutcome()
    {
        if (mnCurrentEquation.isNotEmpty())
        {
           try {
               mnInterpreter.eval("result=$mnCurrentEquation")
               val result = mnInterpreter.get("result")
               if (result!= null && result is Int){
                   mnCurrentOutcome=result.toString()
               }
           }
           catch (e:Exception){
               mnCurrentOutcome=""
           }
        }
        else
        {
            mnCurrentOutcome=""
        }


    }
    private fun updateEquation(){
        mnView?.setEquation(mnCurrentEquation)

    }
    private fun updateOutcome(){
        mnView?.setOutcome(mnCurrentOutcome)

    }
}