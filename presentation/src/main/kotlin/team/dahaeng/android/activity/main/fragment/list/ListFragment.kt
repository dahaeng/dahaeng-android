/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TaskingFragment.kt] created by Ji Sungbin on 22. 1. 18. 오후 9:08
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main.fragment.list

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.birjuvachhani.locus.Locus
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import team.dahaeng.android.GlideApp
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.FragmentListBinding
import java.util.Locale

class ListFragment : BaseFragment<FragmentListBinding, MainViewModel>(R.layout.fragment_list) {

    override val vm: MainViewModel by activityViewModels()
    private var lastestAddress = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlideApp.with(this).load(DataStore.me.profileImageUrl).override(100).into(binding.ivAvatar)
        Locus.startLocationUpdates(this) { result ->
            result.location?.let { location ->
                binding.tvLocate.text = location.tryParseAddress()
            }
            result.error?.let { exception ->
                logeukes(type = LoggerType.E) { exception }
            }
        }
    }

    private fun Location.tryParseAddress() = try {
        val geoCoder = Geocoder(requireContext().applicationContext, Locale.KOREA)
        val addressList = geoCoder.getFromLocation(latitude, longitude, 2)
        val address = addressList[1].getAddressLine(0)
        lastestAddress = address
        address
    } catch (exception: Exception) {
        logeukes(type = LoggerType.E) { exception }
        lastestAddress
    }

    override fun onPause() {
        super.onPause()
        Locus.stopLocationUpdates()
    }
}
