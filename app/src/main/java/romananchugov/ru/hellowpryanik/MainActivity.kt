package romananchugov.ru.hellowpryanik

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import org.jetbrains.anko.setContentView
import romananchugov.ru.hellowpryanik.di.DaggerAppComponent
import romananchugov.ru.hellowpryanik.network.ViewDataModel
import romananchugov.ru.hellowpryanik.presenters.MainActivityPresenter
import romananchugov.ru.hellowpryanik.ui.MainActivityUI
import romananchugov.ru.hellowpryanik.views.MainActivityView
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    init {
        DaggerAppComponent.create().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        presenter.onCreate()

    }

    override fun addTextView(data: ViewDataModel) {
        Timber.i("Add texView")
    }

    override fun addImage(data: ViewDataModel) {

    }

    override fun addRadioGroup(data: ViewDataModel) {

    }
}
