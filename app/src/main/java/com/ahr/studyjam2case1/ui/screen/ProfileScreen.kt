package com.ahr.studyjam2case1.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahr.studyjam2case1.R
import com.ahr.studyjam2case1.ui.theme.StudyJam2Case1Theme

@Composable
fun ProfileScreen(
    @DrawableRes profile: Int,
    name: String,
    username: String,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        HeaderProfile(
            profile = profile,
            name = name,
            username = username
        )
        ButtonProfile(
            text = R.string.button_edit_title,
            onClicked = {  }
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
        )
        Divider(thickness = 2.dp, color = Color(0xFFE7E7E7))
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
        )
        for (item in itemProfiles.entries) {
            ItemProfile(icon = item.value, title = item.key)
        }
    }
}

@Composable
fun HeaderProfile(
    @DrawableRes profile: Int,
    name: String,
    username: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 48.dp, bottom = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = profile),
            contentDescription = stringResource(R.string.user_photo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(152.dp)
                .border(2.dp, Color.Black, shape = CircleShape)
                .clip(CircleShape)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.h6.copy(
                fontSize = 22.sp,
                color = MaterialTheme.colors.onBackground
            ),
            modifier = Modifier.padding(top = 23.dp)
        )
        Text(
            text = username,
            style = MaterialTheme.typography.body2.copy(
                fontWeight = FontWeight.Medium,
                color = Color(0xFF707070)
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ButtonProfile(
    @StringRes text: Int,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClicked,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF263775)
        ),
        contentPadding = PaddingValues(vertical = 9.dp),
        elevation = null,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Medium,
                color = Color.White,
                lineHeight = 24.sp
            )
        )
    }
}

@Composable
fun ItemProfile(
    @DrawableRes icon: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { }
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = title),
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .padding(end = 24.dp)
        )
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.onBackground,
                lineHeight = 24.sp
            )
        )
    }
}

private val itemProfiles = mapOf(
    R.string.setting to R.drawable.ic_setting,
    R.string.friend to R.drawable.ic_friend,
    R.string.new_group to R.drawable.ic_new_group,
    R.string.support to R.drawable.ic_support,
    R.string.share to R.drawable.ic_share,
    R.string.help to R.drawable.ic_help
)

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    StudyJam2Case1Theme {
        ProfileScreen(
            profile = R.drawable.profile,
            name = "Alex Marshall",
            username = "@alex_marshall",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemProfile() {
    StudyJam2Case1Theme {
        ItemProfile(
            icon = R.drawable.ic_setting,
            title = R.string.setting
        )
    }
}