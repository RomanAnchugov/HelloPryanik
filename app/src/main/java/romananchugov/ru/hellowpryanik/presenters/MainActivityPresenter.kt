package romananchugov.ru.hellowpryanik.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import romananchugov.ru.hellowpryanik.di.DaggerAppComponent
import romananchugov.ru.hellowpryanik.network.NetworkUIService
import romananchugov.ru.hellowpryanik.utils.Constants
import romananchugov.ru.hellowpryanik.views.MainActivityView
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityView>() {
    @Inject
    lateinit var retrofit: Retrofit

    init{
        DaggerAppComponent.create().inject(this)
    }

    fun onCreate() {
        val networkUiService = retrofit.create(NetworkUIService::class.java)
        val disposable = networkUiService
            .listRepos()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result ->
                    Timber.i("Response ${result.viewOrder.size}")
                    result.viewOrder.forEach {
                        when(it){
                            Constants.TEXT_VIEW_KEY -> viewState.addTextView(result.getTextViewData())
                            Constants.IMAGE_VIEW_KEY -> viewState.addImage(result.getImageViewData())
                            Constants.RADIO_GROUP_KEY -> viewState.addImage(result.getRadioGroupData())
                        }
                    }
                },
                { error -> Timber.i("Error ${error.localizedMessage}") })
    }
}