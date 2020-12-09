package co.kyald.coronavirustracking.ui.feature.menuscreen

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.kyald.coronavirustracking.R
import co.kyald.coronavirustracking.data.database.model.CoronaEntity
import co.kyald.coronavirustracking.ui.feature.preferencescreen.PreferenceActivity
import co.kyald.coronavirustracking.utils.extensions.observe
import co.kyald.coronavirustracking.utils.extensions.startActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_menu.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MenuActivity : AppCompatActivity() {

    private val viewModel: MenuActivityViewModel by viewModel()
    private val preferences: SharedPreferences by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        initObserver()
        initListener()

    }

    private fun initListener() {
        imgSetting.setOnClickListener {
            startActivity<PreferenceActivity>()
        }
    }

    private fun initObserver() {
        observe(viewModel.coronaCountryLiveDataSource, ::setupCountryData)
    }

    private fun setupCountryData(coronaEntity: CoronaEntity) {
        tvFlag.text = coronaEntity.info.country.toString()
        tvRecovered.text = coronaEntity.info.case_recovered.toString()
        tvActive.text = coronaEntity.info.case_actives.toString()
        tvInfected.text = coronaEntity.info.case_confirms.toString()
        tvDeaths.text = coronaEntity.info.case_deaths.toString()
        Glide.with(this).load(coronaEntity.info.flags).into(imgFlag)
    }


}


