/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationadvancedsample.homescreen

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.android.navigationadvancedsample.R
import com.google.android.material.snackbar.Snackbar

/**
 * Shows "About"
 */
class About : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.user_1_btn).setOnClickListener {
            try {
                findNavController().navigate("www.example.com/user/Donkey")
            } catch (e: Exception) {
                errorToast(e.localizedMessage)
            }
        }
        view.findViewById<Button>(R.id.user_2_btn).setOnClickListener {
            try {
                findNavController().navigate("www.example.com/users/Donkey")
            } catch (e: Exception) {
                errorToast(e.localizedMessage)
            }
        }
        view.findViewById<Button>(R.id.user_3a_btn).setOnClickListener {
            val request =
                NavDeepLinkRequest.Builder
                    .fromUri(Uri.parse("www.example.com/user/Fiona"))
                    .build()
            try {
                findNavController().navigate(request, null)
            } catch (e: Exception) {
                errorToast(e.localizedMessage)
            }
        }
        view.findViewById<Button>(R.id.user_3b_btn).setOnClickListener {
            val request =
                NavDeepLinkRequest.Builder
                    .fromUri(Uri.parse("www.example.com/user/Fiona"))
                    .setAction("android.intent.action.MY_ACTION")
                    .build()
            try {
                findNavController().navigate(request, null)
            } catch (e: Exception) {
                errorToast(e.localizedMessage)
            }
        }
        view.findViewById<Button>(R.id.user_4a_btn).setOnClickListener {
            val request =
                NavDeepLinkRequest.Builder
                    .fromUri(Uri.parse("www.example.com/usersList?id=Shreck"))
                    .build()
            try {
                findNavController().navigate(request, null)
            } catch (e: Exception) {
                errorToast(e.localizedMessage)
            }
        }
        view.findViewById<Button>(R.id.user_4b_btn).setOnClickListener {
            val request =
                NavDeepLinkRequest.Builder
                    .fromUri(Uri.parse("www.example.com/usersList?id=Shreck"))
                    .setAction("android.intent.action.MY_ACTION")
                    .build()
            try {
                findNavController().navigate(request, null)
            } catch (e: Exception) {
                errorToast(e.localizedMessage)
            }
        }
    }

    private fun errorToast(text: String) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).setTextMaxLines(30) .show()
    }
}
