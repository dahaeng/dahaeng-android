package team.dahaeng.android.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import team.dahaeng.android.data.api.TMapApi
import team.dahaeng.android.data.api.TourApi
import kotlin.reflect.KClass


@Module
@InstallIn(ViewModelComponent::class)
object ApiModule {
    private const val tourBaseUrl =
        "http://api.visitkorea.or.kr/openapi/service/rest/KorService"
    private const val tmapBaseUrl = "https://apis.openapi.sk.com/tmap/geo"

    private fun getInterceptor(vararg interceptors: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        for (interceptor in interceptors) builder.addInterceptor(interceptor)
        return builder.build()
    }

    private fun <T : Any> buildRetrofit(
        loggingInterceptor: HttpLoggingInterceptor,
        baseUrl: String,
        service: KClass<T>,
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(JacksonConverterFactory.create())
        .client(getInterceptor(loggingInterceptor))
        .build()
        .create(service.java)

    @Provides
    @ViewModelScoped
    fun provideTourApi(loggingInterceptor: HttpLoggingInterceptor): TourApi =
        buildRetrofit(loggingInterceptor, "$tourBaseUrl/", TourApi::class)

    @Provides
    @ViewModelScoped
    fun provideTmapApi(loggingInterceptor: HttpLoggingInterceptor): TMapApi =
        buildRetrofit(loggingInterceptor, "$tmapBaseUrl/", TMapApi::class)
}