package com.example.tvpocapplication

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvpocapplication.ui.theme.TVpocApplicationTheme
import com.zoho.catalyst.common.ZCatalystUtil
import com.zoho.catalyst.setup.ZCatalystApp
import com.zoho.catalyst.setup.ZCatalystSDKConfigs

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ZCatalystApp.init(
            this,
            ZCatalystSDKConfigs.Environment.DEVELOPMENT
        )

        // Check if the user is already signed in
        if (ZCatalystApp.getInstance().isUserSignedIn()) {
            Log.d("Login", "User is already logged in")
            fetchLoggedInUserDetails()
        } else {
            // Trigger login process
            ZCatalystApp.getInstance().login(
                success = {
                    Log.i("Login", "Login successful")
                    fetchLoggedInUserDetails() // Fetch user details after successful login
                },
                failure = {
                    Log.e("Login", "Login failed: $it")
                }
            )
        }

        enableEdgeToEdge()
        setContent {
            TVpocApplicationTheme {

            }
        }
    }
}


private fun fetchLoggedInUserDetails() {
    // Fetch logged-in user details
    val loggedInUser = ZCatalystApp.getInstance().getCurrentUser(
        success = { user ->
            Log.d("User Info", "User Email: ${user.email}")
            Log.d("User Info", "User Name: ${user.firstName}")
        },
        failure = { exception ->
            Log.e("User Info", "Failed to fetch user info: $exception")
        }
    )
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



//@Composable
//fun VideoItem(
//    thumbnailRes: Int,
//    channelIconRes: Int,
//    title: String,
//    channel: String,
//    views: String,
//    timeAgo: String
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//    ) {
//        // Thumbnail with duration
//        Box {
//            Image(
//                painter = painterResource(id = thumbnailRes),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(16f/9f),
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                text = "7:02",
//                color = Color.White,
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(8.dp)
//                    .background(Color.Black.copy(alpha = 0.8f))
//                    .padding(4.dp)
//            )
//        }
//
//        // Video info
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Image(
//                painter = painterResource(id = channelIconRes),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//            )
//
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(start = 8.dp)
//            ) {
//                Text(
//                    text = title,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//                Text(
//                    text = "$channel • $views • $timeAgo",
//                    fontSize = 14.sp,
//                    color = Color.Gray
//                )
//            }
//
//            IconButton(onClick = { }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_more_vert),
//                    contentDescription = "More options",
//                    tint = Color.White
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun YoutubeScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        //YoutubeTopBar()
//
//        // Video content would go here
//        // You would typically use a LazyColumn for the video list
//        VideoItem(
//            thumbnailRes = R.drawable.mufasa_thumbnail,
//            channelIconRes = R.drawable.disney_icon,
//            title = "Voice of Mufasa in Tamil, ARJUN DAS! | Mufasa: The Lion King | In Cinemas",
//            channel = "Walt Disney Studios India",
//            views = "1.1M views",
//            timeAgo = "4 days ago"
//        )
//
//        VideoItem(
//            thumbnailRes = R.drawable.wsj_thumbnail,
//            channelIconRes = R.drawable.wsj_icon,
//            title = "Assad's Reign Is Over. What's Next for Syria? | WSJ",
//            channel = "The Wall Street Journal",
//            views = "738K views",
//            timeAgo = "2 days ago"
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TVpocApplicationTheme {
//        YoutubeScreen()
//
//    }
//}