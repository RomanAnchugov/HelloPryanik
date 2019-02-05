package romananchugov.ru.hellowpryanik

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import org.jetbrains.anko.*
import romananchugov.ru.hellowpryanik.di.DaggerAppComponent
import romananchugov.ru.hellowpryanik.network.ViewDataModel
import romananchugov.ru.hellowpryanik.presenters.MainActivityPresenter
import romananchugov.ru.hellowpryanik.ui.MainActivityUI
import romananchugov.ru.hellowpryanik.views.MainActivityView
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    lateinit var activityUI: MainActivityUI

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
            textView(data.text) {
                gravity = Gravity.CENTER
                textSize = 14f
                layoutParams = LinearLayout
                    .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                padding = dip(8)

            }
        }
    }

    override fun addImageView(data: ViewDataModel) {
        Timber.i("Add ImageView text = ${data.text}; url = ${data.url}")
        activityUI.linearLayout.apply {

            val imageView = imageView(R.drawable.ic_launcher_foreground)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            Glide.with(this).load(data.url).into(imageView)

            textView(data.text) {
                gravity = Gravity.CENTER
                textSize = 24f
                textColor = Color.BLACK
            }
        }
    }

    override fun addRadioGroup(data: ViewDataModel) {
        Timber.i("Add RadioGroup selectId = ${data.selectedId}; variants = ${data.variants.size}")
        activityUI.linearLayout.apply {
            val radioGroup = radioGroup()

            data.variants.forEach {
                radioGroup.apply {
                    radioButton {
                        text = it.text
                    }
                }
            }

            (radioGroup.getChildAt(data.selectedId) as RadioButton).isChecked = true
        }
    }
}
