package zfani.assaf.task.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import zfani.assaf.task.R
import zfani.assaf.task.data.Num

class NumberAdapter(private val numbers: List<Num>) : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(num: Num) {
            itemView.findViewById<TextView>(R.id.tvText).setText(num.number.toString())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (numbers[position].isTypeOne) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    if (viewType == 0) R.layout.list_item_type_1 else R.layout.list_item_type_2,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(numbers[position])
    }

    override fun getItemCount(): Int {
        return numbers.size
    }
}