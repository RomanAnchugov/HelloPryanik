package romananchugov.ru.hellowpryanik.di

import dagger.Component
import romananchugov.ru.hellowpryanik.MainActivity
import romananchugov.ru.hellowpryanik.presenters.MainActivityPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
 fun inject(mainActivity: MainActivity)
 fun inject(presenter: MainActivityPresenter)
}