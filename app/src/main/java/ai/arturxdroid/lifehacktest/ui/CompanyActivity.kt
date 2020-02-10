package ai.arturxdroid.lifehacktest.ui

import ai.arturxdroid.lifehacktest.R
import ai.arturxdroid.lifehacktest.databinding.CompanyActivityBinding
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_company.*
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

        setupViewModel(binding, id)

        setupClickListeners()

    }

    private fun setupClickListeners() {
        if (phone_text_view.visibility == View.VISIBLE)
            phone_text_view.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:" + viewModel.company.value?.phone)
                    )
                )
            }

        if (web_url_text_view.visibility == View.VISIBLE)
            web_url_text_view.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://" + viewModel.company.value?.www)
                    )
                )
            }
    }

    private fun setupViewModel(
        binding: CompanyActivityBinding,
        id: String
    ) {
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