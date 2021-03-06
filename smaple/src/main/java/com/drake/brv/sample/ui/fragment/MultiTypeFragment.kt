/*
 * Copyright (C) 2018, Umbrella CompanyLimited All rights reserved.
 * Project：BRV
 * Author：Drake
 * Date：9/11/19 6:49 PM
 */

package com.drake.brv.sample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.drake.brv.sample.R
import com.drake.brv.sample.mod.DoubleItemModel
import com.drake.brv.sample.mod.Model
import com.drake.brv.utils.bindingAdapter
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.drake.tooltip.toast
import kotlinx.android.synthetic.main.fragment_multi_type.*


class MultiTypeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_multi_type, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        /**
         * 请查看Application的初始化
         */

        rv_multi_type.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<DoubleItemModel>(R.layout.item_multi_type_double)
        }.models = getData()

        // 点击事件
        rv_multi_type.bindingAdapter.onClick(R.id.item) {

            when (itemViewType) {
                R.layout.item_multi_type_simple -> toast("类型1")
                else -> toast("类型2")
            }
        }
    }

    private fun getData(): List<Any> {
        return listOf(
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model(),
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model()
        )
    }


}
