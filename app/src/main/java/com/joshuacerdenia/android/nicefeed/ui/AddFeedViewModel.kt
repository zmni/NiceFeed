package com.joshuacerdenia.android.nicefeed.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.joshuacerdenia.android.nicefeed.data.FeedParser
import com.joshuacerdenia.android.nicefeed.data.Repository
import com.joshuacerdenia.android.nicefeed.data.model.FeedWithEntries

open class AddFeedViewModel: ViewModel() {

    val repository = Repository.get()
    private val feedParser =
        FeedParser()

    var requestFailedNoticeEnabled = false
    var alreadyAddedNoticeEnabled = false

    val feedRequestLiveData: LiveData<FeedWithEntries>? = feedParser.feedRequestLiveData
    val feedListLiveData = repository.getFeeds()

    fun requestFeed(vararg url: String) {
        requestFailedNoticeEnabled = true
        alreadyAddedNoticeEnabled = true
        feedParser.requestFeed(*url)
    }

    fun saveFeedWithEntries (feedWithEntries: FeedWithEntries) {
        repository.addFeedWithEntries(feedWithEntries)
    }
}