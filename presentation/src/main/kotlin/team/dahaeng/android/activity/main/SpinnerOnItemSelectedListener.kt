package team.dahaeng.android.activity.main

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import team.dahaeng.android.R

class SpinnerOnItemSelectedListener(spinner : Spinner, items : Array<String>, adapter : ArrayAdapter<String>) : AdapterView.OnItemSelectedListener {

    var items = items
    val adapter = adapter
    val spinner = spinner

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}