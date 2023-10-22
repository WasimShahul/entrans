package com.wasim.entrans.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.wasim.entrans.data.HorizontalItem
import com.wasim.entrans.data.ListItem
import com.wasim.entrans.data.MyData
import com.wasim.entrans.data.VerticalItem

class MainViewModel : ViewModel() {
    // Using LiveData to hold the data
    val verticalItems = MutableLiveData<List<VerticalItem>>()
    val horizontalItems = MutableLiveData<List<HorizontalItem>>()
    val listItems = MutableLiveData<List<ListItem>>()

    fun fetchData() {
        // Fetching data from the JSON here and updating LiveData
        //Dummy data has been added to the sample structure provided in thew email
        val json = "{ \"vertical\": [ { \"title\": \"Candy Crush\", \"desc\": \"Puzzle. Match 3. Casual. Offline\", \"image\": \"https://play-lh.googleusercontent.com/gU9NKwpgLDYA6LIYK4dnkAkVyqNHUfTIqklEiNuO4oZ2OCpWQhQdqhnDh8Yb9B8SWIM=w240-h480-rw\" }, { \"title\": \"Coin Master\", \"desc\": \"Casino. Casino-adventure. Casual\", \"image\": \"https://play-lh.googleusercontent.com/Gpp87vMy7HMftEnl8GkTJrWPf2g6lIbNR0asWPtFBNSduXxfdzuky2fK1itlx4pfjaU=w240-h480-rw\" }, { \"title\": \"Evony: The King's Return\", \"desc\": \"Strategy. 4x\", \"image\": \"https://play-lh.googleusercontent.com/NugwgkxSKszaL4YW4Jto_gZ8Sdeo66AWVoRMzGQG45e04WX_Dj7ilvZwg1CRoBacNw=w240-h480-rw\" } ], \"horizontal\": [ { \"title\": \"Hill Climb Racing\", \"desc\": \"Racing\", \"image\": \"https://play-lh.googleusercontent.com/N0UxhBVUmx8s7y3F7Kqre2AcpXyPDKAp8nHjiPPoOONc_sfugHCYMjBpbUKCMlK_XUs=w240-h480-rw\" }, { \"title\": \"Ludo King™\", \"desc\": \"Board\", \"image\": \"https://play-lh.googleusercontent.com/AwrQb4bJk-34pw_ye7VhjDN0Azraz_pYYq9s5FbcapiF7qfxbYYvqWl-TjIF9xJIeA=w240-h480-rw\" }, { \"title\": \"Free Fire MAX\", \"desc\": \"Action. Tactical Shooter\", \"image\": \"https://play-lh.googleusercontent.com/DDwl4oKqYD9tLgas79qNQ-2oQ_O0gT3O0ZyBoFvrgm6UzI5qEjHFbMsnhTQ-MjqOqMU=w240-h480-rw\" } ], \"list\": [ { \"title\": \"Battlegrounds Mobile India\", \"desc\": \"Action. Tactical Shooter\", \"image\": \"https://play-lh.googleusercontent.com/DYXNS7NyuIgbCk5ElbK2Ch7dNuUnnCJ2ToDsV0QK0Q-MiGWQR7oDl9w8VXGinA5ureA=w240-h480-rw\" }, { \"title\": \"GRID™ Autosport\", \"desc\": \"Racing\", \"image\": \"https://play-lh.googleusercontent.com/stwUFdYIiKFCOU1uOCPQK5mRxr2fnZraDbM0ra32_-QxhudPDBGaehpzz_o9xLQl7A_v=w240-h480-rw\" } ] }"
        val jsonData = Gson().fromJson(json, MyData::class.java)
        verticalItems.value = jsonData.vertical
        horizontalItems.value = jsonData.horizontal
        listItems.value = jsonData.list
    }
}
