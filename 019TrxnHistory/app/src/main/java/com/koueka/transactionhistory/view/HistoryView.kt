package com.koueka.transactionhistory.view

/*
import androidx.activity.compose.setContent
*/
import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
/*import androidx.compose.foundation.layout.fillMaxSize
*/
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
/*import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
*/
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
/*import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn*/
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
/*import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
*/
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
/*import androidx.compose.ui.Alignment
*/
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*import androidx.compose.ui.tooling.preview.Preview
import com.koueka.transactionhistory.ui.theme.HistoryTheme
import com.koueka.transactionhistory.data.Dog
//import com.koueka.transactionhistory.data.dogs
//import com.koueka.woofapp.ui.theme.WoofAppTheme
*/
import com.koueka.transactionhistory.R
import com.koueka.transactionhistory.data.TrxnRepository
import com.koueka.transactionhistory.model.Transaction
import com.koueka.transactionhistory.ui.theme.HistoryTheme



/**
 * Composable that displays a list item containing a profile icon and the transaction information.
 *
 * @param trxnList contains the list of transaction items
 * @param modifier modifiers to set to this composable
 */
@Composable
fun TransactionListView(
    trxnList: List<Transaction>,
    modifier: Modifier = Modifier
) {
    LazyColumn (modifier = modifier) {
        items(trxnList) { trxn ->
            TransactionItemView(
                transaction = trxn,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}



/**
 * Composable that displays a list item containing a profile icon and the transaction information.
 *
 * @param transaction contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun TransactionItemView(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {

    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_card_size)),
        modifier = modifier
//        .background(Color.Yellow)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        //dampingRatio = Spring.DampingRatioNoBouncy,
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        //stiffness = Spring.StiffnessMedium
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
                .background(color = color)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                UserIcon(profileImage = transaction.profilePictureId)
                UserHeaderInformation(
                    userName = transaction.userName,
                    amountSent = transaction.sent
                )
                Spacer(modifier = Modifier.weight(1f))
                ItemDetailButtonAndStatus(
                    expanded = false,
                    onClick = { expanded = !expanded },
                    statusPic = transaction.status,
                )
            }

            if (expanded) {
                TransactionSummary(
                    transaction = transaction,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun TransactionItemViewPreview(modifier: Modifier = Modifier) {
    HistoryTheme {
        TransactionItemView(
            transaction = TrxnRepository.transaction
//            modifier: Modifier = Modifier
        )
    }
}


@Composable
fun TransactionSummary(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = transaction.fullName,
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = "Details",
            style = MaterialTheme.typography.bodyLarge
        )
        Row {
            TransactionDetail(
                element = transaction.date,
                icon = Icons.Rounded.DateRange,
                description = "Date",
                modifier = Modifier.weight(1f)
            )
            TransactionDetail(
                element = transaction.received,
                icon = Icons.Rounded.CurrencyExchange,
                description = "Currency XAF",
                modifier = Modifier.weight(1f)
            )
        }
        Row {
            TransactionDetail(
                element = transaction.town,
                icon = Icons.Rounded.LocationOn,
                description = "Town",
//                modifier = Modifier.weight(1f)
            )
            TransactionDetail(
                element = transaction.phone,
                icon = Icons.Rounded.Phone,
                description = "Phone",
//                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun TransactionDetail(
    element: String,
    icon: ImageVector,
    description: String,
    modifier: Modifier = Modifier

) {
    //----
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            //.background(Color.Green)
//            .fillMaxWidth(0.5f)
            .padding(2.dp)
    ) {
        Icon(
            //Icons.Rounded.Phone,
            icon,
            contentDescription = description,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = element,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.width(130.dp)
        )
    }

}


/**
 *
 */
@Composable
fun ItemDetailButtonAndStatus(
    expanded: Boolean,
    onClick: () -> Unit,
    @DrawableRes statusPic: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_size))
//            .background(Color.Red)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
            .padding(top = 0.dp)
            .size(32.dp)
//            .background(Color.White)
        ) {
            IconButton(
                onClick = onClick,
                modifier = modifier
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = stringResource(R.string.expand_button_content_description),
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Column(modifier = Modifier
            .width(40.dp)
            .height(10.dp)
//            .background(Color.DarkGray)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(statusPic),
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
fun ItemDetailButtonAndStatePreview() {
    HistoryTheme {
        ItemDetailButtonAndStatus(
            expanded = false,
            onClick = {  },
            statusPic = R.drawable.trxn_ph2_check_s2_progress,
        )
    }
}


/**
 * Composable that displays a userName and the amount in Canadian dollars.
 *
 * @param userName is the resource ID for the string of the user name
 * @param amount is the string that represents the amount sent
 * @param modifier modifiers to set to this composable
 */
@Composable
fun UserHeaderInformation(
    @StringRes userName: Int,
    amountSent: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
//        .background(Color.Green)
    ) {
        Text(
            text = stringResource(userName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = amountSent,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview
@Composable
fun UserHeaderInformationPreview() {
    HistoryTheme {
        UserHeaderInformation(
            userName = R.string.user_kompina,
            amountSent = "Sent: \$100.46"
        )
    }
}


/**
 * Composable that displays a photo of a dog.
 *
 * @param profileImage is the resource ID for the image of the user
 * @param modifier modifiers to set to this composable
 */
@Composable
fun UserIcon(
    @DrawableRes profileImage: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
//        .background(Color.Blue)
        .size(dimensionResource(R.dimen.image_size))
        .padding(dimensionResource(R.dimen.padding_small))
        .clip(CircleShape),
        //.clip(MaterialTheme.shapes.small),
    ) {
        Image(
            painter = painterResource(profileImage),
            contentDescription = "profile user picture",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun UserIconPreview() {
    HistoryTheme {
        UserIcon(profileImage = R.drawable.user_kompina)
    }
}


/**
 * Composable that displays an app bar and a list of dogs.
 */
/*@Composable
fun WoofApp(modifier: Modifier = Modifier) {
    LazyColumn (modifier = modifier) {
        items(dogs) {
            DogItem(
                dog = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}


@Preview
@Composable
fun FullWoofAppPreview() {
    WoofAppTheme {
        Scaffold(
            topBar = { WoofTopAppBar() },
            modifier = Modifier.fillMaxSize()) { innerPadding ->
                WoofApp(modifier = Modifier.padding(innerPadding))
        }
    }
}
*/




/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
/*@Preview
@Composable
fun WoofPreview() {
    WoofAppTheme(darkTheme = false) {
        WoofApp()
    }
}


@Preview
@Composable
fun WoofDarkThemePreview() {
    WoofAppTheme(darkTheme = true) {
        WoofApp()
    }
}
*/
