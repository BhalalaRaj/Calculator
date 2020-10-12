package com.example.dell.calculator.calculator

object calculatorOutputPresenter{

    private var mnView: calculatorOutputInterfaceView?=null
    fun attach(view: calculatorOutputInterfaceView)
    {
        mnView=view
    }

    fun detach(){
        mnView = null
    }

    fun add(item : String)
    {

    }

    fun remove(){

    }

    fun solve(){

    }

    fun clear(){

    }
}