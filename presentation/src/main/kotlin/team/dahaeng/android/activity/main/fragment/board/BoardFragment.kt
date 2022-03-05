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
import androidx.recyclerview.widget.LinearLayoutManager
import com.birjuvachhani.locus.Locus
import io.github.jisungbin.logeukes.logeukes
import java.util.Locale
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.activity.schedule.modify.ScheduleModifyActivity
import team.dahaeng.android.constant.LoadState
import team.dahaeng.android.databinding.FragmentBoardBinding
import team.dahaeng.android.domain.schedule.model.SimpleAddress
import team.dahaeng.android.util.extensions.collectWithLifecycle
import team.dahaeng.android.util.extensions.hide
import team.dahaeng.android.util.extensions.launchedWhenCreated
import team.dahaeng.android.util.extensions.show
import team.dahaeng.android.util.extensions.startActivityWithAnimation

class BoardFragment : BaseFragment<FragmentBoardBinding>(R.layout.fragment_board) {

    private val vm: MainViewModel by activityViewModels()
    private val schedulesAdapter by lazy {
        BoardAdapter { post ->
            logeukes { "Post clicked: $post" }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (vm.lastAddress == null) {
            // getCurrentLocate 로 하면 작동하지 않음
            Locus.startLocationUpdates(this) { result ->
                result.location?.let { location ->
                    location.tryParseAddress()?.let { address ->
                        vm.lastAddress = address
                        binding.tvLocate.text = address.toString()
                        // vm.importAllSchedules(address)
                        Locus.stopLocationUpdates()
                    }
                }
                result.error?.let { exception ->
                    vm.emitException(exception)
                }
            }
        } else {
            vm.importAllSchedules(vm.lastAddress!!)
            binding.tvLocate.text = vm.lastAddress.toString()
        }

        vm.testEmitting()

        binding.rvVeiledSchedule.run {
            val linear = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            setLayoutManager(linear)
            getRecyclerView().run {
                setHasFixedSize(true)
                setItemViewCacheSize(10)
            }
            addVeiledItems(10)
            setAdapter(schedulesAdapter)
        }

        binding.tilSesarchContainer.setEndIconOnClickListener {
            // TODO: filter menu
        }

        binding.fabCreateSchedule.setOnClickListener {
            moveScheduleCreateActivity()
        }

        launchedWhenCreated {
            vm.schedules.collectWithLifecycle(this@BoardFragment.viewLifecycleOwner) { loadState ->
                (loadState as? LoadState.Done)?.value?.let { schedules ->
                    schedulesAdapter.submitList(schedules)
                }
                toggleUi(loadState)
            }
        }
    }

    @Deprecated(message = "Use reverse geocoding api from t-map instead of.")
    private fun Location.tryParseAddress() = try {
        val geoCoder = Geocoder(requireContext().applicationContext, Locale.KOREA)
        val addressList = geoCoder.getFromLocation(latitude, longitude, 2)
        val address = addressList[1].getAddressLine(0).replace("대한민국 ", "")
        with(address.split(" ")) {
            SimpleAddress(
                ciDo = first(),
                gunGu = last()
            )
        }
    } catch (exception: Exception) {
        vm.emitException(exception)
        null
    }

    private fun moveScheduleCreateActivity() {
        startActivityWithAnimation<ScheduleModifyActivity>()
    }

    private fun toggleUi(state: LoadState<*>) {
        when (state) {
            LoadState.Loading -> {
                binding.rvVeiledSchedule.veil()
            }
            LoadState.Empty -> {
                binding.rvVeiledSchedule.unVeil()
                binding.viewstubEmptyPublicSchedule.viewStub?.show()
                binding.tilSesarchContainer.hide()
                binding.rvVeiledSchedule.hide()
                binding.fabCreateSchedule.hide()
            }
            is LoadState.Done -> {
                binding.rvVeiledSchedule.unVeil()
                binding.viewstubEmptyPublicSchedule.viewStub?.hide(isGone = true)
                binding.tilSesarchContainer.show()
                binding.rvVeiledSchedule.show()
            }
        }
    }

    override fun onPause() {
        Locus.stopLocationUpdates()
        super.onPause()
    }
}
