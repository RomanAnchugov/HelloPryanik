package romananchugov.ru.hellowpryanik.network

import io.reactivex.Observable
import retrofit2.http.GET


interface NetworkUIService {

    @GET("/tmp/JSONSample.json")
    fun listRepos(): Observable<ResponseModel>

}