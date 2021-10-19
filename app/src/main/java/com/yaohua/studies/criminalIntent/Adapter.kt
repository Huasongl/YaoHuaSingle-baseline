package com.yaohua.studies.criminalIntent

import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yaohua.studies.R
import com.yaohua.studies.criminalIntent.Adapter.BaseVH
import com.yaohua.studies.criminalIntent.moudle.BaseItemBean
import com.yaohua.studies.criminalIntent.viewmodel.ItemType

class Adapter(private val data:List<BaseItemBean>):RecyclerView.Adapter<BaseVH>() {

    private val TAG = "Adapter"

    public var onItemDeleteClick : ((position:Int)->Unit)? = null

    private val timerHandler = Handler(Looper.getMainLooper())

    private val vsh = SparseArray<VHFactory>()

    init {
        vsh.put(ItemType.ITEM_BASE,BaseVHFactory())
        vsh.put(ItemType.ITEM_ON_SALE,OnSaleVHFactory())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH = vsh.get(viewType).createVH(parent.context,parent)

    override fun onBindViewHolder(holder: BaseVH, position: Int) =holder.display(data[position])

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun onViewRecycled(holder: BaseVH) {
        holder.onRecycled()
    }

    open inner class BaseVH(itemView:View):RecyclerView.ViewHolder(itemView) {
        private val TAG: String = "BaseVH"
        private val tvTimer = itemView.findViewById<TextView>(R.id.list_item_crime_title)
        private val btnDelete = itemView.findViewById<TextView>(R.id.list_item_crime_content)

        init {
            btnDelete.setOnClickListener {
                onItemDeleteClick?.invoke(adapterPosition)
            }
        }

        /**
         * 进入屏幕时: 填充数据，这里声明为open，让子类重写
         */
        open fun display(bean: BaseItemBean) {
            Log.d(TAG, "display: $adapterPosition")

            // 使用 终止时间 - 当前时间，计算倒计时还有多少秒
            delay = bean.terminalTime - System.currentTimeMillis()

            // 检测并更新timer状态
            updateTimerState()
        }

        /**
         * 剩余倒计时
         */
        private var delay = 0L

        private val timerRunnable = Runnable {
            // 这里打印日志，来印证我们只跑了 "屏幕内可展示item数量的 倒计时"
            Log.d(TAG, "run: ${hashCode()}")
            delay -= 1000
            updateTimerState()
        }

        // 开始倒计时
        private fun startTimer() {
            timerHandler.postDelayed(timerRunnable, 1000)
        }

        // 结束倒计时
        private fun endTimer() {
            timerHandler.removeCallbacks(timerRunnable)
        }

        // 检测倒计时 并 更新状态
        private fun updateTimerState() {
            if (delay <= 0) {
                // 倒计时结束了
                tvTimer.text = "已结束"
                itemView.setBackgroundColor(Color.GRAY)
                endTimer()
            } else {
                // 继续倒计时
                tvTimer.text = "${delay / 1000}S"
                itemView.setBackgroundColor(Color.parseColor("#FFBB86FC"))
                startTimer()
            }
        }

        /**
         * 滑出屏幕时: 移除倒计时
         */
        fun onRecycled() {
            Log.d(TAG, "onRecycled: $adapterPosition")

            // 终止计时
            endTimer()
        }
    }

    inner class OnSaleVH(itemView: View): BaseVH(itemView){
        private val tvName = itemView.findViewById<TextView>(R.id.list_item_crime_title)
        override fun display(bean: BaseItemBean) {
            super.display(bean)
            tvName.text = "${bean.id}在售"
        }
    }

    abstract class VHFactory{
        abstract fun createVH(context:Context,parent:ViewGroup): BaseVH
    }

    inner class BaseVHFactory :VHFactory(){
        override fun createVH(context: Context, parent: ViewGroup): BaseVH {
            return BaseVH(
                LayoutInflater.from(context).inflate(R.layout.list_item_basesale, parent, false)
            )
        }
    }

    inner class OnSaleVHFactory:VHFactory() {
        override fun createVH(context: Context, parent: ViewGroup): BaseVH {
            return OnSaleVH(
                LayoutInflater.from(context).inflate(R.layout.list_item_crime, parent, false)
            )
        }
    }
}
