package com.example.dell.calculator

import com.example.dell.calculator.calculator.calculatorOutputInterfaceView
import com.example.dell.calculator.calculator.calculatorOutputPresenter
import org.junit.Test
import org.mockito.*
import org.mockito.BDDMockito.then

class CalculatorOutputTest{

    private val mnPresenter = calculatorOutputPresenter
    private val mnMockView = Mockito.mock(calculatorOutputInterfaceView::class.java)

    @Test
    fun `1 plus 1 is 2`(){
        //given that the view is attached
        mnPresenter.attach(mnMockView)

        //when
        mnPresenter.add("1")

        //then
        then(mnMockView).should().setEquation("1")

        //when operator is added
        mnPresenter.add("+")

        //then
        then(mnMockView).should().setEquation("1+")

        //when a number is added
        mnPresenter.add("1")

        //then
        then(mnMockView).should().setEquation("1+1")

        //the correct outcome
        then(mnMockView).should().setOutcome("2")

        //clear presenter
        mnPresenter.clear()

    }
    @Test
    fun `2 plus 2 minus 1 is 3`(){
        //given that the view is attached
        mnPresenter.attach(mnMockView)

        //when
        mnPresenter.add("2")

        //then
        then(mnMockView).should().setEquation("2")

        //when operator is added
        mnPresenter.add("+")

        //then
        then(mnMockView).should().setEquation("2+")

        //when a number is added
        mnPresenter.add("2")

        //then
        then(mnMockView).should().setEquation("2+2")

        //the correct outcome
        then(mnMockView).should().setOutcome("4")

        //when operator is added
        mnPresenter.add("-")

        //then
        then(mnMockView).should().setEquation("2+2-")
        //when a number is added
        mnPresenter.add("1")

        //then
        then(mnMockView).should().setEquation("2+2-1")
        then(mnMockView).should().setOutcome("3")



    }
}