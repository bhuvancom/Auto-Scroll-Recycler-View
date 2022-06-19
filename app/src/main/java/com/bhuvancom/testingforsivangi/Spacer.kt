package com.bhuvancom.testingforsivangi

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class Spacer(private val mSpaceHeight:Int):RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = mSpaceHeight
        outRect.top = mSpaceHeight
        outRect.left = mSpaceHeight
        outRect.right = mSpaceHeight
    }

}

