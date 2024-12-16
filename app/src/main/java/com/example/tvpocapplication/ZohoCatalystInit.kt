//import android.content.Context
//import android.util.Log
////import com.zoho.catalyst.ZCatalyst
//import org.json.JSONObject
//import java.io.InputStream
//
object ZohoCatalystInit {
//
//    fun initializeZohoCatalyst(context: Context) {
//        try {
//            // Read the Zoho config JSON file from assets folder
//            val inputStream: InputStream = context.assets.open("app_config.json")
//            val size = inputStream.available()
//            val buffer = ByteArray(size)
//            inputStream.read(buffer)
//            inputStream.close()
//
//            // Convert the buffer to string
//            val json = String(buffer, Charsets.UTF_8)
//
//            // Parse the JSON
//            val config = JSONObject(json)
//
//            // Get the required values from the JSON
//            val clientID = config.getString("clientID")
//            val clientSecret = config.getString("clientSecret")
//            val redirectUrl = config.getString("redirectUrl")
//            val projectID = config.getString("projectID")
//            val portalID = config.getString("portalID")
//            val apiBaseURL = config.getString("apiBaseURL")
//
//            // Initialize Zoho Catalyst
////            ZCatalyst.initialize(
////                context,
////                clientID,
////                clientSecret,
////                redirectUrl,
////                projectID,
////                portalID,
////                apiBaseURL
////            )
//
//            Log.d("ZohoCatalystInit", "Catalyst SDK initialized successfully.")
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Log.e("ZohoCatalystInit", "Error initializing Zoho Catalyst: ${e.message}")
//        }
//    }
}
