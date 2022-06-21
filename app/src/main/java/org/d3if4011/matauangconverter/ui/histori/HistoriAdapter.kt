package org.d3if4011.matauangconverter.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if4011.matauangconverter.R
import org.d3if4011.matauangconverter.databinding.ItemHistoriBinding
import org.d3if4011.matauangconverter.db.ConverterEntity
import org.d3if4011.matauangconverter.model.hitungConverter
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter:
    ListAdapter<ConverterEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<ConverterEntity>() {
                override fun areItemsTheSame(
                    oldData: ConverterEntity, newData: ConverterEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: ConverterEntity, newData: ConverterEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: ConverterEntity) = with(binding) {
            val hasilConverter = item.hitungConverter()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            converterTextView.text = root.context.getString(R.string.data_x, item.jumlahUang)
            dataTextView.text = root.context.getString(
                R.string.hasil_xx,
                item.hasil
            )

        }
    }
}
