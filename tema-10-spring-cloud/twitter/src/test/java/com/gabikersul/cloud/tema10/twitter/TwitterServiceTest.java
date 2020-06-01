package com.gabikersul.cloud.tema10.twitter;

import com.gabikersul.cloud.tema10.twitter.service.TwitterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import twitter4j.TwitterException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TwitterServiceTest {

	@Spy
	private TwitterService twitterService;

	@Test
	public void shouldReturnTotalOfUserTweetsTest() throws TwitterException {
		Mockito.doReturn(1).when(twitterService).getUserTotalTweets("gabikersul");
		int totalOfTweetsExpected = 1;
		int actualTotalOfTweets = twitterService.getUserTotalTweets("gabikersul");
		assertEquals(totalOfTweetsExpected, actualTotalOfTweets);
	}

}
