package com.example.DTOuse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class DtOuseApplicationTests {
	private calculator c = new calculator();

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void testSum() {
		//expected
		int expectedResult = 17;

		//actual
		int actualResult = c.doSum(12,3,2);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testProduct() {
		//expected
		int expectedResult = 12;

		//actual
		int actualResult = c.doProduct(3,4);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testComareNums() {
		//expected
//		boolean expectedResult = true;

		//actual
		boolean actualResult = c.compare(3,3);

		assertThat(actualResult).isTrue();
	}

}
