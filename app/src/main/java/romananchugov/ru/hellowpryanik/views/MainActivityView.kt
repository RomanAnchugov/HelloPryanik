package romananchugov.ru.hellowpryanik.views

import com.arellomobile.mvp.MvpView
import romananchugov.ru.hellowpryanik.network.ViewDataModel

interface MainActivityView:MvpView {
    fun addTextView(data:ViewDataModel)
    fun addImageView(data:ViewDataModel)
    fun addRadioGroup(data:ViewDataModel)
}