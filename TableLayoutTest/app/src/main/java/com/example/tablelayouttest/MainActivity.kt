package com.example.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        // Create a new table row.
        val tblRow = TableRow(this)

        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tblRow.setLayoutParams(layoutParams)
        tblRow.setBackgroundColor(getResources().getColor(R.color.purple_200))

        //Create TextViews
        val tvVersion = TextView(this);
        tvVersion.text = txtVersion.text

        val tvCodeName = TextView(this);
        tvCodeName.text = txtCodeName.text

        // add values into row by calling addView()
        tblRow.addView(tvVersion,0)
        tblRow.addView(tvCodeName,1)

        // Add the created row row into layout
        tblAndroid.addView(tblRow)

        // Finally set the hint again after adding in table
        txtVersion.text.clear()
        txtCodeName.text.clear()
        txtVersion.hint = "Enter Android Version"
        txtCodeName.hint = "Enter Android Code Name"

    }
}