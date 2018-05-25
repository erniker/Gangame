package silmood.com.gangame.owned

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import silmood.com.commons.BaseFragment
import silmood.com.commons.BaseListFragment
import silmood.com.commons.DataBindingRecyclerAdapter
import silmood.com.gangame.BR
import silmood.com.gangame.R
import silmood.com.gangame.TopGame

class MostOwnedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<TopGame>)
                .items.addAll(getDummyTopGames())

        listAdapter.notifyDataSetChanged()
    }

    fun getDummyTopGames(): ArrayList<TopGame> {
        return arrayListOf(TopGame("Counter Strike",
                12344546,
                publisher ="Valve",
                steamRating = 80,
                price = 9.99F,
                position = 1,
                thumb = "http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
    }
}