package alexsullivan.com.myapplication

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class MainViewModel(taps: Observable<Unit>): ViewModel() {
    private var disposable: Disposable? = null
    init {
        disposable = taps.subscribe { println("Got a tap!") }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}
