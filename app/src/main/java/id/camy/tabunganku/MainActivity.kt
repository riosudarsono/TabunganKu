package id.camy.tabunganku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import id.camy.tabunganku.history.HistoryFragment
import id.camy.tabunganku.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: Fragment
    private lateinit var historyFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = supportFragmentManager.instantiate(HomeFragment::class.java.name)
        historyFragment = supportFragmentManager.instantiate(HistoryFragment::class.java.name)

        supportFragmentManager.beginTransaction()
            .add(R.id.frame, homeFragment, "1")
            .show(homeFragment).commit()

        bottom_nav_view.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.homeFragment -> if (homeFragment.isAdded) {
                    supportFragmentManager.beginTransaction()
                        .show(homeFragment)
                        .hide(historyFragment)
                        .commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.frame, homeFragment, "1")
                        .show(homeFragment).commit()
                }

                R.id.historyFragment -> if (historyFragment.isAdded) {
                    supportFragmentManager.beginTransaction()
                        .hide(homeFragment)
                        .show(historyFragment)
                        .commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.frame, historyFragment, "1")
                        .show(historyFragment).commit()
                }
            }
            true
        }
    }

    private fun FragmentManager.instantiate(className: String): Fragment {
        return fragmentFactory.instantiate(ClassLoader.getSystemClassLoader(), className)
    }

}