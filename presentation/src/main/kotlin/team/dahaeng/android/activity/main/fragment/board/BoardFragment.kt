/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TaskingFragment.kt] created by Ji Sungbin on 22. 1. 18. 오후 9:08
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main.fragment.board

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.birjuvachhani.locus.Locus
import io.github.jisungbin.logeukes.logeukes
import java.util.Locale
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.FragmentListBinding
import team.dahaeng.android.util.extensions.collectWithLifecycle
import team.dahaeng.android.util.extensions.launchedWhenCreated

class BoardFragment : BaseFragment<FragmentListBinding, MainViewModel>(R.layout.fragment_list) {

    override val vm: MainViewModel by activityViewModels()
    private val schedulesAdapter by lazy {
        BoardAdapter { post ->
            logeukes { "Post clicked: $post" }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (vm.lastLocate.isEmpty()) {
            Locus.getCurrentLocation(requireContext()) { result ->
                result.location?.let { location ->
                    location.tryParseAddress()?.let { address ->
                        vm.lastLocate = address
                        binding.tvLocate.text = address
                        Locus.stopLocationUpdates()
                    }
                }
                // 여기서 발생하는 에러는 오직 위치 권한이 없는 에러임
                // 따라서 별도로 에러를 처리하지 않음
            }
        } else {
            binding.tvLocate.text = vm.lastLocate
        }

        binding.rvPost.run {
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            adapter = schedulesAdapter
        }

        binding.tilSesarchContainer.setEndIconOnClickListener {
            // TODO: filter menu
        }

        launchedWhenCreated {
            DataStore.schedules.collectWithLifecycle(this@BoardFragment.viewLifecycleOwner) { schedules ->
                schedulesAdapter.submitList(schedules)
            }
        }
    }

    @Deprecated(message = "Use reverse geocoding api from t-map instead of.")
    private fun Location.tryParseAddress() = try {
        val geoCoder = Geocoder(requireContext().applicationContext, Locale.KOREA)
        val addressList = geoCoder.getFromLocation(latitude, longitude, 2)
        val address = addressList[1].getAddressLine(0).replace("대한민국 ", "")
        address
    } catch (exception: Exception) {
        vm.emitException(exception)
        null
    }

    override fun onPause() {
        Locus.stopLocationUpdates()
        super.onPause()
    }
}
