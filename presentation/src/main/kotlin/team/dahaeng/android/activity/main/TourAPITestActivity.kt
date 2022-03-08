package team.dahaeng.android.activity.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityTourapiTestBinding

class TourAPITestActivity : BaseActivity<ActivityTourapiTestBinding, MainViewModel>(
    R.layout.activity_tourapi_test
) {
    override val vm: MainViewModel by viewModels()

    var items = resources.getStringArray(R.array.travel_type_array)
    val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        spinnerSetting()

    }
    private fun setSpinnerOnItemSelectedListener(spinner : Spinner){
        when(spinner){
            binding.snTraveltype ->{
                binding.snTraveltype.onItemSelectedListener = SpinnerOnItemSelectedListener()
            }
        }
    }
    private fun spinnerSetting() {
        binding.snTraveltype.adapter = adapter

        items = resources.getStringArray(R.array.service_main_array)
        adapter.clear()
        adapter.addAll(items.toMutableList())
        binding.snServicefiltmain.adapter = adapter

        items = resources.getStringArray(R.array.service_middle_empty_array)
        adapter.clear()
        adapter.addAll(items.toMutableList())
        binding.snServicefiltmiddle.adapter = adapter


        items = resources.getStringArray(R.array.service_sub_empty_array)
        adapter.clear()
        adapter.addAll(items.toMutableList())
        binding.snServicefiltsub.adapter = adapter
    }
}