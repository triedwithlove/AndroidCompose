package com.koueka.transactionhistory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.koueka.transactionhistory.data.TrxnRepository
import com.koueka.transactionhistory.ui.theme.HistoryTheme
import com.koueka.transactionhistory.view.ItemDetailButtonAndStatus
import com.koueka.transactionhistory.view.TransactionItemView
import com.koueka.transactionhistory.view.TransactionListView
import com.koueka.transactionhistory.view.UserHeaderInformation
import com.koueka.transactionhistory.view.UserIcon




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HistoryTheme {
                Scaffold(
                    topBar = { TrxnTopAppBar() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    //UserIcon(profileImage = R.drawable.user_kompina)
                    /*UserHeaderInformation(
                        userName = R.string.user_kompina,
                        amountSent = "Sent: \$100.46"
                    )*/
                    /*
                    ItemDetailButtonAndStatus(
                        expanded = false,
                        onClick = {  },
                        statusPic = R.drawable.trxn_ph2_check_s2_progress,
                    )*/
                    /*
                    TransactionItemView(
                        transaction = TrxnRepository.transaction,
                        modifier = Modifier//.padding(innerPadding)
                    )*/
                    TransactionListView(
                        trxnList = TrxnRepository.trxnList,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrxnTopAppBar(modifier: Modifier = Modifier) {
    //
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}



@Composable
fun TransactionsHistory(modifier: Modifier = Modifier) {
    TransactionListView(
        trxnList = TrxnRepository.trxnList,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HistoryTheme {
        TransactionsHistory()
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HistoryTheme {
        Greeting("Android")
    }
}*/