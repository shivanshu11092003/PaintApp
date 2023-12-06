package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet

import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path

class PaintView: View{
    // things need to intialize the brush
    var params:ViewGroup.LayoutParams?=null //this param is responsible for height and weight of canvas with respect to parent layout
    companion object{
        var pathList=ArrayList<Path>() // store all the path that we draw in screen
        var colorList=ArrayList<Int>()
        var currentBrush= Color.BLACK
    }

    constructor(context: Context) : this(context, null){
        init()

    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()

    }

    private fun init(){
        paintBrush.isAntiAlias=true
        paintBrush.color= currentBrush
        paintBrush.style= Paint.Style.STROKE
        paintBrush.strokeJoin=Paint.Join.ROUND
        paintBrush.strokeWidth=8f  // here 8f is float value

        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)


    }

    // now how user using its finger to draw the things
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x=event.x
        val y=event.y

        when(event.action){
            MotionEvent.ACTION_DOWN->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)
            }else-> return false
        }
        postInvalidate() //used to inform non ui threats to inform some changes are made
        return false
    }
    // upto above we recognise the movement of finger of user but we didn't draw anything now we draw that movement
    override fun onDraw(canvas: Canvas) {
        for(i in pathList.indices){
            paintBrush.setColor(colorList[i])  //from this we can draw with picked color
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()
        }
    }


}