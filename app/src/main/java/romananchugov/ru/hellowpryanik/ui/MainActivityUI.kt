package romananchugov.ru.hellowpryanik.ui

import android.widget.LinearLayout
import org.jetbrains.anko.*
import romananchugov.ru.hellowpryanik.MainActivity

class MainActivityUI : AnkoComponent<MainActivity>{

    lateinit var linearLayout: LinearLayout
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui){
        linearLayout = verticalLayout {
            padding = dip(30)
        }
        linearLayout
    }
}