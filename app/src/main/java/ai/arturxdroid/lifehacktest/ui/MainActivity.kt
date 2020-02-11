package ai.arturxdroid.lifehacktest.ui

import ai.arturxdroid.lifehacktest.R
import ai.arturxdroid.lifehacktest.binding.CompanyShortInfoItem
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GroupAdapter<GroupieViewHolder>()
        adapter.setOnItemClickListener { item, view ->
            val intent = Intent(this, CompanyActivity::class.java)
            val companyItem = item as CompanyShortInfoItem
            intent.putExtra(CompanyActivity.EXTRA_ID, companyItem.companyShortInfo.id)
            startActivity(intent)
        }

        recycler_view.adapter = adapter
        viewModel.companies.observe(this, Observer { list ->
            val companiesList = list.map { CompanyShortInfoItem(it) }
            adapter.clear()
            adapter.addAll(companiesList)
        })

        viewModel.fetchCompanies()

    }
}
