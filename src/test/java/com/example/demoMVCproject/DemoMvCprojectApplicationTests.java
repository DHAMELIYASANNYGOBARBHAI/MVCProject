package com.example.demoMVCproject;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoMvCprojectApplicationTests {

	Calc c = new Calc();

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void addNum()
	{
		int expected = 10;
		int actually = c.sum(2,3,5);

		assertThat(actually).isEqualTo(expected);
	}

	@Test
	void mulNum()
	{
		int expected = 10;
		int actually = c.mal(2,5);

		assertThat(actually).isEqualTo(expected);
	}

	@Test
	void compare()
	{
		boolean actually = c.compare(2,2);
		assertThat(actually).isTrue();
	}




}
