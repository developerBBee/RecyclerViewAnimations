package com.example.recyclerviewanimations.list

import android.animation.ObjectAnimator
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.DurationUnit

class MyAnimator : DefaultItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        val view = holder.itemView

        val slideAnimator = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, view.width.toFloat(), 0f)
            .apply { duration = 500.milliseconds.toLong(DurationUnit.MILLISECONDS) }
        val fadeAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0f, 1f)
            .apply { duration = 1000.milliseconds.toLong(DurationUnit.MILLISECONDS) }
        val scaleAnimatorX = ObjectAnimator.ofFloat(view, View.SCALE_X, 1.2f, 1.2f, 1f)
            .apply { duration = 1000.milliseconds.toLong(DurationUnit.MILLISECONDS) }
        val scaleAnimatorY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.2f, 1.2f, 1f)
            .apply { duration = 1000.milliseconds.toLong(DurationUnit.MILLISECONDS) }

        slideAnimator.start()
        fadeAnimator.start()
        scaleAnimatorX.start()
        scaleAnimatorY.start()
        return true
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        val view = holder.itemView

        val slideAnimator = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0f, view.width.toFloat())
        val fadeAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 1f, 0f)

        slideAnimator.start()
        fadeAnimator.start()
        return true
    }
}