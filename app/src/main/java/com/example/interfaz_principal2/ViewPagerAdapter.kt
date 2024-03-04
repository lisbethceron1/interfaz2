package com.example.interfaz_principal2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.interfaz_principal2.Articulo
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val context: Context, private val model: ArrayList<Articulo>) : PagerAdapter() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return model.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.item, container, false)

        val nombresTextView = view.findViewById<TextView>(R.id.nombres)
        val descripcionTextView = view.findViewById<TextView>(R.id.descripcion)
        val imagenImageView = view.findViewById<ImageView>(R.id.imagen)

        val currentItem = model[position]

        nombresTextView.text = currentItem.nombres
        descripcionTextView.text = currentItem.descripcion
        imagenImageView.setImageResource(currentItem.imagenid)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
