package ai.arturxdroid.lifehacktest.binding

import ai.arturxdroid.lifehacktest.R
import ai.arturxdroid.lifehacktest.data.CompanyShortInfo
import ai.arturxdroid.lifehacktest.databinding.CompanyShortBinding
import com.xwray.groupie.databinding.BindableItem

class CompanyShortInfoItem(val companyShortInfo: CompanyShortInfo) :
    BindableItem<CompanyShortBinding>() {

    override fun getLayout(): Int = R.layout.company_item

    override fun bind(viewBinding: CompanyShortBinding, position: Int) {
        viewBinding.company = companyShortInfo
    }
}