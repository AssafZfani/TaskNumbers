package zfani.assaf.task.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import zfani.assaf.task.utils.NumberAdapter
import zfani.assaf.task.R
import zfani.assaf.task.data.Num

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getNumberList()?.observe(this, Observer { numbers ->
            val nums = mutableListOf<Num>()
            numbers.forEach { num ->
                nums.add(
                    Num(
                        num,
                        numbers.contains(0 - num)
                    )
                )
            }
            rvNumbers.adapter =
                NumberAdapter(nums.sortedBy {
                    it.number
                })
        })
        rvNumbers.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        rvNumbers.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.HORIZONTAL
            )
        )
    }
}
