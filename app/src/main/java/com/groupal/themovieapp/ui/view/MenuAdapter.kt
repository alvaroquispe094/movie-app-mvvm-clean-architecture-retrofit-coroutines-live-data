package com.groupal.themovieapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.groupal.themovieapp.R
import com.groupal.themovieapp.data.model.Menu

class MenuAdapter(val listener: OnItemClickListener) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val items = mutableListOf<Menu>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent, false);
        return MenuViewHolder(view);
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.menu = item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setMenus(menus: List<Menu>){
        items.clear()
        items.addAll(menus)
        notifyDataSetChanged()
    }

    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var menu: Menu? = null
            set(value){
                value?.let {
                    //averiguar como usar viewBinding en adapter que hereda de Recyclerview en vez de fragment o activity
                    //val bindingDetail = ActivityDetailBinding.inflate(layoutInflater)

                    itemView.findViewById<TextView>(R.id.description).text = value?.description;

                }
                field = value
            }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
//                listener?.invoke(menu as Menu, bindingAdapterPosition)
                menu?.let { listener.onItemClick(menu!!) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(menu: Menu)
    }
}