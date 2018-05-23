package silmood.com.gangame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import silmood.com.gangame.deals.DealsFragment
import silmood.com.gangame.owned.MostOwnedFragment
import silmood.com.gangame.rated.TopRatedFragment
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_OPTION = R.id.action_deals
    }

    val fragments : HashMap<Int, Fragment> = hashMapOf(
        Pair(R.id.action_deals, DealsFragment()),
        Pair(R.id.action_top_rated, TopRatedFragment()),
        Pair(R.id.action_most_owned, MostOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigationView.selectedItemId = DEFAULT_OPTION
        navigationView.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment? = fragments[item.itemId]

            if(fragment != null)
                replaceFragment(fragment)

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    fun initView() {
        val currentFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentContainer)

         if (currentFragment == null)
             supportFragmentManager
                     .beginTransaction()
                     .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                     .commit()
    }
}
