package com.decagonhq.clads.data.remote

import com.decagonhq.clads.data.domain.login.EmailLoginSuccessResponse
import com.decagonhq.clads.data.domain.login.GoogleLoginSuccessResponse
import com.decagonhq.clads.data.domain.login.UserRole
import com.decagonhq.clads.data.domain.profileimage.UserProfileImageResponse
import com.decagonhq.clads.data.domain.registration.UserRegSuccessResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @POST("artisans/register")
    suspend fun registerUser(
        @Body user: UserRegistrationDTO
    ): UserRegSuccessResponse

    @POST("login")
    suspend fun login(
        @Body loginCredentials: LoginCredentialsDTO
    ): EmailLoginSuccessResponse

//    @Headers("application/json")
    @POST("login/google")
    suspend fun googleLogin(
        @Header("Authorization") auth: String,
        @Body userRole: UserRole
    ): GoogleLoginSuccessResponse

//    @GET("driver/v1/driver")
//    fun getAuthorizedDriver(@Header("authorization") auth: String?): Call<Driver?>?

    @Multipart
    @POST("upload")
    fun uploadImage(@Part image: MultipartBody.Part): UserProfileImageResponse
}
