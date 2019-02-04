package romananchugov.ru.hellowpryanik.network

import com.google.gson.annotations.SerializedName

class ResponseModel {

    @SerializedName("data")
    var viewsDescription: Array<ViewDescriptionModel> = emptyArray()

    @SerializedName("view")
    var viewOrder: Array<String> = emptyArray()

    class ViewDescriptionModel {
        @SerializedName("name")
        var name: String = ""

        @SerializedName("data")
        var data: ViewDataModel = ViewDataModel()
    }

    fun getTextViewData():ViewDataModel{
        return viewsDescription[0].data
    }

    fun getImageViewData():ViewDataModel{
        return viewsDescription[1].data
    }

    fun getRadioGroupData():ViewDataModel{
        return  viewsDescription[2].data
    }
}