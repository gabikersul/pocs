package com.gabikersul.cloud.tema10.github;

import com.gabikersul.cloud.tema10.github.service.GithubService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ContextConfiguration(classes = {GithubConfig.class})
class GithubServiceTest {

	@Spy
	private GithubService service;

	@Test
	public void shouldReturnTotalOfUserReposTest(){
		Mockito.doReturn(7).when(service).getUserRepositories("gabikersul");
		int totalOfReposExpected = 7;
		int actualTotalOfRepos = service.getUserRepositories("gabikersul");
		assertEquals(totalOfReposExpected, actualTotalOfRepos);
	}

}
