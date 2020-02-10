package ai.arturxdroid.lifehacktest.ui

import ai.arturxdroid.lifehacktest.R
import ai.arturxdroid.lifehacktest.databinding.CompanyActivityBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    val viewModel: CompanyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: CompanyActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_company)

        binding.lifecycleOwner = this

        val id = intent.extras?.getString(EXTRA_ID) ?: "1"

        viewModel.company.observe(this, Observer {
            binding.company = it
            binding.executePendingBindings()
        })

        viewModel.error.observe(this, Observer {
            if (it == true) {
                Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show()
                this.finish()
            }
        })

        viewModel.fetchCompany(id)

    }
}