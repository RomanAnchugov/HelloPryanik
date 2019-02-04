package romananchugov.ru.hellowpryanik.network

import com.google.gson.annotations.SerializedName

class ViewDataModel {
    //PICTURE, TEXT
    @SerializedName("text")
    var text: String = ""

    //PICTURE
    @SerializedName("url")
    var url: String = ""

    //SELECTOR
    @SerializedName("selectedId")
    var selectedId: Int = 0

    @SerializedName("variants")
    var variants: Array<SelectorModel> = emptyArray()


    class SelectorModel {
        @SerializedName("id")
        var id: String = ""

        @SerializedName("text")
        var text: String = ""
    }
}