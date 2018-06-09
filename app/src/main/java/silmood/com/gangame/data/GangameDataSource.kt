package silmood.com.gangame.data

import silmood.com.gangame.Deal
import silmood.com.gangamesdk.GangameApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import silmood.com.gangame.TopGame

object GangameDataSource {
    val apiService = GangameApiService()

    fun getDeals(): Observable<ArrayList<Deal>> {
        return apiService.apiClient
                .getDealsObservable()
                .map { listDeal ->
                    val deals = listDeal.map { deal -> DealMapper.fromSdk(deal) }
                    val arrayList = arrayListOf<Deal>()
                    arrayList.addAll(deals)
                    arrayList
                }.oberserveOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    fun getTopRated(): Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getTopRatedGamesObservable()
                .map { listGames ->
                    val games = listGames.map { game -> TopGameMapper.fromSdk(game) }
                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(games)
                    arrayList
                }.oberserveOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}