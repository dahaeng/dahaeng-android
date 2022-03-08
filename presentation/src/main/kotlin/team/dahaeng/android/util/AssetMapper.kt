/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [AssetMapper.kt] created by Ji Sungbin on 22. 3. 9. 오전 12:43
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util

import team.dahaeng.android.R
import team.dahaeng.android.util.constants.TransportationType

object AssetMapper {
    fun fromTransportation(type: String): Int {
        return with(TransportationType) {
            when (type) {
                Airplane -> R.drawable.ic_round_airplanemode_active_24
                Bike -> R.drawable.ic_round_directions_bike_24
                Boat -> R.drawable.ic_round_directions_boat_24
                Bus -> R.drawable.ic_round_directions_bus_24
                Car -> R.drawable.ic_round_directions_car_24
                Subway -> R.drawable.ic_round_directions_subway_24
                Train -> R.drawable.ic_round_train_24
                else -> R.drawable.ic_round_circle_24
            }
        }
    }
}
