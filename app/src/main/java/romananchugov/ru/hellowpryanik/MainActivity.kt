package romananchugov.ru.hellowpryanik

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import org.jetbrains.anko.imageView
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.textView
import romananchugov.ru.hellowpryanik.di.DaggerAppComponent
import romananchugov.ru.hellowpryanik.network.ViewDataModel
import romananchugov.ru.hellowpryanik.presenters.MainActivityPresenter
import romananchugov.ru.hellowpryanik.ui.MainActivityUI
import romananchugov.ru.hellowpryanik.views.MainActivityView
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    lateinit var activityUI:MainActivityUI

    init {
        DaggerAppComponent.create().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityUI = MainActivityUI()
        activityUI.setContentView(this)
        presenter.onCreate()
    }

    override fun addTextView(data: ViewDataModel) {
        Timber.i("Add texView text = ${data.text}")
        activityUI.linearLayout.apply {
            textView(data.text)
        }
    }

    override fun addImageView(data: ViewDataModel) {
        Timber.i("Add ImageView text = ${data.text}; url = ${data.url}")
        activityUI.linearLayout.apply {
            val imageView = imageView(R.drawable.ic_launcher_foreground)
            Glide.with(this).load(data.url).into(imageView)
        }
    }

    override fun addRadioGroup(data: ViewDataModel) {
        Timber.i("Add RadioGroup selectId = ${data.selectedId}; variants = ${data.variants.size}")
    }
}
