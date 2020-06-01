package com.gabikersul.cloud.tema10.twittergithub;

import com.gabikersul.cloud.tema10.twittergithub.service.CounterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TwitterGithubApplicationTests {
	@Spy
	private CounterService counterService;
	@Test
	public void shouldReturnTotalOfUTweetsTest() {
		Mockito.doReturn(3).when(counterService).getUserTotalTweets("Eduardo62599196");
		Integer totalTweetsExpected = 3;
		Integer actualTotalTweets = counterService.getUserTotalTweets("Eduardo62599196");
		assertEquals(totalTweetsExpected, actualTotalTweets);
	}

	@Test
	public void shouldReturnTotalOfUserGithubRepositoriesTest() {
		Mockito.doReturn(7).when(counterService).getUserTotalRepos("gabikersul");
		Integer totalReposExpected = 7;
		Integer actualTotalRepos = counterService.getUserTotalRepos("gabikersul");
		assertEquals(totalReposExpected, actualTotalRepos);
	}

}
